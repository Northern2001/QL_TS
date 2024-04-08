package fpoly.huyndph40487.qlda_bantrsua.view;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import fpoly.huyndph40487.qlda_bantrsua.Adapter.ListTSAdapter;
import fpoly.huyndph40487.qlda_bantrsua.Adapter.PhotoAdapter;
import fpoly.huyndph40487.qlda_bantrsua.DAO.ProductDAO;
import fpoly.huyndph40487.qlda_bantrsua.MainActivity;
import fpoly.huyndph40487.qlda_bantrsua.Model.Photo;
import fpoly.huyndph40487.qlda_bantrsua.Model.Product;
import fpoly.huyndph40487.qlda_bantrsua.R;
import fpoly.huyndph40487.qlda_bantrsua.base.ModalBottomSheet;
import fpoly.huyndph40487.qlda_bantrsua.base.NavHelper;
import fpoly.huyndph40487.qlda_bantrsua.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    NavigationView navigationView;
    RecyclerView recyclerView;
    ListView listView;
    ImageView image;
    ListTSAdapter listTSAdapter;
    List<Product> listProduct;
    ViewPager viewPager;
    PhotoAdapter photoAdapter;

    ProductDAO productDAO;
    Dialog dialog;
    ArrayList<Product> arrayList;
    ModalBottomSheet modalBottomSheet;
    private FragmentHomeBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        NavHelper navHelper = new NavHelper((MainActivity) requireActivity(), R.id.navHost);

        productDAO = new ProductDAO(getContext());
        modalBottomSheet = new ModalBottomSheet();

        viewPager = binding.viewPager;
        listView = binding.listviewMain;
        listProduct = productDAO.getAll();
        listTSAdapter = new ListTSAdapter(getContext(), R.layout.item_list_trasua, listProduct);
        listView.setAdapter(listTSAdapter);
        binding.icList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navHelper.navigate(R.id.managerBillFragment);
            }
        });
        binding.icManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navHelper.navigate(R.id.fragment_QL_Product);
            }
        });

        binding.icCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navHelper.navigate(R.id.productCartFragment);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showBottomShet(listProduct.get(i));
            }
        });

        photoAdapter = new PhotoAdapter(getContext(), getListPhoto());
        viewPager.setAdapter(photoAdapter);

        View root = binding.getRoot();

        return root;
    }


    private void hideBottomSheet() {
        modalBottomSheet.dismiss();
    }

    private void showBottomShet(Product product) {
        modalBottomSheet.setData(new Gson().toJson(product)).show(getActivity().getSupportFragmentManager(), ModalBottomSheet.TAG);
    }

    private List<Photo> getListPhoto() {
        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.ic_ttdg));
        list.add(new Photo(R.drawable.ic_tradau));
        list.add(new Photo(R.drawable.ic_trakem));
        return list;
    }

}