package com.example.windows.reyogsjr.Bottom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.windows.reyogsjr.Musik.AngklungActivity;
import com.example.windows.reyogsjr.Musik.GongActivity;
import com.example.windows.reyogsjr.Musik.KendangActivity;
import com.example.windows.reyogsjr.Musik.KenongActivity;
import com.example.windows.reyogsjr.Musik.SlompretActivity;
import com.example.windows.reyogsjr.Musik.TipungActivity;
import com.example.windows.reyogsjr.R;
import com.example.windows.reyogsjr._sliders.FragmentSlider;
import com.example.windows.reyogsjr._sliders.SliderIndicator;
import com.example.windows.reyogsjr._sliders.SliderPagerAdapter;
import com.example.windows.reyogsjr._sliders.SliderView;

import java.util.ArrayList;
import java.util.List;

public class MusikFragment extends Fragment {

    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private SliderView sliderView;
    private LinearLayout mLinearLayout;

    private RelativeLayout kendang;
    private RelativeLayout kenong;
    private RelativeLayout gong;
    private RelativeLayout slompret;
    private RelativeLayout angklung;
    private RelativeLayout tipung;

    public MusikFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_musik, container, false);
        View rootView = inflater.inflate(R.layout.fragment_musik, container, false);

        sliderView = (SliderView)rootView.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout)rootView.findViewById(R.id.pagesContainer);
        setupSlider();

        kendang = (RelativeLayout)rootView.findViewById(R.id.kendang);
        kenong = (RelativeLayout)rootView.findViewById(R.id.kenong);
        gong = (RelativeLayout)rootView.findViewById(R.id.gong);
        slompret = (RelativeLayout)rootView.findViewById(R.id.slompret);
        angklung = (RelativeLayout)rootView.findViewById(R.id.angklung);
        tipung = (RelativeLayout)rootView.findViewById(R.id.tipung);
        setupMusik();

        View view = inflater.inflate(R.layout.fragment_musik,container , false);
        return rootView;
    }

    private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-1.jpg"));
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-2.jpg"));
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-3.jpg"));
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-4.jpg"));

        mAdapter = new SliderPagerAdapter(getFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(getActivity(), mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }

    private void setupMusik() {
        kendang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "kendang!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), KendangActivity.class);
                startActivity(intent);
            }
        });
        kenong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "kenong!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), KenongActivity.class);
                startActivity(intent);
            }
        });
        gong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "gong!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), GongActivity.class);
                startActivity(intent);
            }
        });
        slompret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "slompret!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), SlompretActivity.class);
                startActivity(intent);
            }
        });
        angklung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "angklung!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), AngklungActivity.class);
                startActivity(intent);
            }
        });
        tipung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "tipung!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), TipungActivity.class);
                startActivity(intent);
            }
        });
    }
}
