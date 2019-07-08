package indi.zhangwei.community.usermanage.service.impl;

import com.alibaba.druid.util.StringUtils;
import indi.zhangwei.community.model.dto.UserLoginDTO;
import indi.zhangwei.community.model.dto.UserRegInfoDTO;
import indi.zhangwei.community.model.entity.UserAuthsEntity;
import indi.zhangwei.community.model.vo.UserInfoLoginVO;
import indi.zhangwei.community.usermanage.repository.UserAuthsRepository;
import indi.zhangwei.community.usermanage.service.UserAuthsService;
import indi.zhangwei.community.utils.sysutils.ShiroPassWordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @pathName: UserAuthsServiceImpl
 * @author: ZhangWei
 * 用户权证服务实现
 */
@Service
public class UserAuthsServiceImpl implements UserAuthsService {

    /**
     * 引用数据库交互服务Bean
     */
    @Autowired
    private UserAuthsRepository userAuthsRepository;

    /**
     * 用户登录
     * 系统登录入口——用户名登录
     * 多种登录方式，包含但不限于微信、QQ、手机号、用户名等
     *
     * @param userLoginDTO 登录凭证信息
     * @return 用户基本信息
     */
    @Override
    public UserInfoLoginVO userLogin(UserLoginDTO userLoginDTO) {
        return null;
    }

    /**
     * 用户登录
     * 系统登录入口——手机号登录
     * 多种登录方式，包含但不限于微信、QQ、手机号、用户名等
     *
     * @param userLoginDTO 登录凭证信息
     * @return 用户基本信息
     */
    @Override
    public UserInfoLoginVO phoneLogin(UserLoginDTO userLoginDTO) {
        Optional<UserAuthsEntity> userAuthsInfo = userAuthsRepository.findByIdentifierTypeAndIdentifier(userLoginDTO.getIdentifierType(),
                userLoginDTO.getIdentifier());
        userAuthsInfo.ifPresent(userAuthsEntity ->
            StringUtils.equals(ShiroPassWordUtil.encryptPassword(userLoginDTO.getIdentifier(),
                    userLoginDTO.getPassword()), ShiroPassWordUtil.encryptPassword(userAuthsEntity.getIdentifier(),
                    userAuthsEntity.getPassword())));
        return null;
    }

    /**
     * 用户登录
     * 系统登录入口——微信登录
     * 多种登录方式，包含但不限于微信、QQ、手机号、用户名等
     *
     * @param userLoginDTO 登录凭证信息
     * @return 用户基本信息
     */
    @Override
    public UserInfoLoginVO weChatLogin(UserLoginDTO userLoginDTO) {
        return null;
    }

    /**
     * 用户注册
     * 多种注册方式，包含但不限于微信、QQ、手机号、用户名等
     *
     * @param userRegInfoDTO 注册信息
     * @return 用户唯一Id
     */
    @Override
    public Integer register(UserRegInfoDTO userRegInfoDTO) {
        return null;
    }
}
