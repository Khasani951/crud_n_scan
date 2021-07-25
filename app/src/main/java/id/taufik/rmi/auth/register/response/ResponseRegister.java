package id.taufik.rmi.auth.register.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseRegister{

	@SerializedName("code")
	private int code;

	@SerializedName("newregist")
	private List<NewregistItem> newregist;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public int getCode(){
		return code;
	}

	public List<NewregistItem> getNewregist(){
		return newregist;
	}

	public String getMessage(){
		return message;
	}

	public boolean isStatus(){
		return status;
	}
}