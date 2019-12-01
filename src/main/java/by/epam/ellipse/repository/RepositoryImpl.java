package by.epam.ellipse.repository;

import by.epam.ellipse.entity.Ellipse;
import by.epam.ellipse.registrar.EllipseObservable;
import by.epam.ellipse.registrar.ParametersObserver;
import by.epam.ellipse.dao.exception.DAOexception;
import by.epam.ellipse.service.exception.ServiceException;
import by.epam.ellipse.service.impl.EllipseServiceImpl;
import by.epam.ellipse.util.IdGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositoryImpl implements Repository<Ellipse> {

    private List<EllipseObservable> ellipses = new ArrayList<>();
    private Map<Integer, ParametersObserver> ellipseParameters = new HashMap<>();


    @Override
    public void add(Ellipse ellipse, IdGenerator idGenerator) throws DAOexception {
        try {
            EllipseObservable ellipseObservable = new EllipseObservable();
            ParametersObserver paramObserver = new ParametersObserver(ellipseObservable);
            ellipseObservable.setEllipse(ellipse, EllipseServiceImpl.getInstance());
            int id = idGenerator.generate(ellipses);
            ellipse.setId(id);

            ellipses.add(ellipseObservable);
            ellipseParameters.put(id, paramObserver);

        } catch (NullPointerException | ServiceException e) {
            throw new DAOexception("RepositoryImpl: add(): " + e.getMessage());
        }
    }

    @Override
    public void update(Ellipse item) {
    }

    @Override
    public void remove(Ellipse item) {
    }

    @Override
    public void remove(Specification specification) {
    }

    @Override
    public List<Ellipse> sort(Specification specification) {


        return null;
    }

    @Override
    public List<Ellipse> takeAll(Specification specification) {
        List<Ellipse> result;
        return null;
    }


    @Override
    public List<Ellipse> takeSome(Specification specification) {
        return null;
    }

    @Override
    public Ellipse takeOne(Specification specification) {
        return null;
    }

    private void coordinate() {
        List<Integer> idBase = new ArrayList<>(ellipseParameters.keySet());

        for (int currentId : idBase) {
            boolean missingId = true;
            for (EllipseObservable ellipseObservable : ellipses) {
                Ellipse currentEllipse = ellipseObservable.getEllipse();
                if (currentEllipse.getId() == currentId) {
                    missingId = false;
                }
            }
            if (missingId) {
                ellipseParameters.remove(currentId);
            }
        }
    }
}