package id.taufik.rmi.machine.response;

import com.google.gson.annotations.SerializedName;

public class NewmesinItem{

	@SerializedName("timing_id")
	private String timingId;

	@SerializedName("spm")
	private String spm;

	@SerializedName("mc_no")
	private String mcNo;

	@SerializedName("die_height")
	private String dieHeight;

	@SerializedName("vorl_role_id")
	private String vorlRoleId;

	@SerializedName("id")
	private String id;

	public String getTimingId(){
		return timingId;
	}

	public String getSpm(){
		return spm;
	}

	public String getMcNo(){
		return mcNo;
	}

	public String getDieHeight(){
		return dieHeight;
	}

	public String getVorlRoleId(){
		return vorlRoleId;
	}

	public String getId(){
		return id;
	}
}