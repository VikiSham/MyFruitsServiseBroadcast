package com.example.myfruits;

import android.graphics.Color;

/**
 * אובייקט חדש
 */
public class Fruit {
    private String fruitName;
    private int fruitWeight;
    private int fruitImageId;
    private int color;

        public Fruit(String fruitName, int fruitWeight, int fruitImageId) {
        this.fruitName = fruitName;
        this.fruitImageId = fruitImageId;
        this.fruitWeight = fruitWeight;
        this.color= Color.TRANSPARENT;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getFruitImageId() {
        return fruitImageId;
    }

    public void setFruitImageId(int fruitImageId) {
        this.fruitImageId = fruitImageId;
    }

    public int getFruitWeight() {
        return fruitWeight;
    }

    public void setFruitWeight(int fruitWeight) {
        this.fruitWeight = fruitWeight;
    }

    /**
     * Getter for color property of object
     * @return the color of object
     */
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return "Fruit{" +
                "fruitName='" + fruitName + '\'' +
                ", fruitImageId=" + fruitImageId +
                ", fruitWeight=" + fruitWeight +
                '}';
    }
}
