package function

class Lec15 {
}

fun main() {
  iterate(listOf(1, 2, 3, 4, 5)) { num ->
    if (num == 3) {
      // return // crossinline을 쓰면 사용을 할 수 없다.
    }
    println(num)
  }
}

inline fun iterate(numbers: List<Int>, crossinline exec: (Int) -> Unit) {
  for (num in numbers) {
    exec(num)
  }
}

inline fun repeat(
  times: Int,
  noinline exec: () -> Unit, // noinline 지시어를 붙였다!
) {
  for (i in 1..times) {
    exec()
  }
}

/**
 * 정리
 * 1. inline 함수는 본인만 인라이닝 되는게 아니라, 알 수 있는 함수 파라미티 같이 인라이닝. non-local return 도 사용 가능.
 * 2. inline 함수의 함수 파라미터를 인라이닝 시키고 싶지 않다면 noinline 키워드 사용.
 * 3. inline 함수의 함수 파라미터가 non-local return 사용을 막고 싶다면 crossinline 사용.
 */
