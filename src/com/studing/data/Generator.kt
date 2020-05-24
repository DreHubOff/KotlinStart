package com.studing.data

import com.studing.model.Phone
import com.studing.model.Store

fun generate(): List<Store> {
    val stores = ArrayList<Store>()

    stores.add(
        Store(
            "Allo", "Gogola st. 18", "https://allo.ua/", listOf(
                Phone("Xiaomi", "Redmi Note 8 Pro", 5_800),
                Phone("Samsung", "Galaxy A51", 8_430, 12.toDouble()),
                Phone("Xiaomi", "Redmi Note 8T", 5_000)
            )
        )
    )

    stores.add(
        Store(
            "Citrus", "Simonova st. 18", "https://www.citrus.ua/", listOf(
                Phone("Xiaomi", "Redmi Note 8 Pro", 5_999, 4.toDouble()),
                Phone("Samsung", "Galaxy A51", 8_499),
                Phone("Xiaomi", "Redmi Note 8T", 4_999, 2.7),
                Phone("Apple", "iPhone 11", 24_999),
                Phone("Xiaomi", "Mi 9T", 7_999),
                Phone("Apple", "iPhone 11 Pro Max", 39_9999, 1.toDouble())
            )
        )
    )

    stores.add(
        Store(
            "Rozetka", webSite = "https://rozetka.ua/", phones = listOf(
                Phone("Xiaomi", "Redmi Note 8 Pro", 5_999),
                Phone("Samsung", "Galaxy A51", 8_499, 5.5),
                Phone("Xiaomi", "Redmi Note 8T", 4_999, 12.toDouble()),
                Phone("Apple", "iPhone 11", 24_999),
                Phone("Xiaomi", "Mi 9T", 8_200, 6.9),
                Phone("iPhone 11 Pro Max", "Apple", 39_9999),
                Phone("Samsung", "Galaxy Note 10 Lite", 14_100, 5.toDouble())
            )
        )
    )

    stores.add(
        Store(
            "Mobilochka", "Kirova st. 18", "https://mo.ua/", listOf(
                Phone("Xiaomi", "Redmi Note 8 Pro", 5_999),
                Phone("Samsung", "Galaxy A51", 8_799, 10.toDouble()),
                Phone("Unique Phone", "firs", 9999)
            )
        )
    )
    return stores
}