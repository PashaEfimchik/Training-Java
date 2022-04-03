package by.epam.efimchik.Information_handling.entity.impl;

import by.epam.efimchik.Information_handling.entity.IComponent;
import by.epam.efimchik.Information_handling.entity.ComponentType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CompositeText implements IComponent {
    private List<IComponent> components = new ArrayList<>();
    private ComponentType componentType;

    public CompositeText(ComponentType componentType) {
        this.componentType = componentType;
    }

    @Override
    public ComponentType getComponentType() {
        return componentType;
    }

    @Override
    public List<IComponent> getComponents() {
        return components;
    }

    @Override
    public boolean add(IComponent component) {
        return components.add(component);
    }

    @Override
    public boolean remove(IComponent component) {
        return components.remove(component);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeText that = (CompositeText) o;
        return Objects.equals(components, that.components) && componentType == that.componentType;
    }

    @Override
    public int hashCode() {
        int first = 31;
        int result = 1;
        result = result * first * components.hashCode();
        result = result * first * componentType.hashCode();

        return result;
    }

    @Override
    public String toString() {
        components.removeIf(c -> c == null);
        StringBuilder strBuilder = new StringBuilder(componentType.getBefore());
        components.forEach(t -> strBuilder
                .append(t.toString())
                .append(componentType.getAfter()));

        return strBuilder.toString();
    }
}
