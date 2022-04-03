package by.epam.efimchik.Information_handling.parser;

import by.epam.efimchik.Information_handling.entity.IComponent;
import by.epam.efimchik.Information_handling.entity.impl.CompositeText;
import by.epam.efimchik.Information_handling.entity.impl.SymbolText;
import by.epam.efimchik.Information_handling.entity.ComponentType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractParser{
    static final String PUNCTUATION_REGEX = "\\W";

    @Override
    IComponent parse(String text) {
        IComponent lexemeComposite = new CompositeText(ComponentType.LEXEME);
        IComponent word;
        IComponent punctuation;

        Pattern pattern = Pattern.compile(PUNCTUATION_REGEX);
        Matcher firstSymbolMatcher = pattern.matcher(String.valueOf(text.charAt(0)));
        Matcher lastSymbolMatcher = pattern.matcher(String.valueOf(text.charAt(text.length() - 1)));

        if(firstSymbolMatcher.matches() && lastSymbolMatcher.matches() && text.length() > 1) {
            punctuation = new SymbolText(ComponentType.PUNCTUATION, text.charAt(0));
            lexemeComposite.add(punctuation);
            word = new WordParser().passNext(text.substring(1, text.length() - 1));
            lexemeComposite.add(word);
            punctuation = new SymbolText(ComponentType.PUNCTUATION, text.charAt(text.length() - 1));
            lexemeComposite.add(punctuation);
        } else if(firstSymbolMatcher.matches()) {
            punctuation = new SymbolText(ComponentType.PUNCTUATION, text.charAt(0));
            lexemeComposite.add(punctuation);
            word = new WordParser().passNext(text.substring(1));
            lexemeComposite.add(word);
        } else {
            word = new WordParser().passNext(text.substring(0, text.length() - 1));
            lexemeComposite.add(word);
            punctuation = new SymbolText(ComponentType.PUNCTUATION, text.charAt(text.length() - 1));
            lexemeComposite.add(punctuation);
        }
        return lexemeComposite;
    }
}
