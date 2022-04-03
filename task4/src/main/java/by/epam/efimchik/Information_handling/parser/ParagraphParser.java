package by.epam.efimchik.Information_handling.parser;

import by.epam.efimchik.Information_handling.entity.IComponent;
import by.epam.efimchik.Information_handling.entity.impl.CompositeText;
import by.epam.efimchik.Information_handling.entity.ComponentType;

import java.util.Arrays;
import java.util.List;

public class ParagraphParser extends AbstractParser{
    static final String PARAGRAPH_SEPARATOR = "(?<=[.?!…])\s";

    public ParagraphParser() {
        changeParser(new SentenceParser());
    }

    @Override
    IComponent parse(String paragraph) {
        List<String> sentences = Arrays.asList(paragraph.split(PARAGRAPH_SEPARATOR));
        IComponent paragraphComposite = new CompositeText(ComponentType.PARAGRAPH);
        sentences.forEach(s -> {
            IComponent sentence = nextParser.passNext(s);
            paragraphComposite.add(sentence);
        });
        return paragraphComposite;
    }
}
