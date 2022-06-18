package vn.adsun.app.manager.features.dulichdilai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.adsun.app.manager.R;

public class DuLichDiLaiFragment extends Fragment {


    public DuLichDiLaiFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_du_lich_di_lai, container, false);
        
        addControl(view);
        addEvent();
        return view;
    }

    private void addEvent() {
    }

    private void addControl(View view) {
    }
}