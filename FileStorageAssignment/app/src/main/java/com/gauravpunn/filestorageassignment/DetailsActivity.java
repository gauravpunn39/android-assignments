package com.gauravpunn.filestorageassignment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class DetailsActivity extends AppCompatActivity {

    TextView detailstv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        detailstv = (TextView)findViewById(R.id.DetailsTV);

        try {
            FileInputStream fileInputStream = openFileInput("userFile.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            char[] inputDetails = new char[10];
            String holdDetails ="";

            int charCount;
            while((charCount = inputStreamReader.read(inputDetails))>0){
                holdDetails = holdDetails+String.copyValueOf(inputDetails);
            }
            inputStreamReader.close();
            detailstv.setText(holdDetails);
            detailstv.setVisibility(TextView.VISIBLE);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
