package by.epam.ellipse.dao.util;

import by.epam.ellipse.entity.Ellipse;
import by.epam.ellipse.service.registrar.EllipseRegistrar;

import java.util.Comparator;

public class IdComparator implements Comparator<EllipseRegistrar> {
    @Override
    public int compare(EllipseRegistrar er1, EllipseRegistrar er2){
        Ellipse ellipse1 = er1.returnEllipse();
        Ellipse ellipse2 = er2.returnEllipse();

        if (ellipse1.getId() == ellipse2.getId()) {
            return 0;
        } else if (ellipse1.getId() < ellipse2.getId()) {
            return -1;
        } else return 1;
    }
}