package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomNumberGeneratorTest {
    @Test
    fun `랜덤값 생성기는 0에서 9사이의 랜덤값을 생성한다`() {
        val randomNumberGenerator = RandomNumberGenerator()
        repeat(10) {
            val actual = randomNumberGenerator.generate()
            assertThat(actual).isGreaterThan(-1).isLessThan(10)
        }
    }
}
