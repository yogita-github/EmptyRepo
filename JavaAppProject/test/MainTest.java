import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void testAdd() {
        Main m = new Main();
        assertEquals(5, m.add(2, 3));
    }
}
