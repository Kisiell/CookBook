package com.example.kisiel.cookbook.itemView;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.kisiel.cookbook.R;
import com.example.kisiel.cookbook.data.Recipes;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.list_item)
public class RecipesItemView extends RelativeLayout {

    @ViewById
    TextView title;

    @ViewById
    TextView introduction;


    public RecipesItemView(Context context) {
        super(context);
    }

    public void bind(Recipes recipes) {
        title.setText(recipes.title);
        introduction.setText(recipes.introduction);
    }

}