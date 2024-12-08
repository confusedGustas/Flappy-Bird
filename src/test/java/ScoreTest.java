import com.gustas.entity.Score;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTest {

    @Test
    public void testScoreIncrement() {
        Score score = new Score();

        assertEquals(0, score.getScore());

        score.incrementScore();
        assertEquals(1, score.getScore());

        score.incrementScore();
        assertEquals(2, score.getScore());
    }

    @Test
    public void testScoreReset() {
        Score score = new Score();
        score.incrementScore();
        score.incrementScore();

        score.resetScore();
        assertEquals(0, score.getScore());
    }
}
