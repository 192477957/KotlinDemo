package com.pkroad

fun myFun():String{
    println("执行了myFun函数")
    return "这是MyFun函数的返回值"
}

fun runFunDemo(){
    myFun()
    run { myFun() }
    run({myFun()})
    run { println("A") }
}
fun applyDemo(){
    val dataList = arrayListOf<String>()
    dataList.add("A")
    dataList.add("B")
    dataList.add("C")
    println(dataList)

    val dateList = arrayListOf<String>()
            .apply { add("A")
                add("B")
                add("C")}.let { item-> println(item) }
}


fun String.firstChar():String{
    if (this.length <= 0){
        return ""
    }
    return this[0].toString()
}

fun testNUll(name:String?):Int{
    return name?.length?:-1
}

interface Generator<in K,out T>{
    fun next():T
    fun add(item:K)
}

var p = object : Generator<String,Int> {

    override fun next(): Int {
        return 0;
    }

    override fun add(item: String) {

    }

}

