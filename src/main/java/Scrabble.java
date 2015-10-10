import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class Scrabble {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/detector", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/detector.vtl");

      String userInputtedWord = request.queryParams("word");
      Integer wordScore = getWordScore(userInputtedWord);
      model.put("wordScore", wordScore);
      model.put("word", userInputtedWord);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static Integer getWordScore(String word) {

    HashMap<String, Integer> tiles = new HashMap<>();

    tiles.put("A",1);
    tiles.put("E",1);
    tiles.put("I",1);
    tiles.put("O",1);
    tiles.put("U",1);
    tiles.put("L",1);
    tiles.put("N",1);
    tiles.put("R",1);
    tiles.put("S",1);
    tiles.put("T",1);
    tiles.put("D",2);
    tiles.put("G",2);
    tiles.put("B",3);
    tiles.put("C",3);
    tiles.put("M",3);
    tiles.put("P",3);
    tiles.put("F",4);
    tiles.put("H",4);
    tiles.put("V",4);
    tiles.put("W",4);
    tiles.put("Y",4);
    tiles.put("K",5);
    tiles.put("J",8);
    tiles.put("X",8);
    tiles.put("Q",10);
    tiles.put("Z",10);

    String[] letters = word.split("");

    Integer score = 0;
    for(int i=0; i < letters.length ; i++) {
      String letter = letters[i].toUpperCase();
      System.out.println(tiles.get(letter));
      Integer letterScore = tiles.get(letter);
      System.out.println(letterScore);
      score = score + letterScore;
    }
    return score;
  }
}
