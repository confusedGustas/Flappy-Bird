import com.gustas.Constants;
import com.gustas.entity.Pipe;
import com.gustas.handler.PipeHandler;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PipeHandlerTest {

    @Test
    public void testPipeGeneration() {
        PipeHandler pipeHandler = new PipeHandler();

        for (int i = 0; i < Constants.PIPE_GEN_INTERVAL; i++) {
            pipeHandler.updatePipes();
        }

        List<Pipe> pipes = pipeHandler.getPipes();
        assertEquals(2, pipes.size());

        Pipe topPipe = pipes.get(0);
        Pipe bottomPipe = pipes.get(1);

        assertTrue(topPipe.getHeight() > 0 && topPipe.getY() == 0);
        assertTrue(bottomPipe.getHeight() > 0 && bottomPipe.getY() == topPipe.getHeight() + Constants.PIPE_GAP);
    }
}
