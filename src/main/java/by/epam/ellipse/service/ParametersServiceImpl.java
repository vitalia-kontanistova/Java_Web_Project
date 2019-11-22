package by.epam.ellipse.service;

import by.epam.ellipse.entity.Ellipse;
import by.epam.ellipse.service.exception.ServiceException;

public class ParametersServiceImpl implements ParametersService {
    private static ParametersServiceImpl instance = new ParametersServiceImpl();

    private ParametersServiceImpl() {
    }

    public static ParametersServiceImpl getInstance() {
        return instance;
    }

    @Override
    public double findPerimeter(Ellipse ellipse) throws ServiceException {
        EllipseServiceImpl instance = EllipseServiceImpl.getInstance();
        double perimeter = 0;
        double halfAxisX;
        double halfAxisY;
        try {
            if (instance.isEllipseExist(ellipse)) {
                halfAxisX = instance.findDeltaX(ellipse) / 2;
                halfAxisY = instance.findDeltaY(ellipse) / 2;
                perimeter = Math.PI * (3 * (halfAxisX + halfAxisY) - Math.sqrt((3 * halfAxisX + halfAxisY) * (halfAxisX + 3 * halfAxisY)));
            }
        } catch (NullPointerException e) {
            throw new ServiceException("EllipseServiceImpl: findPerimeter(): " + e.getMessage());
        }
        return perimeter;
    }

    @Override
    public double findArea(Ellipse ellipse) throws ServiceException {
        EllipseServiceImpl instance = EllipseServiceImpl.getInstance();
        double area = 0;
        double halfAxisX;
        double halfAxisY;

        try {
            if (instance.isEllipseExist(ellipse)) {
                halfAxisX = instance.findDeltaX(ellipse) / 2;
                halfAxisY = instance.findDeltaY(ellipse) / 2;
                area = Math.PI * (halfAxisX) * (halfAxisY);
            }
        } catch (NullPointerException e) {
            throw new ServiceException("EllipseServiceImpl: findArea(): " + e.getMessage());
        }
        return area;
    }
}