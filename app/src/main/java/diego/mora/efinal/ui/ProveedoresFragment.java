package diego.mora.efinal.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;

import diego.mora.efinal.R;
import diego.mora.efinal.adapters.ProveedoresAdapter;
import diego.mora.efinal.global.Total;

public class ProveedoresFragment extends Fragment {
    ArrayList arrayList = new ArrayList<HashMap<String,String>>();
    RecyclerView recyclerView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        leerDatos();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_proveedores, container, false);

    }

    private void leerDatos() {
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        String url = Total.rutaServicio + "servicioclientes.php";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("DATOS", response);
                        llenarLista(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("DATOS", "ERROR DE VOLLEY");
            }
        });
        queue.add(stringRequest);
    }

    private void llenarLista(String response) {
        try {
            JSONArray jsonArray = new JSONArray(response);
            for(int i=0; i<jsonArray.length(); i++){
                String idcliente = jsonArray.getJSONObject(i).getString("idcliente");
                String empresa = jsonArray.getJSONObject(i).getString("empresa");
                String cargo = jsonArray.getJSONObject(i).getString("cargo");
                String nombres = jsonArray.getJSONObject(i).getString("nombres");
                String pais = jsonArray.getJSONObject(i).getString("pais");
                HashMap<String,String> map = new HashMap<>();
                map.put("idcliente", idcliente);
                map.put("empresa", empresa);
                map.put("cargo", cargo);
                map.put("nombres", nombres);
                map.put("pais", pais);
                arrayList.add(map);
            }


            RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.rvProveedores);
            ProveedoresAdapter proveedoresAdapter = new ProveedoresAdapter(arrayList);
            recyclerView.setAdapter(proveedoresAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}