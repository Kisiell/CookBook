package com.example.kisiel.cookbook;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;


@EActivity(R.layout.activity_my)
public class MyActivity extends ActionBarActivity {



    @Click
    void addRecipesClicked(){
        AddRecipeView_.intent(this).start();

    }


    @Click
    void recipesClicked() {
        Intent secondintent = new Intent(this, ListaActivity_.class);
        startActivity(secondintent);
    }

    @Click
    void loginClicked() {
        Intent firstintent = new Intent(this, LoginActivity_.class);
        startActivity(firstintent);
    }


}
