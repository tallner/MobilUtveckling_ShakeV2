package com.example.mobilutveckling_shakev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mySensorManager;
    Sensor accelerometers;

    TextView xValue,yValue,zValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xValue = (TextView) findViewById(R.id.xValue);
        yValue = (TextView) findViewById(R.id.yValue);
        zValue = (TextView) findViewById(R.id.zValue);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mySensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        }
        accelerometers = mySensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mySensorManager.registerListener(this,accelerometers,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.i("TestTag","onSensorChanged:X"+sensorEvent.values[0]);
        Log.i("TestTag","onSensorChanged:Y"+sensorEvent.values[1]);
        Log.i("TestTag","onSensorChanged:Z"+sensorEvent.values[2]);

        xValue.setText("xValue:" + sensorEvent.values[0]);
        yValue.setText("yValue:" + sensorEvent.values[1]);
        zValue.setText("zValue:" + sensorEvent.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}