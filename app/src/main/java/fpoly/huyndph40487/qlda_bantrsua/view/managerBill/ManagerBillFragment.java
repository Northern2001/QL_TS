package fpoly.huyndph40487.qlda_bantrsua.view.managerBill;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import fpoly.huyndph40487.qlda_bantrsua.Adapter.ViewPagerAdapter;
import fpoly.huyndph40487.qlda_bantrsua.MainActivity;
import fpoly.huyndph40487.qlda_bantrsua.R;
import fpoly.huyndph40487.qlda_bantrsua.base.NavHelper;
import fpoly.huyndph40487.qlda_bantrsua.databinding.FragmentManagerBillBinding;


public class ManagerBillFragment extends Fragment {
    FragmentManagerBillBinding binding;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentManagerBillBinding.inflate(inflater, container, false);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(requireActivity().getSupportFragmentManager());
        binding.viewPager.setAdapter(viewPagerAdapter);
        binding.tabs.setupWithViewPager(binding.viewPager);
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new NavHelper((MainActivity) requireActivity(), R.id.navHost).navigate(R.id.navigation_home);
            }
        });
        return binding.getRoot();
    }
}