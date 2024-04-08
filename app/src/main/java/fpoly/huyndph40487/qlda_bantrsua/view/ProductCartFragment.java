package fpoly.huyndph40487.qlda_bantrsua.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import fpoly.huyndph40487.qlda_bantrsua.Adapter.ProductCartAdapter;
import fpoly.huyndph40487.qlda_bantrsua.DAO.ProductCartDAO;
import fpoly.huyndph40487.qlda_bantrsua.MainActivity;
import fpoly.huyndph40487.qlda_bantrsua.Model.Product;
import fpoly.huyndph40487.qlda_bantrsua.Model.ProductCart;
import fpoly.huyndph40487.qlda_bantrsua.R;
import fpoly.huyndph40487.qlda_bantrsua.base.ICallback;
import fpoly.huyndph40487.qlda_bantrsua.base.NavHelper;
import fpoly.huyndph40487.qlda_bantrsua.databinding.FragmentProductCartBinding;

public class ProductCartFragment extends Fragment implements ICallback {

    ProductCartDAO productCartDAO;
    ProductCartAdapter productCartAdapter;
    FragmentProductCartBinding binding;
    List<ProductCart> productCartList;
    List<ProductCart> productCartSelected;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProductCartBinding.inflate(inflater, container, false);
        productCartSelected = new ArrayList<>();
        productCartDAO = new ProductCartDAO(getContext());
        productCartList = productCartDAO.getAll().stream().filter(productCart -> {
            return productCart.getStatus() == 0;
        }).collect(Collectors.toList());
        Collections.reverse(productCartList);
        productCartAdapter = new ProductCartAdapter(getContext(), productCartList, false,this);
        binding.recyclerTotal.setAdapter(productCartAdapter);

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new NavHelper((MainActivity) requireActivity(), R.id.navHost).navigate(R.id.navigation_home);
            }
        });

        binding.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (productCartSelected != null) {
                    for (ProductCart data : productCartSelected) {
                        productCartDAO.deleteProductCart(data.getId());
                        productCartList.remove(data);
                    }
                    Toast.makeText(getContext(), "Xóa thành công", Toast.LENGTH_SHORT).show();

                    productCartAdapter.notifyDataSetChanged();
                }
            }
        });
        binding.cardDelete.setBackgroundResource(android.R.color.transparent);

        binding.btnThanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paymentProduct();
            }
        });

        binding.chkTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.chkTotal.isChecked()) {
                    binding.imgDelete.setVisibility(View.VISIBLE);
                    productCartSelected.addAll(productCartList);
                    productCartAdapter.selectAll();


                } else {
                    productCartAdapter.unselectall();
                    productCartSelected.removeAll(productCartList);
                    binding.imgDelete.setVisibility(View.GONE);
                }

            }
        });

        return binding.getRoot();
    }

    private void paymentProduct() {
        for (ProductCart productCart : productCartSelected) {
            productCart.setStatus(1);
            productCartDAO.updateProductCart(productCart);
            productCartList.remove(productCart);
            productCartAdapter.notifyDataSetChanged();
        }
        Toast.makeText(getContext(),"Đặt hàng thành công", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void callback(List<ProductCart> productCart) {
        productCartSelected.addAll(productCart);
        if (productCart.size() == 0) {
            binding.imgDelete.setVisibility(View.GONE);
        } else {
            binding.imgDelete.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void insert(Product product) {

    }
}