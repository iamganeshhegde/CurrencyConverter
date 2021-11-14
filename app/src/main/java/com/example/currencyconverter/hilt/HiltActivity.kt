package com.example.currencyconverter.hilt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyconverter.R
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Qualifier
import javax.inject.Singleton

@AndroidEntryPoint
class HiltActivity : AppCompatActivity() {

    //Field injection
    @Inject lateinit var someClass:SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_hilt)

//        println(someClass.doAThing())
//        println(someClass.doSomeOtherThing())

        println(someClass.doSomeThingFroOther1())
        println(someClass.doSomeThingFroOther2())
    }
}

class SomeClass
@Inject
constructor(
//    private val someOtherClass: SomeOtherClass // this is class constructor injected
//    private val someOtherClass: SomeInterFace // interface added with binds
    @Impl1 private val someOtherClass1: SomeInterFace,
    @Impl2 private val someOtherClass2: SomeInterFace,
    var gson: Gson
) {

    fun doAThing():String {
        return "Look I did a thing"
    }

    fun doSomeOtherThing(): String {
        return someOtherClass2.doSomeOtherThing()
    }

    fun doSomeThingFroOther1(): String {
        return "someOtherClass: :  ${someOtherClass1.doSomeOtherThing()}"
    }

    fun doSomeThingFroOther2(): String {
        return "someOtherClass: :  ${someOtherClass2.doSomeOtherThing()}"
    }

}


/*class SomeOtherClass @Inject constructor() {
    fun doSomeOtherThing(): String {
        return "Look this is other thing"
    }
}*/

class SomeOtherClass1 @Inject constructor():SomeInterFace {
    override fun doSomeOtherThing(): String {
        return "Look this is 1st thing"
    }
}

class SomeOtherClass2 @Inject constructor():SomeInterFace {
    override fun doSomeOtherThing(): String {
        return "Look this is 2nd thing"
    }
}

interface SomeInterFace {
    fun doSomeOtherThing():String
}

// check interface to pass in constructor injection



//complex way using @binds - not easy
/*@Module
@InstallIn(ActivityComponent::class)
abstract class MyModule {

    @ActivityScoped
    @Binds
    abstract fun bindSomeImpl(
        someClass: SomeOtherClass
    ) :SomeInterFace

    @ActivityScoped
    @Binds
    abstract fun bindGson(
        gson:Gson
    ):Gson
}*/



// easier and working way - @Provides
@InstallIn(SingletonComponent::class)
@Module
class Module() {

    @Impl1
    @Singleton
    @Provides
    fun provideSomeInterface1():SomeInterFace {
        return SomeOtherClass1()
    }

    @Impl2
    @Singleton
    @Provides
    fun provideSomeInterface2():SomeInterFace {
        return SomeOtherClass2()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }
}


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl1

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl2





