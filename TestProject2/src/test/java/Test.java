import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Test {
    @org.junit.Test
    public void testAddBook() {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        assertEquals(Main.addPhones("1", "2", "3"), list);
    }
}