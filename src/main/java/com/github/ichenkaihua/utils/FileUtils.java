package com.github.ichenkaihua.utils;

/**
 * Created by chenkaihua on 15-8-23.
 */
public class FileUtils {


    public static String getFileType(String fileName){
        int index = fileName.lastIndexOf(".");
        int length = fileName.length();
        String fileType = null;
        if( index == -1){
            fileType = "";
        }
        else {
            fileType =  fileName.substring(index,length);
        }
        return  fileType;


    }

}
