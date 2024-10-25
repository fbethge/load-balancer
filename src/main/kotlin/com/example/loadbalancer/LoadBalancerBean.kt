package com.example.loadbalancer

import ch.qos.logback.core.testUtil.RandomUtil
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LoadBalancerBean {
    private val sizeOfBalancers = 5

    @Bean
    fun getServers(): List<ServerInstance> {
        val instances = mutableListOf<ServerInstance>()
        for (i in 0 until sizeOfBalancers) {
            val port = RandomUtil.getRandomServerPort()
            val url = "http://localhost:$port"
            val instance = ServerInstance(url, port)
            instances.add(instance)
        }
        return instances
    }
}
