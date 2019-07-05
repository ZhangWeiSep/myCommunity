package indi.zhangwei.community.utils;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则工具类
 * @pathName：RegUtils
 * @author：ZhangWei
 */
public class RegUtils {

    /**
     * 正则验证
     * @param reg 正则表达式
     * @param str 待验证字符
     * @return
     */
    public static boolean isRegStr(String reg, String str) {
        boolean flag = false;
        if (StringUtils.isNotBlank(reg) && StringUtils.isNotBlank(str)) {
            Pattern pattern = Pattern.compile(reg);
            Matcher matcher = pattern.matcher(str.trim());
            flag = matcher.matches();
        }
        return flag;
    }
}
