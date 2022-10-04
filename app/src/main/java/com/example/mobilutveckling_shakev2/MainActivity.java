package com.example.mobilutveckling_shakev2;

import static java.lang.Math.abs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mySensorManager;
    Sensor accelerometers;

    TextView xValue,yValue,zValue;
    EditText xSignedNumber,ySignedNumber,zSignedNumber;
    Button xChip,yChip,zChip;

    ImageView testImage;
    boolean rotated = false;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xValue = (TextView) findViewById(R.id.xValue);
        yValue = (TextView) findViewById(R.id.yValue);
        zValue = (TextView) findViewById(R.id.zValue);

        xSignedNumber = (EditText) findViewById(R.id.xSignedNumber);
        ySignedNumber = (EditText) findViewById(R.id.ySignedNumber);
        zSignedNumber = (EditText) findViewById(R.id.zSignedNumber);

        xChip = (Button) findViewById(R.id.xChip);
        yChip = (Button) findViewById(R.id.yChip);
        zChip = (Button) findViewById(R.id.zChip);

        testImage = (ImageView) findViewById(R.id.testImage);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mySensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        }
        accelerometers = mySensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mySensorManager.registerListener(this,accelerometers,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
       // Log.i("TestTag","onSensorChanged:X"+sensorEvent.values[0]);
      //  Log.i("TestTag","onSensorChanged:Y"+sensorEvent.values[1]);
      //  Log.i("TestTag","onSensorChanged:Z"+sensorEvent.values[2]);

        xValue.setText("xValue:" + sensorEvent.values[0]);
        yValue.setText("yValue:" + sensorEvent.values[1]);
        zValue.setText("zValue:" + sensorEvent.values[2]);

        xSignedNumber.setText("xValue:" + sensorEvent.values[0]);
        ySignedNumber.setText("yValue:" + sensorEvent.values[1]);
        zSignedNumber.setText("zValue:" + sensorEvent.values[2]);

        xChip.setText("xValue:" + sensorEvent.values[0]);
        yChip.setText("yValue:" + sensorEvent.values[1]);
        zChip.setText("zValue:" + sensorEvent.values[2]);

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