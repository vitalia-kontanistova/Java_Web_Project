package by.epam.ellipse.service;

import by.epam.ellipse.entity.Ellipse;
import by.epam.ellipse.service.exception.ServiceException;

public interface EllipseService {
     Ellipse createFromString(String ellipseStr) throws ServiceException;

     boolean isCircle(Ellipse ellipse) throws ServiceException;

     boolean isCrossX(Ellipse ellipse) throws ServiceException;

     boolean isCrossY(Ellipse ellipse) throws ServiceException;

     boolean isEllipseExist(Ellipse ellipse) throws ServiceException;

     boolean isEllipseExist(Ellipse.Point pointA, Ellipse.Point pointB) throws ServiceException;
}