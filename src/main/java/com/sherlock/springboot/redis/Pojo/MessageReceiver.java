package com.sherlock.springboot.redis.Pojo;

import org.springframework.stereotype.Component;

/**
 * @auther Sherlock
 * @date 2020/4/1 23:46
 * @Description:
 */
@Component
public class MessageReceiver {

    /**接收消息的方法*/
    public void receiveMessage(String message){
        System.out.println("收到一条消息："+message);
    }

}
