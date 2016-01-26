package com.example.amand.androidgamesreviews;


import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.amand.androidgamesreviews.Model.Categoria;
import com.example.amand.androidgamesreviews.Model.DatabaseHandler;
import com.example.amand.androidgamesreviews.Model.Produtora;

import java.util.List;


/**
 * André Amândio
 * Trabalho: PDM2
 * Ficheiro: SecondaryListsFragment
 * Data entrega: 27/01/2016
 */
public class SecondaryListsFragment extends android.support.v4.app.ListFragment {

    public SecondaryListsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        DatabaseHandler db = new DatabaseHandler(getContext());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =super.getView(position, convertView, parent);
                TextView textView=(TextView) view.findViewById(android.R.id.text1);
                textView.setTextColor(Color.WHITE);
                return view;
            }
        };

        if(SecondaryLists.buttonName.equals("categoria")){
            List<Categoria> categorys = db.getAllCategorys();
            for (Categoria ct : categorys) {
                String log = "Id: "+ct.get_cod_categoria()+" ,Name: " + ct.get_nome_categoria();
                Log.d("Name: ", log);
                adapter.add(ct.get_nome_categoria());
            }
            setListAdapter(adapter);
        }

        if(SecondaryLists.buttonName.equals("produtora")){
            List<Produtora> produtions = db.getAllProdutions();
            for (Produtora pd : produtions) {
                String log = "Id: "+pd.get_cod_produtora()+" ,Name: " + pd.get_nome_produtora();
                Log.d("Name: ", log);
                adapter.add(pd.get_nome_produtora());
            }
            setListAdapter(adapter);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
