package com.github.ichenkaihua.utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by chenkaihua on 15-8-23.
 */
public class RandomUtils {


    /**
     * 获取指定位数的的string随机数，随机范围为a-z A-Z 0-9
     * @param length string的长度
     * @return 指定lenght的随机字符串
     */
    public  static  String randomString(int length){
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(62);
            buf.append(str.charAt(num));
        }
        return buf.toString();

    }


    /**
     * 获取长度为5的随机字符串
     * @return 获取长度为5的随机字符串
     */
    public  static  String randomString(){
        return randomString(5);
    }






}
