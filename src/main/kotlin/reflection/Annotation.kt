package reflection

import kotlin.reflect.KClass

@Repeatable
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Shape(
  val texts: Array<String>
)


//@Repeatable 선언 시 여러 번 사용 가능
@Shape(["C"])
@Shape(["A", "B"])
class Annotation {
}

fun main() {
  val clazz: KClass<Annotation> = Annotation::class
}
