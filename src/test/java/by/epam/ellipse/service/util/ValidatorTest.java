package by.epam.ellipse.service.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class ValidatorTest {

    @Test
    public void isValidFormat() {
        Validator inst = Validator.getInstance();
        String ell1 = "-0.1 0.1 5.0 4.0";
        String ell2 = "0.1 0.1 -5.0 4.0";
        String ell3 = "-0. 0.1 5.0 4.0";
        String ell4 = "-0.1 0.1 ";
        String ell5 = "-0k.1 0.1 0.2 0.4";

        boolean actual;
        boolean expected1 = true;
        boolean expected2 = false;
        try {
            actual = inst.isValidFormat(ell4);
            Assert.assertEquals(expected2,actual);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }
}