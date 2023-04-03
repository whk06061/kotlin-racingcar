import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class CarTest {
    @Test
    fun `자동차는 이름으로 생성한다`() {
        assertDoesNotThrow {
            Car("aaa")
        }
    }

    @Test
    fun `자동차의 초기 전진상태는 0이다`() {
        // given
        val car = Car("aaa")

        // then
        assertThat(car.distance).isEqualTo(0)
    }
}
