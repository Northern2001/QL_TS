package fpoly.huyndph40487.qlda_bantrsua.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import fpoly.huyndph40487.qlda_bantrsua.DataBase.DbHelper;

public class ShipperDAO {
private SQLiteDatabase db;
public ShipperDAO(Context context){
    DbHelper dbHelper= new DbHelper(context);
    db=dbHelper.getWritableDatabase();

}
}
