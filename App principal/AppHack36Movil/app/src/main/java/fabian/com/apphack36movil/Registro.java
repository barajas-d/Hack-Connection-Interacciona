package fabian.com.apphack36movil;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        final EditText nombreT     = (EditText)findViewById(R.id.nombreRegistro);
        final EditText idUserT     = (EditText)findViewById(R.id.cedulaRegistro);
        final EditText emailT      = (EditText)findViewById(R.id.emailRegistro);
        final EditText passT       = (EditText)findViewById(R.id.passRegistro);
        Button btnRegistroT        = (Button)findViewById(R.id.btnRegistro);

        btnRegistroT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre   = nombreT.getText().toString();
                String idUser   = idUserT.getText().toString();
                String email    = emailT.getText().toString();
                String pass     = passT.getText().toString();

                Response.Listener<String> respuesta = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonRespuesta = new JSONObject(response);
                            boolean ok = jsonRespuesta.getBoolean("success");
                            if(ok == true){
                                Intent i = new Intent(Registro.this, MainActivity.class);
                                Registro.this.startActivity(i);
                                Registro.this.finish();
                            }else{
                                AlertDialog.Builder alerta = new AlertDialog.Builder(Registro.this);
                                alerta.setMessage("fallo en el registro")
                                        .setNegativeButton("Reintentar", null)
                                        .create()
                                        .show();
                            }
                    }catch(JSONException e){
                            e.getMessage();
                        }
                    }
                };

                RegistroRequest r = new RegistroRequest(nombre,idUser, email, pass, respuesta);
                RequestQueue cola = Volley.newRequestQueue(Registro.this);
                cola.add(r);
            }
        });
    }
}
