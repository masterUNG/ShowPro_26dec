package appthai.pdmobile.showpro;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by masterUNG on 12/26/2016 AD.
 */

public class MyAlert {

    //Explicit
    private Context context;
    private int anInt;
    private String namePromotionString, detailString, priceString;
    private int[] ints = new int[]{R.drawable.ais_logo, R.drawable.ais_logo,
    R.drawable.dtac_logo, R.drawable.true_logo};

    public MyAlert(Context context,
                   int anInt,
                   String namePromotionString,
                   String detailString,
                   String priceString) {
        this.context = context;
        this.anInt = anInt;
        this.namePromotionString = namePromotionString;
        this.detailString = detailString;
        this.priceString = priceString;
    }

    public void myDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(ints[anInt]);
        builder.setTitle(namePromotionString);
        builder.setMessage(detailString + "\n" + "\n" + priceString);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                dialogInterface.dismiss();
            }
        });
        builder.show();

    }   // myDialog


}   // Main Class
