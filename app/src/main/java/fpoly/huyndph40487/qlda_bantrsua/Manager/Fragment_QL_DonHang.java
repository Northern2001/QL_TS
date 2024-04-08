package fpoly.huyndph40487.qlda_bantrsua.Manager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import fpoly.huyndph40487.qlda_bantrsua.Adapter.ViewPagerAdapter;
import fpoly.huyndph40487.qlda_bantrsua.R;
import fpoly.huyndph40487.qlda_bantrsua.databinding.FragmentQLDonHangBinding;


public class Fragment_QL_DonHang extends Fragment {



    private TableLayout tableLayout ;
    private ViewPager viewPager ;

    FragmentQLDonHangBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(getActivity().getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
//        binding.viewPager.setAdapter(viewPagerAdapter);
//        binding.tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__q_l__don_hang, container, false);


    }
}