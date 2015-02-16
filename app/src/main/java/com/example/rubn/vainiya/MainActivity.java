package com.example.rubn.vainiya;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    EditText nombre, tlf, email, pass;
    Button btAgregar;
    Switch btSexo;
    TextView tvSexo;

    private ArrayAdapter<Contacto> adapter;
    private ImageView imagen;
    private ListView vistaContactos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inicializarComponentes();
        inicializarListaContactos();
        inicializarTabs();

        btAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarContacto(nombre.getText().toString(), tlf.getText().toString(), email.getText().toString(), btSexo.isChecked());
                Toast mensaje =  Toast.makeText(getApplicationContext(), "Contacto agregado", Toast.LENGTH_LONG);
                mensaje.show();
                limpiarCampos();
            }
        });


    }

    public void inicializarComponentes(){
        nombre = (EditText) findViewById(R.id.editText);
        tlf = (EditText) findViewById(R.id.editText2);
        email = (EditText) findViewById(R.id.editText3);
        pass = (EditText) findViewById(R.id.editText4);

        tvSexo = (TextView) findViewById(R.id.tvSexo);
        btSexo = (Switch) findViewById(R.id.btSexo);

        vistaContactos = (ListView) findViewById(R.id.lvContactos);
        btAgregar = (Button) findViewById(R.id.btAgregar);
    }


    private void inicializarListaContactos(){
        adapter = new ContactoListAdapter(this, new ArrayList<Contacto>());
        vistaContactos.setAdapter(adapter);
    }

    private void agregarContacto(String nombre, String tlf, String email, boolean boton) {
        Contacto c;

        if(boton){
            c = new Contacto(nombre, tlf, email, "Mujer");
        }else{
            c = new Contacto(nombre, tlf, email, "Hombre");
        }

        adapter.add(c);
    }

    private void inicializarTabs() {
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("tab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Crear");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("tab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Lista");
        tabHost.addTab(spec);

    }

    private void limpiarCampos(){
        nombre.getText().clear();
        tlf.getText().clear();
        email.getText().clear();
        pass.getText().clear();
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
