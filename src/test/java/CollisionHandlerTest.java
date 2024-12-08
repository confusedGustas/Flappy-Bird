import com.gustas.entity.Bird;
import com.gustas.entity.Pipe;
import com.gustas.handler.CollisionHandler;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CollisionHandlerTest {

    @Test
    public void testPipeCollision() {
        Bird bird = new Bird(10, 10, 30, 30);
        Pipe pipe = new Pipe(15, 15, 30, 30);
        Pipe noCollisionPipe = new Pipe(100, 100, 30, 30);

        CollisionHandler handler = new CollisionHandler();

        assertTrue(handler.checkPipeCollision(bird, List.of(pipe)));
        assertFalse(handler.checkPipeCollision(bird, List.of(noCollisionPipe)));
    }
}
