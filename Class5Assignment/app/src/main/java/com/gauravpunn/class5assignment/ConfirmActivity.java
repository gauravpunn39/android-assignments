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
    EditText nameEt,mobileEt,usernameEt,passwordEt;
    Spinner countryS,cityS;

    int countryInt,cityInt;
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

        nameEt = (EditText)findViewById(R.id.NameET);
        mobileEt = (EditText)findViewById(R.id.MobileET);
        usernameEt = (EditText)findViewById(R.id.UsernameET);
        passwordEt = (EditText)findViewById(R.id.PasswordET);

        countryS = (Spinner)findViewById(R.id.CountrySpinner);
        cityS = (Spinner)findViewById(R.id.CitySpinner);

        editbtn.setOnClickListener(this);
        Intent i = getIntent();
        Common.name = i.getStringExtra("name");
        Common.mobile = i.getStringExtra("mobile");
        Common.username = i.getStringExtra("username");
        Common.password = i.getStringExtra("password");
        Common.country = i.getStringExtra("country");
        Common.city = i.getStringExtra("city");

        nametv.setText(Common.name);
        mobiletv.setText(Common.mobile);
        usernametv.setText(Common.username);
        passwordtv.setText(Common.password);
        countrytv.setText(Common.country);
        citytv.setText(Common.city);

        Toast.makeText(this, Common.name, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.EditBtn:
                              Intent eb = new Intent(ConfirmActivity.this,MainActivity.class);
                              nameEt.setText(Common.name);
                              mobileEt.setText(Common.mobile);
                              usernameEt.setText(Common.username);
                              passwordEt.setText(Common.password);
                              countryS.setSelection(Common.countryInt);
                              cityS.setSelection(Common.cityInt);
                              startActivity(eb);
                              break;
            default :
                     break;

        }



    }
}
