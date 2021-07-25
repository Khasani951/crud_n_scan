package id.taufik.rmi.machine.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseMesin{

	@SerializedName("code")
	private int code;

	@SerializedName("newmesin")
	private List<NewmesinItem> newmesin;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public int getCode(){
		return code;
	}

	public List<NewmesinItem> getNewmesin(){
		return newmesin;
	}

	public String getMessage(){
		return message;
	}

	public boolean isStatus(){
		return status;
	}
}