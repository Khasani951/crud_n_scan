package id.taufik.rmi.barcode.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseLot{

	@SerializedName("code")
	private int code;

	@SerializedName("message")
	private String message;

	@SerializedName("newlot")
	private List<NewlotItem> newlot;

	@SerializedName("status")
	private boolean status;

	public int getCode(){
		return code;
	}

	public String getMessage(){
		return message;
	}

	public List<NewlotItem> getNewlot(){
		return newlot;
	}

	public boolean isStatus(){
		return status;
	}
}