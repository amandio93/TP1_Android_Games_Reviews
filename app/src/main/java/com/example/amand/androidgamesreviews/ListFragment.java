package com.example.amand.androidgamesreviews;


import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.amand.androidgamesreviews.Model.DatabaseHandler;
import com.example.amand.androidgamesreviews.Model.Jogo;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends android.support.v4.app.ListFragment {

    //public static final String STATE_ARGS = "getArguments";
    private int selectedIndex;

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DatabaseHandler db = new DatabaseHandler(getContext());
        List<Jogo> jogos = db.getAllGames();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =super.getView(position, convertView, parent);
                TextView textView=(TextView) view.findViewById(android.R.id.text1);
                textView.setTextColor(Color.WHITE);
                return view;
            }
        };
        for (Jogo gm : jogos) {
            adapter.add(gm.get_nome_jogo());
            Log.d("Nome do jogo: ", "Nome: " + gm.get_nome_jogo());
        }
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }


    public void onListItemClick(ListView l, View v, int position, long id) {

        this.selectedIndex = (position + 1);

        /*GameInfoFragment gameInfoFragmentLand = (GameInfoFragment)
                getActivity().getSupportFragmentManager().findFragmentById(R.id.game_info_fragment);

        if (gameInfoFragmentLand != null ) {
            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                //gameInfoFragmentLand.updateGameInfo(selectedIndex +1);
                GameInfoFragment gameInfoFragment = new GameInfoFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, gameInfoFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                gameInfoFragmentLand.updateGameInfo(selectedIndex);
            }else{
                gameInfoFragmentLand.updateGameInfo(selectedIndex);
            }
            //gameInfoFragmentLand.updateGameInfo(selectedIndex +1);
        }else{

        }*/
        GameInfoFragment gameInfoFragment = new GameInfoFragment();
        if (getActivity().findViewById(R.id.fragment_container) != null){

            Bundle args = new Bundle();
            args.putInt("position", selectedIndex);
            gameInfoFragment.setArguments(args);
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.fragment_container, gameInfoFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }else{
            GameInfoFragment gameInfoFragmentLand = (GameInfoFragment)
                    getActivity().getSupportFragmentManager().findFragmentById(R.id.game_info_fragment);
            gameInfoFragmentLand.updateGameInfo(selectedIndex);
        }


    }

}
