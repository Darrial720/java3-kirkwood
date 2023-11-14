package com.shirley.demo.day21;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Category implements Comparable<Category>{

    @JsonProperty("idCategory")
    private int idCategory;
    @JsonProperty("idMeal")
    private int idMeal;
    @JsonProperty("strCategory")
    private String strCategory;
    @JsonProperty("strCategoryThumb")
    private String strCategoryThumb;
    @JsonProperty("strCategoryDescription")
    private String strCategoryDescription;
    @JsonProperty("strIngredient1")
    private String strIngredient1;

    @JsonProperty("strImageSource")
    private String strImageSource;

    public int getIdMeal() {
        return idMeal;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public String getStrCategoryThumb() {
        return strCategoryThumb;
    }

    public String getStrCategoryDescription() {
        return strCategoryDescription;
    }

    public String getStrIngredient1() {
        return strIngredient1;
    }

    public String getStrImageSource() {
        return strImageSource;
    }

    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + idCategory +
                ", idMeal=" + idMeal +
                ", strCategory='" + strCategory + '\'' +
                ", strCategoryThumb='" + strCategoryThumb + '\'' +
                ", strCategoryDescription='" + strCategoryDescription + '\'' +
                ", strIngredient1='" + strIngredient1 + '\'' +
                ", strImageSource='" + strImageSource + '\'' +
                '}';
    }

    @Override
    public int compareTo(Category o) {
        int result = this.getStrCategory().compareTo(o.getStrCategory());
        if(result == 0){
            result = this.getStrCategoryDescription().compareTo(o.getStrCategoryDescription());
        }
        return result;
    }
}
