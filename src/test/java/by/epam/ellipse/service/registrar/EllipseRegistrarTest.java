package by.epam.ellipse.service.registrar;

import by.epam.ellipse.entity.Ellipse;
import by.epam.ellipse.service.exception.ServiceException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class EllipseRegistrarTest {
    private EllipseRegistrar ellipseRegistrar;

    private Ellipse.Point point1;
    private Ellipse.Point point2;
    private Ellipse.Point point3;
    private Ellipse.Point point4;

    private Ellipse ellipse1;
    private Ellipse ellipse2;
    private Ellipse ellipse3;
    private Ellipse ellipse4;
    private Ellipse ellipse5;
    private Ellipse ellipse6;
    private Ellipse ellipse7;

    @Before
    public void setUp() {
        ellipseRegistrar = new EllipseRegistrar();

        point1 = new Ellipse.Point(-1.0, -1.0);
        point2 = new Ellipse.Point(1.0, 1.0);
        point3 = new Ellipse.Point(10.0, 11.0);
        point4 = new Ellipse.Point(-10.0, -11.0);

        ellipse1 = new Ellipse(point1, point2);
        ellipse2 = new Ellipse(point3, point4);
        ellipse3 = new Ellipse(null, point4);
        ellipse4 = new Ellipse(point3, null);
        ellipse5 = new Ellipse(null, null);
        ellipse6 = new Ellipse(point1, point1);
        ellipse7 = null;
    }

    @After
    public void shutDown() {
        ellipseRegistrar = null;
    }


    @Test
    public void setEllipse() {
        Ellipse actual;
        Ellipse expected;

        try {
            ellipseRegistrar.setEllipse(ellipse2);
            actual = ellipseRegistrar.returnEllipse();
            expected = ellipse2;
            Assert.assertEquals(expected, actual);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setEllipse_NULL_POINT_A() {
        try {
            ellipseRegistrar.setEllipse(ellipse3);
            Assert.fail("Expected ServiceException");
        } catch (ServiceException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void setEllipse_NULL_POINT_B() {
        try {
            ellipseRegistrar.setEllipse(ellipse4);
            Assert.fail("Expected ServiceException");
        } catch (ServiceException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void setEllipse_NULL_POINTS() {
        try {
            ellipseRegistrar.setEllipse(ellipse5);
            Assert.fail("Expected ServiceException");
        } catch (ServiceException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void setEllipse_NULL() {
        try {
            ellipseRegistrar.setEllipse(ellipse7);
            Assert.fail("Expected ServiceException");
        } catch (ServiceException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void setEllipse_INVALID() {
        try {
            ellipseRegistrar.setEllipse(ellipse6);
            Assert.fail("Expected ServiceException");
        } catch (ServiceException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }


    @Test
    public void setPoints() {
        Ellipse actual;
        Ellipse expected;

        try {
            ellipseRegistrar.setPoints(point3, point4);
            actual = ellipseRegistrar.returnEllipse();
            expected = new Ellipse(new Ellipse.Point(10.0, 11.0), new Ellipse.Point(-10.0, -11.0));
            Assert.assertEquals(expected, actual);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setPoints_NULL_POINT_A() {
        try {
            ellipseRegistrar.setPoints(null, point1);
            Assert.fail("Expected ServiceException");
        } catch (ServiceException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void setPoints_NULL_POINT_B() {
        try {
            ellipseRegistrar.setPoints(point1, null);
            Assert.fail("Expected ServiceException");
        } catch (ServiceException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void setPoints_NULL_POINTS() {
        try {
            ellipseRegistrar.setPoints(null, null);
            Assert.fail("Expected ServiceException");
        } catch (ServiceException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void setPoints_INVALID() {
        try {
            ellipseRegistrar.setPoints(point1, point1);
            Assert.fail("Expected ServiceException");
        } catch (ServiceException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }


    @Test
    public void setPointA() {
        Ellipse actual;
        Ellipse expected;

        try {
            ellipseRegistrar.setPointA(point3);
            actual = ellipseRegistrar.returnEllipse();
            expected = new Ellipse(new Ellipse.Point(10.0, 11.0), new Ellipse().getPointB());
            Assert.assertEquals(expected, actual);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setPointA_NULL_POINT() {
        try {
            ellipseRegistrar.setPointA(null);
            Assert.fail("Expected ServiceException");
        } catch (ServiceException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void setPointA_INVALID() {
        try {
            ellipseRegistrar.setPointA(point2);
            Assert.fail("Expected ServiceException");
        } catch (ServiceException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }


    @Test
    public void setPointB() {
        Ellipse actual;
        Ellipse expected;

        try {
            ellipseRegistrar.setPointB(point3);
            actual = ellipseRegistrar.returnEllipse();
            expected = new Ellipse(new Ellipse().getPointA(), new Ellipse.Point(10.0, 11.0));
            Assert.assertEquals(expected, actual);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setPointB_NULL_POINT() {
        try {
            ellipseRegistrar.setPointB(null);
            Assert.fail("Expected ServiceException");
        } catch (ServiceException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void setPointB_INVALID() {
        try {
            ellipseRegistrar.setPointB(point1);
            Assert.fail("Expected ServiceException");
        } catch (ServiceException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }
}