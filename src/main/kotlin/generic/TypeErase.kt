package generic

// inline -> 코드의 본문을 호출지점으로 이동시켜 컴파일
// reified -> T의 인스턴스를 만들거나, T의 companion object 사용 불가
inline fun <reified T> T.toSuperString() {
  println("${T::class.java.name}: $this")
}

inline fun <reified T> List<*>.hasAnyInstanceOf(): Boolean {
  return this.any { it is T }
}

class TypeErase<T, R, B> {
}

//타입 파라미터 쉐도잉
class CageShadow<T : Animal> {
  // 함수레벨에서 작성하면 클래스레벨에서 작성된것이 덮어씌어짐
  fun <T : Animal> addAnimal(animal: T) {

  }
}


fun main() {
  val cage = CageShadow<GoldFish>()
  cage.addAnimal(GoldFish("금붕어"))
  cage.addAnimal(Carp("잉어"))
}

open class CageV1<T : Animal> {
  open fun addAnimal(animal: T) {

  }
}

class CageV2<T : Animal> : CageV1<T>() {
  override fun addAnimal(animal: T) {
    super.addAnimal(animal)
  }
}

class GoldFishCageV2 : CageV1<GoldFish>() {
  override fun addAnimal(animal: GoldFish) {
    super.addAnimal(animal)
  }
}
