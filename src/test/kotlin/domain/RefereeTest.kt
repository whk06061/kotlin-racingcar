package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RefereeTest {
    @Test
    fun `c의 이동거리가 가장 길 때 우승자는 c이다`() {

        // when
        val a = Car("a", 0)
        val b = Car("b", 1)
        val c = Car("c", 2)
        val actual: List<String> = Referee.calculateWinner(listOf(a, b, c))

        // then
        assertThat(actual).containsOnly("c")
    }

    @Test
    fun `a와 b의 이동거리가 가장 길 때 우승자는 a와 b이다`() {

        // when
        val a = Car("a", 3)
        val b = Car("b", 3)
        val c = Car("c", 2)
        val actual: List<String> = Referee.calculateWinner(listOf(a, b, c))

        // then
        assertThat(actual).containsOnly("a", "b")
    }
}
