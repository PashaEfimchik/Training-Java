package by.epam.efimchik.Information_handling.parser;

import by.epam.efimchik.Information_handling.entity.IComponent;
import by.epam.efimchik.Information_handling.entity.impl.CompositeText;
import by.epam.efimchik.Information_handling.entity.ComponentType;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser{
    static final String SENTENCE_SEPARATOR_REGEX = "\s+";
    static final String WORD_REGEX = "([\\wа-яА-Я]+[-']?[\\wа-яА-Я]+)|[\\wа-яА-Я]+";

    @Override
    public IComponent parse(String sentence) {
        List<String> lexemes = Arrays.asList(sentence.split(SENTENCE_SEPARATOR_REGEX));
        IComponent sentenceComposite = new CompositeText(ComponentType.SENTENCE.SENTENCE);
        Pattern wordPattern = Pattern.compile(WORD_REGEX);
        lexemes.forEach(l -> {
            Matcher wordMatcher = wordPattern.matcher(l);

            if(wordMatcher.matches()) {
                changeParser(new WordParser());
                IComponent word = nextParser.passNext(l);
                sentenceComposite.add(word);
            } else if(!l.isEmpty()) {
                changeParser(new LexemeParser());
                IComponent lexeme = nextParser.passNext(l);
                sentenceComposite.add(lexeme);
            }
        });
        return sentenceComposite;
    }
}
