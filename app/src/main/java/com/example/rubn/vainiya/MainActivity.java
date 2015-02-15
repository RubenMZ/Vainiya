package com.example.rubn.vainiya;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    EditText nombre, tlf, email, pass;
    Button btAgregar;
    Switch btSexo;
    TextView tvSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.editText);
        tlf = (EditText) findViewById(R.id.editText2);
        email = (EditText) findViewById(R.id.editText3);
        pass = (EditText) findViewById(R.id.editText4);

        tvSexo = (TextView) findViewById(R.id.tvSexo);
        btAgregar = (Button) findViewById(R.id.btAgregar);
        btSexo = (Switch) findViewById(R.id.btSexo);

        btAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast mensaje =  Toast.makeText(getApplicationContext(), "Contacto agregado", Toast.LENGTH_LONG);
                mensaje.show();
                limpiarCampos();
            }
        });

    }

    private void limpiarCampos(){
        nombre.getText().clear();
        tlf.getText().clear();
        email.getText().clear();
        pass.getText().clear();
        limpiarCampos();
    }

    public void onToggleClicked(View view) {
        // Is the toggle on?
        boolean on = ((Switch) view).isChecked();

        if (on) {
            Vibrator v = (Vibrator) getSystemService(getApplicationContext().VIBRATOR_SERVICE);
            v.vibrate(250);
            tvSexo.setText("Mujer");
        } else {
            Vibrator v = (Vibrator) getSystemService(getApplicationContext().VIBRATOR_SERVICE);
            v.vibrate(500);
            tvSexo.setText("Hombre");
        }
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
