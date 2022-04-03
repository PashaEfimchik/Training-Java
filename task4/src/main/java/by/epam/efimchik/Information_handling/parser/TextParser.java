package by.epam.efimchik.Information_handling.parser;

import by.epam.efimchik.Information_handling.entity.IComponent;
import by.epam.efimchik.Information_handling.entity.impl.CompositeText;
import by.epam.efimchik.Information_handling.entity.ComponentType;

import java.util.Arrays;
import java.util.List;

public class TextParser extends AbstractParser{
    static final String TEXT_SEPARATOR = "[\t\n]";

    public TextParser() {
        changeParser(new ParagraphParser());
    }

    @Override
    public IComponent parse(String text) {
        List<String> paragraphs = Arrays.asList(text.split(TEXT_SEPARATOR));
        IComponent textComposite = new CompositeText(ComponentType.TEXT);
        paragraphs.forEach(p -> {
            IComponent paragraph = nextParser.passNext(p);
            textComposite.add(paragraph);
        });
        return textComposite;
    }
}
