package com.ian.mvn.account.email;


public class AccountEmailException extends Exception{

	public AccountEmailException(){}

	public AccountEmailException(String msg, Throwable cause){
		super(msg, cause);
	}
}