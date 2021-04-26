package com.hxb.kotlin_demo


inline fun loopAsInline(action: (Int) -> Unit) {
    for (i in 1..10) {
        action(i)
    }
}

inline fun loopAsInlineCrossInlineAction(crossinline action: (Int) -> Unit) {
    for (i in 1..10) {
        action(i)
    }
}

fun loopNoInline(action: (Int) -> Unit) {
    for (i in 1..10) {
        action(i)
    }
}


fun invokeLoop(){
    loopAsInlineCrossInlineAction {
        if (it == 5) {
//            此处return会编译错误，虽然loopAsInlineCrossInlineAction是被inline修饰的，但是action被crossinline修饰（禁用内联）
//            return
        }
        print("$it-")
    }

    println("")

    loopNoInline {
        if (it == 5) {
            //此处return会编译错误，非inline方法无法直接return
//            return
        }
        print("$it-")
    }

    println("")

    loopAsInline {
        if (it == 5) {
            return@loopAsInline
        }
        print("$it-")
    }

    println("")

    loopAsInline action@{
        if (it == 5) {
            return@action
        }
        print("$it-")
    }

    println("")

    loopAsInline {
        if (it == 5) {
            return
        }
        print("$it-")
    }
}

