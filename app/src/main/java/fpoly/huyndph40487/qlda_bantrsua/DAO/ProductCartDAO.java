package fpoly.huyndph40487.qlda_bantrsua.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fpoly.huyndph40487.qlda_bantrsua.DataBase.DbHelper;
import fpoly.huyndph40487.qlda_bantrsua.Model.ProductCart;

public class ProductCartDAO {
    private SQLiteDatabase db;
    private Context context;

    public ProductCartDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
        this.context = context;
    }

    @SuppressLint("Range")
    public List<ProductCart> getData(String sql, String... selectionArgs) {
        List<ProductCart> productList = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            ProductCart product = new ProductCart(
                    cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("name")),
                    convertToInt(cursor.getString(cursor.getColumnIndex("Gia"))),
                    cursor.getString(cursor.getColumnIndex("Anh")),
                    cursor.getInt(cursor.getColumnIndex("soLuong")),
                    cursor.getInt(cursor.getColumnIndex("size")),
                    cursor.getInt(cursor.getColumnIndex("topping")),
                    cursor.getInt(cursor.getColumnIndex("ice")),
                    cursor.getInt(cursor.getColumnIndex("sugar")),
                    cursor.getInt(cursor.getColumnIndex("status"))
            );
            productList.add(product);
        }
        return productList;
    }

    private int convertToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public long insert(ProductCart obj) {
        ContentValues values = new ContentValues();
        values.put("name", obj.getName());
        values.put("Gia", obj.getGia());
        values.put("Anh", obj.getAnh());
        values.put("soLuong", obj.getSoLuong());
        values.put("size", obj.getSize());
        values.put("topping", obj.getTopping());
        values.put("ice", obj.getIce());
        values.put("sugar", obj.getSugar());
        values.put("status", 0);
        return db.insert("Product_Cart", null, values);
    }

    public long deleteProductCart(int id) {
        return db.delete("Product_Cart", "id=?", new String[]{String.valueOf(id)});
    }

    public long updateProductCart(ProductCart obj) {
        ContentValues values = new ContentValues();
        values.put("name", obj.getName());
        values.put("Gia", obj.getGia());
        values.put("Anh", obj.getAnh());
        values.put("soLuong", obj.getSoLuong());
        values.put("size", obj.getSize());
        values.put("topping", obj.getTopping());
        values.put("ice", obj.getIce());
        values.put("sugar", obj.getSugar());
        values.put("status", obj.getStatus());
        return db.update("Product_Cart", values, "id=?", new String[]{String.valueOf(obj.getId())});
    }

    public List<ProductCart> getAll() {
        String sql = "SELECT * FROM Product_Cart";
        return getData(sql);
    }
}
