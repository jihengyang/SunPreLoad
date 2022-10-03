package com.sun.sunproxy

import android.util.Log
import kotlin.reflect.KProperty

/**
 * Kotlin代理
 * @author hengyangji
 * on 2022/10/2
 */
object SunKTProxy {
    fun doProxy() {

    }
}

//fun main() {
//    SunPro("李华").doSomeThing()
//}

interface ISubKt {
    fun doIt()
}

class SunKt(private val who:String) : ISubKt {
    override fun doIt() {
        Log.i("SunKTProxy", "$who doIt")
    }
}

class SunPro(who: String) : ISubKt by SunKt(who) {
    private val name:Int by SunName()

    fun doSomeThing() {
        doIt()
        val a = name
        val b = name
        val c = name
        val d = name
    }
}

class SunName {
    operator fun getValue(sunPro: SunPro, property: KProperty<*>): Int {
        Log.i("SunKTProxy", "getValue")
        return 1
    }
}

