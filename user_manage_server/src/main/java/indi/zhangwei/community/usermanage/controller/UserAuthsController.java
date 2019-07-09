package indi.zhangwei.community.usermanage.controller;

import indi.zhangwei.community.model.dto.UserLoginDTO;
import indi.zhangwei.community.model.vo.UserInfoLoginVO;
import indi.zhangwei.community.usermanage.service.UserAuthsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @pathName: UserAuthsController
 * @author: ZhangWei
 */
@RestController
@RequestMapping("/userAuths")
public class UserAuthsController {

    /**
     * 注入用户权证服务Bean
     */
    @Autowired
    private UserAuthsService userAuthsService;

    /**
     * 用户登录
     * @param userLoginDTO 用户权证信息
     * @return 用户基本信息
     */
    @PostMapping("/login")
    public UserInfoLoginVO login(@RequestBody UserLoginDTO userLoginDTO) {
        UserInfoLoginVO userInfoLoginVO;
        switch (userLoginDTO.getIdentityType()){
            case 1:
                userInfoLoginVO = userAuthsService.userLogin(userLoginDTO);
                break;
            case 2:
                userInfoLoginVO = userAuthsService.phoneLogin(userLoginDTO);
                break;
            default:
                userInfoLoginVO = userAuthsService.weChatLogin(userLoginDTO);
                break;
        }
        return userInfoLoginVO;
    }

}
