package fpoly.huyndph40487.qlda_bantrsua;

import android.content.Context;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableField;

import java.util.List;

import fpoly.huyndph40487.qlda_bantrsua.Model.Product;

public class ManagerProductViewModel extends BaseObservable {
    public ObservableField<List<Product>> listObservableField = new ObservableField<>();

    public void onClickAddProduct(Context context) {
        Toast.makeText(context, "Click here", Toast.LENGTH_SHORT).show();

    }


}
