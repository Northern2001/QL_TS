package fpoly.huyndph40487.qlda_bantrsua.view.adminmanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fpoly.huyndph40487.qlda_bantrsua.Adapter.ProductCartAdapter;
import fpoly.huyndph40487.qlda_bantrsua.DAO.ProductCartDAO;
import fpoly.huyndph40487.qlda_bantrsua.DAO.ProductDAO;
import fpoly.huyndph40487.qlda_bantrsua.MainActivity;
import fpoly.huyndph40487.qlda_bantrsua.Model.Product;
import fpoly.huyndph40487.qlda_bantrsua.Model.ProductCart;
import fpoly.huyndph40487.qlda_bantrsua.R;
import fpoly.huyndph40487.qlda_bantrsua.base.ICallback;
import fpoly.huyndph40487.qlda_bantrsua.base.NavHelper;
import fpoly.huyndph40487.qlda_bantrsua.databinding.FragmentQLProductBinding;
import fpoly.huyndph40487.qlda_bantrsua.view.dialog.InsertProductDialog;


public class Fragment_QL_Product extends Fragment implements ICallback {
    FragmentQLProductBinding binding;
    List<ProductCart> listProductCart;
    List<ProductCart> listProductCartSelected;
    ProductDAO dao;
    ProductCartDAO daoCart;
    ProductCartAdapter productCartAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentQLProductBinding.inflate(inflater, container, false);
        listProductCartSelected = new ArrayList<>();
        dao = new ProductDAO(getContext());
        daoCart = new ProductCartDAO(getContext());
        listProductCart = daoCart.getAll().stream().filter(productCart -> {
            return productCart.getStatus() == 1;
        }).collect(Collectors.toList());
         productCartAdapter = new ProductCartAdapter(getContext(), listProductCart, false, this);
        binding.recyclerTotal.setAdapter(productCartAdapter);

        binding.btnDuyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                duyetDon();
            }
        });


        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new NavHelper((MainActivity) requireActivity(), R.id.navHost).navigate(R.id.navigation_home);
            }
        });

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        return binding.getRoot();
    }

    private void duyetDon() {
        if (listProductCartSelected != null) {
            for (ProductCart productCart : listProductCartSelected) {
                productCart.setStatus(2);
                daoCart.updateProductCart(productCart);
                listProductCart.remove(productCart);
                productCartAdapter.notifyDataSetChanged();
            }
            Toast.makeText(getContext(), "Duyệt hàng thành công", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Duyệt hàng thất bại", Toast.LENGTH_SHORT).show();
        }

    }

    private void showDialog() {
        InsertProductDialog cdd = new InsertProductDialog(requireActivity(), this);
        cdd.show();
    }

    @Override
    public void callback(List<ProductCart> productCart) {
        if (productCart != null)
            listProductCartSelected.addAll(productCart);
    }

    @Override
    public void insert(Product product) {
        if (dao.insert(product) > 1)
            Toast.makeText(getContext(), "Thêm sản phẩm thành công", Toast.LENGTH_SHORT).show();
    }
}