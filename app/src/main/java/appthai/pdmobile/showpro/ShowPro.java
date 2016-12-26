package appthai.pdmobile.showpro;

import android.os.AsyncTask;
import android.speech.tts.Voice;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
        int[] iconInts = new int[]{0,R.drawable.ais_logo,
        R.drawable.dtac_logo,R.drawable.true_logo};
        imageView.setImageResource(iconInts[anInt]);

        //Create listview
        MyConstant myConstant = new MyConstant();


    }//Main Method



}  // Main Class
