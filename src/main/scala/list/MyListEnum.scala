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

  def append[U >: T](other: MyListEnum[U]): MyListEnum[U] = this match
    case Empty => other
    case NonEmpty(h, t) => NonEmpty(h, t.append(other))

  def map[R](f: T => R): MyListEnum[R] = this match
    case Empty => Empty
    case NonEmpty(h, t) => NonEmpty(f(h), t.map(f))