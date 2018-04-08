package org.yqj.dao.demo.controller;

import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author yaoqijun on 2018-04-08.
 */
@Controller
public class InfoController {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(value = "/bean_info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String indexPage(){
        // mapper test
//        Map<String, PersonPretendMapper> stringPersonPretendMapperMap = applicationContext.getBeansOfType(PersonPretendMapper.class);
//        System.out.println(stringPersonPretendMapperMap.size());
//        stringPersonPretendMapperMap.forEach((k,v)-> {
//            System.out.println(k);
//            System.out.println(v.sayHello());
//        });

//        Map<String, MapperFactoryBean> stringMapperFactoryBeanMap = applicationContext.getBeansOfType(MapperFactoryBean.class);
//        System.out.println(stringMapperFactoryBeanMap.size());
//        stringMapperFactoryBeanMap.forEach((k,v)->{
//            System.out.println(k);
//            System.out.println(v.getMapperInterface().getName());
//        });

        return "OK";
    }

}
