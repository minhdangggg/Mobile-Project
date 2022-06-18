package vn.adsun.app.manager.features.dulichdilai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.adsun.app.manager.R;

public class QuanLyVeFragment extends Fragment {


    public QuanLyVeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quan_ly_ve, container, false);
        addControl(view);
        addEvent();
        return view;
    }

    private void addEvent() {
    }

    private void addControl(View view) {
    }
}