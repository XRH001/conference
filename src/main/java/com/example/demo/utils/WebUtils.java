package com.example.demo.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 把map中的值注入到javabean对象中
 * 相当于省去了取实参和带实参的构造方法,以此替代
 */
public class WebUtils {
    public static <T> T copyParameterToBean(Map map, T bean){
        try {
            BeanUtils.populate(bean,map);
        }catch (Exception e){
            e.printStackTrace();
        }
            return bean;
    }
}
