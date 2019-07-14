package com.example.chapter3.homework;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Handler;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HelloFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        int cnt = 0;
        final View view = inflater.inflate(R.layout.hello_fragment, container, false);
        LottieAnimationView animationView = (LottieAnimationView)view.findViewById(R.id.loading);
        ListView listview = view.findViewById(R.id.listview);
        listview.setAdapter(new ListViewAdapter(getActivity()));

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("mes", "run() called");
                Animator animator1 = AnimatorInflater.loadAnimator(getActivity(),R.animator.fade_away);
                Animator animator2 = AnimatorInflater.loadAnimator(getActivity(),R.animator.emerge);
                animator1.setTarget(view.findViewById(R.id.loading));
                animator2.setTarget(view.findViewById(R.id.listview));

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(animator1,animator2);
                animatorSet.start();
            }
        },4000);

        return view;
    }

    public static  class ListViewAdapter extends BaseAdapter {

        private int[] args = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        private Context mContext;

        public ListViewAdapter(Context context){mContext=context;}

        @Override
        public int getCount(){return args.length;}

        @Override
        public Object getItem(int position){return null;}

        @Override
        public long getItemId(int position){return 0;}

        @Override
        public View getView(int position, View ConvertView, ViewGroup parent){
            View view;
            if(ConvertView == null){
                LayoutInflater inflater = LayoutInflater.from(mContext);
                view  = inflater.inflate(R.layout.im_list_item,null);
            }
            else view = ConvertView;
            return view;
        }


    }

}
