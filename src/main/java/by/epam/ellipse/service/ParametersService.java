package by.epam.ellipse.service;

import by.epam.ellipse.entity.Ellipse;
import by.epam.ellipse.service.exception.ServiceException;

public interface ParametersService {
    double findPerimeter(Ellipse ellipse) throws ServiceException;

    double findArea(Ellipse ellipse) throws ServiceException;
}