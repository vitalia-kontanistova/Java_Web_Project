package by.epam.ellipse.registrar;

import by.epam.ellipse.entity.Ellipse;

public class EllipseParametersObserverTest {
//    private ParametersObserver parametersObserver;
//    private EllipseObservable ellipseObservable;
//
//
//    private Ellipse.Point point1;
//    private Ellipse.Point point2;
//    private Ellipse.Point point3;
//    private Ellipse.Point point4;
//
//    private Ellipse ellipse1;
//    private Ellipse ellipse2;
//
//    @Before
//    public void setUp() {
//        ellipseObservable = new EllipseObservable();
//        try {
//            parametersObserver = new ParametersObserver(ellipseObservable);
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
//        ellipseObservable = null;
//        parametersObserver = null;
//    }
//
//
//    @Test
//    public void returnEllipse() {
//        Ellipse expected = ellipse1;
//        Ellipse actual = parametersObserver.returnEllipse();
//        Assert.assertEquals(expected, actual);
//    }
//
//
//    @Test
//    public void returnEllipse1() {
//        try {
//            ellipseObservable.setEllipse(ellipse2);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//        Ellipse expected = ellipse2;
//        Ellipse actual = parametersObserver.returnEllipse();
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void returnParameters() {
//        Parameters expected;
//        Parameters actual;
//
//        try {
//            actual = parametersObserver.returnParameters();
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
//            ellipseObservable.setEllipse(ellipse2);
//            actual = parametersObserver.returnParameters();
//            expected = new Parameters(ellipse2);
//            Assert.assertEquals(expected, actual);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//    }
}