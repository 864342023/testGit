package com.sxt.bls.utils;

import com.opensymphony.xwork2.ActionContext;
import com.sxt.bls.vo.UserVo;
import org.apache.struts2.ServletActionContext;

public class StackUtils {


    /**
     * 将数据保存到request作用域中
     * @param key
     * @param object
     */
    public static void putStack(String key ,Object object){
        ActionContext.getContext().put(key ,object);
    }


    /**
     * 将数据保存到session作用域中
     * @param key
     * @param object
     */
    public static void putSession(String key ,Object object){
        ActionContext.getContext().getSession().put(key, object);
    }

    /**
     * 从session中获取当前用户
     * @return
     */
    public static UserVo getUserBySession (){
        return (UserVo) ActionContext.getContext().getSession().get("userVo");
    }

    /**
     * 注销session
     */
    public static void clearSession(){
        ServletActionContext.getRequest().getSession().invalidate();
    }
}
