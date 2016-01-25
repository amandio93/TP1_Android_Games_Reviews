package com.example.amand.androidgamesreviews;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * André Amândio
 * Trabalho: PDM2
 * Ficheiro: FragmentLocal
 * Data entrega: 22/01/2016
 */
public class FragmentContainer extends AppCompatActivity {

    private String buttonName;

    static final String STATE_INFO = "InfoFragment";
    static final String STATE_LIST_GAME = "ListGameFragment";

    static final boolean STATE = false;

    public boolean stateInfo = false;
    public boolean stateListGames = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);

        Intent intent = getIntent();
        buttonName = intent.getStringExtra("btnName");
        Log.d("btnName", buttonName);

        /*if (savedInstanceState != null) {
            stateInfo = savedInstanceState.getBoolean(STATE_INFO, true);
            stateListGames = savedInstanceState.getBoolean(STATE_LIST_GAME, true);
        }*/

        /*if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            if (stateListGames){
                ListFragment listFragment = new ListFragment();
                FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, listFragment).commit();

            }else{
                FragmentTransaction res = showList(R.id.fragment_container);
            }
        }*/

        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }
            FragmentTransaction res = showList(R.id.fragment_container);
        }
    }

    private FragmentTransaction showList(Integer container){
        ListFragment listFragment = new ListFragment();
        listFragment.setArguments(getIntent().getExtras());

        FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
        transaction.add(container, listFragment).commit();
        stateListGames = true;
        return transaction;
    }

    private FragmentTransaction showGameInfo(Integer container){
        GameInfoFragment gameInfoFragment = new GameInfoFragment();
        gameInfoFragment.setArguments(getIntent().getExtras());
        FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
        transaction.add(container, gameInfoFragment).commit();
        return transaction;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        Fragment infoFragment = getSupportFragmentManager().findFragmentById(R.id.game_info);
        if (infoFragment != null){
            savedInstanceState.putBoolean(STATE_INFO, true);
        }

        super.onSaveInstanceState(savedInstanceState);
    }


}
