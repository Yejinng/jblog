package com.bit2016.jblog.exception;


@SuppressWarnings("serial")
public class UserServiceException extends RuntimeException{
   public UserServiceException(){
         super("User Not Found");
      }
   
   public UserServiceException(String message){
       super(message);
    }
}