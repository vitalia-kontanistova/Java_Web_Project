package by.epam.ellipse.repository;

import by.epam.ellipse.entity.Ellipse;
import by.epam.ellipse.registrar.EllipseObservable;

import java.util.List;

public class IdSpecification implements Specification<Ellipse, EllipseObservable> {
    @Override
    public void remove(List<EllipseObservable> base, int id) {
        for (int i = 0; i < base.size(); i++) {
            EllipseObservable ellipseObservable = base.get(i);
            Ellipse currentEllipse = ellipseObservable.getEllipse();
            if (currentEllipse.getId() == id){
                base.remove(i);
                return;
            }
        }
    }

    @Override
    public List<Ellipse> sort(Specification specification) {
        return null;
    }

    @Override
    public List<Ellipse> takeAll(Specification specification) {
        List<Ellipse> base = null;

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
}
