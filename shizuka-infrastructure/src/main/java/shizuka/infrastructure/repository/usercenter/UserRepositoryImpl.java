package shizuka.infrastructure.repository.usercenter;

import shizuka.domain.usercenter.model.UserInfo;
import shizuka.domain.usercenter.repository.UserRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-09-10 14:57
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    public UserInfo getUserInfo(String uid) {
        return null;
    }
}
