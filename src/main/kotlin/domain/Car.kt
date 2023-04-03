package domain

private const val MINIMUM_MOVE_VALUE = 4
private const val NAME_LENGTH_ERROR = "이름은 다섯글자를 초과하면 안됩니다."
private const val MAX_NAME_LENGTH = 5

class Car(val name: String, distance: Int = 0) {
    var distance = distance
        private set

    init {
        require(name.length <= MAX_NAME_LENGTH) { NAME_LENGTH_ERROR }
    }

    fun move(value: Int) {
        if (value >= MINIMUM_MOVE_VALUE) {
            distance++
        }
    }
}
