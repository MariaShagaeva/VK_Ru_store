/**
 * Модель данных, представляющая приложение в магазине RuStore.
 */
package com.shagaeva.rustore.data.models

data class App(
    val id: Int,
    val name: String,
    val developer: String,
    val iconResId: Int,
    val shortDescription: String,
    val fullDescription: String,
    val category: Category,
    val ageRating: AgeRating,
    val screenshots: List<Int>,
    val apkUrl: String? = null
)

/** Возрастной рейтинг приложения */
enum class AgeRating(val displayName: String) {
    ZERO_PLUS("0+"),
    SIX_PLUS("6+"),
    EIGHT_PLUS("8+"),
    TWELVE_PLUS("12+"),
    SIXTEEN_PLUS("16+"),
    EIGHTEEN_PLUS("18+");

    /**
     * Вспомогательный объект для преобразования строки в элемент перечисления.
     */
    companion object {
        fun fromString(value: String): AgeRating {
            return values().find { it.displayName == value } ?: ZERO_PLUS
        }
    }
}