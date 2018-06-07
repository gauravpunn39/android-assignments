package com.gauravpunn.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ConfirmActivity extends AppCompatActivity implements View.OnClickListener {

    TextView nametv,mobiletv,usernametv,passwordtv,countrytv,citytv;
    Button editbtn;
    String name,mobile,username,password,country,city;
    int cityId,countryId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        nametv = (TextView)findViewById(R.id.nameTV);
        mobiletv = (TextView)findViewById(R.id.mobileTV);
        usernametv = (TextView)findViewById(R.id.usernameTV);
        passwordtv = (TextView)findViewById(R.id.passwordTV);
        countrytv = (TextView)findViewById(R.id.countryTV);
        citytv = (TextView)findViewById(R.id.cityTV);

        editbtn = (Button)findViewById(R.id.EditBtn);

        Intent i = getIntent();
        name = i.getStringExtra("name");
        mobile = i.getStringExtra("mobile");
        username = i.getStringExtra("username");
        password = i.getStringExtra("password");
        country = i.getStringExtra("country");
        city = i.getStringExtra("city");

        countryId = i.getIntExtra("countryid",0);
        cityId = i.getIntExtra("cityid",0);

        nametv.setText(name);
        mobiletv.setText(mobile);
        usernametv.setText(username);
        passwordtv.setText(password);
        countrytv.setText(country);
        citytv.setText(city);

        editbtn.setOnClickListener(this);

    }

    @Override

    public void onClick(View v) {

        switch (v.getId()){

            case R.id.EditBtn :
                                Intent eb = new Intent(ConfirmActivity.this,MainActivity.class);
                eb.putExtra("name",name);
                eb.putExtra("mobile",mobile);
                eb.putExtra("username",username);
                eb.putExtra("password",password);
                eb.putExtra("countryi",countryId);
                eb.putExtra("cityi",cityId);
                                startActivity(eb);
                                break;


        }

    }
}
