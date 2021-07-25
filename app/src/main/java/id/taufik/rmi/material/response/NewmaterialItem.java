package id.taufik.rmi.material.response;

import com.google.gson.annotations.SerializedName;

public class NewmaterialItem{

	@SerializedName("result")
	private String result;

	@SerializedName("berat")
	private String berat;

	@SerializedName("start")
	private String start;

	@SerializedName("tag_number")
	private String tagNumber;

	@SerializedName("finish")
	private String finish;

	@SerializedName("id")
	private String id;

	@SerializedName("total_time")
	private String totalTime;

	public String getResult(){
		return result;
	}

	public String getBerat(){
		return berat;
	}

	public String getStart(){
		return start;
	}

	public String getTagNumber(){
		return tagNumber;
	}

	public String getFinish(){
		return finish;
	}

	public String getId(){
		return id;
	}

	public String getTotalTime(){
		return totalTime;
	}
}