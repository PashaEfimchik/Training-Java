package by.epam.efimchik.Information_handling.entity;

import by.epam.efimchik.Information_handling.entity.ComponentType;

import java.util.List;

public interface IComponent<T> {
    boolean add(T t);
    boolean remove(T t);
    List<T> getComponents();
    ComponentType getCompositeType();
}
