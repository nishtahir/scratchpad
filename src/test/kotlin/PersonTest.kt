import assertk.Assert
import assertk.all
import assertk.assert
import assertk.assertAll
import assertk.assertions.*
import assertk.assertions.support.expected
import org.junit.Test
import kotlin.reflect.KProperty1

data class Person(val name: String, val age: Int, val email: String = "")

class PersonTest {
    val person = Person(name = "Bob", age = 18)
    val person2 = Person(name = "Bill", age = 22)


    @Test
    fun testName() {
        assert("").all {

        }
        assert(person.name).prop(Person::name).isEqualTo("")

        val subject = mapOf("one" to "")
        assert(subject).key("one") {
            it.isEqualTo("")
        }

        val map = mapOf("one" to 1, "two" to 2, "three" to 3)
        assert(map).all {
            contains("one" to 1)
            doesNotContain("four" to 4)
            containsExactly("one" to 1, "two" to 2, "three" to 3)
            containsAll("two" to 2)
        }

        assert(map).key("one") {
            it.isEqualTo(1)
        }
        assert(person).isEqualToWithGivenProperties(person2, Person::name)
    }

    @Test
    fun testAge() {
        assert(person).all {
            hasValidName()
            hasValidEmail()
        }

//        assert(person.age, "age").isGreaterThan(15)
    }

    @Test
    fun testFruit() {
        val fruits = listOf("orange", "pineapple", "banana", "pear")
        assert(fruits, "name").all {
            contains("banana")
            doesNotContain("apple")
            hasSize(4)
        }

        assert(fruits).containsNone("orange", "pineapple")
    }
}


fun Assert<Person>.hasValidName() {
    if (actual.name.isNotBlank()) return
    expected("Name must not be blank")
}

fun Assert<Person>.hasValidEmail() {
    if (actual.email.isNotBlank()) return
    expected("Email must not be blank")
}