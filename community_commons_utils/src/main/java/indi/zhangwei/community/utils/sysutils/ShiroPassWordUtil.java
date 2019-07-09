package indi.zhangwei.community.utils.sysutils;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @pathName: ShiroPassWordUtil
 * @author: ZhangWei
 */
public class ShiroPassWordUtil {

    /**
     * 密码加密
     * @param account 用户名
     * @param pwd 密码
     * @return 加密后的密码
     */
    public static String encryptPassword(String account, String pwd) {
        pwd = Base64.encodeToString(pwd.getBytes());
        String obj = new SimpleHash("MD5", pwd, ByteSource.Util.bytes(account), 1024).toHex();
        return obj;
    }

    public static void main(String[] args) {
        System.out.println(encryptPassword("admin", "123456"));
    }

}
