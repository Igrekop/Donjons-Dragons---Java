package Test;

import Des.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestDes {

    @Test
    public void testLancerDesSimple() {
        int result = Des.lancerDes("1d6");
        assertTrue(result >= 1 && result <= 6);
    }

    @Test
    public void testLancerDesAvecNotationMultiple() {
        int result = Des.lancerDes("4d8");
        assertTrue(result >= 4 && result <= 32);
    }

    @Test
    public void testLancerDesNotationInvalide() {
        assertThrows(NumberFormatException.class, () -> {
            Des.lancerDes("XdY");
        });
    }
}
