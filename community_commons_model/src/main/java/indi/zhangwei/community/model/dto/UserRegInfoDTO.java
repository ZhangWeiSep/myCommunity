package indi.zhangwei.community.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @pathName: UserRegInfoDTO
 * @author: ZhangWei
 * 用户注册信息 <br/>
 * 提供多种注册方式，包含但不限于微信、QQ、手机号、用户名等 <br/>
 * 仅提供注册所需基本信息，详细信息注册完成后再进行完善 <br/>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 登录类型
     */
    private String identityType;

    /**
     * 登录标识
     */
    private String identifier;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机验证码
     */
    private String msgCode;

    /**
     * 用户头像路径
     */
    private String userImg;

}
