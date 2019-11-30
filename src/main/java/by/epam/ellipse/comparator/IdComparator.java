package by.epam.ellipse.comparator;

import by.epam.ellipse.entity.Ellipse;
import java.util.Comparator;

public class IdComparator implements Comparator<Ellipse> {
    @Override
    public int compare(Ellipse ellipse1, Ellipse ellipse2){
        if (ellipse1.getId() == ellipse2.getId()) {
            return 0;
        } else if (ellipse1.getId() < ellipse2.getId()) {
            return -1;
        } else return 1;
    }
}