package fpoly.huyndph40487.qlda_bantrsua.view.managerBill;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fpoly.huyndph40487.qlda_bantrsua.Adapter.ProductCartAdapter;
import fpoly.huyndph40487.qlda_bantrsua.DAO.ProductCartDAO;
import fpoly.huyndph40487.qlda_bantrsua.Model.Product;
import fpoly.huyndph40487.qlda_bantrsua.Model.ProductCart;
import fpoly.huyndph40487.qlda_bantrsua.base.ICallback;
import fpoly.huyndph40487.qlda_bantrsua.databinding.FragmentBillStatusBinding;

public class FragmentStatusBill extends Fragment implements ICallback {
    List<ProductCart> listProductCart;
    int type;
    FragmentBillStatusBinding binding;
    ProductCartDAO dao;


    public FragmentStatusBill(int type) {
        this.type = type;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        dao = new ProductCartDAO(getContext());

        listProductCart = new ArrayList<>();
        listProductCart = dao.getAll().stream().filter(productCart -> {
            return productCart.getStatus() == type;
        }).collect(Collectors.toList());

        binding = FragmentBillStatusBinding.inflate(inflater, container, false);
        ProductCartAdapter productCartAdapter = new ProductCartAdapter(getContext(), listProductCart, true,this);
        binding.listView.setAdapter(productCartAdapter);

        return binding.getRoot();
    }

    @Override
    public void callback(List<ProductCart> productCart) {

    }

    @Override
    public void insert(Product productCart) {

    }
}