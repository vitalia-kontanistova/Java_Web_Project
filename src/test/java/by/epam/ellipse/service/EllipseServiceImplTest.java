package by.epam.ellipse.service;

import by.epam.ellipse.entity.Ellipse;
import by.epam.ellipse.service.exception.ServiceException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EllipseServiceImplTest {
    private static EllipseServiceImpl instance = EllipseServiceImpl.getInstance();

    private static List<Ellipse> ellipses;
    private static Ellipse el1;
    private static Ellipse el2;
    private static Ellipse el3;
    private static Ellipse el4;
    private static Ellipse el5;
    private static Ellipse el6;
    private static Ellipse el7;
    private static Ellipse el8;

    @Before
    public void setUp() throws Exception {
        ellipses = new ArrayList<>();
        el1 = new Ellipse(new Ellipse.Point(0.0, 0.0), new Ellipse.Point(10.0, 10.0));
        el2 = new Ellipse(new Ellipse.Point(-10.0, -5.0), new Ellipse.Point(0.0, 5.0));
        el3 = new Ellipse(new Ellipse.Point(-2.0, -2.0), new Ellipse.Point(2.0, 2.0));

        el4 = new Ellipse(new Ellipse.Point(-10.0, -5.0), new Ellipse.Point(0.0, 0.0));
        el5 = new Ellipse(new Ellipse.Point(0.0, 5.0), new Ellipse.Point(10.0, 0.0));

        el6 = new Ellipse(null, new Ellipse.Point(10.0, 5.0));
        el7 = new Ellipse(new Ellipse.Point(0.0, 0.0), new Ellipse.Point(0.0, 0.0));
        el8 = new Ellipse(new Ellipse.Point(10.0, 5.0), new Ellipse.Point(0.0, 5.0));
    }

    @After
    public void shutDown() throws Exception {
        ellipses = null;
    }


    @Test
    public void createFromString() {
    }

    @Test
    public void createFromList() {
    }

    @Test
    public void isCircle() throws ServiceException {
        ellipses.add(el1);
        ellipses.add(el2);
        ellipses.add(el3);

        boolean actual;
        for (Ellipse ellipse : ellipses) {
            actual = instance.isCircle(ellipse);
            Assert.assertTrue(actual);
        }
    }

    @Test
    public void is_NOT_Circle() throws ServiceException {
        ellipses.add(el4);
        ellipses.add(el5);

        boolean actual;
        for (Ellipse ellipse : ellipses) {
            actual = instance.isCircle(ellipse);
            Assert.assertFalse(actual);
        }
    }

    @Test(expected = ServiceException.class)
    public void isCircle_INVALID_FORMAT_NUL() throws ServiceException {
        ellipses.add(el6);
        ellipses.add(el7);
        ellipses.add(el8);

        for (Ellipse ellipse : ellipses) {
            instance.isCircle(ellipse);
        }
    }

    @Test
    public void isCrossX() throws ServiceException {
//        ellipses.add(el1);
//        ellipses.add(el2);
//        ellipses.add(el3);
//
//        boolean actual;
//        for (Ellipse ellipse : ellipses) {
//            actual = instance.isCrossX(ellipse);
//            Assert.assertTrue(actual);
//        }
    }

    @Test
    public void isCrossY() {
    }

    @Test
    public void isEllipseExist() {
    }

    @Test
    public void isEllipseExist1() {
    }

    @Test
    public void findDeltaX() {
    }

    @Test
    public void findDeltaY() {
    }

    @Test
    public void findDeltaX1() {
    }

    @Test
    public void findDeltaY1() {
    }
}