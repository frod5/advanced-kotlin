package delegate

import kotlin.properties.Delegates
import kotlin.properties.PropertyDelegateProvider
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

//by -> 위임객체에 getValue, setValue가 있어야 한다.
class Person3 {
  val name: String by LazyInitProperty {
    Thread.sleep(2_000)
    "김수한무"
  }

  //ReadOnlyProperty 익명 클래스로 구현.
  val status: String by object : ReadOnlyProperty<Person3, String> {
    private var isGreen: Boolean = false
    override fun getValue(thisRef: Person3, property: KProperty<*>): String {
      return if (isGreen) {
        isGreen = false
        "Happy"
      } else {
        isGreen = true
        "Sad"
      }
    }
  }
}

class LazyInitProperty<T>(val init: () -> T): ReadOnlyProperty<Any, T> {
  private var _value: T? = null
  private val value: T
    get() {
      if (_value == null) {
        this._value = init()
      }
      return _value!!
    }

  //ReadOnlyProperty의 getValue 구현
  override fun getValue(thisRef: Any, property: KProperty<*>): T {
    return value
  }
}

class Person4 {
  // 값이 변경할떄 onChange를 호출해준다.
  var age: Int by Delegates.observable(20) { _, oldValue, newValue ->
    println("이전 값 : ${oldValue} 새로운 값 : ${newValue}")
  }
}

fun main() {
  Person5()
}

class Person5 {
  val name by DelegateProvider("최태현")
  val country by DelegateProvider("한국")
}

//위임객체를 제공하는 인터페이스 사용
class DelegateProvider(
  private val initValue: String
) : PropertyDelegateProvider<Any, DelegateProperty> {
  override fun provideDelegate(thisRef: Any, property: KProperty<*>): DelegateProperty {
    if (property.name != "name") {
      throw IllegalArgumentException("${property.name}은 안되요! name만 연결 가능합니다!")
    }
    return DelegateProperty(initValue)
  }
}

class DelegateProperty(
  private val initValue: String,
) : ReadOnlyProperty<Any, String> {
  override fun getValue(thisRef: Any, property: KProperty<*>): String {
    return initValue
  }
}


interface Fruit {
  val name: String
  val color: String
  fun bite()
}

open class Apple : Fruit {
  override val name: String
    get() = "사과"
  override val color: String
    get() = "빨간색"
  override fun bite() {
    print("사과 톡톡~ 아삭~")
  }
}

class GreenApple : Fruit {
  override val name: String
    get() = "사과"
  override val color: String
    get() = "초록색"

  override fun bite() {
    print("사과 톡톡~ 아삭~")
  }
}

class GreenApple2 : Apple() {
  override val color: String
    get() = "초록색"
}


//위임 클래스
class GreenApple3(
  private val apple: Apple
) : Fruit by apple {
  override val color: String
    get() = "초록색"
}
