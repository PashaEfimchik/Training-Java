package by.epam.efimchik.Information_handling.view;

import by.epam.efimchik.Information_handling.exception.CompositeException;
import by.epam.efimchik.Information_handling.parser.factory.TextComponentParserFactory;
import by.epam.efimchik.Information_handling.reader.FileReader;

public class Application {
    /*private FileReader fileReader;
    private String text;

    {
        fileReader = new FileReader();
        try {
            text = fileReader.readFile("src\\main\\resources\\file\\input.txt");
        } catch (CompositeException e) {
            e.printStackTrace();
        }
    }*/

    public void Start () throws CompositeException {
        String text = new FileReader().readFile("src\\main\\resources\\file\\input.txt");
        Handler textParser = TextComponentParserFactory.create();
        TextImpl textComponent = new TextImpl();
        textParser.parse(textComponent, text);
        System.out.println(textComponent);
    }
}
