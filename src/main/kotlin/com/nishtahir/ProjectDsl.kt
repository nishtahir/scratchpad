package com.nishtahir

@DslMarker
annotation class ProjectDsl

@ProjectDsl
class ProjectBuilder(var name: String = "", var description: String = "") {

    var extensions: List<Extension> = emptyList()
    var dependencies: List<Dependency> = emptyList()

    fun extensions(builder: ExtensionsBuilder.() -> Unit) {
        extensions = ExtensionsBuilder().apply(builder).build()
    }

    fun dependencies(builder: DependenciesBuilder.() -> Unit) {
        dependencies = DependenciesBuilder().apply(builder).build()
    }

    fun build() {
        Project(extensions = extensions, dependencies = dependencies)
    }

}

@ProjectDsl
class ExtensionsBuilder(private val extensions: MutableList<Extension> = mutableListOf()) {

    fun build(): List<Extension> = extensions

    fun <T> create(action: (ExtensionContext) -> Unit) {
        extensions.add(Extension(action))
    }
}

@ProjectDsl
class DependenciesBuilder(private val dependencies: MutableList<Dependency> = mutableListOf()) {

    fun implementation(name: String) {
        dependencies.add(Dependency(name))
    }

    fun build(): List<Dependency> = dependencies.toList()

}


fun project(param: ProjectBuilder.() -> Unit) {
    ProjectBuilder().apply(param).build()
}


data class Project(val extensions: List<Extension>, val dependencies: List<Dependency>)
data class Extension(val action: (ExtensionContext) -> Unit)
data class Dependency(val name: String)

abstract class ExtensionContext
class TestExtension : ExtensionContext()


fun builderTest() {
    project {

        name = "TestProject"
        description = "Test Description"

        extensions {

            create<TestExtension> {
                println("Extension")
            }

        }

        dependencies {
            implementation("org.jetbrains.kotlin")
        }

    }

}