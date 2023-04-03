package domain

class RacingCarManager(private val numberGenerator: NumberGenerator, private val getCarNames: () -> List<String>, private val getTryCount: () -> Int) {
    private val cars: List<Car>
    private val tryCount: Int

    init {
        cars = initCars()
        tryCount = initTryCount()
    }

    private fun initCars(): List<Car> {
        val carNames = getCarNames()
        return runCatching {
            carNames.map { Car(it) }
        }.onFailure { println(it.message) }.getOrNull() ?: initCars()
    }

    private fun initTryCount(): Int = getTryCount()

    fun play(onPlayOneRound: (List<Car>) -> Unit): List<String> {
        repeat(tryCount) {
            cars.forEach {
                it.move(numberGenerator.generate())
            }
            onPlayOneRound(cars)
        }
        return Referee.calculateWinner(cars)
    }
}
