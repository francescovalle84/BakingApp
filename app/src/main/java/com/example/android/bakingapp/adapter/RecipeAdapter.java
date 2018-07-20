package com.example.android.bakingapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.bakingapp.R;
import com.example.android.bakingapp.model.Recipe;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by franc on 20/07/2018.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeAdapterViewHolder> {

    // Store context to be used in onBindViewHolder
    private Context mContext;

    private List<Recipe> mRecipeList;

    public RecipeAdapter(Context context, List<Recipe> recipeList) {
        this.mContext = context;
        this.mRecipeList = recipeList;
    }

    /**
     * This gets called when each new ViewHolder is created. This happens when the RecyclerView
     * is laid out. Enough ViewHolders will be created to fill the screen and allow for scrolling.
     */
    @NonNull
    @Override
    public RecipeAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_card, parent, false);
        return new RecipeAdapterViewHolder(itemView);
    }

    /**
     * OnBindViewHolder is called by the RecyclerView to display the data at the specified
     * position. In this method, we update the contents of the ViewHolder to display the recipe
     * details, using the "position" argument that is conveniently passed into us.
     */
    @Override
    public void onBindViewHolder(@NonNull final RecipeAdapterViewHolder holder, int position) {
        Recipe recipe = mRecipeList.get(position);
        holder.mRecipeTitleTextView.setText(recipe.getName());
        holder.mServingsTextView.setText(String.valueOf(recipe.getServings()));

        String url = recipe.getImage();
        if (url == null || url.isEmpty()) {
            Picasso.with(mContext)
                    .load(R.drawable.error_loading)
                    .into(holder.mRecipeImageImageView);
        } else {
            Picasso.with(mContext)
                    .load(url)
                    .error(R.drawable.error_loading)
                    .into(holder.mRecipeImageImageView);
        }

        holder.mOverflowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.mOverflowImageView);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // Inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_recipe, popup.getMenu());
        popup.setOnMenuItemClickListener(new RecipeItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class RecipeItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public RecipeItemClickListener() {

        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_to_widget:
                    Toast.makeText(mContext, "Add to widget", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_to_remove:
                    Toast.makeText(mContext, "Removed", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    public class RecipeAdapterViewHolder extends RecyclerView.ViewHolder {

        // Declare data items
        public ImageView mRecipeImageImageView;
        public TextView mRecipeTitleTextView;
        public TextView mServingsTextView;
        public ImageView mOverflowImageView;

        public RecipeAdapterViewHolder(View view) {
            super(view);
            mRecipeImageImageView = (ImageView) view.findViewById(R.id.recipe_image_iv);
            mRecipeTitleTextView = (TextView) view.findViewById(R.id.recipe_name_tv);
            mServingsTextView = (TextView) view.findViewById(R.id.servings_tv);
            mOverflowImageView = (ImageView) view.findViewById(R.id.overflow_iv);
        }
    }
}
