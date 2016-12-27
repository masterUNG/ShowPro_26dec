package appthai.pdmobile.showpro;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

/**
 * Created by masterUNG on 12/26/2016 AD.
 */

public class MyAlert {

    //Explicit
    private Context context;
    private int anInt;
    private String namePromotionString, detailString, priceString, codeString;
    private int[] ints = new int[]{R.drawable.ais_logo, R.drawable.ais_logo,
            R.drawable.dtac_logo, R.drawable.true_logo};

    public MyAlert(Context context,
                   int anInt,
                   String namePromotionString,
                   String detailString,
                   String priceString,
                   String codeString) {
        this.context = context;
        this.anInt = anInt;
        this.namePromotionString = namePromotionString;
        this.detailString = detailString;
        this.priceString = priceString;
        this.codeString = codeString;
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

                Log.d("27decV1", "Code ==> " + codeString);

                try {

                    codeString =  codeString.replace("*", Uri.encode("*")).replace("#",Uri.encode("#"));
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    Uri data = Uri.parse("tel:" + codeString);
                    intent.setData(data);

                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    context.startActivity(intent);

                } catch (Exception e) {
                    Log.d("27decV1", "e ==> " + e.toString());
                }

                dialogInterface.dismiss();
            }
        });
        builder.show();

    }   // myDialog


}   // Main Class
