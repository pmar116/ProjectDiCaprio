package com.example.preston.projectdicaprio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public class Pacer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pacer);

        Toolbar myToolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    //menu icons are inflated

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu. This adds items to the action bar, if it is present
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
