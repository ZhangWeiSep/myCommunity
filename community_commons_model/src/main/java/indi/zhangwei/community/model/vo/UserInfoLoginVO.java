package indi.zhangwei.community.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @pathName: UserInfoLoginVO
 * @author: ZhangWei
 * 登录成功，返回信息 <br/>
 * 只包含用户昵称、头像等简单信息 <br/>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoLoginVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户唯一Id
     */
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
     * 用户头像地址
     */
    private String userImg;

}
