package by.epam.ellipse.service;

import by.epam.ellipse.entity.Ellipse;
import by.epam.ellipse.service.exception.ServiceException;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;


public class ParametersServiceImplTest {
    private static ParametersServiceImpl instance = ParametersServiceImpl.getInstance();

    private static List<Ellipse> ellipses;
    private static Ellipse el1;
    private static Ellipse el2;
    private static Ellipse el3;
    private static Ellipse el4;
    private static Ellipse el5;
    private static Ellipse el6;


    @Before
    public void setUp() throws Exception {
        ellipses = new ArrayList<>();
        el1 = new Ellipse(new Ellipse.Point(0.0, 0.0), new Ellipse.Point(10.0, 5.0));
        el2 = new Ellipse(new Ellipse.Point(-10.0, -5.0), new Ellipse.Point(0.0, 0.0));
        el3 = new Ellipse(new Ellipse.Point(-2.0, -2.0), new Ellipse.Point(2.0, 2.0));


        el4 = new Ellipse(null, new Ellipse.Point(10.0, 5.0));
        el5 = new Ellipse(new Ellipse.Point(0.0, 0.0), new Ellipse.Point(0.0, 0.0));
        el6 = new Ellipse(new Ellipse.Point(10.0, 5.0), new Ellipse.Point(0.0, 5.0));
    }

    @After
    public void shutDown() throws Exception {
        ellipses = null;
    }

    @Test()
    public void findPerimeter()  throws ServiceException {
        ellipses.add(el1);
        ellipses.add(el2);
        ellipses.add(el3);

        double[] perimeters = {24.22,24.22,12.56};

        int i = 0;
        for (Ellipse ellipse : ellipses) {
            double expected = perimeters[i];
            double actual = instance.findPerimeter(ellipse);
            i++;
            Assert.assertEquals(expected, actual,0.1);
        }
    }

    @Test(expected = ServiceException.class)
    public void findPerimeter_INVALID_FORMAT_NULL() throws ServiceException {
        ellipses.add(el1);
        ellipses.add(el2);
        ellipses.add(el3);
        ellipses.add(el4);
        ellipses.add(el5);
        ellipses.add(el6);

        for (Ellipse ellipse : ellipses) {
            instance.findPerimeter(ellipse);
        }
    }


    @Test
    public void findArea() throws ServiceException{
        ellipses.add(el1);
        ellipses.add(el2);
        ellipses.add(el3);

        double[] areas = {39.25,39.25,12.56};

        int i = 0;
        for (Ellipse ellipse : ellipses) {
            double expected = areas[i];
            double actual = instance.findArea(ellipse);
            i++;
            Assert.assertEquals(expected, actual,0.1);
        }
    }

    @Test(expected = ServiceException.class)
    public void findArea_INVALID_FORMAT_NULL() throws ServiceException {
        ellipses.add(el1);
        ellipses.add(el2);
        ellipses.add(el3);
        ellipses.add(el4);
        ellipses.add(el5);
        ellipses.add(el6);

        for (Ellipse ellipse : ellipses) {
            instance.findArea(ellipse);
        }
    }

}