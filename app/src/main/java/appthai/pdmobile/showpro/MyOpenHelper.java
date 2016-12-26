package appthai.pdmobile.showpro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hp on 11/10/2016.
 */

public class MyOpenHelper extends SQLiteOpenHelper{

    //Ex
    private Context context;
    private MyConstant myConstant;
    private static final String database_name = "ShowPro.db";
    private static final int database_version = 1;

    public MyOpenHelper(Context context) {

        super(context,database_name,null,database_version);
        this.context = context;
        myConstant = new MyConstant();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(myConstant.getCreate_aisTABLE());
        sqLiteDatabase.execSQL(myConstant.getCreate_dtacTABLE());
        sqLiteDatabase.execSQL(myConstant.getCreate_trueTABLE());

    } // oncreate

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
} // main class
