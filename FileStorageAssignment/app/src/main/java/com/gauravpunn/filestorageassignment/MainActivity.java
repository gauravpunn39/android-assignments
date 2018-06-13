package com.gauravpunn.filestorageassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameet,mobileet,unameet,passet,cityet;
    Button savebtn;
    String FILENAME="userFile.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameet = (EditText)findViewById(R.id.NameET);
        mobileet = (EditText)findViewById(R.id.MobileET);
        unameet = (EditText)findViewById(R.id.UnameET);
        passet = (EditText)findViewById(R.id.PassET);
        cityet = (EditText)findViewById(R.id.CityET);

        savebtn = (Button)findViewById(R.id.SaveBtn);

        savebtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.SaveBtn) {
            try {
                FileOutputStream fileOutputStream = openFileOutput(FILENAME, MODE_PRIVATE);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                outputStreamWriter.write(nameet.getText().toString());
                outputStreamWriter.write(mobileet.getText().toString());
                outputStreamWriter.write(unameet.getText().toString());
                outputStreamWriter.write(passet.getText().toString());
                outputStreamWriter.write(cityet.getText().toString());

                outputStreamWriter.close();
                Toast.makeText(this, "User Details Succesfully Saved", Toast.LENGTH_SHORT).show();
                Intent sb = new Intent(MainActivity.this,DetailsActivity.class);
                startActivity(sb);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
