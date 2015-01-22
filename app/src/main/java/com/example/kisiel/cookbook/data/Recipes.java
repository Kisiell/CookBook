package com.example.kisiel.cookbook.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipes implements Serializable {

    public String title;
    public String introduction;

    public String ingredients;
    public  String steps;
    public  String preparationMinutes;
    public  String created;

    public String cookingMinutes;
    public String servings;
    public String id;

}