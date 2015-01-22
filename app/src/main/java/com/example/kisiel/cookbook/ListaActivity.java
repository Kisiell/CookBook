package com.example.kisiel.cookbook;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.widget.ListView;
import android.widget.Toast;

import com.example.kisiel.cookbook.adapter.RecipesListAdapter;
import com.example.kisiel.cookbook.data.CookBook;
import com.example.kisiel.cookbook.data.Recipes;
import com.example.kisiel.cookbook.data.User;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.activity_lista)
@OptionsMenu(R.menu.lista)
public class ListaActivity extends ActionBarActivity {

    @ViewById
    ListView list;

    @Bean
    RecipesListAdapter adapter;

    @Bean
    @NonConfigurationInstance
    RestBackgroundTask restBackgroundTask;

    ProgressDialog ringProgressDialog;

    @Extra
    User user;

    @AfterViews
    void init() {
        list.setAdapter(adapter);
        ringProgressDialog = new ProgressDialog(this);
        ringProgressDialog.setMessage("Trwa ładowanie. Poczekaj!");
        ringProgressDialog.setIndeterminate(true);
    }

    @ItemClick
    void listItemClicked(Recipes recipes) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("recipes", recipes);
        bundle.putSerializable("user", user);
        ViewRecipeActivity_.intent(this).bundle(bundle).start();

    }


    @Click
    void refreshClicked() {
        ringProgressDialog.show();
        restBackgroundTask.getCookBook();
    }

    public void updateCookbook(CookBook cookBook) {
        ringProgressDialog.dismiss();
        adapter.update(cookBook);
    }

    public void showError(Exception e) {
        ringProgressDialog.dismiss();
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }
}
//@Click
//void dodajClicked() {
//
// }




