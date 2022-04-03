package by.epam.efimchik.Information_handling.service;

import by.epam.efimchik.Information_handling.component.type.CompositeText;

import java.util.Map;

public interface IService<T> {
    CompositeText sort(T t);

    String findSentenceWithLongestWord(T t);

    void removeSentenceWithNumberWordsLess(T t, int wordsNumber);

    Map<String, Integer> findSameWords(T t);

    Map<String, Integer> findConsonantsAndVowelsNumber(T t);
}
