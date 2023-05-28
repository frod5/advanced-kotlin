package generic

fun main() {
  val goldFishCage = Cage2<GoldFish>()
  goldFishCage.put(GoldFish("금붕어"))

  val fishCage = Cage2<Fish>()
  // fishCage.moveFrom(goldFishCage) // Type mismatch
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

class Cage2<T> {
  private val animals: MutableList<T> = mutableListOf()

  fun getFirst(): T {
    return animals.first()
  }

  fun put(animal: T) {
    this.animals.add(animal)
  }

  fun moveFrom(cage: Cage2<T>) {
    this.animals.addAll(cage.animals)
  }
}