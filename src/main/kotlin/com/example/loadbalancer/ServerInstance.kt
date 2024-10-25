package com.example.loadbalancer

class ServerInstance(
    var url: String,
    var port: Int,
) {
    var isActive: Boolean = true
}
