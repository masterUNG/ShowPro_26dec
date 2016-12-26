package appthai.pdmobile.showpro;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by hp on 11/10/2016.
 */

public class MyManage {
    //E
    private Context context;
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;
    private MyConstant myConstant;
    private String[] tableStrings, columnStrings;


    public MyManage(Context context) {
        this.context = context;

        myOpenHelper = new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();

        myConstant = new MyConstant();
        tableStrings = myConstant.getTableStrings();
        columnStrings = myConstant.getColumnStrings();
    }

    public long addValueToSQLite(int index, String[] strings) {

        ContentValues contentValues = new ContentValues();

        for (int i=0;i<columnStrings.length;i++) {
            contentValues.put(columnStrings[i],strings[i]);
        }


        return sqLiteDatabase.insert(tableStrings[index],null,contentValues);
    }
} // main class
