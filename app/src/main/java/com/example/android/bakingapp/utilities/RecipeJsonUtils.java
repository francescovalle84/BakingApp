package com.example.android.bakingapp.utilities;

import android.content.Context;
import android.util.Log;

import com.example.android.bakingapp.model.Ingredient;
import com.example.android.bakingapp.model.Recipe;
import com.example.android.bakingapp.model.Step;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by franc on 19/07/2018.
 */

public class RecipeJsonUtils {

    private static final String LOG_TAG = RecipeJsonUtils.class.getSimpleName();

    public static List<Recipe> getRecipesFromJson(Context context, String recipeJsonStr) throws JSONException {

        Log.v(LOG_TAG, "Starting getRecipesFromJson");

        List<Recipe> recipes = new ArrayList<>();

        final String JSON_RECIPE_ID = "id";
        final String JSON_RECIPE_NAME = "name";
        final String JSON_RECIPE_SERVINGS = "servings";
        final String JSON_RECIPE_IMAGE = "image";

        Log.d(LOG_TAG, "Json string: " + recipeJsonStr);
        JSONArray recipeJsonArray = new JSONArray(recipeJsonStr);

        for (int i = 0; i < recipeJsonArray.length(); i++) {

            JSONObject recipeJSONItem = recipeJsonArray.getJSONObject(i);
            Log.d(LOG_TAG, "Reading recipe with id: " + recipeJSONItem.getString(JSON_RECIPE_ID));

            Recipe recipe = new Recipe();
            recipe.setId(Integer.parseInt(recipeJSONItem.getString(JSON_RECIPE_ID)));
            recipe.setName(recipeJSONItem.getString(JSON_RECIPE_NAME));
            recipe.setServings(recipeJSONItem.getInt(JSON_RECIPE_SERVINGS));
            recipe.setImage(recipeJSONItem.getString(JSON_RECIPE_IMAGE));

            recipes.add(recipe);
        }

        Log.v(LOG_TAG, "Ending getRecipesFromJson");

        return recipes;
    }

    public static List<Ingredient> getIngredientsByRecipeIdFromJson(Context context, String recipeJsonStr, int recipeId) throws JSONException {

        Log.v(LOG_TAG, "Starting getIngredientsByRecipeIdFromJson");

        List<Ingredient> ingredients = new ArrayList<>();

        final String JSON_RECIPE_ID = "id";
        final String JSON_RECIPE_INGREDIENTS = "ingredients";
        final String JSON_INGREDIENT_QUANTITY = "quantity";
        final String JSON_INGREDIENT_MEASURE = "measure";
        final String JSON_INGREDIENT_INGREDIENT = "ingredient";

        Log.d(LOG_TAG, "Json string: " + recipeJsonStr);
        Log.d(LOG_TAG, "Recipe Id: " + recipeId);
        JSONArray recipeJsonArray = new JSONArray(recipeJsonStr);

        for (int i = 0; i < recipeJsonArray.length(); i++) {

            JSONObject recipeJSONItem = recipeJsonArray.getJSONObject(i);
            Log.d(LOG_TAG, "Reading recipe with id: " + recipeJSONItem.getString(JSON_RECIPE_ID));

            if (recipeJSONItem.getInt(JSON_RECIPE_ID) == recipeId) {
                // Get ingredients only for selected recipe id
                JSONArray ingredientJSONArray = recipeJSONItem.getJSONArray(JSON_RECIPE_INGREDIENTS);

                for (int j = 0; j < ingredientJSONArray.length(); j++) {

                    JSONObject ingredientJSONItem = ingredientJSONArray.getJSONObject(j);
                    Log.d(LOG_TAG, "Reading ingredient with name: " + ingredientJSONItem.getString(JSON_INGREDIENT_INGREDIENT));

                    Ingredient ingredient = new Ingredient();
                    ingredient.setQuantity(ingredientJSONItem.getDouble(JSON_INGREDIENT_QUANTITY));
                    ingredient.setMeasure(ingredientJSONItem.getString(JSON_INGREDIENT_MEASURE));
                    ingredient.setIngredient(ingredientJSONItem.getString(JSON_INGREDIENT_INGREDIENT));

                    ingredients.add(ingredient);
                }
            }
        }

        Log.v(LOG_TAG, "Ending getIngredientsByRecipeIdFromJson");

        return ingredients;
    }

    public static List<Step> getStepsByRecipeIdFromJson(Context context, String recipeJsonStr, int recipeId) throws JSONException {

        Log.v(LOG_TAG, "Starting getStepsByRecipeIdFromJson");

        List<Step> steps = new ArrayList<>();

        final String JSON_RECIPE_ID = "id";
        final String JSON_RECIPE_STEPS = "steps";
        final String JSON_STEP_ID = "id";
        final String JSON_STEP_SHORT_DESCRIPTION = "shortDescription";
        final String JSON_STEP_DESCRIPTION = "description";
        final String JSON_STEP_VIDEO_URL = "videoURL";
        final String JSON_STEP_THUMBNAIL_URL = "thumbnailURL";

        Log.d(LOG_TAG, "Json string: " + recipeJsonStr);
        Log.d(LOG_TAG, "Recipe Id: " + recipeId);
        JSONArray recipeJsonArray = new JSONArray(recipeJsonStr);

        for (int i = 0; i < recipeJsonArray.length(); i++) {

            JSONObject recipeJSONItem = recipeJsonArray.getJSONObject(i);
            Log.d(LOG_TAG, "Reading recipe with id: " + recipeJSONItem.getString(JSON_RECIPE_ID));

            if (recipeJSONItem.getInt(JSON_RECIPE_ID) == recipeId) {
                // Get steps only for selected recipe id
                JSONArray stepJSONArray = recipeJSONItem.getJSONArray(JSON_RECIPE_STEPS);

                for (int j = 0; j < stepJSONArray.length(); j++) {

                    JSONObject stepJSONItem = stepJSONArray.getJSONObject(j);
                    Log.d(LOG_TAG, "Reading steps with id: " + stepJSONItem.getString(JSON_STEP_ID));

                    Step step = new Step();
                    step.setId(stepJSONItem.getInt(JSON_STEP_ID));
                    step.setShortDescription(stepJSONItem.getString(JSON_STEP_SHORT_DESCRIPTION));
                    step.setDescription(stepJSONItem.getString(JSON_STEP_DESCRIPTION));
                    step.setVideoUrl(stepJSONItem.getString(JSON_STEP_VIDEO_URL));
                    step.setThumbnailUrl(stepJSONItem.getString(JSON_STEP_THUMBNAIL_URL));

                    steps.add(step);
                }
            }
        }

        Log.v(LOG_TAG, "Ending getStepsByRecipeIdFromJson");

        return steps;
    }
}
