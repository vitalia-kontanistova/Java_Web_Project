package by.epam.ellipse.dao;

import by.epam.ellipse.dao.exception.DAOexception;

public interface EllipseDAO {
    void addEllipse(String ellipse) throws DAOexception;

    void removeEllipse(String ellipse) throws DAOexception;

    void returnEllipse(String ellipse) throws DAOexception;
}