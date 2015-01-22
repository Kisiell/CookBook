package com.example.kisiel.cookbook;

import com.example.kisiel.cookbook.data.Recipes;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;

@EBean
public class RestBackgroundaddRecipe {
    @RootContext
    AddRecipeView activity; //activity with listview

    @RestService
    CookbookRestClient restClient; //use that cool interface


    //load recipes in background withoud blocking main application ;-)
    @Background
    void addRecipe(Recipes recipe){
        try{
            //rest client headers for POST
            restClient.setHeader("X-Dreamfactory-Application-Name", "cookbook");


            //recipe is filled in AddRecipeView so it only requires to pass it to restClient.addRecipe
            restClient.addRecipes(recipe);
        } catch(Exception e){
            publishError(e);
        }

    }

    @UiThread
    void publishSuccess(){activity.showSuccess(); }
    @UiThread
    void publishError(Exception e){activity.showError(e);}



}