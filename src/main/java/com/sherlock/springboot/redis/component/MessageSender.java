package com.sherlock.springboot.redis.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @auther Sherlock
 * @date 2020/4/2 0:02
 * @Description:
 */
@EnableScheduling
@Component
public class MessageSender {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Scheduled(fixedRate = 2000) //间隔2s 通过StringRedisTemplate对象向redis消息队列chat频道发布消息
    public void sendMessage(){
        stringRedisTemplate.convertAndSend("chat",String.valueOf(Math.random()));
    }

    @Scheduled(fixedRate = 3000) //间隔2s 通过StringRedisTemplate对象向redis消息队列chat频道发布消息
    public void sendMessageUUID(){
        stringRedisTemplate.convertAndSend("chat1",(UUID.randomUUID().toString().substring(0,20)));
    }
}
