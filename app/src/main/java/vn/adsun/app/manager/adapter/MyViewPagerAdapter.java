package vn.adsun.app.manager.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vn.adsun.app.manager.features.home.mainft.BussFeeFragment;
import vn.adsun.app.manager.features.home.mainft.FeeFragment;
import vn.adsun.app.manager.features.home.mainft.HomeFragment;
import vn.adsun.app.manager.features.home.mainft.MailBoxFragment;
import vn.adsun.app.manager.features.home.mainft.NullFragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new FeeFragment();
            case 2:
                return new NullFragment();
            case 3:
                return new BussFeeFragment();
            case 4:
                return new MailBoxFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
