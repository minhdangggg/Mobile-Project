package vn.adsun.app.manager.features.dulichdilai;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

import vn.adsun.app.manager.BaseActivity;
import vn.adsun.app.manager.R;
import vn.adsun.app.manager.modal.Chuyen;
import vn.adsun.app.manager.modal.DuLich;

public class MenuDuLichActivity extends BaseActivity {

    private ViewPager2 viewPager2;
    private BottomNavigationView bottomNavigationView;
    private ImageView imgBack;
    private ImageView imgHome;
    private GridView gridView;
    private RecyclerView recyganday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_du_lich);

        //status bar trong suốt
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        Log.d("TestThuThietBi", "Độ dài " + getStatusBarHeight());

        addControl();
        addEvent();

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) imgBack.getLayoutParams();
        params.setMargins(getStatusBarHeight() - 15, getStatusBarHeight() + 10, 0, 0);
        imgBack.setLayoutParams(params);

        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) imgHome.getLayoutParams();
        params1.setMargins(0, getStatusBarHeight() + 10, getStatusBarHeight() - 15, 0);
        imgHome.setLayoutParams(params1);

        setUpViewPager();

        List<DuLich> duLichList = new ArrayList<>();
        duLichList.add(new DuLich(1, "Vé máy bay"));
        duLichList.add(new DuLich(2, "Tàu hỏa"));
        duLichList.add(new DuLich(3, "Xe buýt"));
        duLichList.add(new DuLich(4, "Khách sạn"));
        duLichList.add(new DuLich(5, "KS theo giờ"));

        FeatureAdapter featureAdapter = new FeatureAdapter(this, duLichList);
        gridView.setAdapter(featureAdapter);

        List<Chuyen> chuyens = new ArrayList<>();
        chuyens.add(new Chuyen(1, "GAS Sài Gòn", "GAS Hải DƯơng", "1/2/2020", "", false));
        chuyens.add(new Chuyen(2, "GAS Sài Gòn", "GAS Hà Nội", "1/2/2020", "", false));
        chuyens.add(new Chuyen(3, "GAS Hà Nội", "GAS Bình Dương", "1/2/2020", "", false));

        RecyclerChuyen recyclerChuyen = new RecyclerChuyen(this, chuyens);
        recyganday.setAdapter(recyclerChuyen);
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private void setUpViewPager() {
        PagerAdapter pagerAdapter = new PagerAdapter(this);
        viewPager2.setAdapter(pagerAdapter);
        viewPager2.setUserInputEnabled(false);
        viewPager2.setOffscreenPageLimit(2);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.dulichdilai);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.quanlyve);
                        break;
                }
            }
        });
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.dulichdilai:
                        viewPager2.setCurrentItem(0);
                        break;
                    case R.id.quanlyve:
                        viewPager2.setCurrentItem(1);
                        break;
                }
                return true;
            }
        });
    }

    private void addEvent() {
        imgBack.setOnClickListener(v -> finish());
    }

    private void addControl() {
        viewPager2 = findViewById(R.id.viewpager);
        bottomNavigationView = findViewById(R.id.bottomDulichDilai);
        ImageView imgdulich = findViewById(R.id.imgdulich);
        imgBack = findViewById(R.id.imgBack);
        imgHome = findViewById(R.id.imgHome);

        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displaymetrics);
        int width = displaymetrics.widthPixels;
        int height = displaymetrics.heightPixels;

        //Hình = 1/4 màn hình
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) imgdulich.getLayoutParams();
        params.height = (int) (height / 3.5f);
        imgdulich.setLayoutParams(params);

        gridView = findViewById(R.id.gridView);
        recyganday = findViewById(R.id.recyganday);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyganday.setLayoutManager(layoutManager);
    }

    public static class PagerAdapter extends FragmentStateAdapter {

        public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new DuLichDiLaiFragment();
                case 1:
                    return new QuanLyVeFragment();
                default:
                    return new DuLichDiLaiFragment();
            }
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }

    public static class FeatureAdapter extends BaseAdapter {

        private final Context context;
        private final List<DuLich> duLichList;

        public FeatureAdapter(Context context, List<DuLich> duLichList) {
            this.context = context;
            this.duLichList = duLichList;
        }

        @Override
        public int getCount() {
            return duLichList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (view == null) {
                view = inflater.inflate(R.layout.item_feature, null);
            }
            DuLich duLich = duLichList.get(position);
            LinearLayout background = view.findViewById(R.id.background);
            ImageView imgIcon = view.findViewById(R.id.imgIcon);
            TextView tvName = view.findViewById(R.id.tvName);


            switch (duLich.getId()) {
                case 1:
                    background.setBackgroundColor(Color.parseColor("#E6FFFC"));
                    imgIcon.setImageResource(R.drawable.ic_baseline_airplanemode_active_24);
                    imgIcon.setColorFilter(Color.parseColor("#83E1DB"));
                    break;
                case 2:
                    background.setBackgroundColor(Color.parseColor("#FFF3EA"));
                    imgIcon.setImageResource(R.drawable.ic_baseline_train_24);
                    imgIcon.setColorFilter(Color.parseColor("#F59E0B"));
                    break;
                case 3:
                    background.setBackgroundColor(Color.parseColor("#E6F7FF"));
                    imgIcon.setImageResource(R.drawable.ic_baseline_directions_bus_24);
                    imgIcon.setColorFilter(Color.parseColor("#5CA7E3"));
                    break;
                case 4:
                    background.setBackgroundColor(Color.WHITE);
                    imgIcon.setImageResource(R.drawable.ic_baseline_villa_24);
                    imgIcon.setColorFilter(Color.parseColor("#F59E0B"));
                    break;
                case 5:
                    background.setBackgroundColor(Color.WHITE);
                    imgIcon.setImageResource(R.drawable.ic_baseline_av_timer_24);
                    imgIcon.setColorFilter(Color.parseColor("#5BB92B"));
                    break;
            }

            tvName.setText(duLich.getName());

            view.setOnClickListener(v -> {
                Intent intent = new Intent(context, AddChuyenActivity.class);
                Bundle mBundle = new Bundle();
                if (duLich.getId() == 1) {
                    mBundle.putString("keyName", "Mua vé máy bay");
                    intent.putExtras(mBundle);
                    context.startActivity(intent);
                } else if (duLich.getId() == 2) {
                    mBundle.putString("keyName", "Mua vé tàu hỏa");
                    intent.putExtras(mBundle);
                    context.startActivity(intent);
                } else if (duLich.getId() == 3) {
                    mBundle.putString("keyName", "Mua vé xe khách");
                    intent.putExtras(mBundle);
                    context.startActivity(intent);
                } else if (duLich.getId() == 4) {
                    mBundle.putString("keyName", "Đặt phòng khách sạn");
                    Toast.makeText(context, "Tính năng hiện tại chưa phát triển", Toast.LENGTH_SHORT).show();
                } else if (duLich.getId() == 5) {
                    mBundle.putString("keyName", "Đặt phòng khách theo giờ");
                    Toast.makeText(context, "Tính năng hiện tại chưa phát triển", Toast.LENGTH_SHORT).show();

                }

            });
            return view;
        }
    }

    public static class RecyclerChuyen extends RecyclerView.Adapter<RecyclerChuyen.RecyclerViewHolder> {
        private final Context context;
        private final List<Chuyen> list;

        public RecyclerChuyen(Context context, List<Chuyen> list) {
            this.context = context;
            this.list = list;
        }

        @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.item_chuyen, parent, false);
            return new RecyclerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics displaymetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displaymetrics);
            int width = displaymetrics.widthPixels;
            holder.itemView.setLayoutParams(new RecyclerView.LayoutParams((int) (Math.round((width) / 1.2)),
                    ViewGroup.LayoutParams.MATCH_PARENT));

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
            public RecyclerViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }

}