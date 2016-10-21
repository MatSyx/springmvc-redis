package com.aaron.controller;

import com.aaron.domain.User;
import com.aaron.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

/**
 * Created by shiyongxiang on 16/10/20.
 */
@Controller
@Slf4j
public class SiteController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("add")
    @ResponseBody
    public String add(User user){
        log.info("=====add======");
        log.info("User={}",user);
        userRepository.save(user);
        return "添加成功";
    }

    @RequestMapping("cache")
    @ResponseBody
    public String cache(String key,String value,Long timeout){
        stringRedisTemplate.opsForValue().set(key,value,timeout, TimeUnit.SECONDS);
        return "添加成功";
    }

    @RequestMapping("getCache")
    @ResponseBody
    public String getCache(String key){
        log.info("key={}",key);
        String cache=stringRedisTemplate.opsForValue().get(key);
        log.info("cache={}",cache);
        return cache;
    }

    @RequestMapping("get")
    @ResponseBody
    @Cacheable(value = "cccshi",key = "'id_'+#id")
    public User get(String id){
        log.info("======get=======");
        log.info("id={}",id);
        User user=userRepository.getUserByUserId(id);
        log.info("user={}",user);
        return  user;
    }
}
