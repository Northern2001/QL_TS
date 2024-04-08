package fpoly.huyndph40487.qlda_bantrsua.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import fpoly.huyndph40487.qlda_bantrsua.view.managerBill.FragmentStatusBill;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return new FragmentStatusBill(position + 1);
    }

    @Override
    public int getCount() {
        return 3;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "Chờ Xác Nhận";
                break;
            case 1:
                title = "Đã Xác Nhận";
                break;
            case 2:
                title = "Đã Giao Hàng";
                break;
        }
        return title;
    }
}
