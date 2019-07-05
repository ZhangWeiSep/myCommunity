package indi.zhangwei.community.model.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @pathName: UserLoginLogEntity
 * @author: ZhangWei
 * 用户登录记录 <br/>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sys_user_login_log")
public class UserLoginLogEntity implements Serializable {

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
     * 登录时间
     */
    private LocalDateTime loginTime;

    /**
     * 登录ip
     */
    private String loginIp;

    /**
     * 登录地点
     */
    private String loginAddress;

    /**
     * 是否登录成功：0 失败、1 成功
     */
    private Integer loginState;

    /**
     * 登录方式
     */
    private Integer identityType;


}

