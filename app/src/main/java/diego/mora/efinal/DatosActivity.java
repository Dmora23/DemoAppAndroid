package diego.mora.efinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import diego.mora.efinal.datos.DatosSQLite;

public class DatosActivity extends AppCompatActivity implements View.OnClickListener{
    EditText medtSueldobasico, medtBonificacion;
    Button mbtnRegistrar, mbtnIngreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        medtSueldobasico = findViewById(R.id.edtsuelbasico);
        medtBonificacion = findViewById(R.id.edtBonif);
        mbtnRegistrar = findViewById(R.id.btnRegistrar);
        mbtnIngreso = findViewById(R.id.btnIngreso);

        mbtnRegistrar.setOnClickListener(this);
        mbtnIngreso.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRegistrar:
                insertarRegistro();
                break;
            case R.id.btnIngreso:
                mostrarIngreso();
                break;

        }
    }

        private void insertarRegistro(){
            float Sueldobasico= Float.parseFloat(medtSueldobasico.getText().toString());
            float Bonificacion= Float.parseFloat(medtBonificacion.getText().toString());
            float Sueldototal = Sueldobasico + Bonificacion;

            DatosSQLite datosSQLite = new DatosSQLite(getApplication());
            int autonumerico = datosSQLite.sueldosInsert(datosSQLite,Sueldobasico,Bonificacion,Sueldototal);
            Toast.makeText(getApplication(), String.valueOf(autonumerico), Toast.LENGTH_SHORT).show();
        }

        private void mostrarIngreso(){
            startActivity(new Intent(this,SueldosActivity.class));
        }


}