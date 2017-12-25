package com.sxt.bls.dao;

import com.sxt.bls.pojo.User;

public interface UserDao {
    User findUserByName(String uname);
}
