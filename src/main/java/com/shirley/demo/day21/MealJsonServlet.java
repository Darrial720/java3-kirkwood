package com.shirley.demo.day21;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet(name="mealJsonServlet", value="/meals-json")
public class MealJsonServlet extends HttpServlet{
    private static List<Category> categories;

    private static List<String> cats;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("q");
        String sort = req.getParameter("sort");
        String strCategory = req.getParameter("strCategory");
        String q = query != null ? query : "";
        sort = sort != null ? sort : "";
        String category = strCategory != null ? strCategory : "";


        List<Category> copy = new ArrayList<>(categories);
        if(!q.isBlank()) {
            copy.removeIf(category1 -> !category1.getStrCategory().toLowerCase().contains(q.toLowerCase()));
        }
        if(!category.isBlank()){
            copy.removeIf(category1 -> !category1.getStrCategory().equals(category));
        }
        if(sort.equals("az")){
            Collections.sort(copy);
        }
        else{
            copy.sort(Comparator.reverseOrder());
        }

        //Set all static variables and parameters as attributes
        req.setAttribute("categories", copy);
        req.setAttribute("cats", cats);
        req.setAttribute("q", q);
        req.setAttribute("s", sort);
        req.setAttribute("strCategory", strCategory);
        req.getRequestDispatcher("WEB-INF/day21/meals-json.jsp").forward(req,resp);
    }

    @Override
    public void init() throws ServletException {
        try {
            JSONObject json = JsonReader.readJsonFromUrl("https://www.themealdb.com/api/json/v1/1/categories.php/");
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            MealsFromJson mealsFromJson = mapper.readValue(json.toString(), MealsFromJson.class);
            this.categories = mealsFromJson.getCategories();

            cats = new ArrayList<>();
            for(Category category: categories){
                String  strcategory = category.getStrCategory();
                if(!cats.contains(strcategory)){
                    cats.add(strcategory);
                }
            }
            Collections.sort(cats);
        }catch(IOException e){

        }
    }

}
