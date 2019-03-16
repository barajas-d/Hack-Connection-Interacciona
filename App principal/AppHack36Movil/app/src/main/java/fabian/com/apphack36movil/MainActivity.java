package fabian.com.apphack36movil;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView  registro = (TextView)findViewById(R.id.textViewRegistrate);
        Button btnLogin = (Button)findViewById(R.id.btnLogueo);
        final EditText emailT = (EditText)findViewById(R.id.emailLogueo);
        final EditText passT = (EditText)findViewById(R.id.passLogueo);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registro = new Intent(MainActivity.this, Registro.class);
                MainActivity.this.startActivity(registro);
                finish();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = emailT.getText().toString();
                final String pass = passT.getText().toString();
               Response.Listener<String> respuesta = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonRespuesta = new JSONObject(response);
                            boolean ok = jsonRespuesta.getBoolean("success");
                            if (ok==true){
                                String nombre = jsonRespuesta.getString("nombre");
                                String idUser = jsonRespuesta.getString("idUser");
                                Intent bienvenido = new Intent(MainActivity.this, MapsActivity.class);
                                bienvenido.putExtra("nombre", nombre);
                                bienvenido.putExtra("idUser", idUser);

                                MainActivity.this.startActivity(bienvenido);
                                MainActivity.this.finish();
                            }else{
                                AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                                alerta.setMessage("Fallo en el logueo")
                                        .setNegativeButton("Reintentar", null)
                                        .create()
                                        .show();
                            }
                        }catch (JSONException e){
                              e.getMessage();
                        }
                    }
                };
                LoginRequest r = new LoginRequest(email, pass, respuesta);
                RequestQueue cola = Volley.newRequestQueue(MainActivity.this);
                cola.add(r);
            }
        });
    }
}
