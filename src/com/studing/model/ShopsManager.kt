package com.studing.model

import com.studing.extantions.*
import java.util.HashSet
import kotlin.Comparator

class ShopsManager(private val stores: List<Store>) {

    fun findChPhone(storeName: String): String {
        return "\t${let { stores.find { it.isSameName(storeName) } ?: return "Shop not found" }
            .phones
            .minBy { it.getRealCost() }
            .toString()
            .replace("[]", "")}"
    }

    fun findMaxDiscount(): String {
        val retStore: Store = stores.maxWith(
            Comparator { store1, store2 -> store1.findMaxDiscount() - store2.findMaxDiscount() })!!

        return when {
            retStore.findMaxDiscount() > 0 -> "Store name:${retStore.name} \n\t${retStore.phones.maxBy { it.discount }!!
                .getViewStr()}"
            else -> "No discounts"
        }
    }


    fun findPhoneByBrand(storeName: String, brand: String): String {
        val phonesOut = let { stores.find { it.isSameName(storeName) } ?: return "Shop not found" }
            .phones
            .filter { it.isSameBrand(brand) }
            .map { it.getViewStr() }
        return if (phonesOut.isNotEmpty()) phonesOut.joinToString("", "\t", "") else "Smartphone out of stock"
    }

    fun findPhoneByRange(storeName: String, minCost: Int, maxCost: Int): String {
        val phonesOut = let { stores.find { it.isSameName(storeName) } ?: return "Shop not found" }
            .phones
            .filter { it.cost in (minCost..maxCost) }
            .map { it.getViewStr() }
        return if (phonesOut.isNotEmpty()) phonesOut.joinToString("", "\t", "")
        else "No phones in this price range"
    }

    fun findUniquePhones(): String {
        val allPhone: MutableSet<Phone> = HashSet()
        stores.forEach { if (it.address != null) allPhone.addAll(it.phones) }
        return if (allPhone.isNotEmpty()) allPhone.joinToString("", "\t", "") { it.getViewStr() }
        else "No phones"
    }
}

