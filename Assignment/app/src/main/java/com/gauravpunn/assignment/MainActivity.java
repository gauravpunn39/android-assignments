package com.gauravpunn.assignment;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button registerbtn;
    EditText nameet,mobileet,usernameet,passwordet;
    Spinner countryspinner,cityspinner;
    int CountryId,CityId;

    String [] countryArray={
            "India",
            "Japan",
            "Canada",
            "Australia",
            "China",
            "Sri Lanka",
            "Pakistan",
            "United States of America"
    };

    String [] indiaCitiesArray={
            "Delhi","Mumbai","Chennai","Kolkata","Jaipur","Shimla","Amritsar","Dehradun","Jammu","Chandigarh","Hyderabad"};
    String [] japanCitiesArray={
            "Tokyo","Yokohama","Nagoya","Kyoto","Nara","Osaka","Kobe","Hiroshima","Okinawa","Sapporo","Nagasaki"};
    String [] canadaCitiesArray={
            "Ontario","Toronto","Vancouver","Ottawa","Montreal","Calgary","Quebec City","Edmonton","Kingston"};
    String [] australiaCitiesArray={
            "Sydney","Melbourne","Adelaide","Perth","Brisbane","Canberra","Gold Coast","Hobart","New Castle"};
    String [] chinaCitiesArray={
            "Beijing","Shanghai","Chengdu","Guangzhou","Hangzhou","Tianjin","Hong Kong","Nanjing","Harbin"};
    String [] srilankaCitiesArray={
            "Kandy","Colombo","Galle","Negombo","Bentota","Nuwara Eliya","Trincomalee","Anuradhapura","Mirissa"};
    String [] pakistanCitiesArray={
            "Karachi","Lahore","Islamabad","Peshawar","Faislabad","Multan","Rawalpindi","Quetta","Hyderabad","Sialkot"};
    String [] usaCitiesArray={
            "New York City","San Francisco","Washington D.C.","Chicago","Boston","Austin","Denver","Los Angeles","Houston"};

    ArrayAdapter<String> countryAdapter;
    ArrayAdapter<String> cityAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerbtn = (Button)findViewById(R.id.RegisteBtn);

        nameet = (EditText)findViewById(R.id.NameET);
        mobileet = (EditText)findViewById(R.id.MobileET);
        usernameet = (EditText)findViewById(R.id.UsernameET);
        passwordet = (EditText)findViewById(R.id.PasswordET);

        countryspinner = (Spinner)findViewById(R.id.CountrySpinner);
        cityspinner = (Spinner)findViewById(R.id.CitySpinner);

        registerbtn.setOnClickListener(this);

        countryAdapter = new ArrayAdapter<String>(
                getApplicationContext(),android.R.layout.simple_spinner_item,countryArray);
        countryspinner.setAdapter(countryAdapter);
        countryspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                CountryId = position;
                switch (position){
                    case 0 :
                            cityAdapter = new ArrayAdapter<String>(
                                    getApplicationContext(),android.R.layout.simple_spinner_item,indiaCitiesArray);
                        cityspinner.setAdapter(cityAdapter);
                        break;
                    case 1 :
                        cityAdapter = new ArrayAdapter<String>(
                                getApplicationContext(),android.R.layout.simple_spinner_item,japanCitiesArray);
                        cityspinner.setAdapter(cityAdapter);
                        break;
                    case 2 :
                        cityAdapter = new ArrayAdapter<String>(
                                getApplicationContext(),android.R.layout.simple_spinner_item,canadaCitiesArray);
                        cityspinner.setAdapter(cityAdapter);
                        break;
                    case 3 :
                        cityAdapter = new ArrayAdapter<String>(
                                getApplicationContext(),android.R.layout.simple_spinner_item,australiaCitiesArray);
                        cityspinner.setAdapter(cityAdapter);
                        break;
                    case 4 :
                        cityAdapter = new ArrayAdapter<String>(
                                getApplicationContext(),android.R.layout.simple_spinner_item,chinaCitiesArray);
                        cityspinner.setAdapter(cityAdapter);
                        break;
                    case 5 :
                        cityAdapter = new ArrayAdapter<String>(
                                getApplicationContext(),android.R.layout.simple_spinner_item,srilankaCitiesArray);
                        cityspinner.setAdapter(cityAdapter);
                        break;
                    case 6 :
                        cityAdapter = new ArrayAdapter<String>(
                                getApplicationContext(),android.R.layout.simple_spinner_item,pakistanCitiesArray);
                        cityspinner.setAdapter(cityAdapter);
                        break;
                    case 7 :
                        cityAdapter = new ArrayAdapter<String>(
                                getApplicationContext(),android.R.layout.simple_spinner_item,usaCitiesArray);
                        cityspinner.setAdapter(cityAdapter);
                        break;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cityspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                CityId = pos;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Intent eb = getIntent();
        String name = eb.getStringExtra("name");
        String mobile = eb.getStringExtra("mobile");
        String username = eb.getStringExtra("username");
        String password = eb.getStringExtra("password");

        int countryid = eb.getIntExtra("countryi",0);
        int cityid = eb.getIntExtra("cityi",0);

        nameet.setText(name);
        mobileet.setText(mobile);
        usernameet.setText(username);
        passwordet.setText(password);
        countryspinner.setSelection(countryid);
        cityspinner.setSelection(cityid);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.RegisteBtn :
                                    String name = nameet.getText().toString();
                                    String mobile = mobileet.getText().toString();
                                    String username = usernameet.getText().toString();
                                    String password = passwordet.getText().toString();
                                    String countrys = countryspinner.getSelectedItem().toString();
                                    String citys = cityspinner.getSelectedItem().toString();

                Intent i = new Intent(MainActivity.this,ConfirmActivity.class);
                i.putExtra("name",name);
                i.putExtra("mobile",mobile);
                i.putExtra("username",username);
                i.putExtra("password",password);
                i.putExtra("country",countrys);
                i.putExtra("city",citys);

                i.putExtra("countryid",CountryId);
                i.putExtra("cityid",CityId);
                startActivity(i);

        }

    }
}
