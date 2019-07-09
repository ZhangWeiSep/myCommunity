package indi.zhangwei.community.usermanage.repository;

import indi.zhangwei.community.usermanage.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @pathName: UserInfoRepository
 * @author: ZhangWei
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Integer>, JpaSpecificationExecutor<UserInfoEntity> {
}
