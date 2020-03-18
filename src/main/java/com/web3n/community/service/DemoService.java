package com.web3n.community.service;

import com.web3n.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @create 2020-03-17 10:24
 */

@Service
public class DemoService {
    @Autowired
    private AlphaDao alphaDao;
    
    public String find(){
        return alphaDao.select();
    }
    
    public DemoService(){
        System.out.println("实例化 DemoService");
    }
    @PostConstruct  // 初始化注解
    public void init(){
        System.out.println("初始化 DemoService");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("销毁 DemoService");
    }
}
