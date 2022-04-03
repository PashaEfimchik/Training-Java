package by.epam.efimchik.Information_handling.parser;

import by.epam.efimchik.Information_handling.entity.IComponent;
import by.epam.efimchik.Information_handling.entity.impl.CompositeText;
import by.epam.efimchik.Information_handling.entity.impl.SymbolText;
import by.epam.efimchik.Information_handling.entity.ComponentType;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends AbstractParser{
    static final String WORD_SEPARATOR = "";
    static final String SYMBOLS_REGEX = "[-']";

    @Override
    IComponent parse(String text) {
        List<String> letters = Arrays.asList(text.trim().split(WORD_SEPARATOR));
        IComponent wordComposite = new CompositeText(ComponentType.WORD);
        Pattern symbolPattern = Pattern.compile(SYMBOLS_REGEX);
        letters.forEach(l -> {
            if(!l.isEmpty()) {
                Matcher matcher = symbolPattern.matcher(l);
                IComponent symbol = matcher.matches() ? new SymbolText(ComponentType.PUNCTUATION, l.charAt(0)) : new SymbolText(ComponentType.LETTER, l.charAt(0));
                wordComposite.add(symbol);
            }
        });
        return wordComposite;
    }
}
