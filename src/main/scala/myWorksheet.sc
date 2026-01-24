// Problem 2
def swap(tupleOfInts: (Int, Int)): (Int, Int) =
  tupleOfInts match {
    case (a, b) => (b, a)
  }
val newTuple = swap(1, 2)
println(s"The new tuple is $newTuple.")

// Problem 3
def swap2(arrayOfInts: Array[Int]): Array[Int] = {
    arrayOfInts match {
      case Array[Int](a, b, rest*) => Array.concat(Array(b, a), rest.toArray)
      case Array[Int](a) => throw java.lang.IllegalArgumentException("Array needs at least two integers.")
    }
}
val newTuple1 = swap2(Array(1, 2, 3, 4))
print(s"The new tuple is ${newTuple1.mkString("Array(", ", ", ")")}.")
val newTuple2 = swap2(Array(1))
print("The new tuple is %s.".format(newTuple2.mkString("Array(", ", ", ")")))