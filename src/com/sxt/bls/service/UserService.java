package com.sxt.bls.service;

import com.sxt.bls.vo.UserVo;

public interface UserService {

    UserVo findUserByName(UserVo userVo);
}
