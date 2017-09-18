package com.juancrud.petagram.activities;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.juancrud.petagram.R;

public class ConfigurarActivity extends AppCompatActivity {

    private TextView tvConfigurarCuenta;
    private EditText etConfigurarCuenta;
    private Button btnConfigurarCuenta;

    private String cuentaKey;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar);

        tvConfigurarCuenta = (TextView)findViewById(R.id.tvConfigurarCuenta);
        etConfigurarCuenta = (EditText)findViewById(R.id.etConfigurarCuenta);
        btnConfigurarCuenta = (Button)findViewById(R.id.btnConfigurarCuenta);

        cuentaKey = getString(R.string.CuentaKey);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        String cuentaActual = preferences.getString(cuentaKey, null);
        if(cuentaActual != null){
            etConfigurarCuenta.setText(cuentaActual);
        }
    }

    public void onClick(View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(cuentaKey, etConfigurarCuenta.getText().toString());
        editor.apply();

        finish();
    }
}
