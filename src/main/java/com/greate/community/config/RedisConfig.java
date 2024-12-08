package com.greate.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * Redis 配置类
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        // 设置 key 的序列化的方式
        template.setKeySerializer(RedisSerializer.string());
        // 设置 value 的序列化的方式
        template.setValueSerializer(RedisSerializer.json());
        // 设置 hash 的 key 的序列化的方式
        template.setHashKeySerializer(RedisSerializer.string());
        // 设置 hash 的 value 的序列化的方式
        template.setHashValueSerializer(RedisSerializer.json());

        // 调用afterPropertiesSet方法是Spring框架确保Bean在完全配置好后进行初始化的一种机制。
        // RedisTemplate或其父类/实现可能会需要在所有属性被设置好后进行一些初始化操作，例如连接池的初始化、一些默认配置的设置等
        // 这里调用是为了确保必要的配置（依赖注入的属性）和初始化操作（afterPropertiesSet 方法中的内容）在使用Bean前都已经就绪
        template.afterPropertiesSet();

        return template;
    }

}
