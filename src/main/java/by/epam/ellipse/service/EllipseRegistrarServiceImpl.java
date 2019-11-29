package by.epam.ellipse.service;
//
//import by.epam.ellipse.repository.Specification;
//import by.epam.ellipse.repository.impl.EllipsesFileRepository;
//import by.epam.ellipse.dao.exception.DAOexception;
//import by.epam.ellipse.entity.Ellipse;
//import by.epam.ellipse.service.exception.ServiceException;
//import by.epam.ellipse.registrar.ParametersObserver;
//import by.epam.ellipse.registrar.EllipseObservable;
//
//import java.util.List;
//
//
public class EllipseRegistrarServiceImpl implements EllipseRegistrarService {
//    private static EllipseRegistrarServiceImpl instance = new EllipseRegistrarServiceImpl();
//
//    private EllipseRegistrarServiceImpl() {
//    }
//
//    public static EllipseRegistrarServiceImpl getInstance() {
//        return instance;
//    }
//
//
//    @Override
//    public void add(EllipseObservable ellipseRegistrar) throws DAOexception {
//        EllipsesFileRepository instance = new EllipsesFileRepository();
//        try {
//            instance.add(ellipseRegistrar);
//        } catch (DAOexception e) {
//            throw new DAOexception("EllipseRegistrarServiceImpl: add(): " + e.getMessage());
//        }
//    }
//
//    @Override
//    public void addFromFile(String requestToPropFile) throws ServiceException {
//        try {
//            List<Ellipse> ellipses = createFromFile(requestToPropFile);
//            for (Ellipse ellipse : ellipses) {
//                EllipseObservable registrar = new EllipseObservable(ellipse);
//                ParametersObserver parametersObserver = new ParametersObserver(registrar);
//                add(registrar);
//            }
//        } catch (DAOexception | ServiceException e) {
//            throw new ServiceException("EllipseRegistrarServiceImpl: addFromFile(): " + e.getMessage());
//        }
//    }
//
//
//    @Override
//    public void remove(EllipseObservable ellipseRegistrar) {
//
//    }
//
//    @Override
//    public void change(EllipseObservable ellipseRegistrar) {
//
//    }
//
//    @Override
//    public List<EllipseObservable> query(Specification specification) throws ServiceException {
//        return null;
//    }
}

