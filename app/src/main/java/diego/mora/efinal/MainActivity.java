package diego.mora.efinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mbtnValores = findViewById(R.id.btnpreg1);
        Button mbtnnavigation = findViewById(R.id.btnpreg2);
        Button mbtnDatos = findViewById(R.id.btnpreg3);

        mbtnValores.setOnClickListener(this);
        mbtnnavigation.setOnClickListener(this);
        mbtnDatos.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnpreg1:
                mostrarValores();
                break;
            case R.id.btnpreg2:
                mostrarNavigation();
                break;
            case R.id.btnpreg3:
                mostrarDatos();
                break;
        }
    }

    private void mostrarValores(){
        startActivity(new Intent(this,ValoresActivity.class));
    }

    private void mostrarNavigation(){
        startActivity(new Intent(this,NavDrawerActivity.class));
    }

    private void mostrarDatos(){
        startActivity(new Intent(this,DatosActivity.class));
    }

}