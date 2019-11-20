package by.epam.ellipse.dao.util;

import by.epam.ellipse.dao.exception.DAOexception;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;

public class EllipseDataValidatorTest {

    private static EllipseDataValidator instance;
    private static List<String> entriesValid;
    private static List<String> entriesInval;

    @BeforeClass
    public static void setUp() throws Exception {
        instance = EllipseDataValidator.getInstance();

        entriesInval = new ArrayList<>();

        entriesInval.add("0.0 0.0 0.5 0.6 ");
        entriesInval.add("0.c0 0.0 0.5 0.6");
        entriesInval.add("0.0 0.0 0.5 0. 6");
        entriesInval.add("0.0 0.0 ");
        entriesInval.add("0.0 0.0 0..5 0.6");

        entriesValid = new ArrayList<>();

        entriesValid.add("-0.1 -0.0001 -0.5 -0.6");
        entriesValid.add("0.0 0.0 0.5 0.6");
        entriesValid.add("0.0 0.0 0.5 0.6\n");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        instance = null;
        entriesValid = null;
        entriesInval = null;

    }

    @Test
    public void isNotValidFormat() {
        boolean expected = false;
        try {
            for (String entry : entriesInval) {
                expected = instance.isValidFormat(entry);
                Assert.assertFalse(expected);
            }
        } catch (DAOexception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void isValidFormat() {
        boolean expected = false;
        try {
            for (String entry : entriesValid) {
                expected = instance.isValidFormat(entry);
                Assert.assertTrue(expected);
            }
        } catch (DAOexception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(expected);
    }
}