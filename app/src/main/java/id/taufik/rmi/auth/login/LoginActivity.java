package id.taufik.rmi.auth.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.taufik.rmi.R;
import id.taufik.rmi.auth.login.response.ResponseLogin;
import id.taufik.rmi.dashboard.DahboardActivity;
import id.taufik.rmi.network.ApiServices;
import id.taufik.rmi.network.RetrofitClient;
import id.taufik.rmi.preference.PreferencesLogin;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText inEmail, inPwd;
    Button actLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inEmail = (EditText)findViewById(R.id.etLog_email);
        inPwd = (EditText)findViewById(R.id.etLog_pwd);
        actLogin = (Button) findViewById(R.id.btLog_actlogin);

        Bundle getLogin = getIntent().getExtras();

        if (getIntent().getExtras() != null) {
            String eMail = getLogin.getString("MAIL");
            String ePwd = getLogin.getString("PWDS");

            inEmail.setText(eMail);
            inPwd.setText(ePwd);

            Log.e("TRACE", eMail+ePwd);
        }

        actLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inEmail.getText().toString();
                String pwd = inPwd.getText().toString();

                login(email, pwd);
            }
        });
    }

    private void login(String email, String pwd) {
        ApiServices apiServices = RetrofitClient.getInstance();
        Call<ResponseLogin> login = apiServices.reqLoginUser(email, pwd);

        login.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {

                if (response.isSuccessful()) {
                    PreferencesLogin.setSafeEmail(LoginActivity.this, email);
                    PreferencesLogin.setSafePwd(LoginActivity.this, pwd);

                    PreferencesLogin.setStatusLoginAccount(LoginActivity.this, true);

                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(LoginActivity.this, DahboardActivity.class));
                    finish();
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {

            }
        });
    }


}