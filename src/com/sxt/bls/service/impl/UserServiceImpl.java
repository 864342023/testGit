package com.sxt.bls.service.impl;

import com.sxt.bls.dao.UserDao;
import com.sxt.bls.pojo.User;
import com.sxt.bls.service.UserService;
import com.sxt.bls.utils.MD5;
import com.sxt.bls.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public UserVo findUserByName(UserVo userVo) {
        User user = userDao.findUserByName(userVo.getUname());
        if (null != user){
            if (user.getPassword().equals(new MD5().getMD5ofStr(userVo.getPassword()))){
                user.setLastLoginTime(new Date());
                BeanUtils.copyProperties(user,userVo);
                return userVo;
            }
        }
        return null;
    }
}
