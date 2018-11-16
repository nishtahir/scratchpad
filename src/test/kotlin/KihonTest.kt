import assertk.assertions.isEqualTo
import assertk.assert
import org.junit.Test

class KihonTest {

    @Test
    fun test () {
        assert(Point3(1, 2, 0)).isEqualTo(Point2(1, 2))
    }

}