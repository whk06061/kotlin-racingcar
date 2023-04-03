import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class CarTest {
    @Test
    fun `자동차는 이름을 가진다`() {
        assertDoesNotThrow {
            Car("aaa")
        }
    }
}
