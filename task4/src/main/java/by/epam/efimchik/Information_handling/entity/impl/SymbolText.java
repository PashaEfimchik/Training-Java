package by.epam.efimchik.Information_handling.entity.impl;

import by.epam.efimchik.Information_handling.entity.IComponent;
import by.epam.efimchik.Information_handling.entity.ComponentType;

import java.util.List;

public class SymbolText implements IComponent<IComponent> {
    private ComponentType componentType;
    private char symbol;

    public SymbolText(ComponentType componentType, char symbol) {
        this.componentType = componentType;
        this.symbol = symbol;
    }

    @Override
    public ComponentType getCompositeType(){
        return componentType;
    }

    @Override
    public boolean add(IComponent component) {
        throw new UnsupportedOperationException(component + " can't be added due to " + this + " doesn't contain any components");
    }

    @Override
    public boolean remove(IComponent component) {
        throw new UnsupportedOperationException(component + " can't be removed due to " + this + " doesn't contain any components");
    }

    @Override
    public List<IComponent> getComponents() {
        throw new UnsupportedOperationException(this + " doesn't contain any components");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SymbolText)) {
            return false;
        }
        SymbolText that = (SymbolText) o;
        return symbol == that.symbol && (componentType != null ? componentType == that.componentType : that.componentType == null);
    }

    @Override
    public int hashCode() {
        int first = 31;
        int result = 1;
        result = result * first * Character.hashCode(symbol);
        result = result * first + (componentType != null ? componentType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }

}
