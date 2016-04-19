package com.example.vxwokrs.situp.activitys;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.vxwokrs.situp.R;

public class MainActivity extends BaseActivity {
    private static final String TAG="MainActivity";
    private Button[] buttons;
    private int currentSelctedFragment=0;
    //buttonIds[0]按下后对应显示fragments[0],以此类推
    private int[] buttonIds=new int[]{R.id.btn0,R.id.btn1,R.id.btn2};
    private Fragment[] fragments=new Fragment[]{new SportFragment(),new MessageFragment(),new MineFragment()};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "---onCreate---");
        intView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "---onresume---");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "---onPause---");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "---onStart---");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "---onStop---");
    }

    private void intView()
    {
        buttons=new Button[buttonIds.length];
        for(int i=0;i<buttonIds.length;i++)
        {
            buttons[i]=(Button)this.findViewById(buttonIds[i]);
        }
        setBtnSelected(currentSelctedFragment);
        FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
        trx.add(R.id.fragment_container,fragments[currentSelctedFragment]).show(fragments[currentSelctedFragment]).commit();
    }

    private void setBtnSelected(int index)
    {

        for(int i=0;i<buttons.length;i++)
        {
            if(i==index)
            {
                buttons[i].setBackgroundColor(getResources().getColor(R.color.menu_bar_pressed));
            }else
            {
                buttons[i].setBackgroundColor(getResources().getColor(R.color.menu_bar));
            }
        }
    }

    private int getCurrentSelctedFragment(View view)
    {
        int id=view.getId();
        for(int i=0;i<buttonIds.length;i++)
        {
            if(id==buttonIds[i])
            {
                return i;
            }
        }
        return -1;
    }

    public void onBtnClicked(View view)
    {
        int id=view.getId();
        int preSelcetedFragment=currentSelctedFragment;

        currentSelctedFragment=getCurrentSelctedFragment(view);
        if(currentSelctedFragment>=0 && currentSelctedFragment<buttonIds.length)
        {
            setBtnSelected(currentSelctedFragment);
            FragmentTransaction tr=getSupportFragmentManager().beginTransaction();
            //tr.replace(R.id.fragment_container, fragments[currentSelctedFragment]).commit();//每一次replace的时候，当前fragment会销毁
            //tr.replace(R.id.fragment_container, fragments[currentSelctedFragment]).addToBackStack(null).commit();//这样frament不会销毁，而是会放到栈里面，注意这个栈针对的是Transaction而不是fragment
             if(preSelcetedFragment!=currentSelctedFragment) {//避免反复创建fragment
                 tr.hide(fragments[preSelcetedFragment]);
                 if (!fragments[currentSelctedFragment].isAdded()) {
                     tr.add(R.id.fragment_container, fragments[currentSelctedFragment]);
                 }
            }
            tr.show(fragments[currentSelctedFragment]).commit();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "---onDestroy---");
        this.finish();
    }
}
