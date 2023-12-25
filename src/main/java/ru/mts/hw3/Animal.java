package ru.mts.hw3;

import java.math.BigDecimal;

/**
 * Интерфейс для создания животного
 * обладает методами указывающими на получение информации о полях
 */
public interface Animal {
    /**
     * Возвращает породу животного
     * @return имя породы
     */
    String getBreed();
    /**
     * Возвращает имя животного
     * @return имя животного
     */
    String getName();
    /**
     * Возвращает цену одного животного
     * @return цену одного животного
     */
    BigDecimal getCost();
    /**
     * Возвращает характер животного
     * @return характер животного
     */
    String getCharacter();
}
