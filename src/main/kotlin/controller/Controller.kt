package controller

import domain.Car
import domain.RandomNumberGenerator
import view.InputView
import view.OutputView

class Controller(private val inputView: InputView, private val outputView: OutputView) {
    fun start() {
        val cars = initializeCars()
        playGame(cars, initializeRoundCount())
        finishGame(cars)
    }

    private fun initializeCars(): List<Car> {
        outputView.printCarNamesPrompt()
        while (true) {
            kotlin.runCatching {
                inputView.readCarNames()
            }.onSuccess { names ->
                return names.map { name ->
                    Car(name, 0)
                }
            }.onFailure { e ->
                println(e.message.toString())
            }
        }
    }

    private fun initializeRoundCount(): Int {
        outputView.printRoundCountPrompt()
        while (true) {
            kotlin.runCatching {
                inputView.readRoundCount()
            }.onSuccess { roundCount ->
                return roundCount
            }.onFailure { e ->
                println(e.message.toString())
            }
        }
    }

    private fun playGame(cars: List<Car>, roundCount: Int) {
        outputView.printRoundResultMessage()
        val generator = RandomNumberGenerator()
        repeat(roundCount) {
            playOneRound(cars, generator)
            outputView.printRoundResult(cars)
        }
    }

    private fun playOneRound(cars: List<Car>, generator: RandomNumberGenerator) {
        cars.forEach { car ->
            car.tryMove(generator)
        }
    }

    private fun finishGame(cars: List<Car>) {
        val maxCount = cars.maxOfOrNull { car ->
            car.getMoveCount()
        }
        val winners = cars.filter { car ->
            car.getMoveCount() == maxCount
        }.map { winner ->
            winner.getName()
        }
        outputView.printWinners(winners)
    }
}
