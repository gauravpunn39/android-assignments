package com.gauravpunn.class4assisment3;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    Button registerbtn;
    EditText nameet,mobileet,useret,passet;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_main);

        registerbtn = (Button)findViewById(R.id.RegisterBtn);

        nameet = (EditText)findViewById(R.id.NameET);
        mobileet = (EditText)findViewById(R.id.MobileET);
        useret = (EditText)findViewById(R.id.UserET);
        passet = (EditText)findViewById(R.id.PassET);

        registerbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.RegisterBtn :
                                   String name = nameet.getText().toString();
                                   String mobile = mobileet.getText().toString();
                                   String uname = useret.getText().toString();
                                   String pwd = passet.getText().toString();
                                   Intent i = new Intent(RegisterActivity.this,MainActivity.class);
                                   i.putExtra("name",name);
                                   i.putExtra("mobile",mobile);
                                   i.putExtra("username",uname);
                                   i.putExtra("password",pwd);
                                   startActivity(i);
                                   break;
            default:
                                   break;
        }

    }
}
