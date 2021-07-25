package id.taufik.rmi.barcode.response;

import com.google.gson.annotations.SerializedName;

public class NewlotItem{

	@SerializedName("id_daily")
	private String idDaily;

	@SerializedName("lot_no")
	private String lotNo;

	@SerializedName("total")
	private String total;

	@SerializedName("qty")
	private String qty;

	@SerializedName("box")
	private String box;

	@SerializedName("id")
	private String id;

	public String getIdDaily(){
		return idDaily;
	}

	public String getLotNo(){
		return lotNo;
	}

	public String getTotal(){
		return total;
	}

	public String getQty(){
		return qty;
	}

	public String getBox(){
		return box;
	}

	public String getId(){
		return id;
	}
}