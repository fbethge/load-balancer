package com.example.loadbalancer

import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicInteger

@Service
class RoundRobinStrategy(
    val instances: List<ServerInstance>,
) {
    var currentIndex: AtomicInteger = AtomicInteger(-1)

    @Synchronized
    fun getNextServer(): ServerInstance {
        do {
            val nextIndex = (currentIndex.addAndGet(1)) % instances.size
            val nextInstance = instances[nextIndex]
            if (nextInstance.isActive) {
                return nextInstance
            }
        } while (true)
    }
}
