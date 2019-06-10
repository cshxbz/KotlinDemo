package com.hxb.kotlin_demo

/**
 * 密封类的直接之类必须与密封在同一个文件中声明
 * 密封类自身是抽象类，无法实例化
 */
sealed class Animal{
    var weight:Double=1.0
}

class Tiger : Animal()
class Cat : Animal()
object NaughtyDog : Animal()