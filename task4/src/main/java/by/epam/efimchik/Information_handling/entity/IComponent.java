package by.epam.efimchik.Information_handling.entity;

import java.util.List;

public interface IComponent {
    boolean add(IComponent iComponent);
    boolean remove(IComponent iComponent);
    List<IComponent> getComponents();
    ComponentType getComponentType();
}
