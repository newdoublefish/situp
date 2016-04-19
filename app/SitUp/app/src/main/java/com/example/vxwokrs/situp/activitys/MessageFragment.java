package com.example.vxwokrs.situp.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vxwokrs.situp.R;

/**
 * Created by vxwokrs on 2016/4/19.
 */
public class MessageFragment extends Fragment {
    private final String TAG=this.getClass().getSimpleName().toString();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_message,container,false);
        Log.e(TAG, "---onCreateView---");
        return view;
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
