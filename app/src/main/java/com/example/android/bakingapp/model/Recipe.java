package com.example.android.bakingapp.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

/**
 * Created by franc on 15/07/2018.
 */

@Entity(tableName = "recipes")
public class Recipe implements Parcelable {

    @PrimaryKey
    private int id;
    private String name;
    private int servings;
    private String image;

    public Recipe() {

    }

    protected Recipe(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.servings = in.readInt();
        this.image = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.servings);
        dest.writeString(this.image);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj == null || getClass() != obj.getClass())
            return false;

        Recipe recipe = (Recipe) obj;
        return (this.id == recipe.id)
                && (this.name.equals(recipe.name))
                && (this.servings == recipe.servings)
                && (this.image.equals(recipe.image));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.servings, this.image);
    }

    @Override
    public String toString() {
        return "Recipe {" +
                    "id=" + this.id + ", " +
                    "name='" + this.name + "', " +
                    "servings=" + this.servings + ", " +
                    "image='" + this.image + "'" +
                "}";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Recipe> CREATOR = new Parcelable.Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel source) {
            return new Recipe(source);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };
}
