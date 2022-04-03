package by.epam.efimchik.Information_handling.parser;

import by.epam.efimchik.Information_handling.entity.IComponent;

public abstract class AbstractParser {
    protected AbstractParser nextParser;

    public void changeParser(AbstractParser nextParser){
        this.nextParser = nextParser;
    }

    public IComponent passNext(String text){
        IComponent component = parse(text);
        if(nextParser != null){
            nextParser.passNext(text);
        }
        return component;
    }

    abstract IComponent parse(String text);
}
