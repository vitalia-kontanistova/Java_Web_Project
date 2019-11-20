package by.epam.ellipse.service.registrar;

public interface Observable {
    void add(Observer observer);

    void remove(Observer observer);

    void notifyObservers();
}