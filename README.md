# Training-Java

#  Интернет магазин автозапчастей #

Данный проект представляет собой консольное приложение интернет магазина автозапчастей.

## Приложение разработано в многослойной архитектуре: 

- [entities](https://github.com/PashaEfimchik/Training-Java/tree/main/task1v2/src/main/java/by/epam/Efimchik/task1/entities) - классы сущностей
- [services](https://github.com/PashaEfimchik/Training-Java/tree/main/task1v2/src/main/java/by/epam/Efimchik/task1/services) - бизнес-логика
- [dao](https://github.com/PashaEfimchik/Training-Java/tree/main/task1v2/src/main/java/by/epam/Efimchik/task1/dao) - доступ к данным (в данной версии проекта - эмуляция базы данных в виде коллекций)
- [view](https://github.com/PashaEfimchik/Training-Java/tree/main/task1v2/src/main/java/by/epam/Efimchik/task1/view) - диспетчер, распределяющий запросы пользователя
- [utils](https://github.com/PashaEfimchik/Training-Java/tree/main/task1v2/src/main/java/by/epam/Efimchik/task1/utils) - начальная инициализация данными

## В beans-классах реализовано:

- Переопределение методов equals(), hashCode(), toString()
- Добавлены необходимые конструкторы
- Добавлены геттеры и сеттеры
- У полей есть свои модификаторы доступа
- Счетчики созданных объектов

## В проекте реализовано:

- Custom exception
- [Сериализация](https://github.com/PashaEfimchik/Training-Java/blob/main/task1v2/src/main/java/by/epam/Efimchik/task1/utils/InitializationUtil.java)
- Generics
- Regexp
- Валидация данных
- Сгенерированный javadoc для всех классов
- Написаны [unit-тесты](https://github.com/PashaEfimchik/Training-Java/tree/main/task1v2/src/test/java/by/epam/Efimchik/task1/dao/impl) с использованием Junit
- Для логирования используется Log4j
- Логика входа в приложение разделена на пользователя / админа
