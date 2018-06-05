package com.gauravpunn.class4assisment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button loginbtn,resetbtn;
    EditText useret,passet;
    TextView registerlink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginbtn = (Button)findViewById(R.id.LoginBtn);
        resetbtn = (Button)findViewById(R.id.ResetBtn);

        useret = (EditText)findViewById(R.id.UserNameET);
        passet = (EditText)findViewById(R.id.PassWordET);

        registerlink = (TextView)findViewById(R.id.RegistrationLink);

        loginbtn.setOnClickListener(this);
        resetbtn.setOnClickListener(this);
        registerlink.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.LoginBtn:
                                Intent i = getIntent();
                                String name = i.getStringExtra("name");
                                String mobile = i.getStringExtra("mobile");
                                String uname = i.getStringExtra("username");
                                String pwd = i.getStringExtra("password");

                                String username = useret.getText().toString();
                                String password = passet.getText().toString();

                                if(username.equalsIgnoreCase(uname) && password.equals(pwd)){

                                   Intent lb = new Intent(MainActivity.this,LoginActivity.class);
                                   lb.putExtra("username",username);
                                   startActivity(lb);
                                }else {
                                    Toast.makeText(this, "User Details are incorrect", Toast.LENGTH_SHORT).show();
                                }

                                break;
            case R.id.ResetBtn:
                               useret.setText("");
                               passet.setText("");
                               break;
            case R.id.RegistrationLink:
                               Toast.makeText(this, "Redirecting to Registration Page", Toast.LENGTH_SHORT).show();
                               Intent rl = new Intent(MainActivity.this,RegisterActivity.class);
                               startActivity(rl);
                               break;

        }

    }
}
