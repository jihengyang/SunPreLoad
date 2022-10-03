package com.sun.sunproxy

import android.util.Log
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

/**
 * @author hengyangji
 * on 2022/10/2
 */
object SunProxy {
    fun doProxy() {
        val student = SunStudent()
        val proxyObj = Proxy.newProxyInstance(
            student.javaClass.classLoader,
            arrayOf(ISunStudent::class.java),
            SunStudentProxy(student)
        )
        (proxyObj as ISunStudent).study(10)
    }
}

interface ISunStudent {
    fun study(time: Int)
}

class SunStudent : ISunStudent {
    override fun study(time: Int) {
        Log.i("SunStudent", "do study $time hours")
    }
}

class SunStudentProxy(private val obj: Any?) : InvocationHandler {
    override fun invoke(proxy: Any?, method: Method?, args: Array<Any?>): Any? {
        Log.i("SunStudent", "before do study")
        return method!!.invoke(obj, *args)
    }
}