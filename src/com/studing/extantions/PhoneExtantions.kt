package com.studing.extantions

import com.studing.model.Phone

fun Phone.isSameBrand(inBrand: String) = this.brand.toLowerCase() == inBrand.toLowerCase()

fun Phone.getRealCost() = this.cost - (this.discount / 100 * this.cost)

fun Phone.getViewStr() = "$this\n".replace("[", "").replace("]", "")
