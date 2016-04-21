package com.example.vxwokrs.situp.activitys;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.vxwokrs.situp.R;
import com.example.vxwokrs.situp.application.SitupPreferenceUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by vxwokrs on 2016/4/19.
 */
public class MineFragment extends Fragment {
    private final int LOGIN_REQUEST_CODE=1;
    private final String TAG=this.getClass().getSimpleName().toString();
    private SimpleDraweeView simpleDraweeView;
    private Button btn;
    private TextView loginedUserNameTv;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void initView(View view)
    {
        simpleDraweeView=(SimpleDraweeView)view.findViewById(R.id.main_adv);
        Uri imageUri= Uri.parse("http://img01.sogoucdn.com/net/a/04/link?url=http://img01.sogoucdn.com/app/a/100520093/135af7683914878b-0429e3faa7dc75a3-dec813deb352cc0e4941bb54372fde34.jpg&appid=122");
        simpleDraweeView.setImageURI(imageUri);
        DraweeController controller=Fresco.newDraweeControllerBuilder()
                .setUri(imageUri)
                .setTapToRetryEnabled(true)
                .setOldController(simpleDraweeView.getController())
                .build();
        simpleDraweeView.setController(controller);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        Fresco.initialize(getActivity());
        View view=inflater.inflate(R.layout.fragment_mine,container,false);
        btn=(Button)view.findViewById(R.id.login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(SitupPreferenceUtils.getInstance().getLoginedUserName()==null)
                {
                    Intent intent=new Intent(getActivity(),LoginActivity.class);
                    startActivityForResult(intent,LOGIN_REQUEST_CODE);
                }else
                {
                    SitupPreferenceUtils.getInstance().clearAll();
                    getActivity().finish();
                    Intent intent=new Intent(getActivity(),MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        loginedUserNameTv=(TextView)view.findViewById(R.id.loginedUserName);

        if(SitupPreferenceUtils.getInstance().getLoginedUserName()!=null)
        {
            loginedUserNameTv.setVisibility(View.VISIBLE);
            loginedUserNameTv.setText(SitupPreferenceUtils.getInstance().getLoginedUserName());
            btn.setText("登出");
        }

        initView(view);
        Log.e(TAG, "---onCreateView---");
        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode)
        {
            case LOGIN_REQUEST_CODE:
                if(resultCode==getActivity().RESULT_OK)
                {
                    Log.e(TAG, "login---success!!!");
                    Bundle bundle=data.getExtras();
                    btn.setText("登出");
                    loginedUserNameTv.setVisibility(View.VISIBLE);
                    loginedUserNameTv.setText(bundle.getString("userName"));

                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.e(TAG, "---onAttach---");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "---onCreate---");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "---onActivityCreated---");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "---onStart---");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "---onResume---");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "---onPause---");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "---onStop---");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG, "---onDestroyView---");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "---onDestroy---");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG, "---onDetach---");
    }
}
