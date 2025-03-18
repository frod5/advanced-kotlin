package generic

fun main() {
  val cage: Cage = Cage()
  cage.put(Carp("잉어"))
  val carp: Carp = cage.getFirst() as? Carp?: throw IllegalArgumentException() // 여전히 다른 타입을 넣으면 예외발생
}

class Cage {
  private val animals: MutableList<Animal> = mutableListOf()

  fun getFirst(): Animal {
    return animals.first()
  }

  fun put(animal: Animal) {
    this.animals.add(animal)
  }

  fun moveFrom(cage: Cage) {
    this.animals.addAll(cage.animals)
  }
}
