package domain

private const val MIN_RANDOM_NUMBER = 0
private const val MAX_RANDOM_NUMBER = 9
class RandomNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        return (MIN_RANDOM_NUMBER..MAX_RANDOM_NUMBER).random()
    }
}
