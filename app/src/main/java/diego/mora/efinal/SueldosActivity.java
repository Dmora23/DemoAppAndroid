package diego.mora.efinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;

import diego.mora.efinal.adapters.SueldosAdapter;
import diego.mora.efinal.datos.DatosSQLite;

public class SueldosActivity extends AppCompatActivity {
    ArrayList arrayList = new ArrayList<HashMap<String,String>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sueldos);
        leerDatos();
    }

    private void leerDatos() {
        DatosSQLite datosSQLite = new DatosSQLite(this);
        Cursor cursor = datosSQLite.mostrarTodo(datosSQLite);
        if(cursor != null){
            if(cursor.moveToFirst()){
                do{
                    HashMap map = new HashMap<String,String>();
                    map.put("idsueldos",cursor.getColumnIndexOrThrow("idsueldos"));
                    map.put("Sueldobasico",cursor.getColumnIndexOrThrow("Sueldobasico"));
                    map.put("Bonificacion",cursor.getColumnIndexOrThrow("Bonificacion"));
                    map.put("Sueldototal",cursor.getColumnIndexOrThrow("Sueldototal"));
                    arrayList.add(map);
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            llenarLista(response);
                        }
                    };

                }while(cursor.moveToNext());
            }
        }
    }
    private void llenarLista(String response) {
        try {
            JSONArray jsonArray = new JSONArray(response);
            for(int i=0; i<jsonArray.length(); i++){
                String idsueldos = jsonArray.getJSONObject(i).getString("idsueldos");
                String Sueldobasico = jsonArray.getJSONObject(i).getString("Sueldobasico");
                String Bonificacion = jsonArray.getJSONObject(i).getString("Bonificacion");
                String Sueldototal = jsonArray.getJSONObject(i).getString("Sueldototal");
                HashMap<String,String> map = new HashMap<>();
                map.put("idsueldos", idsueldos);
                map.put("Sueldobasico", Sueldobasico);
                map.put("Bonificacion", Bonificacion);
                map.put("Sueldototal", Sueldototal);
                arrayList.add(map);
            }
            RecyclerView mrvTotal = findViewById(R.id.rvTotal);
            SueldosAdapter sueldosAdapter = new SueldosAdapter(arrayList);
            mrvTotal.setAdapter(sueldosAdapter);
            mrvTotal.setLayoutManager(new LinearLayoutManager(this));


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}