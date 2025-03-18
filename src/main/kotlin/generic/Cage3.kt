package generic

fun main() {
  val fishCage = Cage3<Fish>()
  val animalCage: Cage3<Animal> = fishCage
}


//생산만 하는 클래스
//클래스 자체 공변하도록
//클래스 자체 공변은 자바에는 없다.
class Cage3<out T> {
  private val animals: MutableList<T> = mutableListOf()

  fun getFirst(): T {
    return this.animals.first()
  }

  fun getAll(): List<T> {
    return this.animals
  }
}
