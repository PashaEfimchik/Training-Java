package by.epam.efimchik.Information_handling.service.impl;

import by.epam.efimchik.Information_handling.entity.impl.CompositeText;
import by.epam.efimchik.Information_handling.parser.SentenceParser;
import by.epam.efimchik.Information_handling.parser.TextParser;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TextServiceTest extends TestCase {
    private TextService textService;
    private CompositeText compositeText;
    private TextParser parser;
    private String document;
    private String emptyDocument;

    @BeforeEach
    public void setUp() {
        parser = new TextParser();
        textService = new TextService();
        document = """
                First sentence 1. Second sentence 2.
                Sentence one. TheLongestWord in sentence two. Sentence three.
                Sentence 1.
                """;
        emptyDocument = "";
        compositeText = (CompositeText) parser.parse(document);
    }

    @Test
    void sort() {
    }

    @Test
    void findSentenceWithLongestWord() {
        SentenceParser sentenceParser = new SentenceParser();
        String longestWordSentence = "TheLongestWord in sentence two.";
        String expected = textService.findSentenceWithLongestWord(compositeText);
        String actual = String.valueOf(sentenceParser.parse(longestWordSentence));

        assertEquals(expected, actual);
    }

    @Test
    void removeSentenceWithNumberWordsLess() {
        /*String expected = String.valueOf(compositeText);
        textService.removeSentenceWithNumberWordsLess(compositeText, 2);
        String actual = String.valueOf(compositeText);
        assertEquals(expected, actual);*/
    }

    @Test
    void findSameWords() {
    }

    @Test
    void findConsonantsAndVowelsNumber() {
    }
}