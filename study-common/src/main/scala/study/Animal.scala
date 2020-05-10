package study

sealed trait Animal

class Cat extends Animal {
  def meow(): Unit = println("meow")
}

class Dog extends Animal {
  def woof(): Unit = println("woof")
}

object Animal {
  def perform(animal: Animal): Unit = {
    val func = animal match {
      case cat: Cat => cat.meow _
      case dog: Dog => dog.woof _
    }
    func.apply()
  }

  def main(args: Array[String]): Unit = {
    perform(new Cat())
  }
}
