package by.epam.ellipse.service.util;

import by.epam.ellipse.service.exception.ServiceException;
import org.junit.Assert;
import org.junit.Test;
import by.epam.ellipse.service.util.*;

import static org.junit.Assert.*;

public class ExtractorTest {

    @Test
    public void extractCoordinates() {
        Extractor instance = Extractor.getInstance();

        String ell1 = "-0.1 0.1 5.0 4.0";
        String ell2 = "0.1 0.1 -5.0 4.0";
        String ell3 = "-0. 0.1 5.0 4.0";
        String ell4 = "-0.1 0.1 ";
        String ell5 = "-0k.1 0.1 0.2 0.4";

        double[] expected = {-0.1, 0.1, 5.0, 4.0};
        double[] actual;

        try {
            actual = instance.extractCoordinates(ell1);
            Assert.assertEquals(expected, actual);

        } catch (NullPointerException | ServiceException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void parse() {
        Extractor inst = Extractor.getInstance();
        String ell1 = "-0.1 0.1 5.0 4.0";
        String ell2 = "0.1 0.1 -5.0 4.0";
        String ell3 = "-0. 0.1 5.0 4.0";
        String ell4 = "-0.1 0.1 ";
        String ell5 = "-0k.1 0.1 0.2 0.4";

        Validator validator = Validator.getInstance();
        String[] expected = {"-0.1", "0.1", "5.0", "4.0"};
        String[] actual;

        try {
            actual = inst.parse(ell1);
            Assert.assertEquals(expected, actual);

        } catch (NullPointerException | ServiceException e) {
            e.printStackTrace();
        }
    }


}