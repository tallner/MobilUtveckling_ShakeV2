package com.example.mobilutveckling_shakev2;

import static java.lang.Math.abs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mySensorManager;
    private Sensor accelerometers;

    private Button btnFragment1,btnFragment2,btnFragment3;

    private ImageView testImage;
    private boolean rotated = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mySensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        }
        accelerometers = mySensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mySensorManager.registerListener(this,accelerometers,SensorManager.SENSOR_DELAY_NORMAL);

        testImage = (ImageView) findViewById(R.id.testImage);
        btnFragment1 = (Button) findViewById(R.id.btnFragment1);
        btnFragment2 = (Button) findViewById(R.id.btnFragment2);
        btnFragment3 = (Button) findViewById(R.id.btnFragment3);




        btnFragment1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment1 firstFragment = new Fragment1();
                // Begin the transaction
                androidx.fragment.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                // Replace the contents of the container with the new fragment
                ft.replace(R.id.fragcont, firstFragment);
                // Complete the changes added above
                ft.commit();
            }
        });

        btnFragment2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment2 secondFragment = new Fragment2();
                // Begin the transaction
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                // Replace the contents of the container with the new fragment
                ft.replace(R.id.fragcont, secondFragment);
                // Complete the changes added above
                ft.commit();
            }
        });



        btnFragment3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment3 thirdFragment = new Fragment3();
                // Begin the transaction
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                // Replace the contents of the container with the new fragment
                ft.replace(R.id.fragcont, thirdFragment);
                // Complete the changes added above
                ft.commit();
            }
        });


    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if ((abs(sensorEvent.values[0]) > 5f)&&(rotated==false)) {
           testImage.setRotation(90f);
            rotated = true;
            Log.i("TestTag", "true");
        }
        if ((abs(sensorEvent.values[0]) < 5f)&&(rotated==true)) {
            testImage.setRotation(0f);
            rotated = false;
            Log.i("TestTag", "false");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}