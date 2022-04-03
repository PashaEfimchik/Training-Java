package by.epam.efimchik.Information_handling.service.impl;

import by.epam.efimchik.Information_handling.entity.ComponentType;
import by.epam.efimchik.Information_handling.entity.IComponent;
import by.epam.efimchik.Information_handling.entity.impl.CompositeText;
import by.epam.efimchik.Information_handling.service.IService;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextService implements IService<CompositeText> {
    static final String VOWELS = "[aeyuioуеыаоэёяию]";
    private static String sentence = "";
    private static int lengthWord = 0;
    private static TextService instance;

    public static TextService getInstance() {
        if(instance == null) {
            instance = new TextService();
        }
        return instance;
    }

    @Override
    public CompositeText sort(CompositeText textComposite) {
        List<IComponent> components = textComposite
                .getComponents()
                .stream()
                .sorted(Comparator.comparingInt(p -> p.getComponents().size()))
                .toList();
        for (int i = 0; i < components.size(); i++) {
            textComposite
                    .getComponents()
                    .set(i, components.get(i));
        }
        return textComposite;
    }

    @Override
    public String findSentenceWithLongestWord(CompositeText textComposite) {
        List<IComponent> sentences = findAllByType(textComposite, ComponentType.SENTENCE);
        sentences.forEach(s ->
                s.getComponents().forEach(c -> {
                    int cLength = c.getComponents().size();
                    if(c.getComponentType() == ComponentType.LEXEME ) {
                        IComponent word = c.getComponents()
                                .stream()
                                .filter(c1 -> c.getComponentType() == ComponentType.WORD)
                                .findFirst()
                                .orElse(new CompositeText(ComponentType.WORD));
                        int length = ((IComponent) word).getComponents().size();
                        if(length > lengthWord) {
                            lengthWord = length;
                            sentence = s.toString();
                        }
                    } else if(c.getComponentType() == ComponentType.WORD && cLength > lengthWord) {
                        lengthWord = cLength;
                        sentence = s.toString();
                    }
                }));

        return sentence;
    }

    @Override
    public void removeSentenceWithNumberWordsLess(CompositeText textComposite, int wordsNumber) {
        textComposite.getComponents().forEach(p ->
                p.getComponents().removeIf(s ->
                        s.getComponents().size() < wordsNumber));
    }

    @Override
    public Map<String, Integer> findSameWords(CompositeText textComposite) {
        Map<String, Integer> repeatedWords = new ConcurrentHashMap<>();
        List<IComponent> allWords = findAllByType(textComposite, ComponentType.WORD);

        allWords.stream()
                .map(c -> c.toString().toLowerCase().trim())
                .forEach(s -> {
                    int step = 1;
                    repeatedWords.merge(s, step, Integer::sum);
                });

        Set<String> keys = repeatedWords.keySet();
        keys.forEach(k -> {
            int minValue = 1;
            repeatedWords.remove(k, minValue);
        });

        return repeatedWords;
    }

    @Override
    public Map<String, Integer> findConsonantsAndVowelsNumber(CompositeText textComposite) {
        String vowelsKey = "vowels";
        String consonantsKey = "consonants";
        int startValue = 0;

        Map<String, Integer> lettersNumber = new HashMap<>();
        lettersNumber.put(vowelsKey, startValue);
        lettersNumber.put(consonantsKey, startValue);

        List<IComponent> letters = findAllByType(textComposite, ComponentType.LETTER);
        Pattern vowelPattern = Pattern.compile(VOWELS);
        letters.forEach(l -> {
            Matcher matcher = vowelPattern.matcher(String.valueOf(l).toLowerCase());
            int currentValue;
            if(matcher.matches()) {
                currentValue = lettersNumber.get(vowelsKey);
                lettersNumber.put(vowelsKey, ++currentValue);
            } else {
                currentValue = lettersNumber.get(consonantsKey);
                lettersNumber.put(consonantsKey, ++currentValue);
            }
        });

        return lettersNumber;
    }

    private List<IComponent> findAllByType(IComponent component, ComponentType type) {
        List<IComponent> components = new ArrayList<>();
        component.getComponents().forEach(c -> findByType(components, c, type));

        return components;
    }

    private void findByType(List<IComponent> components, IComponent component, ComponentType componentType) {
        component.getComponents().forEach(c -> {
            ComponentType type = c.getComponentType();
            if(type == componentType) {
                components.add(c);
            } else if(type != ComponentType.LETTER && type != ComponentType.PUNCTUATION){
                findByType(components, c, componentType);
            }
        });
    }
}
