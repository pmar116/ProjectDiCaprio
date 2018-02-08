package com.example.preston.projectdicaprio;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Settings extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    EditText ed1;
    EditText ed2;
    EditText ed3;
    EditText ed4;
    Button b1;
    Toolbar myToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        ed1=findViewById(R.id.editText1);
        ed2=findViewById(R.id.editText2);
        ed3=findViewById(R.id.editText3);
        ed4=findViewById(R.id.editText4);
        b1=findViewById(R.id.button);

        ed1.setText(sharedpreferences.getString("name",""));
        ed2.setText(sharedpreferences.getString("age",""));
        ed3.setText(sharedpreferences.getString("weight",""));
        ed4.setText(sharedpreferences.getString("height",""));
        Toolbar myToolbar = (Toolbar)findViewById(R.id.settingToolbar);
        setSupportActionBar(myToolbar);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name  = ed1.getText().toString();
                String age  = ed2.getText().toString();
                String weight  = ed3.getText().toString();
                String height  = ed4.getText().toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("name", name);
                editor.putString("age", age);
                editor.putString("weight", weight);
                editor.putString("height", height);
                editor.commit();
            }
        });

}
}
