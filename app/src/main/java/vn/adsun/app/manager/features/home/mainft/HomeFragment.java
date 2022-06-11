package vn.adsun.app.manager.features.home.mainft;

import static vn.adsun.app.manager.MainActivity.scheduleList;
import static vn.adsun.app.manager.MainActivity.user;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import vn.adsun.app.manager.MainActivity;
import vn.adsun.app.manager.R;
import vn.adsun.app.manager.adapter.ScheduleAdapter;
import vn.adsun.app.manager.features.userinfo.UserInfoActivity;
import vn.adsun.app.manager.modal.Schedule;
import vn.adsun.app.manager.modal.User;


public class HomeFragment extends Fragment {

    private RelativeLayout relative;
    private RecyclerView recyclerSchedule;
    private ScheduleAdapter scheduleAdapter;
    private ImageView imgUserInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        setUpUI(view);

        setUpData();
        return view;
    }

    private void setUpData() {
        scheduleList.add(new Schedule(1, 8000000,"8.000.000 đ","3/1/2022","KTX khu A",0,"Bay đến Hà Nội"));
        scheduleList.add(new Schedule(2, 7000000,"7.000.000 đ","4/1/2022","KTX khu A",0,"Bay đến Vũng Tàu"));
        scheduleList.add(new Schedule(3, 6000000,"6.000.000 đ","10/1/2022","KTX khu A",0,"Bay đến Qui Nhơn"));
        scheduleList.add(new Schedule(4, 5000000,"5.000.000 đ","12/2/2022","KTX khu A",1,"Bay đến Đăk Lăk"));
        scheduleList.add(new Schedule(5, 4000000,"4.000.000 đ","13/4/2022","KTX khu A",2,"Bay đến Campuchia"));

        scheduleList.add(new Schedule(6, 16000000,"16.000.000 đ","10/1/2022","KTX khu A",0,"Bay đến Ukraina"));
        scheduleList.add(new Schedule(7, 25000000,"25.000.000 đ","1/2/2022","KTX khu A",1,"Bay đến Thượng Hải"));
        scheduleList.add(new Schedule(8, 44000000,"44.000.000 đ","2/4/2022","KTX khu A",2,"Bay đến America"));
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerSchedule.setLayoutManager(manager);
        scheduleAdapter = new ScheduleAdapter(getContext(), scheduleList);
        recyclerSchedule.setAdapter(scheduleAdapter);
    }

    private void setUpUI(View view) {
        relative = view.findViewById(R.id.relative);
        relative.post(new Runnable() {
            @Override
            public void run() {
                LinearLayout.LayoutParams param = (LinearLayout.LayoutParams) relative.getLayoutParams();
                param.setMargins(0,getStatusBarHeight(),0,0);
                relative.setLayoutParams(param);
            }
        });

        TextView tvName = view.findViewById(R.id.tvName);
        tvName.setText("Xin chào "+user.getName());
        TextView tvSeeAll = view.findViewById(R.id.tvSeeAll);

        recyclerSchedule= view.findViewById(R.id.recyclerSchedule);

        tvSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgUserInfo = view.findViewById(R.id.imgUserInfo);
        imgUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}