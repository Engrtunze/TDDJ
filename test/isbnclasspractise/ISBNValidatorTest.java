package isbnclasspractise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
     void checkAvailable13DigitISBN()
    {
        ISBNValidator validator = new ISBNValidator();
        boolean result = validator.checkISBN("9781853260087");
        assertTrue(result);

    }


    @Test
    void ISBNNumbersEndingInAnXAreValid()
    {
        ISBNValidator validator = new ISBNValidator();

            boolean result = validator.checkISBN("012000030X");
        assertTrue(result);
    }
    @Test
    void checkAnInvalidISBN() {
        ISBNValidator validator = new ISBNValidator();
        boolean result = validator.checkISBN("0140449117");
        assertFalse(result);
    }

    @Test
    void nineDigitISBNAreNotAllowed()
    {
        ISBNValidator validator = new ISBNValidator();
       var exception = assertThrows(NumberFormatException.class, () -> {
           validator.checkISBN("123456789");
       });

        Assertions.assertEquals("ISBN numbers must be 10 digits long", exception.getMessage());

    }

    @Test
    void nonNumericISBNAReNotAllowed()
    {
        ISBNValidator validator = new ISBNValidator();
        var exception = assertThrows(NumberFormatException.class, () -> {
            validator.checkISBN("helloworld");
        });

        Assertions.assertEquals("ISBN numbers can only contain numeric digits", exception.getMessage());
    }

}