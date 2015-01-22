package com.example.kisiel.cookbook;

import com.example.kisiel.cookbook.data.CookBook;
import com.example.kisiel.cookbook.data.EmailAndPassword;
import com.example.kisiel.cookbook.data.Recipes;
import com.example.kisiel.cookbook.data.User;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.RequiresHeader;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.RestClientHeaders;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;


@Rest(rootUrl = "http://pegaz.wzr.ug.edu.pl:8080/rest",
        converters = { MappingJackson2HttpMessageConverter.class })
@RequiresHeader({"X-Dreamfactory-Application-Name"})
public interface CookbookRestClient extends RestClientHeaders {

    @Get("/db/recipes")
    CookBook getCookBook(); //pobieranie ksiazki z api

    @Post("/user/session")
    User email (EmailAndPassword emailAndPassword); //logowanie

    @RequiresHeader({"X-Dreamfactory-Application-Name","X-Dreamfactory-Session-Token"})
    @Post("/db/recipes")  // dodawanie nowego przepisu
    void addRecipes(Recipes recipes);

}