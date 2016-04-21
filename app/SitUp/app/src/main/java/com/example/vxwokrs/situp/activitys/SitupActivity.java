package com.example.vxwokrs.situp.activitys;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.widget.TextView;

import com.example.vxwokrs.situp.R;

/**
 * Created by vxwokrs on 2016/4/21.
 */
public class SitupActivity extends BaseActivity {
    private TextView cntView;
    private SensorManager sensorManager;
    private Sensor sensor;
    private int sitUpCnt=0;
    private int status=0;
    private final int UPDATE_TEXT=1;
    private Handler handle=new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch(msg.what)
            {
                case UPDATE_TEXT:
                    System.out.println(sitUpCnt + "");
                    break;
                default:
                    break;
            }
        }
    };

    private void initView()
    {
        cntView=(TextView)this.findViewById(R.id.count);
        //cntView.setText("1");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_situp);
        initView();
        sensorManager=(SensorManager)getSystemService(this.SENSOR_SERVICE);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        cntView=(TextView)this.findViewById(R.id.count);

    }

    private void calcPolicy(float current)
    {
        if(status==0)//高处状态
        {
            if(current<=4.0)
            {
                status=1;
            }
        }else if(status==1)//低处状态
        {
            if(current>4.0)
            {
                status=0;
                sitUpCnt++;
                SitupActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        cntView.setText(sitUpCnt+"");
                    }
                });
                Message message=new Message();
                message.what=UPDATE_TEXT;
                handle.sendMessage(message);
            }
        }
    }

    private SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] val=sensorEvent.values;
            calcPolicy(val[0]);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

    @Override
    protected void onResume(){
        super.onResume();
        if(sensorManager!=null)
        {
            sensorManager.registerListener(sensorEventListener,sensor,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        if(sensorManager!=null)
            sensorManager.unregisterListener(sensorEventListener);

    }


}
