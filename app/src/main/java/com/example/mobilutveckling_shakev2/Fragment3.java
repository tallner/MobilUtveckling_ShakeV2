package com.example.mobilutveckling_shakev2;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import android.widget.TextView;

public class Fragment3 extends Fragment implements SensorEventListener {

    private SensorManager mySensorManager;
    private Sensor accelerometers;
    private TextView xValue;
    private TextView yValue;
    private TextView zValue;

    public Fragment3(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        mySensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        accelerometers = mySensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mySensorManager.registerListener(this,accelerometers,SensorManager.SENSOR_DELAY_NORMAL);

        return inflater.inflate(R.layout.fragment3_layout,container,false);

    }
    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null){
            xValue = (TextView) view.findViewById(R.id.xChip);
            yValue = (TextView) view.findViewById(R.id.yChip);
            zValue = (TextView) view.findViewById(R.id.zChip);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        xValue.setText("xValue:" + sensorEvent.values[0]);
        yValue.setText("xValue:" + sensorEvent.values[1]);
        zValue.setText("xValue:" + sensorEvent.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}