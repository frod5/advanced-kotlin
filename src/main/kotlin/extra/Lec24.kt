package extra

import kotlin.system.measureTimeMillis

class Lec24 {
}

fun main() {
  //repeat
  repeat(3) {
    println("hello")
  }

  //TODO
//  TODO("main 함수 구현")

  //measureTimeMillis -> 걸린 시간 측정
  val measureTimeMillis = measureTimeMillis {
    val a = 1
    val b = 2
    val result = a + b
  }

  // runCatching -> Result 객체 사용 가능
  val result: Result<Int> = runCatching { 1 / 0 }
}

fun acceptOnlyTwo(num: Int) {
  //require -> 값 검증, IllegalArgumentException
  require(num == 2) { "2만 허용!" }
}

class Person {
  val status: PersonStatus = PersonStatus.PLAYING

  fun sleep() {
    //require 유사 -> 보통 상태 검증할 때 사용. -> IllegalStateException
    check(this.status == PersonStatus.PLAYING) { "에러 메시지!" }
  }

  enum class PersonStatus {
    PLAYING, SLEEPING
  }
}
