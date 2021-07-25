package id.taufik.rmi.network;

import id.taufik.rmi.auth.login.response.ResponseLogin;
import id.taufik.rmi.auth.register.response.ResponseRegister;
import id.taufik.rmi.barcode.response.ResponseLot;
import id.taufik.rmi.machine.response.ResponseMesin;
import id.taufik.rmi.material.response.ResponseMaterial;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiServices {

    @FormUrlEncoded
    @POST("auth/login.php")
    Call<ResponseLogin> reqLoginUser (
            @Field("email") String setEmail,
            @Field("password") String setPassword
    );

    @FormUrlEncoded
    @POST("auth/register.php")
    Call<ResponseRegister> reqRegisterNewUser (
            @Field("full_name") String setFull_name,
            @Field("nik") String setNik,
            @Field("email") String setEmail,
            @Field("password") String setPassword,
            @Field("role") String setRole
    );

    @FormUrlEncoded
    @POST("module/lot/create_lot.php")
    Call<ResponseLot> reqSafeLot (
            @Field("email") String setEmail,
            @Field("password") String setPassword,
            @Field("lot_no") String setLotno,
            @Field("id_daily") String setIdDaily,
            @Field("qty") String setQty,
            @Field("box") String setBox,
            @Field("total") String setTotal
    );

    @FormUrlEncoded
    @POST("module/material/create_material.php")
    Call<ResponseMaterial> reqSafeMaterial (
            @Field("email") String setEmail,
            @Field("password") String setPassword,
            @Field("tag_material") String setTagMat,
            @Field("berat") String setBerat,
            @Field("start") String setStart,
            @Field("finish") String setFinish,
            @Field("total_time") String setTotal,
            @Field("result") String setResult
    );

    @FormUrlEncoded
    @POST("module/machine/create_data_machine.php")
    Call<ResponseMesin> reqSafeMesin (
            @Field("email") String setEmail,
            @Field("password") String setPassword,
            @Field("mc_no") String setM_no,
            @Field("die_height") String setDie_height,
            @Field("spm") String setSpm,
            @Field("timing_id") String setTiming_id,
            @Field("vorl_role_id") String setVorl_role_id
    );

}
