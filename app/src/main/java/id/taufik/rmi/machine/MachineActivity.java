package id.taufik.rmi.machine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import id.taufik.rmi.R;
import id.taufik.rmi.dashboard.DahboardActivity;
import id.taufik.rmi.machine.response.ResponseMesin;
import id.taufik.rmi.network.ApiServices;
import id.taufik.rmi.network.RetrofitClient;
import id.taufik.rmi.preference.PreferencesLogin;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MachineActivity extends AppCompatActivity {

    EditText nmachine, die, spm, timid, vorl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine);

        nmachine = (EditText)findViewById(R.id.etMac_nomc);
        die = (EditText)findViewById(R.id.etMac_dieheight);
        spm = (EditText)findViewById(R.id.etMac_spm);
        timid = (EditText)findViewById(R.id.etMac_tmid);
        vorl = (EditText)findViewById(R.id.etMac_vorl);
    }

    public void onSafeMesin(View view) {

        String mNoMac = nmachine.getText().toString();
        String mDie = die.getText().toString();
        String mSpm = spm.getText().toString();
        String mTimingID = timid.getText().toString();
        String mVorl = vorl.getText().toString();

        ApiServices apiServices = RetrofitClient.getInstance();
        Call<ResponseMesin> mesin = apiServices.reqSafeMesin(PreferencesLogin.getSafeEmail(MachineActivity.this), PreferencesLogin.getSafePwd(MachineActivity.this), mNoMac, mDie, mSpm, mTimingID, mVorl);

        mesin.enqueue(new Callback<ResponseMesin>() {
            @Override
            public void onResponse(Call<ResponseMesin> call, Response<ResponseMesin> response) {
                if (response.isSuccessful()) {

                    int code = response.body().getCode();

                    if (code == 201) {
                        Toast.makeText(MachineActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MachineActivity.this, DahboardActivity.class));

                        finish();
                    } else {
                        Toast.makeText(MachineActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseMesin> call, Throwable t) {

            }
        });

    }
}