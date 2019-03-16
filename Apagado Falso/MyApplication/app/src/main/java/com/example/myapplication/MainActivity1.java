package com.example.myapplication;


import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Ocultar Notificacion bar
        if (Build.VERSION.SDK_INT > 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    //getActionBar().hide();
        }

        //Ocultar home bar
        //View decorView = getWindow().getDecorView();
        //int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        //        | View.SYSTEM_UI_FLAG_FULLSCREEN;
        //decorView.setSystemUiVisibility(uiOptions);

        setContentView(R.layout.activity_main);

        ImageView apagar = (ImageView)findViewById(R.id.apagar);

        apagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Down_Fake.class);
                startActivityForResult(intent, 0);
            }
        });



        ImageView reiniciar = (ImageView)findViewById(R.id.reiniciar);

        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Down_Fake.class);
                startActivityForResult(intent, 0);
            }
        });

        ImageView otro = (ImageView)findViewById(R.id.otro);

        otro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Down_Fake.class);
                startActivityForResult(intent, 0);
            }
        });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                View decorView = getWindow().getDecorView();
                //int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                //        | View.SYSTEM_UI_FLAG_FULLSCREEN;
                //decorView.setSystemUiVisibility(uiOptions);
                return true;
            case KeyEvent.KEYCODE_VOLUME_UP:
                //CODIGO AQUI
                return true;
            default:
                return super.onKeyDown(keyCode, event);
        }


    }



}
