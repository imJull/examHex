package unadeca.net.examhex;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Declaracion de las Variables

        final EditText Num1 = findViewById(R.id.txrnum1);
        Button btnConvertir = findViewById(R.id.btnconvert);
        final TextView Resptxt = findViewById(R.id.txtresp);

        FloatingActionButton fab = findViewById(R.id.fab);

        //Boton que agrega la funcionalidad de convertir
        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValiHex(Num1);
                Resptxt.setText(Convertidor(Integer.parseInt(Num1.getText().toString())));



            }
        });
    }


    // Funcion que intenta convertir valores decimales a decimales
    // COnvierto los numeros 1-15

    private String Convertidor(int dec) {
        String NumHexa="";
        if(dec < 16) {
            switch(dec) {
                case 10:
                    NumHexa="A";
                    break;
                case 11:
                    NumHexa="B";
                    break;
                case 12:
                    NumHexa="C";
                    break;
                case 13:
                    NumHexa="D";
                    break;
                case 14:
                    NumHexa="E";
                    break;
                case 15:
                    NumHexa="F";
                    break;
                default:
                    NumHexa=Integer.toString(dec);
                    break;
            }
            return NumHexa;
        } else {
            return "Fuera de Rango";
        }
    }

    //Método para validar si no se introduce nada en el editText
    private boolean ValiHex(EditText Num1){
        boolean error = true;

        if (Num1.getText().toString().isEmpty()){
            Num1.setText("0");
            error = false;
        }return error;
        }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);


    }
}
