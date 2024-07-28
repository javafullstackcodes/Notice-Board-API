package com.kiu.noticeboard.exception;

public class NoticeNotFoundException extends  RuntimeException{

    public NoticeNotFoundException(String message){
        super(message);
    }
}
