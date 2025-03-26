package function


class Lec14 {
}

fun main() {
  var num = 5
  num += 1
  val plusOne: () -> Unit = { num += 1 }
}

/**
 * 고차 함수 결론
 * 1. 고차 함수를 사용하게 되면 FunctionN 클래스가 만들어지고
 *    인스턴스화 되어야 하므로 오버헤드가 발생할 수 있다.
 *
 * 2. 함수에서 변수를 포획할경우 (Closure), 해당 변수를 Ref 객체로 감싸야한다 -> 오버헤드 발생.
 */

