package generic

fun main() {
  val cage = Cage5<Bird>(mutableListOf(Eagle(), Sparrow()))
  cage.printAfterSorting()
}

abstract class Bird(
  name: String,
  private val size: Int,
) : Animal(name), Comparable<Bird> {
  override fun compareTo(other: Bird): Int {
    return this.size.compareTo(other.size)
  }
}

class Sparrow : Bird("참새", 100)
class Eagle : Bird("독수리", 500)


class Cage5<T>(
  private val animals: MutableList<T> = mutableListOf(),
) where T : Animal, T : Comparable<T> { // 제네릭 제약조건 -> Animal을 하위, Comparable 구현 타입

  fun printAfterSorting() {
    this.animals.sorted()
      .map { it.name }
      .let { println(it) }
  }

  fun getFirst(): T {
    return animals.first()
  }

  fun put(animal: T) {
    this.animals.add(animal)
  }

  fun moveFrom(otherCage: Cage5<T>) {
    this.animals.addAll(otherCage.animals)
  }

  fun moveTo(otherCage: Cage5<T>) {
    otherCage.animals.addAll(this.animals)
  }
}

fun <T> List<T>.hasIntersection(other: List<T>): Boolean {
  return (this.toSet() intersect other.toSet()).isNotEmpty()
}

