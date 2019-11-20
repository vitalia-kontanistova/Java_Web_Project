package by.epam.ellipse.service.util;

import by.epam.ellipse.dao.util.EllipseDataValidator;
import by.epam.ellipse.dao.util.EllipseParser;
import by.epam.ellipse.service.exception.ServiceException;
import org.junit.Assert;
import org.junit.Test;

public class ExtractorTest {

//    @Test
//    public void extractCoordinates() {
//        EllipseParser instance = EllipseParser.getInstance();
//
//        String ell1 = "-0.1 0.1 5.0 4.0";
//        String ell2 = "0.1 0.1 -5.0 4.0";
//        String ell3 = "-0. 0.1 5.0 4.0";
//        String ell4 = "-0.1 0.1 ";
//        String ell5 = "-0k.1 0.1 0.2 0.4";
//
//        double[] expected = {-0.1, 0.1, 5.0, 4.0};
//        double[] actual;
//
//        try {
//            actual = instance.parseCoordinates(ell1);
//            Assert.assertEquals(expected, actual);
//
//        } catch (NullPointerException | ServiceException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Test
//    public void parse() {
//        EllipseParser inst = EllipseParser.getInstance();
//        String ell1 = "-0.1 0.1 5.0 4.0";
//        String ell2 = "0.1 0.1 -5.0 4.0";
//        String ell3 = "-0. 0.1 5.0 4.0";
//        String ell4 = "-0.1 0.1 ";
//        String ell5 = "-0k.1 0.1 0.2 0.4";
//
//        EllipseDataValidator ellipseDataValidator = EllipseDataValidator.getInstance();
//        String[] expected = {"-0.1", "0.1", "5.0", "4.0"};
//        String[] actual;
//
//        try {
//            actual = inst.parseCoord(ell1);
//            Assert.assertEquals(expected, actual);
//
//        } catch (NullPointerException | ServiceException e) {
//            e.printStackTrace();
//        }
//    }
//

}