package com.studing.extantions

import com.studing.model.Store

fun Store.findMaxDiscount() = this.phones.maxBy { it.discount }!!.discount.toInt()

fun Store.isSameName(inName: String) = this.name.toLowerCase() == inName.toLowerCase()