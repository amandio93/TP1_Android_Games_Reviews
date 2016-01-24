package com.example.amand.androidgamesreviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.amand.androidgamesreviews.Model.DatabaseInsert;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseInsert dbInsert = new DatabaseInsert(this);
    }

    public void btnGameList_OnClick(View view){
        Intent fragmentLocal = new Intent(this, FragmentContainer.class);
        fragmentLocal.putExtra("btnName", "gameList");
        startActivity(fragmentLocal);
    }

    public void btnCategory_OnClick(View view){
        Intent fragmentLocal = new Intent(this, FragmentContainer.class);
        fragmentLocal.putExtra("btnName", "categoria");
        startActivity(fragmentLocal);
    }

    public void btnProdution_OnClick(View view){
        Intent fragmentLocal = new Intent(this, FragmentContainer.class);
        fragmentLocal.putExtra("btnName", "produtora");
        startActivity(fragmentLocal);
    }
}
