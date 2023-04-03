package domain

import io.kotest.matchers.throwable.shouldHaveMessage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class CarTest {
    @Test
    fun `자동차는 이름으로 생성한다`() {
        assertDoesNotThrow {
            Car("aaa")
        }
    }

    @Test
    fun `자동차 이름이 5글자를 초과하면 오류가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Car("aaaaaa")
        }.shouldHaveMessage("이름은 다섯글자를 초과하면 안됩니다.")
    }

    @Test
    fun `자동차의 초기 전진상태는 0이다`() {
        // given
        val car = Car("aaa")

        // then
        assertThat(car.distance).isEqualTo(0)
    }

    @Test
    fun `값이 4이상이면 전진한다`() {
        // given
        val car = Car("aaa")

        // when
        car.move(4)

        // then
        assertThat(car.distance).isEqualTo(1)
    }

    @Test
    fun `값이 4미만이면 전진하지 않는다`() {
        // given
        val car = Car("aaa")

        // when
        car.move(3)

        // then
        assertThat(car.distance).isEqualTo(0)
    }
}
