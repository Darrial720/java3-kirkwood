package FinalExam;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shirley.demo.day21.Category;
import com.shirley.demo.day21.JsonReader;
import com.shirley.demo.day21.MealsFromJson;
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

@WebServlet(name="artistJsonServlet", value="/artist-json")
public class ArtistJsonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/FinalExam/artist-json.jsp").forward(req,resp);
    }

    @Override
    public void init() throws ServletException {
        try {
            JSONObject json = JsonReader.readJsonFromUrl("https://api.deezer.com/search/artist?q=artist_name");
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        }catch(IOException e){

        }
    }
}
