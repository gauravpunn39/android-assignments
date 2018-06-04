package com.gauravpunn.class4assisment3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    TextView userT;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

      Intent lb = getIntent();
      String username = lb.getStringExtra("username");

              userT = (TextView)findViewById(R.id.HelloTV);
              userT.setText(userT.getText()+" "+username+",");
    }
    }

