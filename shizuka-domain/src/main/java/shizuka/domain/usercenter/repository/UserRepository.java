package shizuka.domain.usercenter.repository;

import shizuka.domain.usercenter.model.UserInfo;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-09-10 14:53
 */
public interface UserRepository {
    UserInfo getUserInfo(String uid);
}
