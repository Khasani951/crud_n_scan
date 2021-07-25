package id.taufik.rmi.barcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.taufik.rmi.R;
import id.taufik.rmi.barcode.response.ResponseLot;
import id.taufik.rmi.dashboard.DahboardActivity;
import id.taufik.rmi.network.ApiServices;
import id.taufik.rmi.network.RetrofitClient;
import id.taufik.rmi.preference.PreferencesLogin;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddLotNoActivity extends AppCompatActivity {

    EditText idaily, lotno, qty, box, ttl;

    Button addToData;

    String no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lot_no);

        lotno = (EditText)findViewById(R.id.etLot_no);
        qty = (EditText)findViewById(R.id.etLot_qty);
        box = (EditText)findViewById(R.id.etLot_box);
        ttl = (EditText)findViewById(R.id.etLot_ttl);
        idaily = (EditText)findViewById(R.id.etLot_idaliy);

        addToData = (Button)findViewById(R.id.btLot_save);

        Bundle getLot = getIntent().getExtras();

        if (getIntent().getExtras() != null) {
            no = getLot.getString("CODE");

            lotno.setText(no);
        }


        addToData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mIddy = idaily.getText().toString();
                String mQty = qty.getText().toString();
                String mBox = box.getText().toString();
                String mTtl = ttl.getText().toString();

                savelotno(no, mIddy, mQty, mBox, mTtl);
            }
        });

    }

    private void savelotno(String no, String mIddy, String mQty, String mBox, String mTtl) {
        ApiServices apiServices = RetrofitClient.getInstance();
        Call<ResponseLot> lotno = apiServices.reqSafeLot(PreferencesLogin.getSafeEmail(AddLotNoActivity.this), PreferencesLogin.getSafePwd(AddLotNoActivity.this), no, mIddy, mQty, mBox, mTtl);

        lotno.enqueue(new Callback<ResponseLot>() {
            @Override
            public void onResponse(Call<ResponseLot> call, Response<ResponseLot> response) {
                if (response.isSuccessful()) {

                    int code = response.body().getCode();

                    if (code == 201) {
                        Toast.makeText(AddLotNoActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(AddLotNoActivity.this, DahboardActivity.class));
                        finish();
                    } else {
                        Toast.makeText(AddLotNoActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseLot> call, Throwable t) {

            }
        });
    }

    public void toScanAgain(View view) {
        startActivity(new Intent(AddLotNoActivity.this, BarcodeScanActivity.class));
        finish();
    }
}