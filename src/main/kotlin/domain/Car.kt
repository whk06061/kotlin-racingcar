package domain

private const val MINIMUM_MOVE_VALUE = 4

class Car(val name: String) {
    var distance: Int = 0

    fun move(value: Int) {
        if (value >= MINIMUM_MOVE_VALUE) {
            distance ++
        }
    }
}
