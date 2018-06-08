package com.gauravpunn.menuassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nameet,mobileet,usernameet,passwordet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameet = (EditText)findViewById(R.id.NameET);
        mobileet = (EditText)findViewById(R.id.MobileET);
        usernameet = (EditText)findViewById(R.id.UsernameET);
        passwordet = (EditText)findViewById(R.id.PasswordET);

        registerForContextMenu(nameet);
        registerForContextMenu(mobileet);
        registerForContextMenu(usernameet);
        registerForContextMenu(passwordet);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {


                menu.add(0, 102, 1, "Copy");
                menu.add(0, 103, 2, "Cut");
                menu.add(0,103,3,"Paste");
                menu.add(0, 104, 4, "Select All");

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.settingMenuOption :
                Toast.makeText(this, "Setting menu option is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.profileMenuOption :
                Toast.makeText(this, "Profile menu option is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.loginMenuOption :
                Toast.makeText(this, "Login menu option is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.exitMenuOption :
                Toast.makeText(this, "Exit menu option is clicked", Toast.LENGTH_SHORT).show();
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
