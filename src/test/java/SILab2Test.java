import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    private List<Time> createList(Time... elems){
        return new ArrayList<>(Arrays.asList(elems));
    }
    private final SILab2 s = new SILab2();

    @Test
    void multipleConditionTestFunction() {
        RuntimeException ex;
        ArrayList<Integer> ints = new ArrayList<Integer>();

        ex = assertThrows(RuntimeException.class, ()-> s.function(createList(new Time(-1,1,11))));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        ex = assertThrows(RuntimeException.class, ()-> s.function(createList(new Time(25, 40, 40))));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        ints.add(43932);
        assertEquals(ints , s.function(createList(new Time(12,12,12))));
        ints.remove(0);

        ex = assertThrows(RuntimeException.class, ()-> s.function(createList(new Time(1,-1,6))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        ex = assertThrows(RuntimeException.class, ()-> s.function(createList(new Time(1,61,50))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        ex = assertThrows(RuntimeException.class, ()-> s.function(createList(new Time(12,40,-2))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        ex = assertThrows(RuntimeException.class, ()-> s.function(createList(new Time(12,40,70))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        ints.add(45640);
        assertEquals(ints , s.function(createList(new Time(12,40,40))));
        ints.remove(0);

        ints.add(86400);
        assertEquals(ints , s.function(createList(new Time(24,0,0))));
        ints.remove(0);

        ex = assertThrows(RuntimeException.class, ()-> s.function(createList(new Time(24,0,1))));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        ex = assertThrows(RuntimeException.class, ()-> s.function(createList(new Time(24,1,1))));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));
    }

    @Test
    void everyBranchTestFunction() {
        RuntimeException ex;
        ArrayList<Integer> ints = new ArrayList<Integer>();

        ints.add(86400);
        assertEquals(ints , s.function(createList(new Time(24,0,0))));
        ints.remove(0);

        ex = assertThrows(RuntimeException.class, ()-> s.function(createList(new Time(25,0,0))));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        ex = assertThrows(RuntimeException.class, ()-> s.function(createList(new Time(-1,1,11))));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        ex = assertThrows(RuntimeException.class, ()-> s.function(createList(new Time(25, 40, 40))));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        ex = assertThrows(RuntimeException.class, ()-> s.function(createList(new Time(1,61,50))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        ints.add(45640);
        assertEquals(ints , s.function(createList(new Time(12,40,40))));
        ints.remove(0);

        ex = assertThrows(RuntimeException.class, ()-> s.function(createList(new Time(12,40,-2))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));
    }
}