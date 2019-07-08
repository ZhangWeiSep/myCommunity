package indi.zhangwei.community.usermanage.controller;

import indi.zhangwei.community.model.dto.UserLoginDTO;
import indi.zhangwei.community.model.vo.UserInfoLoginVO;
import indi.zhangwei.community.usermanage.service.UserAuthsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @pathName: UserAuthsController
 * @author: ZhangWei
 */
@Controller
@RequestMapping("/userAuths")
public class UserAuthsController {

    /**
     * 注入用户权证服务Bean
     */
    @Autowired
    private UserAuthsService userAuthsService;

    /**
     *
     * @param userLoginDTO
     * @return
     */
    @PostMapping("/login")
    public UserInfoLoginVO login(@RequestBody UserLoginDTO userLoginDTO) {
        switch (userLoginDTO.getIdentifierType()){
            case 1:
                break;
            case 2:
                break;
            default:
                break;
        }
        return null;
    }

}
