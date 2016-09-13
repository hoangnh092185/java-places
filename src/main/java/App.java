import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.List;

public class App {

  public static void main (String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request,response) -> {
      Map<String, Object> model = new HashMap <String, Object>();
      model.put("placesList", request.session().attribute("placesList"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/places", (request, response) -> {
      Map<String,Object> model = new HashMap <String, Object>();
      ArrayList<Places> places = request.session().attribute("placesList");
      if (places == null) {
        places = new ArrayList<Places>();
        request.session().attribute("placesList", places);
      }
      String location = request.queryParams("place");
      Places newPlace = new Places(location);
      places.add(newPlace);
      model.put("template", "templates/placeList.vtl");
      model.put("place", location);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
