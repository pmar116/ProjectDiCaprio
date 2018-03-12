package com.example.preston.projectdicaprio;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Pacer extends AppCompatActivity {
    private final Handler handler = new Handler();
    private GraphView graph;
    private Runnable timer1;
    private LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //creation of instance
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pacer);

        //toolkit stuff
        Toolbar myToolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        //Create the circle and run the animations
        final View circle = findViewById(R.id.pacerCircle);
        final Animation anim = AnimationUtils.loadAnimation(this, R.anim.scale);

        //Graph init
        graph = (GraphView) findViewById(R.id.graph);
        series = new LineGraphSeries<>(generateData());
        graph.addSeries(series);



        Button start = (Button) findViewById(R.id.startButton);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                circle.startAnimation(anim);

            }
        });
    }

    //menu icons are inflated
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu. This adds items to the action bar, if it is present
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Overflow menu button selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                Intent toSettings = new Intent(Pacer.this, Settings.class);
                startActivity(toSettings);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    //when the graph resumes
    @Override
    public void onResume(){
        super.onResume();
        timer1 = new Runnable(){
            @Override
            public void run(){
                series.resetData(generateData());
                handler.postDelayed(this,781);
            }
        };
        handler.postDelayed(timer1, 781);
    }

    //when the graph pauses
    @Override
    public void onPause(){
        handler.removeCallbacks(timer1);
        super.onPause();
    }


    private DataPoint[] generateData(){
        //generate data based on text file
        DataPoint[] output = new DataPoint[370];
        int x;
        int y;
        try{
            Resources res = getResources();
            InputStream input = res.openRawResource(R.raw.test1);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String data;
            for(int i = 0; i < output.length; i++){
                data = reader.readLine();
                String[] elements = data.split(" ");
                x = Integer.parseInt(elements[0]);
                y = Integer.parseInt(elements[1]);
                DataPoint v = new DataPoint(x,y);
                output[i] = v;
            }
            return output;
        }catch(Exception e){
            //can't show file
            return null;
        }
    }
}
