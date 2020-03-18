package com.web3n.community;

import com.web3n.community.dao.AlphaDao;
import com.web3n.community.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    
    @Test
    public void testApplicationContext(){
        System.out.println(applicationContext);
        AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
        System.out.println(alphaDao.select());
    
        AlphaDao myDaoBean = applicationContext.getBean("myDaoBean", AlphaDao.class);
        System.out.println(myDaoBean.select());
    
    }
    
    @Test
    public void testBeanManagement(){
        DemoService applicationName = applicationContext.getBean(DemoService.class);
        System.out.println(applicationName);
        applicationName = applicationContext.getBean(DemoService.class);
        System.out.println(applicationName);
    }
    
    @Test
    public void testBeanConfig(){
        SimpleDateFormat dateBean = applicationContext.getBean(SimpleDateFormat.class);
        System.out.println(dateBean.format(new Date()));
    }
    @Autowired
    @Qualifier("AlphaDaoImpl")
    private AlphaDao alphaDao;
    @Test
    public void testDI(){
        System.out.println(alphaDao);
    }
}
