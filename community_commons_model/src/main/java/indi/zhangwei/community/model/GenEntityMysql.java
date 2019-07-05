package indi.zhangwei.community.model;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @pathName: GenEntityMysql
 * @author: ZhangWei
 */
public class GenEntityMysql {

    private String packageOutPath = "main.java.indi.zhangwei.community.model.entity";//指定实体生成所在包的路径
    private String packagePath = "indi.zhangwei.community.model.entity";//实体类包头
    private String projectName = "/community_commons_model";//项目名，如果是maven多子项目结构，需加上项目名称
    private String authorName = "ZhangWei";//作者名字
    private String tablename = "";//表名
    private String upTableName = "";
    private String[] colnames; // 列名数组
    private String[] colTypes; //列名类型数组
    private int[] colSizes; //列名大小数组
    private boolean f_util = false; // 是否需要导入包java.util.*
    private boolean f_sql = false; // 是否需要导入包java.sql.*

    /**
     * 数据库连接
     */
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/community?useUnicode=true&characterEncoding=utf8" +
            "&rewriteBatchedStatements=true&useSSL=false&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
    private static final String NAME = "root";
    private static final String PASS = "123456";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    /*
     * 构造函数
     */
    public GenEntityMysql() {
        //获取所有的表名
        List<String> list = getTableName();

        for (int p = 0; p < list.size(); p++) {
            tablename = list.get(p);
            //创建连接
            Connection con;
            //查要生成实体类的表
            String sql = "select * from " + tablename;
            PreparedStatement pStemt = null;
            upTableName = tablename.substring(tablename.indexOf("_") + 1) + "Entity";
            try {
                try {
                    Class.forName(DRIVER);
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                con = DriverManager.getConnection(URL, NAME, PASS);
                pStemt = con.prepareStatement(sql);
                ResultSetMetaData rsmd = pStemt.getMetaData();
                int size = rsmd.getColumnCount();   //统计列
                colnames = new String[size];
                colTypes = new String[size];
                colSizes = new int[size];
                for (int i = 0; i < size; i++) {
                    colnames[i] = rsmd.getColumnName(i + 1);
                    colTypes[i] = rsmd.getColumnTypeName(i + 1);

                    if (colTypes[i].equalsIgnoreCase("datetime")) {
                        f_util = true;
                    }
                    if (colTypes[i].equalsIgnoreCase("image") || colTypes[i].equalsIgnoreCase("text")) {
                        f_sql = true;
                    }
                    colSizes[i] = rsmd.getColumnDisplaySize(i + 1);
                }

                String content = parse(colnames, colTypes, colSizes);

                try {
                    File directory = new File("");
                    String outputPath =
                            directory.getAbsolutePath() + projectName + "/src/" + this.packageOutPath.replace(".", "/") +
                                    "/" + initcap(upTableName) + ".java";
                    FileWriter fw = new FileWriter(outputPath);
                    PrintWriter pw = new PrintWriter(fw);
                    pw.println(content);
                    pw.flush();
                    pw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
            }
        }
        System.out.println("生成完毕！");
    }

    /**
     * Java方法 得到当前数据库下所有的表名
     */
    private List<String> getTableName() {
        List<String> list = new ArrayList<String>();
        try {
            DatabaseMetaData meta = DriverManager.getConnection(URL, NAME, PASS).getMetaData();
            ResultSet rs = meta.getTables(null, null, null, new String[]{"TABLE"});
            while (rs.next()) {
                list.add(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 功能：生成实体类主体代码
     *
     * @param colnames
     * @param colTypes
     * @param colSizes
     * @return
     */
    private String parse(String[] colnames, String[] colTypes, int[] colSizes) {
        StringBuffer sb = new StringBuffer();
        //包路径
        sb.append("package " + this.packagePath + ";\r\n");
        sb.append("\r\n");

        //引用
        sb.append("import java.io.Serializable;\r\n");
        sb.append("import lombok.AllArgsConstructor;\r\n");
        sb.append("import lombok.Builder;\r\n");
        sb.append("import lombok.Data;\r\n");
        sb.append("import lombok.NoArgsConstructor;\r\n\r\n");
        sb.append("import javax.persistence.*;\r\n");
        //如果存在时间类型的字段，加入Date引用
        if (f_util) {
            sb.append("import java.time.LocalDateTime;\r\n");
        }

        //注释
        sb.append("\r\n/**\r\n");
        sb.append(" * @pathName: " + upTableName + "\r\n");
        sb.append(" * @author: ZhangWei\r\n");
        sb.append(" * \r\n");
        sb.append(" */\r\n");

        //注解
        sb.append("@Data\r\n");
        sb.append("@Builder\r\n");
        sb.append("@NoArgsConstructor\r\n");
        sb.append("@AllArgsConstructor\r\n");
        sb.append("@Entity\r\n");
        sb.append("@Table(name = \"" + tablename + "\" )\r\n");

        //实体部分
        sb.append("public class " + initcap(upTableName) + " implements Serializable {\r\n\r\n");
        //序列化
        sb.append("\tprivate static final long serialVersionUID = 1L;\r\n\r\n");
        processAllAttrs(sb);//属性
        sb.append("}\r\n");
//        System.out.println(sb.toString());
        return sb.toString();
    }

    /**
     * 功能：生成所有属性
     *
     * @param sb
     */
    private void processAllAttrs(StringBuffer sb) {
        for (int i = 0; i < colnames.length; i++) {
            //字段下划线分割处理
            String rStr = "";
            String[] strs = colnames[i].split("_");
            if (strs.length > 1) {
                for (int j = 0; j < strs.length; j++) {

                    char[] chc = strs[j].toCharArray();
                    if (j > 0) {
                        if (chc[0] >= 'a' && chc[0] <= 'z') {
                            chc[0] = (char) (chc[0] - 32);
                        }
                    }
                    rStr += new String(chc);
                }
            } else {
                rStr = colnames[i];
            }
            //id列单独增加注解标识
            if (rStr.equals("id")) {
                sb.append("\t@Id\r\n\t@GeneratedValue(strategy = GenerationType.IDENTITY)\r\n");
            }
            //组装属性
            sb.append("\tprivate " + sqlType2JavaType(colTypes[i]) + " " + rStr + ";\r\n\r\n");
        }
        sb.append("\r\n");
    }

    /**
     * 功能：将输入字符串的首字母改成大写
     *
     * @param str
     * @return
     */
    private String initcap(String str) {

        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        //特殊需要对_进行分割组装
        String rStr = "";
        String[] strs = str.split("_");
        for (int i = 0; i < strs.length; i++) {
            char[] chc = strs[i].toCharArray();
            if (chc[0] >= 'a' && chc[0] <= 'z') {
                chc[0] = (char) (chc[0] - 32);
            }
            strs[i] = new String(chc);
            rStr += strs[i];
        }

        return new String(rStr);
    }

    /**
     * 功能：获得列的数据类型
     *
     * @param sqlType
     * @return
     */
    private String sqlType2JavaType(String sqlType) {

        if (sqlType.equalsIgnoreCase("bit")) {
            return "boolean";
        } else if (sqlType.equalsIgnoreCase("tinyint")) {
            return "Integer";
        } else if (sqlType.equalsIgnoreCase("smallint")) {
            return "short";
        } else if (sqlType.equalsIgnoreCase("int") || sqlType.equalsIgnoreCase("INT UNSIGNED")) {
            //INT UNSIGNED无符号整形
            return "Integer";
        } else if (sqlType.equalsIgnoreCase("bigint")) {
            return "long";
        } else if (sqlType.equalsIgnoreCase("float")) {
            return "float";
        } else if (sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric")
                || sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money")
                || sqlType.equalsIgnoreCase("smallmoney")) {
            return "double";
        } else if (sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char")
                || sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")
                || sqlType.equalsIgnoreCase("text")) {
            return "String";
        } else if (sqlType.equalsIgnoreCase("datetime")) {
            return "LocalDateTime";
        } else if (sqlType.equalsIgnoreCase("image")) {
            return "Blod";
        }
        return null;
    }

    public static void main(String[] args) {
        new GenEntityMysql();
    }

}
