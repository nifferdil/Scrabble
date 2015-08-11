import org.junit.*;
import static org.junit.Assert.*;


@Test
    public void scrabbleScore_returnAScrabbleScoreForALetter_1() {
        App app = new App();
        Integer score = 1;
        assertEquals(score, app.scrabbleScore("a"));
    }
