package by.epam.efimchik.Information_handling.view;

import by.epam.efimchik.Information_handling.entity.IComponent;
import by.epam.efimchik.Information_handling.entity.impl.CompositeText;
import by.epam.efimchik.Information_handling.exception.CompositeException;
import by.epam.efimchik.Information_handling.parser.TextParser;
import by.epam.efimchik.Information_handling.reader.FileReader;
import by.epam.efimchik.Information_handling.service.impl.TextService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;


public class Application {
    final Logger logger = LogManager.getLogger();
    private FileReader fileReader;
    private String text;

    {
        fileReader = new FileReader();
        try {
            text = fileReader.readFile("src\\main\\resources\\file\\input.txt");
        } catch (CompositeException e) {
            e.printStackTrace();
        }
    }

    public void Start () throws CompositeException {
        TextService textService = TextService.getInstance();
        TextParser textParser = new TextParser();
        IComponent component = textParser.parse(text);

        logger.info(text);

        CompositeText compositeText = textService.sort((CompositeText) component);
        logger.info(compositeText);

        String sentenceWithLongestWord = textService.findSentenceWithLongestWord((CompositeText) component);
        logger.info(sentenceWithLongestWord);

        Map<String, Integer> lettersNumber = textService.findConsonantsAndVowelsNumber((CompositeText) component);
        logger.info(lettersNumber);

        Map<String, Integer> sameWords = textService.findSameWords((CompositeText) component);
        logger.info(sameWords);

        textService.removeSentenceWithNumberWordsLess((CompositeText) component, 5);
        logger.info(component);

    }
}
