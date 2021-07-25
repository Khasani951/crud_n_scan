package id.taufik.rmi.material.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseMaterial{

	@SerializedName("code")
	private int code;

	@SerializedName("newmaterial")
	private List<NewmaterialItem> newmaterial;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public int getCode(){
		return code;
	}

	public List<NewmaterialItem> getNewmaterial(){
		return newmaterial;
	}

	public String getMessage(){
		return message;
	}

	public boolean isStatus(){
		return status;
	}
}