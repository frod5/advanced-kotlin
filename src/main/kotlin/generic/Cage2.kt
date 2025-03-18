package generic

// generic은 기본적으로 무공변(불공변) -> 타입파라미터끼리는 상속관계여도, 제네릭에서는 상속관계 X
// 공변 -> 타입파라미터의 상속관계가 제네릭에서도 유지되는것.
// 반공변 -> 상속관계가 반대로 변경 부모 -> 자식

fun main() {
  val cage = Cage2<Carp>()
  cage.put(Carp("잉어"))
  val carp: Carp = cage.getFirst() // generic 사용으로 오류 해결

  val fish = Cage2<Fish>()

  val goldFish = Cage2<GoldFish>()
  goldFish.put(GoldFish("금붕어"))
  goldFish.moveTo(fish)

//  fish.moveFrom(goldFish)

//  val fishData = fish.getFirst()

//  val fish2 = Cage2() // 코틀린에덧 rawType 불가

}

class Cage2<T : Any> { // Any -> non-null 타입으로 지정
  private val animals: MutableList<T> = mutableListOf()

  fun getFirst(): T {
    return animals.first()
  }

  fun put(animal: T) {
    this.animals.add(animal)
  }

  // out 공변으로 변경
  // out을 붙이게되면, otherCage에서 데이터를 꺼낼 수 만 있다.
  // java -> ? extend T
  fun moveFrom(otherCage: Cage2<out T>) {
    otherCage.getFirst()
//    otherCage.put() 넣는 함수 사용 X
    this.animals.addAll(otherCage.animals)
  }

  //반공변
  //in을 붙이면 otherCage는 데이터를 받을 수만 있다.
  // java -> ? super T
  fun moveTo(otherCage: Cage2<in T>) {
    otherCage.animals.addAll(this.animals)
  }
}
