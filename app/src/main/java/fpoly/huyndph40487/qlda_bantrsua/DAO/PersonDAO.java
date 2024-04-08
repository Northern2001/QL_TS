package fpoly.huyndph40487.qlda_bantrsua.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import fpoly.huyndph40487.qlda_bantrsua.DataBase.DbHelper;

public class PersonDAO {
    private SQLiteDatabase db;

    public PersonDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }
}
