package id.taufik.rmi.auth.login.response;

import com.google.gson.annotations.SerializedName;

public class DataUser{

	@SerializedName("nik")
	private String nik;

	@SerializedName("full_name")
	private String fullName;

	@SerializedName("role")
	private String role;

	@SerializedName("id")
	private String id;

	@SerializedName("email")
	private String email;

	public String getNik(){
		return nik;
	}

	public String getFullName(){
		return fullName;
	}

	public String getRole(){
		return role;
	}

	public String getId(){
		return id;
	}

	public String getEmail(){
		return email;
	}
}