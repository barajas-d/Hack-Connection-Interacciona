package fabian.com.apphack36movil.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import fabian.com.apphack36movil.Home;
import fabian.com.apphack36movil.MapsActivity;
import fabian.com.apphack36movil.R;
import fabian.com.apphack36movil.denun;

import android.util.Log;

public class BottomNavigationViewHelper {
    private static final String TAG = "BottomNavigationViewHel";

    public static void setUpButtomNavigationViewHelper(BottomNavigationView bottomNavigationView){
        Log.d(TAG, "setUpButtomNavigationViewHelper: ");

    }

    public static void enableNavigation(final Context context, BottomNavigationView view){
      view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
              switch(menuItem.getItemId()){
                  case R.id.homeItem:
                      Intent intent = new Intent(context, Home.class);
                      context.startActivity(intent);
                      break;
                  case R.id.mapItem:
                      Intent intent2 = new Intent(context, MapsActivity.class);
                      context.startActivity(intent2);
                      break;
                  case R.id.denunItem:
                      Intent intent3 = new Intent(context, denun.class);
                      context.startActivity(intent3);
                      break;
              }

              return false;
          }
      });
    }
}
