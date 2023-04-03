package view

import domain.Car

object OutputView {
    fun printCarsDistance(cars: List<Car>) {
        cars.forEach {
            println("${it.name} : ${getDistanceShape(it.distance)}")
        }
    }

    private fun getDistanceShape(distance: Int): String = "-".repeat(distance)

    fun printFinalWinners(names: List<String>) {
        println("최종 우승자 : ${names.joinToString(", ")}")
    }
}
