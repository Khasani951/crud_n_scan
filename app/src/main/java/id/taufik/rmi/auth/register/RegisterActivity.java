package id.taufik.rmi.auth.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.taufik.rmi.R;
import id.taufik.rmi.auth.login.LoginActivity;
import id.taufik.rmi.auth.register.response.ResponseRegister;
import id.taufik.rmi.dashboard.DahboardActivity;
import id.taufik.rmi.network.ApiServices;
import id.taufik.rmi.network.RetrofitClient;
import id.taufik.rmi.preference.PreferencesLogin;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText fullnm, id, mail, key, rle;

    Button btActRegist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullnm = (EditText)findViewById(R.id.etReg_fullname);
        id = (EditText)findViewById(R.id.etReg_nik);
        mail = (EditText)findViewById(R.id.etReg_email);
        key = (EditText)findViewById(R.id.etReg_pwd);
        rle = (EditText)findViewById(R.id.etReg_role);

        btActRegist = (Button)findViewById(R.id.btReg_actRegist);

        btActRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = fullnm.getText().toString();
                String nik = id.getText().toString();
                String email = mail.getText().toString();
                String pwds = key.getText().toString();
                String role = rle.getText().toString();

                register(name, nik, email, pwds, role);
            }
        });
    }

    private void register(String name, String nik, String enmail, String pwds, String role) {
        ApiServices apiServices = RetrofitClient.getInstance();
        Call<ResponseRegister> register = apiServices.reqRegisterNewUser(name, nik, enmail, pwds, role);

        register.enqueue(new Callback<ResponseRegister>() {
            @Override
            public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                Log.e("TRACE", response.body().getMessage());

                if (response.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    Bundle kirimLogin = new Bundle();
                    kirimLogin.putString("MAIL", enmail);
                    kirimLogin.putString("PWDS", pwds);
                    Intent toLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                    toLogin.putExtras(kirimLogin);
                    startActivity(toLogin);

                    finish();
                }
            }

            @Override
            public void onFailure(Call<ResponseRegister> call, Throwable t) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (PreferencesLogin.getStatusLoginAccount(RegisterActivity.this)) {
            startActivity(new Intent(RegisterActivity.this, DahboardActivity.class));
            finish();
        }
    }
}