package com.example.amand.androidgamesreviews;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * André Amândio
 * Trabalho: PDM2
 * Ficheiro: SecondaryLists
 * Data entrega: 27/01/2016
 */
public class SecondaryLists extends AppCompatActivity {

    public static String buttonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary_lists);

        Intent intent = getIntent();
        buttonName = intent.getStringExtra("btnName");
        Log.d("btnName", buttonName);

        if(buttonName.equals("categoria") || buttonName.equals("produtora")){
            showList(R.id.fragment_container_secondary);
        }
    }

    /**
     *
     * @param container
     * @return
     */
    private FragmentTransaction showList(Integer container){
        SecondaryListsFragment secondaryListsFragment = new SecondaryListsFragment();
        FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
        transaction.replace(container, secondaryListsFragment).commit();
        return transaction;
    }
}
