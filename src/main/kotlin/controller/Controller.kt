package controller

import domain.Car
import domain.Judgment
import domain.RandomNumberGenerator
import view.InputView
import view.OutputView

class Controller(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val generator: RandomNumberGenerator,
    private val judgment: Judgment
) {
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
                    Car(name)
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
        repeat(roundCount) {
            playOneRound(cars)
            outputView.printRoundResult(cars)
        }
    }

    private fun playOneRound(cars: List<Car>) {
        cars.forEach { car ->
            car.tryMove(generator.generate())
        }
    }

    private fun finishGame(cars: List<Car>) {
        outputView.printWinners(judgment.findWinners(cars))
    }
}
