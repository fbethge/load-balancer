package com.example.loadbalancer

import java.util.concurrent.atomic.AtomicInteger
import kotlin.random.Random

class RandomStrategy(
    val instances: List<ServerInstance>,
) {
    var currentIndex: AtomicInteger = AtomicInteger(-1)

    @Synchronized
    fun getRandomInstance(): ServerInstance {
        do {
            val randomNunber = Random.nextInt(instances.size - 1)
            val atomicInteger = AtomicInteger(randomNunber)
            val randomInstance = instances[atomicInteger.get()]
            if (randomInstance.isActive) {
                return randomInstance
            }
        } while (true)
    }
}
