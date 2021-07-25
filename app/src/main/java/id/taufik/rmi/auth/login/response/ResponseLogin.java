package id.taufik.rmi.auth.login.response;

import com.google.gson.annotations.SerializedName;

public class ResponseLogin{

	@SerializedName("code")
	private int code;

	@SerializedName("data_user")
	private DataUser dataUser;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public int getCode(){
		return code;
	}

	public DataUser getDataUser(){
		return dataUser;
	}

	public String getMessage(){
		return message;
	}

	public boolean isStatus(){
		return status;
	}
}