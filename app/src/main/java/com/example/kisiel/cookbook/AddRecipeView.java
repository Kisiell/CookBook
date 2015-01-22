package com.example.kisiel.cookbook;

import android.support.v7.app.ActionBarActivity;

import android.widget.EditText;
import android.widget.Toast;

import com.example.kisiel.cookbook.data.Recipes;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.ViewById;
import org.springframework.util.StringUtils;


@EActivity(R.layout.activity_add_recipe_view)
public class AddRecipeView extends ActionBarActivity {




    @Bean
    @NonConfigurationInstance
    RestBackgroundaddRecipe restBackgroundaddRecipe;

    //region EditTexts
    @ViewById
    EditText title;
    @ViewById
    EditText introduction;
    @ViewById
    EditText ingredients;
    @ViewById
    EditText steps;
    @ViewById
    EditText servings;
    @ViewById
    EditText preparationMinutes;
    @ViewById
    EditText cookingMinutes;
    //endregion


    @AfterViews
    void init() {

    }


    @Click
    void addRecipesClicked(){
        if(StringUtils.hasText(title.getText().toString()) == true ||
                StringUtils.hasText(ingredients.getText().toString()) == true ||
                StringUtils.hasText(steps.getText().toString()) == true ||
                StringUtils.hasText(servings.getText().toString()) == true){

            //new class
            Recipes recipe = new Recipes();
            recipe.title = title.getText().toString();
            recipe.introduction = introduction.getText().toString();
            recipe.ingredients = ingredients.getText().toString();
            recipe.steps = steps.getText().toString();
            recipe.servings = servings.getText().toString();
            recipe.preparationMinutes = preparationMinutes.getText().toString();
            recipe.cookingMinutes = cookingMinutes.getText().toString();
            //owner id


            //POST operation
            restBackgroundaddRecipe.addRecipe(recipe);


            ListaActivity_.intent(this).start();

        } else{
            Toast.makeText(this, "Uzupełnij wymagane pola!", Toast.LENGTH_LONG).show();
        }
    }


    public void showSuccess(){
        Toast.makeText(this,"Dodano przepis!",Toast.LENGTH_LONG).show();
    }

    public void showError(Exception e){
        Toast.makeText(this, "LOL, nie działa\n" + e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace(); //debug
    }
}

