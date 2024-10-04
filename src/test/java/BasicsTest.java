import org.example.Basics;
import org.example.NegativeNumberException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BasicsTest {

    @Test
    @DisplayName("First number is less than the second")
    public void compare() {
        Basics basicTests = new Basics();
        int value = basicTests.compare(2, 1);
        Assertions.assertEquals(1, value);

    }
    @Test
    @DisplayName("Calculator")
    public void calculate() throws NegativeNumberException {
        Basics basicsTests = new Basics();
        Assertions.assertEquals(0, basicsTests.add(""));
        Assertions.assertEquals(1, basicsTests.add("1"));
        Assertions.assertEquals(6, basicsTests.add("1,5"));
        Assertions.assertEquals(7,basicsTests.add("1,2,3,1"));
        Assertions.assertEquals(6, basicsTests.add("1\n2,3"));
        Assertions.assertEquals(3, basicsTests.add("//;\n1;2"));
        NegativeNumberException exception = Assertions.assertThrows(NegativeNumberException.class, () ->
                basicsTests.add("-1,2,-3"));
        Assertions.assertEquals("Negative number is present", exception.getMessage());
    }

    }
