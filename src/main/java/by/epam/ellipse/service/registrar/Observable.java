package by.epam.ellipse.service.registrar;

import by.epam.ellipse.service.exception.ServiceException;

public interface Observable {
    void add(Observer observer) throws ServiceException;

    void notifyObservers() throws ServiceException;
}