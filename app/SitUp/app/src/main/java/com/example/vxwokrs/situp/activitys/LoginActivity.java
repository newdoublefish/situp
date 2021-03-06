package com.example.vxwokrs.situp.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.vxwokrs.situp.R;
import com.example.vxwokrs.situp.application.SitupPreferenceUtils;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;


/**
 * Created by vxwokrs on 2016/4/19.
 */
public class LoginActivity extends BaseActivity {
    private TextView userNameTv;
    private TextView passwordTv;
    private Button loginBtn;
    private Button registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView()
    {
        userNameTv=(TextView)this.findViewById(R.id.username);
        passwordTv=(TextView)this.findViewById(R.id.password);
    }

    public void login(View view)
    {
        //TODO:用retrofit来登入
        Intent intent=new Intent();
        Bundle bundle=new Bundle();
        bundle.putString("userName",userNameTv.getText().toString());
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
        SitupPreferenceUtils.getInstance().setLoginedUserName(userNameTv.getText().toString());
    }

    public void register(View view)
    {

    }


}
