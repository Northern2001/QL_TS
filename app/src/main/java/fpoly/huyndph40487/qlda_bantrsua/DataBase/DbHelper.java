package fpoly.huyndph40487.qlda_bantrsua.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "TS";
    private static final int DB_VERSION = 4;
    public DbHelper(@Nullable Context context){
        super(context, DB_NAME,null,DB_VERSION);
    }
    static final String CREATE_TABLE_Person =
            "CREATE TABLE person(" +
                    "name text PRIMARY KEY," +
                    "phoneNumber text NOT NULL," +
                    "email text NOT NULL" +
                    ")";
    static final String CREATE_TABLE_Shipper =
            "CREATE TABLE Shipper(" +
                    "name text PRIMARY KEY," +
                    "phoneNumber text NOT NULL," +
                    "signal text NOT NULL" +
                    ")";
    static final String CREATE_TABLE_Product =
            "CREATE TABLE Product(" +
                    "id integer PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    "name text NOT NULL," +
                    "Gia text NOT NULL," +
                    "Anh text NOT NULL" +
                    ")";
    static final String CREATE_TABLE_PRODUCT_CART =
            "CREATE TABLE Product_Cart(" +
                    "id integer PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    "name text NOT NULL," +
                    "Gia double NOT NULL," +
                    "Anh text NOT NULL," +
                    "soLuong int NOT NULL," +
                    "size int NOT NULL," +
                    "topping int NOT NULL," +
                    "ice int NOT NULL," +
                    "sugar int NOT NULL," +
                    "status int NOT NULL" +
                    ")";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_Person);
//        db.execSQL(CREATE_TABLE_Shipper);
        db.execSQL(CREATE_TABLE_Product);
        db.execSQL(CREATE_TABLE_PRODUCT_CART);

        db.execSQL(SQLite.INSERT_Product);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTableperson = "drop table if exists person";
        db.execSQL(dropTableperson);
        onCreate(db);

        String dropTableShipper = "drop table if exists Shipper";
        db.execSQL(dropTableShipper);
        onCreate(db);

        String dropTableProduct = "drop table if exists Product";
        db.execSQL(dropTableProduct);
        onCreate(db);

    }
}
