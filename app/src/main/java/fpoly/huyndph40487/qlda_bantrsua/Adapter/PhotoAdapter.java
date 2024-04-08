package fpoly.huyndph40487.qlda_bantrsua.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.concurrent.RecursiveTask;

import fpoly.huyndph40487.qlda_bantrsua.Model.Photo;
import fpoly.huyndph40487.qlda_bantrsua.R;

public class PhotoAdapter extends PagerAdapter {
    private Context context;
    private List<Photo> list;

    public PhotoAdapter(Context context, List<Photo> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view= LayoutInflater.from(container.getContext()).inflate(R.layout.item_photo,container,false);
        ImageView imageView=view.findViewById(R.id.img_photo);

        Photo photo=list.get(position);

        if (photo!= null){
            Glide.with(context).load(photo.getImgg_photo()).into(imageView);

        }
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        if (list!=null){
            return list.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((View) object);
    }
}
