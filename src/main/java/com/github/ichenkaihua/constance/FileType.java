package com.github.ichenkaihua.constance;

/**
 * Created by chenkaihua on 15-8-23.
 */
public enum FileType {
    IMAGE(0),VOICE(1),VIDEO(2),FILE(3);

    int type;

    public int type(){
        return type;
    }




    FileType(int type){
        this.type = type;
    }




}
