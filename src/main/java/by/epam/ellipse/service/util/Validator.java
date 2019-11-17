package by.epam.ellipse.service.util;

import by.epam.ellipse.service.exception.ServiceException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final Validator instance = new Validator();
    private Validator() {
    }
    public static Validator getInstance() {
        return instance;
    }

    private static final String POINT_PATTERN = "-?\\d+\\.\\d+\\s\\d+\\.\\d+";
    private static final String ELLIPSE_PATTERN = "^" + POINT_PATTERN + "\\s" + POINT_PATTERN + "$";//уточнить наличие энтера в передаваемой строке

    public boolean isValidFormat(String ellipse) throws NullPointerException {
        Pattern pattern;
        Matcher matcher;
        try {
            pattern = Pattern.compile(ELLIPSE_PATTERN);
            matcher = pattern.matcher(ellipse);
            return matcher.find();

        } catch (NullPointerException e) {
            throw new NullPointerException("Validator: isValidFormat(): Null object has been passed into method.");
        }
    }
}
