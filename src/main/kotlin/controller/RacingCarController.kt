package controller

import domain.RacingCarManager
import domain.RandomNumberGenerator
import view.InputView
import view.OutputView

class RacingCarController {

    private val racingCarManager = RacingCarManager(RandomNumberGenerator(), InputView::readCarNames, InputView::readTryCount)

    fun play() {
        val winners = racingCarManager.play(OutputView::printCarsDistance)
        OutputView.printFinalWinners(winners)
    }
}
