package id.taufik.rmi.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import id.taufik.rmi.R;
import id.taufik.rmi.barcode.BarcodeScanActivity;
import id.taufik.rmi.machine.MachineActivity;
import id.taufik.rmi.material.MaterialActivity;

public class DahboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dahboard);
    }

    public void scanLotNo(View view) {
        startActivity(new Intent(DahboardActivity.this, BarcodeScanActivity.class));
    }

    public void addMaterial(View view) {
        startActivity(new Intent(DahboardActivity.this, MaterialActivity.class));
    }

    public void addMachine(View view) {
        startActivity(new Intent(DahboardActivity.this, MachineActivity.class));
    }
}