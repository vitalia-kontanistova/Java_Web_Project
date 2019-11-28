package by.epam.ellipse.service;

import by.epam.ellipse.dao.exception.DAOexception;
import by.epam.ellipse.service.exception.ServiceException;
import by.epam.ellipse.service.registrar.EllipseRegistrar;

import java.util.List;

public interface EllipseService {

    void add(EllipseRegistrar ellipseRegistrar) throws ServiceException, DAOexception;

    void addFromFile(String requestToPropFile) throws ServiceException;

    void remove(EllipseRegistrar ellipseRegistrar) throws ServiceException;

    void change(EllipseRegistrar ellipseRegistrar) throws ServiceException;

    List<EllipseRegistrar> query() throws ServiceException; //????????????
}