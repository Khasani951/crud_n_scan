package id.taufik.rmi.material;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.security.SecureRandom;

import id.taufik.rmi.R;
import id.taufik.rmi.dashboard.DahboardActivity;
import id.taufik.rmi.material.response.ResponseMaterial;
import id.taufik.rmi.network.ApiServices;
import id.taufik.rmi.network.RetrofitClient;
import id.taufik.rmi.preference.PreferencesLogin;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MaterialActivity extends AppCompatActivity {

    EditText tag, berat, start, finish, ttltm, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);

        tag = (EditText)findViewById(R.id.etMat_tag);
        berat = (EditText)findViewById(R.id.etMat_berat);
        start = (EditText)findViewById(R.id.etMat_start);
        finish = (EditText)findViewById(R.id.etMat_finish);
        ttltm = (EditText)findViewById(R.id.etMat_ttltime);
        result = (EditText)findViewById(R.id.etMat_result);

        //createCodeAcak();
    }

    private void createCodeAcak() {
        SecureRandom random = new SecureRandom();
        int num = random.nextInt(100000000);
        tag.setText(num);
    }

    public void onSafeMaterial(View view) {
        String mTag = tag.getText().toString();
        String mBerat = berat.getText().toString();
        String mStart = start.getText().toString();
        String mFinish = finish.getText().toString();
        String mTtlWkt = ttltm.getText().toString();
        String mResult = result.getText().toString();

        ApiServices apiServices = RetrofitClient.getInstance();
        Call<ResponseMaterial> material = apiServices.reqSafeMaterial(
                PreferencesLogin.getSafeEmail(MaterialActivity.this),
                PreferencesLogin.getSafePwd(MaterialActivity.this),
                mTag,
                mBerat,
                mStart,
                mFinish,
                mTtlWkt,
                mResult);

        material.enqueue(new Callback<ResponseMaterial>() {
            @Override
            public void onResponse(Call<ResponseMaterial> call, Response<ResponseMaterial> response) {

                if (response.isSuccessful()) {

                    int code = response.body().getCode();

                    if (code == 201) {
                        Toast.makeText(MaterialActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MaterialActivity.this, DahboardActivity.class));

                        finish();
                    } else {
                        Toast.makeText(MaterialActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseMaterial> call, Throwable t) {

            }
        });
    }
}