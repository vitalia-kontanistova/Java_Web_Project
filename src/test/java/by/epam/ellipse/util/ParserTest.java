package by.epam.ellipse.util;

import by.epam.ellipse.dao.exception.DAOexception;
import org.junit.*;

public class ParserTest {
    private static Parser instance;

    private static String coordinates1;
    private static String coordinates2;
    private static String coordinates3;
    private static String coordinates4;

    @BeforeClass
    public static void setUp() {
        instance = Parser.getInstance();

        coordinates1 = "-10.0 5.0 10.0 -10.0";
        coordinates2 = "-10.c0 0.0 -0.5 0.6";
        coordinates3 = "-10.6 5.06 ";
        coordinates4 = "";
    }

//    @AfterClass            //ЭТО ИЗЛИШНЕ ИЛИ ОСТАВИТЬ ПОСТУСЛОВИЯ?
//    public static void shutDown() {
//        instance = null;
//    }

    @Test
    public void parseCoordinates() {
        double[] actual;
        double[] expected = new double[]{-10.0, 5.0, 10.0, -10.0};

        try {
            actual = instance.parseCoordinates(coordinates1);
            for (int i = 0; i < actual.length; i++) {
                Assert.assertEquals(actual[i], expected[i], 0.01);
            }
        } catch (DAOexception e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void parseCoordinates_INCORRECT_STRING_FORMAT() {
        try {
            instance.parseCoordinates(coordinates2);
            Assert.fail("Expected DAOException.");
        } catch (DAOexception e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }


    @Test
    public void parseCoordinates_LACK_INFORMATION() {
        try {
            instance.parseCoordinates(coordinates3);
            Assert.fail("Expected DAOException.");
        } catch (DAOexception e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void parseCoordinates_EMPTY_STRING() {
        try {
            instance.parseCoordinates(coordinates4);
            Assert.fail("Expected DAOException.");
        } catch (DAOexception e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void parseCoordinates_NULL() {
        try {
            instance.parseCoordinates(null);
            Assert.fail("Expected DAOException.");
        } catch (DAOexception e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }
}