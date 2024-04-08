package fpoly.huyndph40487.qlda_bantrsua.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import fpoly.huyndph40487.qlda_bantrsua.Model.Product;
import fpoly.huyndph40487.qlda_bantrsua.R;
import fpoly.huyndph40487.qlda_bantrsua.base.ICallback;

public class InsertProductDialog extends Dialog {

    public Activity c;
    public Dialog d;
    public Button yes;
    public EditText nameEdt, priceEdt;
    public ICallback iCallback;

    public InsertProductDialog(Activity a, ICallback iCallback) {
        super(a);
        // TODO Auto-generated constructor stub
        this.iCallback = iCallback;
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.insert_product_dialog);
        yes = (Button) findViewById(R.id.btn_yes);
        nameEdt = (EditText) findViewById(R.id.name);
        priceEdt = (EditText) findViewById(R.id.price);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                iCallback.insert(new Product(nameEdt.getText().toString(), Integer.parseInt(priceEdt.getText().toString())));
            }
        });

    }
}