package appthai.pdmobile.showpro;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class ShowPro extends AppCompatActivity {

    //E
    private int anInt;
    private ImageView imageView;
    private ListView listView;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_pro);

        //Bind Widget
        imageView = (ImageView) findViewById(R.id.imageView4);
        listView = (ListView) findViewById(R.id.livPromotion);
        button = (Button) findViewById(R.id.button);


        //get value
        anInt = getIntent().getIntExtra("Index", 1);
        Log.d("9novV1", "Index ==>" + anInt);
        //Back Controller
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // show image
        int[] iconInts = new int[]{0, R.drawable.ais_logo,
                R.drawable.dtac_logo, R.drawable.true_logo};
        imageView.setImageResource(iconInts[anInt]);

        //Create listview
        MyConstant myConstant = new MyConstant();
        String[] tableStrings = myConstant.getTableStrings();
        Log.d("9novV1", "tableString ==> " + tableStrings[anInt]);

        try {

            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                    MODE_PRIVATE, null);
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + "'" + tableStrings[anInt] + "'", null);
            cursor.moveToFirst();

            final String[] nameStrings = new String[cursor.getCount()];
            final String[] priceStrings = new String[cursor.getCount()];
            final String[] detailStrings = new String[cursor.getCount()];
            String[] registStrings = new String[cursor.getCount()];
            final String[] codeStrings = new String[cursor.getCount()];
            String[] periodStrings = new String[cursor.getCount()];
            String[] dateRecordStrings = new String[cursor.getCount()];
            String[] showPeriodStrings = new String[cursor.getCount()];

            for (int i = 0; i < cursor.getCount(); i++) {

                nameStrings[i] = cursor.getString(1);
                detailStrings[i] = cursor.getString(2);
                priceStrings[i] = cursor.getString(3);
                registStrings[i] = cursor.getString(4);
                codeStrings[i] = cursor.getString(5);
                periodStrings[i] = cursor.getString(6);
                showPeriodStrings[i] = findShowPeriod(periodStrings[i]);
                dateRecordStrings[i] = cursor.getString(7);

                cursor.moveToNext();
            }   // for

            MyAdapter myAdapter = new MyAdapter(ShowPro.this, nameStrings, priceStrings,
                    detailStrings, registStrings, showPeriodStrings, dateRecordStrings);
            listView.setAdapter(myAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    MyAlert myAlert = new MyAlert(ShowPro.this, anInt, nameStrings[i],
                            detailStrings[i], priceStrings[i], codeStrings[i]);
                    myAlert.myDialog();

                }
            });


        } catch (Exception e) {
            Log.d("9novV1", "e ==> " + e.toString());
        }


    }//Main Method

    private String findShowPeriod(String periodString) {

        String result = null;
        int i = Integer.parseInt(periodString);

        switch (i) {

            case 1:
                result = "24 ชั่วโมง";
                break;
            case 2:
                result = "a";
                break;
            case 3:
                result = "b";
                break;
            case 6:
                result = "c";
                break;
            case 8:
                result = "d";
                break;
            case 9:
                result = "e";
                break;
            case 12:
                result = "f";
                break;
            case 13:
                result = "g";
                break;
            default:
                result = "not thing";
                break;
        }   // switch


        return result;
    }

}  // Main Class
