package by.epam.ellipse.service.registrar;

import by.epam.ellipse.entity.Ellipse;
import by.epam.ellipse.service.exception.ServiceException;

public interface Observer {
    void update(Ellipse ellipse) throws ServiceException;
}