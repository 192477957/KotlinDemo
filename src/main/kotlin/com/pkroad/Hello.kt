package com.pkroad

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf

class AnEmptyClass

class Person(val name: String, val age: Int) {
    override fun toString(): String {
        return super.toString() + "{name:$name,age:$age}"
    }
}

class Person1() {
    lateinit var name: String
    var age: Int = 0;

}

abstract class Shape {
    abstract var width: Double
    abstract var height: Double
    abstract var radia: Double
    abstract fun area(): Double
    fun getStr():String{
        return "${this::class.simpleName}"
    }
}

class Rectangle(override var width: Double, override var height: Double,
                                    override var radia: Double) : Shape() {
    override fun area(): Double {
        return width*height;
    }
}

class Circle(override var width: Double, override var height: Double,
                                override var radia: Double) : Shape() {
    override fun area(): Double {
        return 3.14*radia*radia
    }
}

class Triangle(override var width: Double, override var height: Double,
                                    override var radia: Double) : Shape() {
    override fun area(): Double {
        return width*height/2
    }
}

interface ProjectService{
    var name:String
    var owner:String
    fun save(shape:Shape)
    fun log(){
        println("i am a ProjectService")
    }
}

interface ProjectService2{
    var name:String
    var owner:String
    fun save(shape:Shape)
    fun log(){
        println("i am a ProjectService2+$name")
    }
}

class ProjectServiceImpl(override var name: String,
                         override var owner: String) : ProjectService {
    override fun save(shape: Shape) {
        log();
    }

}

class ProjectServiceImpl2(override var name: String, override var owner: String)
                        : ProjectService,ProjectService2 {
    companion object {
        var INS = ProjectServiceImpl2("aaa","bbb");
    }
    override fun save(shape: Shape) {
        println("asdfa")
    }

    override fun log() {
        super<ProjectService2>.log();
    }
}

object User{
    var name:String = "xiaoming"
    var age:Int = 5;
    override fun toString(): String {
        return "$name + $age"
    }
}
