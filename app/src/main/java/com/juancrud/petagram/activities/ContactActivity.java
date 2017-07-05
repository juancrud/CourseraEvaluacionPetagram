package com.juancrud.petagram.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.juancrud.petagram.R;
import com.juancrud.petagram.SendMail;

public class ContactActivity extends AppCompatActivity {

    private EditText etContactName;
    private EditText etContactEmail;
    private EditText etContactMessage;
    private Button btnContactSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        etContactName = (EditText)findViewById(R.id.etContactName);
        etContactEmail = (EditText)findViewById(R.id.etContactEmail);
        etContactMessage = (EditText)findViewById(R.id.etContactMessage);
        btnContactSend = (Button)findViewById(R.id.btnContactSend);
    }

    public void btnContactSendOnClick(View view){
        String nombre = etContactName.getText().toString();
        String email = etContactEmail.getText().toString();
        String mensaje = etContactMessage.getText().toString();

        SendMail sm = new SendMail(this, email, "Hola " + nombre, mensaje);
        sm.execute();

        clear();
    }

    private void clear(){
        etContactName.setText("");
        etContactEmail.setText("");
        etContactMessage.setText("");
    }

}
