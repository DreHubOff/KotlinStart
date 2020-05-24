package com.studing.model

data class Phone(
    val brand: String,
    val model: String,
    val cost: Int,
    val discount: Double = 0.0
){   //Для получения уникальных устройств с учетом цены и другиг параметров
     //необходимо использовать стандартную реализацию методов equals() и hashCode()
    override fun equals(other: Any?) = this.brand == (other as Phone).brand && this.model == other.model
    override fun hashCode() = this.brand.length * 10 + this.model.length * 13 + 399
}
