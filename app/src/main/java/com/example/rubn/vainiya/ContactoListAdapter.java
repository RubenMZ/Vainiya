package com.example.rubn.vainiya;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rubén on 15/02/2015.
 */
public class ContactoListAdapter extends ArrayAdapter<Contacto> {

    private Activity ctx;
    public ContactoListAdapter(Activity context, List<Contacto> lista){
        super(context, R.layout.listview_item, lista);
        this.ctx = context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = ctx.getLayoutInflater().inflate(R.layout.listview_item, parent, false);

        Contacto actual = this.getItem(position);
        inicializarCamposTexto(convertView, actual);
        return convertView;
    }

    private void inicializarCamposTexto(View view, Contacto actual) {

        TextView vista = (TextView) view.findViewById(R.id.nombre);
        vista.setText(actual.getNombre());
        vista = (TextView) view.findViewById(R.id.telefono);
        vista.setText(actual.getTlf());
        vista = (TextView) view.findViewById(R.id.email);
        vista.setText(actual.getEmail());
        vista = (TextView) view.findViewById(R.id.sexo);
        vista.setText(actual.getSexo());
    }


}
