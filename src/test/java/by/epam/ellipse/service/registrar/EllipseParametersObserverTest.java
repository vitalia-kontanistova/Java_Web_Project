package by.epam.ellipse.service.registrar;

import by.epam.ellipse.entity.Ellipse;
import by.epam.ellipse.entity.Parameters;
import by.epam.ellipse.service.exception.ServiceException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EllipseParametersObserverTest {
    private EllipseParametersObserver ellipseParametersObserver;
    private EllipseRegistrar ellipseRegistrar;


    private Ellipse.Point point1;
    private Ellipse.Point point2;
    private Ellipse.Point point3;
    private Ellipse.Point point4;

    private Ellipse ellipse1;
    private Ellipse ellipse2;

//    @Before
//    public void setUp() {
//        ellipseRegistrar = new EllipseRegistrar();
//        try {
//            ellipseParametersObserver = new EllipseParametersObserver(ellipseRegistrar);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//
//        point1 = new Ellipse.Point(-1.0, -1.0);
//        point2 = new Ellipse.Point(1.0, 1.0);
//        point3 = new Ellipse.Point(10.0, 11.0);
//        point4 = new Ellipse.Point(-10.0, -11.0);
//
//        ellipse1 = new Ellipse(point1, point2);
//        ellipse2 = new Ellipse(point3, point4);
//    }
//
//    @After
//    public void shutDown() {
//        ellipseRegistrar = null;
//        ellipseParametersObserver = null;
//    }
//
//
//    @Test
//    public void returnEllipse() {
//        Ellipse expected = ellipse1;
//        Ellipse actual = ellipseParametersObserver.returnEllipse();
//        Assert.assertEquals(expected, actual);
//    }
//
//
//    @Test
//    public void returnEllipse1() {
//        try {
//            ellipseRegistrar.setEllipse(ellipse2);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//        Ellipse expected = ellipse2;
//        Ellipse actual = ellipseParametersObserver.returnEllipse();
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void returnParameters() {
//        Parameters expected;
//        Parameters actual;
//
//        try {
//            actual = ellipseParametersObserver.returnParameters();
//            expected = new Parameters(ellipse1);
//            Assert.assertEquals(expected, actual);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void returnParameters1() {
//        Parameters expected;
//        Parameters actual;
//
//        try {
//            ellipseRegistrar.setEllipse(ellipse2);
//            actual = ellipseParametersObserver.returnParameters();
//            expected = new Parameters(ellipse2);
//            Assert.assertEquals(expected, actual);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//    }
}