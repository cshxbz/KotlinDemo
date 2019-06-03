package com.hxb.kotlin_demo


/**
 * 编译器常量
 */
const val PROPERTY_C: Boolean = true

class FieldSample {

    var propertyA: Int = 0
        get() {
            println("propertyA get() field: $field")
            return field.plus(1)
        }
        set(value) {
            println("propertyA set() value: $value")
            field = value.plus(1)
        }


    /**
     * val属性不能有set
     */
    val propertyB: String? = "erika"
    get() {
        return "$field go"
    }


    /**
     *  延迟初始化属性
     *  如果没有初始化就使用此属性，会抛异常
     */
    lateinit var propertyD: String


    /**
     * 将set设置为私有，则外部无法访问此属性
     */
    var propertyE: Byte = 15
        private set

}