package by.epam.ellipse.service;

import by.epam.ellipse.entity.Ellipse;

public interface EllipseService {
     double findPerimeter(Ellipse ellipse);

     double findArea(Ellipse ellipse);

     boolean isCircle(Ellipse ellipse);

     boolean isCrossX(Ellipse ellipse);

     boolean isCrossY(Ellipse ellipse);
}