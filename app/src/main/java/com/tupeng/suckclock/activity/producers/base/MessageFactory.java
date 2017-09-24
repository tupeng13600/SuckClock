package com.tupeng.suckclock.activity.producers.base;

import android.os.Handler;
import android.os.Message;

import com.tupeng.suckclock.constant.Constant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 22670 on 2017/9/19.
 */

public abstract class MessageFactory {

    private static String logTag = Constant.tag(MessageFactory.class);

    private static ExecutorService threadPool = Executors.newFixedThreadPool(8);

    public static void sendMessage(final MessageSender sender, final Handler handler){
        threadPool.execute(() -> {
            Message message = new Message();
            sender.buildMessage(message);
            handler.sendMessage(message);
        });
    }
}
