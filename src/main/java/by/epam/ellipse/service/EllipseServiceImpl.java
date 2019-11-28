package by.epam.ellipse.service;

import by.epam.ellipse.dao.impl.EllipsesFileRepository;
import by.epam.ellipse.dao.exception.DAOexception;
import by.epam.ellipse.dao.util.EllipseParser;
import by.epam.ellipse.dao.util.FileManipulator;
import by.epam.ellipse.entity.Ellipse;
import by.epam.ellipse.service.exception.ServiceException;
import by.epam.ellipse.service.registrar.EllipseParametersObserver;
import by.epam.ellipse.service.registrar.EllipseRegistrar;

import java.util.ArrayList;
import java.util.List;


public class EllipseServiceImpl implements EllipseService {
    private static EllipseServiceImpl instance = new EllipseServiceImpl();

    private EllipseServiceImpl() {
    }

    public static EllipseServiceImpl getInstance() {
        return instance;
    }


    public boolean isEllipseExist(Ellipse ellipse) throws ServiceException {
        ParametersServiceImpl instance = ParametersServiceImpl.getInstance();
        double axisX;
        double axisY;

        try {
            axisX = instance.findDeltaX(ellipse);
            axisY = instance.findDeltaY(ellipse);
        } catch (NullPointerException e) {
            throw new ServiceException("EllipseServiceImpl: isEllipseExist(): null object has been passed into method: " + e.getMessage());
        }
        return axisX > 0.1 && axisY > 0.1;
    }

    public boolean isEllipseExist(Ellipse.Point pointA, Ellipse.Point pointB) throws ServiceException {
        return isEllipseExist(new Ellipse(pointA, pointB));
    }




    @Override
    public void add(EllipseRegistrar ellipseRegistrar) throws DAOexception {
        EllipsesFileRepository instance = new EllipsesFileRepository();
        try {
            instance.add(ellipseRegistrar);
        } catch (DAOexception e) {
            throw new DAOexception ("EllipseServiceImpl: add(): " + e.getMessage());
        }
    }

    @Override
    public void addFromFile(String requestToPropFile) throws ServiceException {
        List<Ellipse> ellipses;
        EllipseParametersObserver parametersObserver;
        try {
            ellipses = createFromFile(requestToPropFile);
            for (Ellipse ellipse : ellipses) {
                EllipseRegistrar registrar = new EllipseRegistrar(ellipse);
                parametersObserver = new EllipseParametersObserver(registrar);
                add(registrar);
            }
        } catch (DAOexception| ServiceException e) {
            throw new ServiceException("EllipseServiceImpl: addFromFile(): " + e.getMessage());
        }
    }


    @Override
    public void remove(EllipseRegistrar ellipseRegistrar) {

    }

    @Override
    public void change(EllipseRegistrar ellipseRegistrar) {

    }

    @Override
    public List<EllipseRegistrar> query() {
        return null;
    }

    private Ellipse createFromString(String ellipseStr) throws ServiceException {
        EllipseParser instance = EllipseParser.getInstance();
        double[] coordinates;

        Ellipse ellipse;
        Ellipse.Point pointA;
        Ellipse.Point pointB;

        try {
            coordinates = instance.parseCoordinates(ellipseStr);
            pointA = new Ellipse.Point(coordinates[0], coordinates[1]);
            pointB = new Ellipse.Point(coordinates[2], coordinates[3]);
            ellipse = new Ellipse(pointA, pointB);

        } catch (DAOexception e) {
            throw new ServiceException("EllipseServiceImpl: createFromString(): " + e.getMessage());
        }
        return ellipse;
    }

    private List<Ellipse> createFromFile(String request) throws ServiceException { //REFACTOR???
        FileManipulator instance = FileManipulator.getInstance();

        List<Ellipse> ellipses = new ArrayList<>();
        List<String> ellipsesStr;

        try {
            ellipsesStr = instance.extractEntriesFromFile(request);
            for (String s : ellipsesStr) {
                Ellipse temp = createFromString(s);
                if (isEllipseExist(temp)) {
                    ellipses.add(temp);
                }
            }
        } catch (ServiceException | DAOexception e) {
            throw new ServiceException("EllipseServiceImpl: createFromString(): " + e.getMessage());
        }
        return ellipses;
    }

}