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

import com.example.windows.reyogsjr.R;
import com.example.windows.reyogsjr.Tokoh.DadakActivity;
import com.example.windows.reyogsjr.Tokoh.GanongActivity;
import com.example.windows.reyogsjr.Tokoh.JathilActivity;
import com.example.windows.reyogsjr.Tokoh.KelonoActivity;
import com.example.windows.reyogsjr.Tokoh.WarokActivity;
import com.example.windows.reyogsjr._sliders.FragmentSlider;
import com.example.windows.reyogsjr._sliders.SliderIndicator;
import com.example.windows.reyogsjr._sliders.SliderPagerAdapter;
import com.example.windows.reyogsjr._sliders.SliderView;

import java.util.ArrayList;
import java.util.List;

public class TokohFragment extends Fragment {

    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private SliderView sliderView;
    private LinearLayout mLinearLayout;

    private RelativeLayout warok;
    private RelativeLayout jathil;
    private RelativeLayout ganong;
    private RelativeLayout kelono;
    private RelativeLayout dadak;
    private RelativeLayout pengrawit;

    public TokohFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_musik, container, false);

        View rootView = inflater.inflate(R.layout.fragment_tokoh, container, false);

        sliderView = (SliderView)rootView.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout)rootView.findViewById(R.id.pagesContainer);
        setupSlider();

        warok = (RelativeLayout) rootView.findViewById(R.id.warok);
        jathil = (RelativeLayout) rootView.findViewById(R.id.jathil);
        ganong = (RelativeLayout) rootView.findViewById(R.id.ganong);
        kelono = (RelativeLayout) rootView.findViewById(R.id.kelono);
        dadak = (RelativeLayout) rootView.findViewById(R.id.dadak);
        pengrawit = (RelativeLayout) rootView.findViewById(R.id.pengrawit);
        setupTokoh();

        View view = inflater.inflate(R.layout.fragment_tokoh,container , false);
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

    private void setupTokoh() {
        warok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Warok!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), WarokActivity.class);
                startActivity(intent);
            }
        });
        jathil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Jathil!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), JathilActivity.class);
                startActivity(intent);
            }
        });
        ganong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ganong!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), GanongActivity.class);
                startActivity(intent);
            }
        });
        kelono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "kelono!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), KelonoActivity.class);
                startActivity(intent);
            }
        });
        dadak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "dadak!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), DadakActivity.class);
                startActivity(intent);
            }
        });
        pengrawit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "pengrawit!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), WarokActivity.class);
                startActivity(intent);
            }
        });
    }



}
