package by.epam.ellipse.service;

import by.epam.ellipse.entity.Ellipse;
import by.epam.ellipse.service.exception.ServiceException;
import org.junit.*;


public class ParametersServiceImplTest {
    private static ParametersServiceImpl instance;

    private Ellipse.Point point1;
    private Ellipse.Point point2;

    private Ellipse ellipse1;
    private Ellipse ellipse2;

    @Before
    public void setUp() {
        instance = ParametersServiceImpl.getInstance();

        point1 = new Ellipse.Point(-10.0, -10.0);
        point2 = new Ellipse.Point(10.0, 10.0);

        ellipse1 = new Ellipse(point1, point2);
        ellipse2 = new Ellipse(point1, point1);
    }

    @After
    public void shutDown() {
        instance = null;
    }


    @Test()
    public void findPerimeter() {
        double expected = 62.83;
        double actual;
        try {
            actual = instance.findPerimeter(ellipse1);
            Assert.assertEquals(expected, actual, 0.01);
        } catch (ServiceException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test()
    public void findPerimeter_INVALID_ELLIPSE() {
        try {
            instance.findPerimeter(ellipse2);
            Assert.fail("Expected ServiceException.");
        } catch (ServiceException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test()
    public void findPerimeter_NULL() {
        try {
            instance.findPerimeter(null);
            Assert.fail("Expected ServiceException.");
        } catch (ServiceException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }


    @Test()
    public void findArea() {
        double expected = 314.16;
        double actual;
        try {
            actual = instance.findArea(ellipse1);
            Assert.assertEquals(expected, actual, 0.01);
        } catch (ServiceException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test()
    public void findArea_INVALID_ELLIPSE() {
        try {
            instance.findArea(ellipse2);
            Assert.fail("Expected ServiceException.");
        } catch (ServiceException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test()
    public void findArea_NULL() {
        try {
            instance.findArea(null);
            Assert.fail("Expected ServiceException.");
        } catch (ServiceException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }
}