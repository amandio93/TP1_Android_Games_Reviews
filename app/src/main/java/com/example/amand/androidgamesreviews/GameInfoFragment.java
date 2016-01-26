package com.example.amand.androidgamesreviews;


import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amand.androidgamesreviews.Model.DatabaseHandler;
import com.example.amand.androidgamesreviews.Model.Jogo;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameInfoFragment extends Fragment {

    static String ARG_POSITION = "position";

    /*private TextView txtGameName;
    private TextView txtClassification;
    private TextView txtCategory;
    private TextView txtProdution;
    private TextView txtDescription;
    private ImageView imgVgame;
    private Button btnVideo;
    private Button btnStore;*/

    private String gameName;
    private String gameClassification;
    private String gameProdution;
    private String gameCategory;
    private String gameDescription;
    private String gameImage;
    private String linkVideo;
    private String linkStore;

    private String argumentsConverter;

    int mCurrentPosition = 0;

    public GameInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_info, container, false);

        /*if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }*/


        /*txtGameName = (TextView)view.findViewById(R.id.txtGameName);
        txtClassification = (TextView)view.findViewById(R.id.txtClassification);
        txtCategory = (TextView)view.findViewById(R.id.txtCategory);
        txtProdution = (TextView)view.findViewById(R.id.txtProdution);
        txtDescription = (TextView)view.findViewById(R.id.txtDescription);
        imgVgame = (ImageView)view.findViewById(R.id.imageView);
        btnVideo = (Button)view.findViewById(R.id.btnVideo);
        btnStore = (Button)view.findViewById(R.id.btnGooglePlay);*/



        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle args = getArguments();
        if (args != null) {
            mCurrentPosition = args.getInt("position");
            updateGameInfo(mCurrentPosition);
            /*if (mCurrentPosition != 0) {
                updateGameInfo(mCurrentPosition);
            }else {
                updateGameInfo(args.getInt(ARG_POSITION));
            }*/
        }
    }

    public void updateGameInfo(int position){

        TextView txtGameName = (TextView)getActivity().findViewById(R.id.txtGameName);
        TextView txtClassification = (TextView)getActivity().findViewById(R.id.txtClassification);
        TextView txtCategory = (TextView)getActivity().findViewById(R.id.txtCategory);
        TextView txtProdution = (TextView)getActivity().findViewById(R.id.txtProdution);
        TextView txtDescription = (TextView)getActivity().findViewById(R.id.txtDescription);
        ImageView imgVgame = (ImageView)getActivity().findViewById(R.id.imageView);
        Button btnVideo = (Button)getActivity().findViewById(R.id.btnVideo);
        Button btnStore = (Button)getActivity().findViewById(R.id.btnGooglePlay);

        DatabaseHandler db = new DatabaseHandler(getContext());
        List<Jogo> games = db.getAllGames(position);

        for (Jogo gm : games) {
            String log = "Id: "+gm.get_nome_jogo()+" ,Name: " + gm.get_classificacao_jogo();
            Log.d("Name: ", log);
            gameName = gm.get_nome_jogo();
            gameClassification = String.valueOf(gm.get_classificacao_jogo());
            gameCategory = gm.get_cod_categoria();
            gameProdution = gm.get_cod_produtora();
            gameDescription = gm.get_descricao_jogo();
            gameImage = gm.get_nome_imagem_jogo();
            linkVideo = gm.get_link_video_jogo();
            linkStore = gm.get_link_store_jogo();
        }

        txtGameName.setText(gameName);
        txtClassification.setText(gameClassification);
        txtCategory.setText(gameCategory);
        txtProdution.setText(gameProdution);
        txtDescription.setText("Descrição: \n" + gameDescription);


        String uri = "@drawable/" + gameImage;
        try{
            int imageResource = getResources().getIdentifier(uri, null, getContext().getPackageName());
            Drawable res = getResources().getDrawable(imageResource);
            imgVgame.setImageDrawable(res);}
        catch (Exception ex){
            String notFound = "@drawable/notfound";
            int imageResourceNotFound = getResources().getIdentifier(notFound, null, getContext().getPackageName());
            Drawable res2 = getResources().getDrawable(imageResourceNotFound);
            imgVgame.setImageDrawable(res2);
        }

        btnVideo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(linkVideo)));
                } catch (Exception ex) {
                    Toast.makeText(getContext(), "Não foi possível ver o video!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnStore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(linkStore)));
                } catch (Exception ex) {
                    Toast.makeText(getContext(), "Não foi possível aceder ao jogo na Google Play Store!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //mCurrentPosition = position;
    }

   /* @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }*/
}
