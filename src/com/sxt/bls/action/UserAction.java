package com.sxt.bls.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sxt.bls.service.UserService;
import com.sxt.bls.utils.StackUtils;
import com.sxt.bls.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<UserVo>{

    @Autowired
    private UserService userService;
    private UserVo userVo = new UserVo();
    @Override
    public UserVo getModel() {
        return userVo;
    }

    public String login(){
        UserVo vo = userService.findUserByName(userVo);
        if (null != vo){
            StackUtils.putSession("user",vo);
            return "toMain";
        }
        return "login";
    }
}
