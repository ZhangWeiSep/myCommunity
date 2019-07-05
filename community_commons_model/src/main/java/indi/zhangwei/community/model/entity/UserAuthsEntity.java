package indi.zhangwei.community.model.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @pathName: UserAuthsEntity
 * @author: ZhangWei
 * 用户登录授权信息实体 <br/>
 * 一个用户可对应多个授权信息 <br/>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sys_user_auths")
public class UserAuthsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户唯一Id
     */
    private Integer userId;

    /**
     * 登录类型
     */
    private Integer identityType;

    /**
     * 登录标识
     * 账号、手机号、微信等
     */
    private String identifier;

    /**
     * 密码凭证
     */
    private String password;

}

