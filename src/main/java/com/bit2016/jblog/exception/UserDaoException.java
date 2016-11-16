package com.bit2016.jblog.exception;


@SuppressWarnings("serial")
public class UserDaoException extends RuntimeException{
   public UserDaoException(){
         super("User Not Found");
      }
}