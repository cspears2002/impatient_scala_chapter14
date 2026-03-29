package list

enum MyListEnum[+T]:
  case Empty
  case NonEmpty(head: T, tail: MyListEnum[T])

  def ::[U >: T](element: U): MyListEnum[U] =
    NonEmpty(element, this)

  def length: Int = this match {
    case Empty => 0
    case NonEmpty(_, tail) => 1 + tail.length
  }