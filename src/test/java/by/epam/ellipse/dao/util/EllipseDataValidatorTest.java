package by.epam.ellipse.dao.util;

import by.epam.ellipse.dao.exception.DAOexception;
import org.junit.*;

public class EllipseDataValidatorTest {
    private EllipseDataValidator instance;
    private String ellipse1;
    private String ellipse2;
    private String ellipse3;
    private String ellipse4;


    @BeforeClass
    public void setUp() {
        ellipse1 = "-1.0 1.0 -5.0 4.0";
        ellipse2 = "-0k.1 0.1 0.2 0.4";
        ellipse3 = "0.1 0.1 ";
        ellipse4 = "";

        instance = EllipseDataValidator.getInstance();
    }

//    @AfterClass            //ЭТО ИЗЛИШНЕ ИЛИ ОСТАВИТЬ ПОСЛУСЛОВИЯ
//    public void shutDown() {
//        instance = null;
//    }

    @Test
    public void isValidFormat() {
        boolean actual;
        try {
            actual = instance.isValidFormat(ellipse1);
            Assert.assertTrue(actual);

        } catch (DAOexception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void isValidFormat_INCORRECT_FORMAT() {
        boolean actual;
        try {
            actual = instance.isValidFormat(ellipse2);
            Assert.assertFalse(actual);

        } catch (DAOexception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void isValidFormat_LACK_INFORMATION() {
        boolean actual;
        try {
            actual = instance.isValidFormat(ellipse3);
            Assert.assertFalse(actual);

        } catch (DAOexception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void isValidFormat_EMPTY_STRING() {
        boolean actual;
        try {
            actual = instance.isValidFormat(ellipse4);
            Assert.assertFalse(actual);

        } catch (DAOexception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void isValidFormat_NULL() {
        try {
            instance.isValidFormat(null);
            Assert.fail("Expected DAOexception.");
        } catch (DAOexception e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }
}