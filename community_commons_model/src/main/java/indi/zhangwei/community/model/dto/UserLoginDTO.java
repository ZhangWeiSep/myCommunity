package indi.zhangwei.community.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @pathName: UserLoginDTO
 * @author: ZhangWei
 * 登录所需验证信息 <br/>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 登录类型
     */
    private Integer identifierType;

    /**
     * 登录标识
     */
    private String identifier;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 验证码
     */
    private String msgCode;

}
