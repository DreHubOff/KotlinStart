package com.studing.model

import com.studing.extantions.*

class ShopsManager(private val stores: List<Store>) {

    fun findChPhone(storeName: String): String {
        return "\t${let { stores.find { it.isSameName(storeName) } ?: return "Shop not found" }
            .phones
            .minBy { it.getRealCost() }
            .toString()
            .replace("[]", "")}"
    }

    fun findMaxDiscount(): String {
        var retStore: Store =
            stores.maxWith(Comparator { store1, store2 -> store1.findMaxDiscount() - store2.findMaxDiscount() })!!

        return if (retStore.findMaxDiscount() == 0) "No discounts"
        else "Store name:${retStore.name} \n\t${retStore.phones.maxBy { it.discount }!!.getViewStr()}"
    }

    fun findPhoneByBrand(storeName: String, brand: String): String {
        val phonesOut = let { stores.find { it.isSameName(storeName) } ?: return "Shop not found" }
            .phones
            .filter { it.isSameBrand(brand) }
            .map { it.getViewStr() }
        return if (phonesOut.isNotEmpty()) phonesOut.getViewString() else "Smartphone out of stock"
    }

    fun findPhoneByRange(storeName: String, minCost: Int, maxCost: Int): String {
        val phonesOut = let { stores.find { it.isSameName(storeName) } ?: return "Shop not found" }
            .phones
            .filter { it.cost in (minCost..maxCost) }
            .map { it.getViewStr() }
        return if (phonesOut.isNotEmpty()) phonesOut.getViewString()
        else "No phones in this price range"
    }

    fun findUniquePhones(): String {
        val allPhone = (stores.first().phones).toMutableList()
        stores.forEachIndexed { index, store -> if (index > 0 && store.address != null) allPhone.addAll((store.phones)) }

        val outList = allPhone
            .filter { !it.containsMore(allPhone) }
            .map { it.getViewStr() }
        return if (outList.isNotEmpty()) outList.getViewString() else "No phones"
    }


}

private fun List<String>.getViewString() = this.toString()
    .replace("[", "").replace("]", "")
