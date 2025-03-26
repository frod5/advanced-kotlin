package delegate

fun main() {
  val fruits = listOf(
    MyFruit("사과", 1000L),
    MyFruit("바나나", 3000L),
  )

  // 2,000,000 -> 모두 필터링!
  // [과일, 과일 과일, .. ]
  // sequence -> 중간 과정 컬렌션을 만들지 않는다. 속도 Up

  //동작원리
  //1. 각 단계(filter, map)가 모든 원소에 적용되지 않을 수 있다.
  //2. 한 원소에 대해 모든 연산을 수행하고 다음 원소로 넘어간다.
  //3. 최종연산이 나오기 전까지 계산 자체를 미리 하지 않는다.

  //데이터의 건수가 적은 경우, sequence가 더 느릴수도 있다.
  val avg = fruits.asSequence()
    .filter { it.name == "사과" }
    .map { it.price }
    .take(10_000)
    .average()
}

data class MyFruit(
  val name: String,
  val price: Long, // 1,000원부터 20,000원 사이
)
