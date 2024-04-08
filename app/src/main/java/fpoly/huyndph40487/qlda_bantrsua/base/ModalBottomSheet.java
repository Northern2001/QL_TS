package fpoly.huyndph40487.qlda_bantrsua.base;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.gson.Gson;

import fpoly.huyndph40487.qlda_bantrsua.DAO.ProductCartDAO;
import fpoly.huyndph40487.qlda_bantrsua.Model.Product;
import fpoly.huyndph40487.qlda_bantrsua.Model.ProductCart;
import fpoly.huyndph40487.qlda_bantrsua.R;
import fpoly.huyndph40487.qlda_bantrsua.databinding.ModalBottomSheetContentBinding;

public class  ModalBottomSheet extends BottomSheetDialogFragment {

    public static String TAG = "ModalBottomSheet";
    static ProductCartDAO dao;
    Product product;

    String data;
    private ModalBottomSheetContentBinding binding;
    private int size, topping, ice, sugar;
    private int soLuong = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ModalBottomSheetContentBinding.inflate(inflater, container, false);
        dao = new ProductCartDAO(getContext());
        initView();
        initData();
        View view = binding.getRoot();
        return view;
    }

    private void initData() {
        product = new Gson().fromJson(data, Product.class);
        if (product == null) return;
        binding.tvNameProduct.setText(product.getName());
        binding.tvPrice.setText(String.valueOf(product.getGia()));
        Glide.with(getContext())
                .load(product.getImg())
                .fitCenter()
                .apply(new RequestOptions() // Placeholder image
                        .error(R.drawable.ic_ttdg) // Error image in case of loading failure
                )
                .into(binding.imgProduct);
    }

    private void initView() {

        binding.imgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soLuong += 1;
                setSoLuongView();
            }
        });

        binding.imgMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (soLuong > 0) {
                    soLuong -= 1;
                    setSoLuongView();
                }
            }
        });

        listenerOption();


        binding.imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }

        });


        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductCart productCart = new ProductCart();
                productCart.setAnh(product.getImg());
                productCart.setName(product.getName());
                productCart.setGia(getPrice());
                productCart.setSoLuong(soLuong);
                productCart.setSize(size);
                productCart.setTopping(topping);
                productCart.setIce(ice);
                productCart.setSugar(sugar);
                if (dao.insert(productCart) > 0) {
                    Toast.makeText(getContext(), "Thêm vào giỏ hàng thành công", Toast.LENGTH_SHORT).show();
                }
                dismiss();
            }
        });

    }

    private double getPrice() {
        double result = product.getGia();
        if (size == 2) {
            result += 15000;
        } else if (topping == 1 || topping == 2 || topping == 3) {
            if (topping == 3) {
                result += 22000;
            } else {
                result += 20000;
            }

        }
        return result;
    }

    private void setSoLuongView() {
        binding.tvNumberadd.setText(String.valueOf(soLuong));
    }

    private void listenerOption() {

        binding.ckcSizeM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disableCheckBox();
                size = 1;
            }
        });

        binding.ckcSizeL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disableCheckBox();
                size = 2;
            }
        });

        binding.ckcTct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disableCheckBox();
                topping = 2;
            }
        });

        binding.ckcTcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disableCheckBox();
                topping = 1;
            }
        });

        binding.ckcCheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disableCheckBox();
                topping = 3;
            }
        });

//        binding.ckcNoIce.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                disableCheckBox();
//                ice = 2;
//            }
//        });
//
//        binding.ckc50Ice.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                disableCheckBox();
//                ice = 1;
//            }
//        });
//
//        binding.ckcNoSugar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                disableCheckBox();
//                sugar = 1;
//            }
//        });

//        binding.ckc50Sugar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                disableCheckBox();
//                sugar = 2;
//            }
//        });
    }

    private void disableCheckBox() {
        if (binding.ckcSizeL.isChecked()) {
            binding.ckcSizeM.setChecked(false);
        } else {
            binding.ckcSizeL.setChecked(false);
        }

        if (binding.ckcTcd.isChecked()) {
            binding.ckcCheese.setChecked(false);
            binding.ckcTct.setChecked(false);
        } else if (binding.ckcCheese.isChecked()) {
            binding.ckcTct.setChecked(false);
            binding.ckcTcd.setChecked(false);
        } else {
            binding.ckcCheese.setChecked(false);
            binding.ckcTcd.setChecked(false);
        }

//        if (binding.ckcNoIce.isChecked()) {
//            binding.ckc50Ice.setChecked(false);
//        } else {
//            binding.ckcNoIce.setChecked(false);
//        }
//
//        if (binding.ckcNoSugar.isChecked()) {
//            binding.ckc50Sugar.setChecked(false);
//        } else {
//            binding.ckcNoSugar.setChecked(false);
//        }
    }

    public ModalBottomSheet setData(String data) {
        this.data = data;
        return this;
    }
}
