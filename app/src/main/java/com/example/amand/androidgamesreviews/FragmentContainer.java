package com.example.amand.androidgamesreviews;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * André Amândio
 * Trabalho: PDM2
 * Ficheiro: FragmentContainer
 * Data entrega: 27/01/2016
 */
public class FragmentContainer extends AppCompatActivity {

    private String buttonName;
    static final String STATE_INFO = "InfoFragment";
    public boolean stateListGames = false;
    boolean firstTimePortrait = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);

        Intent intent = getIntent();
        buttonName = intent.getStringExtra("btnName");
        Log.d("btnName", buttonName);

        if (savedInstanceState != null) {
            firstTimePortrait = savedInstanceState.getBoolean("firstTimePortrait");
        }

        if (findViewById(R.id.fragment_container) != null && buttonName.equals("gameList")) {
            if( ! firstTimePortrait ) {
                return;
            }
            firstTimePortrait = false;
            FragmentTransaction res = showList(R.id.fragment_container);
        }
    }

    /**
     *
     * @param container
     * @return
     */
    private FragmentTransaction showList(Integer container){
        ListFragment listFragment = new ListFragment();
        listFragment.setArguments(getIntent().getExtras());
        FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
        transaction.add(container, listFragment).commit();
        stateListGames = true;
        return transaction;
    }

    /**
     *
     * @param container
     * @return
     */
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
        savedInstanceState.putBoolean("firstTimePortrait", firstTimePortrait);
        super.onSaveInstanceState(savedInstanceState);
    }


}
