package com.example.kisiel.cookbook.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.kisiel.cookbook.data.CookBook;
import com.example.kisiel.cookbook.data.Recipes;
import com.example.kisiel.cookbook.itemView.RecipesItemView;
import com.example.kisiel.cookbook.itemView.RecipesItemView_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

@EBean
public class RecipesListAdapter extends BaseAdapter {

    @RootContext
    Context context;

    List<Recipes> recipes = new ArrayList<Recipes>();

    public RecipesListAdapter() {
    }

    @Override
    public int getCount() {
        return recipes.size();
    }

    @Override
    public Recipes getItem(int i) {
        return recipes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        RecipesItemView recipesItemView;
        if (convertView == null) {
            recipesItemView = RecipesItemView_.build(context);
        } else {
            recipesItemView = (RecipesItemView) convertView;
        }

        recipesItemView.bind(getItem(position));

        return recipesItemView;
    }

    public void update(CookBook cookBook) {
        recipes.clear();
        recipes.addAll(cookBook.records);
        notifyDataSetChanged();
    }

}