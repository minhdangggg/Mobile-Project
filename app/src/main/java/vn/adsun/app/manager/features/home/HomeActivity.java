package vn.adsun.app.manager.features.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import vn.adsun.app.manager.BaseActivity;
import vn.adsun.app.manager.R;
import vn.adsun.app.manager.adapter.MyViewPagerAdapter;
import vn.adsun.app.manager.features.fee.AddFeeActivity;


public class HomeActivity extends BaseActivity {

    private BottomNavigationView bottomNavigationView;
    private ViewPager2 viewPager2;
    private FloatingActionButton fab_plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        setUpUI();
        setViewPager();

    }

    private void setViewPager() {
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(this);
        viewPager2.setAdapter(adapter);
        viewPager2.setUserInputEnabled(false);
        viewPager2.setOffscreenPageLimit(5);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.fee).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.placeholder).setChecked(true);
                        break;
                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.bus_fee).setChecked(true);
                        break;
                    case 4:
                        bottomNavigationView.getMenu().findItem(R.id.mail_box).setChecked(true);
                        break;
                }
            }
        });
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        viewPager2.setCurrentItem(0);
                        break;
                    case R.id.fee:
                        viewPager2.setCurrentItem(1);
                        break;
                    case R.id.placeholder:
                        viewPager2.setCurrentItem(2);
                        break;
                    case R.id.bus_fee:
                        viewPager2.setCurrentItem(3);
                        break;
                    case R.id.mail_box:
                        viewPager2.setCurrentItem(4);
                        break;

                }
                return true;
            }
        });
    }

    private void setUpUI() {
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.getMenu().findItem(R.id.placeholder).setEnabled(false);
        bottomNavigationView.setItemHorizontalTranslationEnabled(false);
        viewPager2 = findViewById(R.id.viewPager);
        fab_plus = findViewById(R.id.fab_plus);
        fab_plus.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddFeeActivity.class);
            startActivity(intent);
        });
    }
}