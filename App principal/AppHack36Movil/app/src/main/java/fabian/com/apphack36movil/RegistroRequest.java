package fabian.com.apphack36movil;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class RegistroRequest extends StringRequest {
   private static final String ruta = "https://alamanu.com/hackaton/registro.php";
   private Map<String, String> parametros;
   //Se envía la información al servidor
   public RegistroRequest(String nombre, String idUser, String email, String pass, Response.Listener<String> listener){
       super(Request.Method.POST, ruta, listener, null);
       parametros = new HashMap<>();
       parametros.put("nombre",nombre+"");
       parametros.put("idUser",idUser+"");
       parametros.put("email",email+"");
       parametros.put("pass",pass+"");
   }
    @Override
    protected Map<String, String> getParams()  {
       return parametros;
    }
}
