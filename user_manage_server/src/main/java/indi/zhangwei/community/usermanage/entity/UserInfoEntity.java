package indi.zhangwei.community.usermanage.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @pathName: UserInfoEntity
 * @author: ZhangWei
 * 用户基础信息实体类 <br/>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sys_user_info")
public class UserInfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 出生年月
     */
    private LocalDateTime birthday;

    /**
     * 用户头像地址
     */
    private String userImg;

    /**
     * 证件类型
     */
    private Integer identityCardType;

    /**
     * 证件号码
     */
    private String identityCard;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 简介
     */
    private String synopsis;

    /**
     * 登录状态
     */
    private Integer loginState;

    /**
     * 注册时间
     */
    private LocalDateTime registerTime;

    /**
     * 最后修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 最后一次登录时间
     */
    private LocalDateTime lastTime;

}

