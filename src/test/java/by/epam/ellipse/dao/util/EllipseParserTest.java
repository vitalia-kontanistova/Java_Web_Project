package by.epam.ellipse.dao.util;

import by.epam.ellipse.dao.exception.DAOexception;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;

public class EllipseParserTest {
    private static List<double[]> coordinates;
    private static List<String> coordinatesStr;
    private static EllipseParser instance;

    @BeforeClass
    public static void setUp() throws Exception {
        instance = EllipseParser.getInstance();

        coordinates = new ArrayList<>();

        coordinates.add(new double[]{0.0, 0.0, 0.5, 0.6});
//        coordinates.add(new double[]{-0.0, -0.0, -0.5, -0.6});
//        coordinates.add(new double[]{-0.0006, 0.0006, -0.5, 0.5});

        coordinatesStr = new ArrayList<>();

        coordinatesStr.add("0.0 0.0 0.5 0.6");
//        coordinatesStr.add("-0.0 -0.0 -0.5 -0.6");
//        coordinatesStr.add("-0.0006 0.0006 -0.5 0.5");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        instance = null;
        coordinatesStr = null;
        coordinates = null;
    }

    @Test
    public void parseCoordinatesPosit() {
        try {
            double[] actual = instance.parseCoordinates("0.0 0.0 0.5 0.6");
            double[] expected = new double[]{0.0, 0.0, 0.5, 0.6};
            Assert.assertEquals(actual, expected);

        } catch (DAOexception e) {
            e.printStackTrace();
        }
    }
}