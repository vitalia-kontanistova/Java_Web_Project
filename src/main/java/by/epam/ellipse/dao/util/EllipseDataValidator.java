package by.epam.ellipse.dao.util;

import by.epam.ellipse.dao.exception.DAOexception;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EllipseDataValidator {
    private static final EllipseDataValidator instance = new EllipseDataValidator();

    private EllipseDataValidator() {
    }

    public static EllipseDataValidator getInstance() {
        return instance;
    }


    private static final String POINT_PATTERN = "-?\\d+\\.\\d+\\s-?\\d+\\.\\d+";
    private static final String ELLIPSE_PATTERN = "^" + POINT_PATTERN + "\\s" + POINT_PATTERN + "$";


    public boolean isValidFormat(String ellipse) throws DAOexception {
        Pattern pattern;
        Matcher matcher;
        try {
            pattern = Pattern.compile(ELLIPSE_PATTERN);
            matcher = pattern.matcher(ellipse);
            return matcher.find();

        } catch (NullPointerException e) {
            throw new DAOexception("EllipseDataValidator: isValidFormat(): Null object has been passed into method.");
        }
    }
}