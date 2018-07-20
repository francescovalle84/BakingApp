package com.example.android.bakingapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.VisibleForTesting;

import java.util.Objects;

/**
 * Created by franc on 15/07/2018.
 */

@Entity(tableName = "steps",
        foreignKeys = @ForeignKey(entity = Recipe.class,
                parentColumns = "id",
                childColumns = "recipe_id",
                onDelete = ForeignKey.CASCADE))
public class Step {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "step_id")
    private int stepId;
    @ColumnInfo(name = "short_description")
    private String shortDescription;
    private String description;
    @ColumnInfo(name = "video_url")
    private String videoUrl;
    @ColumnInfo(name = "thumbnail_url")
    private String thumbnailUrl;
    @ColumnInfo(name = "recipe_id")
    private int recipeId;

    public Step() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStepId() {
        return stepId;
    }

    public void setStepId(int stepId) {
        this.stepId = stepId;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
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

        Step step = (Step) obj;
        return (this.id == step.id)
                && (this.stepId == step.stepId)
                && (this.shortDescription.equals(step.shortDescription))
                && (this.description.equals(step.description))
                && (this.videoUrl.equals(step.videoUrl))
                && (this.thumbnailUrl.equals(step.thumbnailUrl))
                && (this.recipeId == step.recipeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.stepId, this.shortDescription, this.description, this.videoUrl, this.thumbnailUrl, this.recipeId);
    }

    @Override
    public String toString() {
        return "Step {" +
                    "id=" + this.id + ", " +
                    "stepId=" + this.stepId + ", " +
                    "shortDescription='" + this.shortDescription + "', " +
                    "description='" + this.description + "', " +
                    "videoUrl='" + this.videoUrl + "', " +
                    "thumbnailUrl='" + this.thumbnailUrl + "', " +
                    "recipeId=" + this.recipeId + "" +
                "}";
    }
}
