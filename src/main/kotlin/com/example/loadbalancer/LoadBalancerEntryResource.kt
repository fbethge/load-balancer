package com.example.loadbalancer

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/api/v1")
class LoadBalancerEntryResource(
    val roundRobinStrategy: RoundRobinStrategy,
) {
    @GetMapping("/load-balancer")
    fun roundRobinStrategy(): String = roundRobinStrategy.getNextServer().url
}
