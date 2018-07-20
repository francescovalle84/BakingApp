package com.example.android.bakingapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.util.Objects;

/**
 * Created by franc on 15/07/2018.
 */

@Entity(tableName = "ingredients",
        foreignKeys = @ForeignKey(entity = Recipe.class,
                parentColumns = "id",
                childColumns = "recipe_id",
                onDelete = ForeignKey.CASCADE))
public class Ingredient {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private double quantity;
    private String measure;
    private String ingredient;
    @ColumnInfo(name = "recipe_id")
    private int recipeId;

    public Ingredient() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj == null || getClass() != obj.getClass())
            return false;

        Ingredient ingredient = (Ingredient) obj;
        return (this.id == ingredient.id)
                && (this.quantity == ingredient.quantity)
                && (this.measure.equals(ingredient.measure))
                && (this.ingredient.equals(ingredient.ingredient))
                && (this.recipeId == ingredient.recipeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.quantity, this.measure, this.ingredient, this.recipeId);
    }

    @Override
    public String toString() {
        return "Ingredient {" +
                    "id=" + this.id + ", " +
                    "quantity=" + this.quantity + ", " +
                    "measure='" + this.measure + "', " +
                    "ingredient='" + this.ingredient + "', " +
                    "recipeId=" + this.recipeId + "" +
                "}";
    }
}
