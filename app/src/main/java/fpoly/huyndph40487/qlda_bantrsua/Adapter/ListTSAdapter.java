package fpoly.huyndph40487.qlda_bantrsua.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import fpoly.huyndph40487.qlda_bantrsua.Model.Product;
import fpoly.huyndph40487.qlda_bantrsua.R;

public class ListTSAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Product> list;

    public ListTSAdapter(Context context, int layout, List<Product> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        Product product = list.get(i);

        TextView view1 = view.findViewById(R.id.tvname);
        TextView view2 = view.findViewById(R.id.tvGia);
        ImageView view3 = view.findViewById(R.id.imgview);

        view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Log.e("EEEEEEEEEEEE", "getView: " + product.getImg() );
        view1.setText(product.getName());
        view2.setText(String.valueOf(product.getGia()));
        Glide.with(context)
                .load(product.getImg())
                .fitCenter()
                .apply(new RequestOptions() // Placeholder image
                        .error(R.drawable.ic_ttdg) // Error image in case of loading failure
                )
                .into(view3);
        return view;


    }

}
