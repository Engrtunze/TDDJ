package isbnclasspractise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ISBNValidatorTest {

    @Test
    void checkAValidISBN() {
        ISBNValidator validator = new ISBNValidator();

        boolean result = validator.checkISBN("0140449116");
        assertTrue(result);
        result = validator.checkISBN("0140177396");
        assertTrue(result);
    }

    @Test
    void checkAnInvalidISBN() {
        ISBNValidator validator = new ISBNValidator();
        boolean result = validator.checkISBN("0140449117");
        assertFalse(result);
    }

    @Test()
    void nineDigitISBNAreNotAllowed()
    {
        ISBNValidator validator = new ISBNValidator();
       var exception = assertThrows(NumberFormatException.class, () -> {
           validator.checkISBN("123456789");
       });
        Assertions.assertEquals("ISBN numbers must be 10 digits long", exception.getMessage());
    }


}