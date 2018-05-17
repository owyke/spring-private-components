package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.stereotype.Component

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder(DemoApplication::class.java).run(*args)
}

interface ValueProvider {
    fun provideValue(): Double
}

@Component
private class ValueProviderImpl(): ValueProvider {
    override fun provideValue() = 3.1415
}

interface MyComp {
    fun getValue(): Double
}

@Component
private class MyCompImpl(val provider: ValueProvider): MyComp {
    override fun getValue() = provider.provideValue()
}
