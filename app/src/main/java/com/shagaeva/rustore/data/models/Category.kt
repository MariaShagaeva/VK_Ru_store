package com.shagaeva.rustore.data.models

/**
 * Перечисление категорий приложений в магазине.
 */
enum class Category(val displayName: String) {
    FINANCE("Финансы"),
    TOOLS("Инструменты"),
    GAMES("Игры"),
    GOVERNMENT("Государственные"),
    TRANSPORT("Транспорт"),
    ALL("Все приложения");

    /**
     * Преобразует строковое название категории в элемент перечисления.
     */
    companion object {
        fun fromString(value: String): Category {
            return values().find { it.displayName == value } ?: ALL
        }
    }
}