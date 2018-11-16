package com.nishtahir

@DslMarker
annotation class ConfigurationDsl

@ConfigurationDsl
class ConfigurationBuilder(
        var provider: String = "",
        var region: String = "",
        var isActive: Boolean = false,
        var fallback: Int = 0,
        var servers: ServersBuilder = ServersBuilder()
) {
    fun build(): Configuration {
        val servers = servers.build()
        return Configuration(provider, region, isActive, fallback, servers)
    }

    fun servers(param: ServersBuilder.() -> Unit): List<Server> {
        return ServersBuilder().apply(param).build()
    }

}

@ConfigurationDsl
class ServersBuilder(
        var servers: MutableList<Server> = mutableListOf()
) {
    fun build(): List<Server> {
        return servers.toList()
    }

    fun server(param: ServerBuilder.() -> Unit) {
        servers.add(ServerBuilder().apply(param).build())
    }
}

@ConfigurationDsl
class ServerBuilder(
        var hostname: String = "",
        var name: String = "",
        var description: String = ""
) {
    fun build(): Server {
        return Server(hostname, name, description)
    }
}

class Server(
        val hostname: String,
        val name: String,
        val description: String
)

class Configuration(
        val provider: String,
        val region: String,
        val isActive: Boolean,
        val fallback: Int,
        val servers: List<Server>
)

fun configuration(param: ConfigurationBuilder.() -> Unit): Configuration {
    return ConfigurationBuilder().apply(param).build()
}

fun main(args: Array<String>) {

    configuration {
        provider = "Google"
        region = "eu-west-1"
        isActive = true
        fallback = 10

        servers {
            server {
                hostname = ""
                name = "persistence1"
                description = "Provides stuff"
            }
        }
    }
}
