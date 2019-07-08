package indi.zhangwei.community.usermanage.repository;

import indi.zhangwei.community.model.entity.UserAuthsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @pathName: UserAuthsRepository
 * @author: ZhangWei
 */
@Repository
public interface UserAuthsRepository extends JpaRepository<UserAuthsEntity, Integer>,
        JpaSpecificationExecutor<UserAuthsEntity> {

    /**
     * 查询用户信息
     * 根据登录类型和登录标识查询用户权证信息
     * @param identifierType 登录类型
     * @param identifier 登录标识
     * @return 用户权证信息
     */
    Optional<UserAuthsEntity> findByIdentifierTypeAndIdentifier(Integer identifierType, String identifier);

}
