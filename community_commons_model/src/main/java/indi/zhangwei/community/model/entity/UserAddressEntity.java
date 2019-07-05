package indi.zhangwei.community.model.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @pathName: UserAddressEntity
 * @author: ZhangWei
 * 用户地址信息实体 <br/>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sys_user_address")
public class UserAddressEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户唯一ID
     */
    private Integer userId;

    /**
     * 省份Code
     */
    private Integer province;

    /**
     * 城市Code
     */
    private Integer cityCode;

    /**
     * 区域Code
     */
    private Integer district;

    /**
     * 具体的详细地址
     */
    private String address;

    /**
     * 最后修改时间
     */
    private LocalDateTime modityTime;


}

