package com.gauravpunn.class5assignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmActivity extends AppCompatActivity implements View.OnClickListener {

    Button editbtn;
    TextView nametv,mobiletv,usernametv,passwordtv,countrytv,citytv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        editbtn = (Button)findViewById(R.id.EditBtn);

        nametv = (TextView)findViewById(R.id.NameTV);
        mobiletv = (TextView)findViewById(R.id.MobileTV);
        usernametv = (TextView)findViewById(R.id.UsernameTV);
        passwordtv = (TextView)findViewById(R.id.PasswordTV);
        countrytv = (TextView)findViewById(R.id.CountryTV);
        citytv = (TextView)findViewById(R.id.CityTV);


        editbtn.setOnClickListener(this);

        nametv.setText(Common.name);
        mobiletv.setText(Common.mobile);
        usernametv.setText(Common.username);
        passwordtv.setText(Common.password);
        countrytv.setText(Common.country);
        citytv.setText(Common.city);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.EditBtn:
                              Intent eb = new Intent(ConfirmActivity.this,MainActivity.class);
                              startActivity(eb);
                              break;
            default :
                     break;

        }



    }
}
