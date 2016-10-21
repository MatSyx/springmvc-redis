package com.aaron.repository;

import com.aaron.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by shiyongxiang on 16/10/21.
 */
@Repository
public class UserRepository {

    private RedisTemplate <Object, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    private ValueOperations<Object, User> valOps;

    @Autowired
    public UserRepository(RedisTemplate<Object, Object> redisTemplate) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(User.class);
        //加入下面的代码插入redis中数据会带类名 在javaconfig spring-data-redis在config类中将Object.class传给Jackson2JsonRedisSerializer()时使用
        //对应具体类的Repository将对应类名传给 Jackson2JsonRedisSerializer()是最好的
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        this.redisTemplate=redisTemplate;
    }

    public void save(User user){
        valOps.set(String.valueOf(user.getId()),user);
    }

    public User getUserByUserId(String id){
        return valOps.get(id);
    }
}
