package by.epam.ellipse.service;

import by.epam.ellipse.entity.Ellipse;

import java.util.ArrayList;
import java.util.List;


public class EllipseServiceImplTest {
    private static EllipseRegistrarServiceImpl instance;
    private static String request;

    private Ellipse.Point point1;
    private Ellipse.Point point2;
    private Ellipse.Point point3;
    private Ellipse.Point point4;
    private Ellipse.Point point5;
    private Ellipse.Point point6;

    private Ellipse ellipse1;
    private Ellipse ellipse2;
    private Ellipse ellipse3;
    private Ellipse ellipse4;

    private List<Ellipse> expected = new ArrayList<>();

//    @Before
//    public void setUp() {
//        instance = EllipseRegistrarServiceImpl.getInstance();
//
//        point1 = new Ellipse.Point(-1.0, -2.0);
//        point2 = new Ellipse.Point(5.0, 6.0);
//        point3 = new Ellipse.Point(-10.0, -10.0);
//        point4 = new Ellipse.Point(10.0, 10.0);
//        point5 = new Ellipse.Point(10.0, 5.0);
//        point6 = new Ellipse.Point(15.0, 10.0);
//
//        ellipse1 = new Ellipse(point1, point2);
//        ellipse2 = new Ellipse(point3, point4);
//        ellipse3 = new Ellipse(point5, point6);
//        ellipse4 = new Ellipse(point5, point5);
//
//        expected.add(ellipse1);
//        expected.add(ellipse2);
//        expected.add(ellipse3);
//    }
//
//    @After
//    public void shutDown() {
//        instance = null;
//    }
//
//    @Test
//    public void createFromFile() {
//        List<Ellipse> actual;
//        request = "test.ellipse.base";
//
//        try {
//            actual = instance.createFromFile(request);
//            Assert.assertEquals(actual, expected);
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//    @Test
//    public void createFromFile_WRONG_REQUEST() {
//        request = "test1.ellipse.base";
//        try {
//            instance.createFromFile(request);
//            Assert.fail("Expected ServiceException.");
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//    @Test
//    public void createFromFile_EMPTY_REQUEST() {
//        request = "";
//        try {
//            instance.createFromFile(request);
//            Assert.fail("Expected ServiceException.");
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//    @Test
//    public void createFromFile_NULL() {
//        try {
//            instance.createFromFile(request);
//            Assert.fail(null);
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//
//    @Test
//    public void isCircle_FALSE() {
//        try {
//            boolean actual = instance.isCircle(ellipse1);
//            Assert.assertFalse(actual);
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//    @Test
//    public void isCircle_TRUE() {
//        try {
//            boolean actual = instance.isCircle(ellipse2);
//            Assert.assertTrue(actual);
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//    @Test
//    public void isCircle_INVALID_ELLIPSE() {
//        try {
//            instance.isCircle(ellipse4);
//            Assert.fail("Expected ServiceException.");
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//    @Test
//    public void isCircle_NUL() {
//        try {
//            instance.isCircle(null);
//            Assert.fail("Expected ServiceException.");
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//
//    @Test
//    public void isCrossX_TRUE() {
//        try {
//            boolean actual = instance.isCrossX(ellipse1);
//            Assert.assertTrue(actual);
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//    @Test
//    public void isCrossX_FALSE() {
//        try {
//            boolean actual = instance.isCrossX(ellipse3);
//            Assert.assertFalse(actual);
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//    @Test
//    public void isCrossX_INVALID_ELLIPSE() {
//        try {
//            instance.isCrossX(ellipse4);
//            Assert.fail("Expected ServiceException.");
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//    @Test
//    public void isCrossX_NULL() {
//        try {
//            instance.isCrossX(null);
//            Assert.fail("Expected ServiceException.");
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//
//    @Test
//    public void isCrossY_TRUE() {
//        try {
//            boolean actual = instance.isCrossY(ellipse1);
//            Assert.assertTrue(actual);
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//    @Test
//    public void isCrossY_FALSE() {
//        try {
//            boolean actual = instance.isCrossY(ellipse3);
//            Assert.assertFalse(actual);
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//    @Test
//    public void isCrossY_INVALID_ELLIPSE() {
//        try {
//            instance.isCrossY(ellipse4);
//            Assert.fail("Expected ServiceException.");
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
//
//    @Test
//    public void isCrossY_NULL() {
//        try {
//            instance.isCrossY(null);
//            Assert.fail("Expected ServiceException.");
//        } catch (ServiceException e) {
//            Assert.assertNotEquals("", e.getMessage());
//        }
//    }
}