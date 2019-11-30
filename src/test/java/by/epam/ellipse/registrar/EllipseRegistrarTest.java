package by.epam.ellipse.registrar;

import by.epam.ellipse.entity.Ellipse;


public class EllipseRegistrarTest {
//    private EllipseObservable ellipseObservable;
//
//    private Ellipse.Point point1;
//    private Ellipse.Point point2;
//    private Ellipse.Point point3;
//    private Ellipse.Point point4;
//
//    private Ellipse ellipse1;
//    private Ellipse ellipse2;
//    private Ellipse ellipse3;
//    private Ellipse ellipse4;
//    private Ellipse ellipse5;
//    private Ellipse ellipse6;
//    private Ellipse ellipse7;
//
//    @Before
//    public void setUp() {
//        ellipseObservable = new EllipseObservable();
//
//        point1 = new Ellipse.Point(-1.0, -1.0);
//        point2 = new Ellipse.Point(1.0, 1.0);
//        point3 = new Ellipse.Point(10.0, 11.0);
//        point4 = new Ellipse.Point(-10.0, -11.0);
//
//        ellipse1 = new Ellipse(point1, point2);
//        ellipse2 = new Ellipse(point3, point4);
//        ellipse3 = new Ellipse(null, point4);
//        ellipse4 = new Ellipse(point3, null);
//        ellipse5 = new Ellipse(null, null);
//        ellipse6 = new Ellipse(point1, point1);
//        ellipse7 = null;
//    }
//
//    @After
//    public void shutDown() {
//        ellipseObservable = null;
//    }
//
//
//    @Test
//    public void setEllipse() {
//        Ellipse actual;
//        Ellipse expected;
//
//        try {
//            ellipseObservable.setEllipse(ellipse2);
//            actual = ellipseObservable.returnEllipse();
//            expected = ellipse2;
//            Assert.assertEquals(expected, actual);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void setEllipse_NULL_POINT_A() {
//        try {
//            ellipseObservable.setEllipse(ellipse3);
//            Assert.fail("Expected ServiceException");
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//    @Test
//    public void setEllipse_NULL_POINT_B() {
//        try {
//            ellipseObservable.setEllipse(ellipse4);
//            Assert.fail("Expected ServiceException");
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//    @Test
//    public void setEllipse_NULL_POINTS() {
//        try {
//            ellipseObservable.setEllipse(ellipse5);
//            Assert.fail("Expected ServiceException");
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//    @Test
//    public void setEllipse_NULL() {
//        try {
//            ellipseObservable.setEllipse(ellipse7);
//            Assert.fail("Expected ServiceException");
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//    @Test
//    public void setEllipse_INVALID() {
//        try {
//            ellipseObservable.setEllipse(ellipse6);
//            Assert.fail("Expected ServiceException");
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//
//    @Test
//    public void setPoints() {
//        Ellipse actual;
//        Ellipse expected;
//
//        try {
//            ellipseObservable.setPoints(point3, point4);
//            actual = ellipseObservable.returnEllipse();
//            expected = new Ellipse(new Ellipse.Point(10.0, 11.0), new Ellipse.Point(-10.0, -11.0));
//            Assert.assertEquals(expected, actual);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void setPoints_NULL_POINT_A() {
//        try {
//            ellipseObservable.setPoints(null, point1);
//            Assert.fail("Expected ServiceException");
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//    @Test
//    public void setPoints_NULL_POINT_B() {
//        try {
//            ellipseObservable.setPoints(point1, null);
//            Assert.fail("Expected ServiceException");
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//    @Test
//    public void setPoints_NULL_POINTS() {
//        try {
//            ellipseObservable.setPoints(null, null);
//            Assert.fail("Expected ServiceException");
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//    @Test
//    public void setPoints_INVALID() {
//        try {
//            ellipseObservable.setPoints(point1, point1);
//            Assert.fail("Expected ServiceException");
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//
//    @Test
//    public void setPointA() {
//        Ellipse actual;
//        Ellipse expected;
//
//        try {
//            ellipseObservable.setPointA(point3);
//            actual = ellipseObservable.returnEllipse();
//            expected = new Ellipse(new Ellipse.Point(10.0, 11.0), new Ellipse().getPointB());
//            Assert.assertEquals(expected, actual);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void setPointA_NULL_POINT() {
//        try {
//            ellipseObservable.setPointA(null);
//            Assert.fail("Expected ServiceException");
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//    @Test
//    public void setPointA_INVALID() {
//        try {
//            ellipseObservable.setPointA(point2);
//            Assert.fail("Expected ServiceException");
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//
//    @Test
//    public void setPointB() {
//        Ellipse actual;
//        Ellipse expected;
//
//        try {
//            ellipseObservable.setPointB(point3);
//            actual = ellipseObservable.returnEllipse();
//            expected = new Ellipse(new Ellipse().getPointA(), new Ellipse.Point(10.0, 11.0));
//            Assert.assertEquals(expected, actual);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void setPointB_NULL_POINT() {
//        try {
//            ellipseObservable.setPointB(null);
//            Assert.fail("Expected ServiceException");
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//    @Test
//    public void setPointB_INVALID() {
//        try {
//            ellipseObservable.setPointB(point1);
//            Assert.fail("Expected ServiceException");
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
}