package by.epam.ellipse.entity.observer;

import by.epam.ellipse.entity.Ellipse;
import by.epam.ellipse.service.EllipseServiceImpl;
import by.epam.ellipse.service.exception.ServiceException;
import by.epam.ellipse.service.registrar.EllipseParametersObserver;
import by.epam.ellipse.service.registrar.EllipseRegistrar;
import org.junit.Assert;
import org.junit.Test;

public class ObserverTest {

//    @Test
//    public void setPointsTest() {
//        EllipseServiceImpl instance = EllipseServiceImpl.getInstance();
//        EllipseRegistrar ellipseRegTest = new EllipseRegistrar();
//        EllipseParametersObserver ellipseParamObservTest = new EllipseParametersObserver(ellipseRegTest);
//        try {
//            ellipseRegTest.setPoints(new Ellipse.Point(0, 0), new Ellipse.Point(5, 5));
//        } catch (ServiceException e) {
//            e.getMessage();
//        }
//
//        Ellipse actualEl = ellipseParamObservTest.returnEllipse();
//        Ellipse expectedEl = new Ellipse(new Ellipse.Point(0, 0), new Ellipse.Point(5, 5));
//        Assert.assertEquals(actualEl, expectedEl);
//        try {
//
//            double actualAr = ellipseParamObservTest.returnArea();
//            double expectedAr = instance.findArea(actualEl);
//            Assert.assertEquals(actualAr, expectedAr, 0);
//        } catch (ServiceException e) {
//            e.getMessage();
//        }
//
//        try {
//            double actualPer = ellipseParamObservTest.returnPerimeter();
//            double expectedPer = instance.findPerimeter(actualEl);
//            Assert.assertEquals(actualPer, expectedPer, 0);
//        } catch (ServiceException e) {
//            e.getMessage();
//        }
//    }

//    @Test
//    public void setPointATest() {
//        EllipseServiceImpl instance = EllipseServiceImpl.getInstanceEl();
//        EllipseRegistrar ellipseRegTest = new EllipseRegistrar();
//        EllipseParametersObserver ellipseParamObservTest = new EllipseParametersObserver(ellipseRegTest);
//
//        try {
//            ellipseRegTest.setPointA(new Ellipse.Point(0, 0));
//        } catch (ServiceException e) {
//            e.getMessage();
//        }
//
//        Ellipse actualEl = ellipseParamObservTest.returnEllipse();
//        Ellipse expectedEl = null;// new Ellipse(new Ellipse.Point(0,0),new Ellipse.Point(5,5));
//        Assert.assertEquals(actualEl, expectedEl);
//
//        double actualAr = ellipseParamObservTest.returnArea();
//        double expectedAr = instance.findArea(actualEl);
//        Assert.assertEquals(actualAr, expectedAr, 0);
//
//        double actualPer = ellipseParamObservTest.returnPerimeter();
//        double expectedPer = instance.findPerimeter(actualEl);
//        Assert.assertEquals(actualPer, expectedPer, 0);
//    }


}