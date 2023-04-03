package domain

object Referee {

    fun calculateWinner(cars: List<Car>): List<String> {
        val maxDistance = calculateMaxDistance(cars)
        val winnerCars = cars.filter { it.distance == maxDistance }
        return winnerCars.map { it.name }
    }

    private fun calculateMaxDistance(cars: List<Car>): Int {
        var maxDistance = 0
        cars.forEach { if (it.distance > maxDistance) maxDistance = it.distance }
        return maxDistance
    }
}
