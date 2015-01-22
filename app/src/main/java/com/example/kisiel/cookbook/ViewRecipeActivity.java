package com.example.kisiel.cookbook;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.kisiel.cookbook.data.Recipes;
import com.example.kisiel.cookbook.data.User;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.activity_view_recipe)
public class ViewRecipeActivity extends ActionBarActivity {


    @Extra
    Bundle bundle;

    @ViewById
    TextView title;

    @ViewById
    TextView introduction;


    @ViewById
    TextView ingredients;

    @ViewById
    TextView steps;

    @ViewById
    TextView created;

    @ViewById
    TextView preparationMinutes;

    @ViewById
    TextView cookingMinutes;

    @ViewById
    TextView servings;



    Recipes recipes;
    User user;
    ProgressDialog ringProgressDialog;


    @AfterViews
    void init (){
        user=(User)bundle.getSerializable("user");
        recipes=(Recipes)bundle.getSerializable("recipes");

        title.setText(recipes.title);
        introduction.setText(recipes.introduction);
        ingredients.setText(recipes.ingredients);
        steps.setText(recipes.steps);
        created.setText("Data dodania: " + recipes.created);
        preparationMinutes.setText("Czas przygotowania: " + recipes.preparationMinutes);
        cookingMinutes.setText("Czas gotowania: " + recipes.cookingMinutes);
        servings.setText("Porcja dla " + recipes.servings + " osób");

        ringProgressDialog = new ProgressDialog(this);
        ringProgressDialog.setMessage("Trwa ładowanie. Poczekaj.");
        ringProgressDialog.setIndeterminate(true);

    }

}
