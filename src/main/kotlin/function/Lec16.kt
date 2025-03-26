package function

/**
 * SAM
 * single abstract method
 * 1개의 추상메소드만 가진 인터페이스 -> SAM 인터페이스
 * java에서는 sam 인터페이스를 람다(자바의 람다)로 인스턴스화 할 수 있다.
 */

fun add(a: Int, b: Int) = a + b

fun main() {

  val add1 = { a: Int, b: Int -> a + b }

  val add2 = fun (a: Int, b: Int) = a + b

  ::add // 호출가능참조

  //KStringFilter { it.startsWith("A") }
}

fun consumeFilter(filter: StringFilter) { }

fun <T> consumeFilter(filter: Filter<T>) {}

// kotlin의 sam 인터페이스
fun interface KStringFilter {
  fun predicate(str: String): Boolean
}
