package list

case class MyList[T](list: List[T]):
  def isEmpty: Boolean = list.isEmpty
  def nonEmpty: Boolean = list.nonEmpty
  def head: Option[T] = list.headOption
  def tail: List[T] = list.drop(1)
  def length: Int = list.length
  def map[B](f: T => B): MyList[B] = MyList(list.map(f))

  // Prepend element
  def ::(elem: T): MyList[T] = MyList(elem::list)
  def ::(elem: MyList[T]): MyList[Any] = MyList(elem::list)

  // Append element
  def :+(elem: T): MyList[T] = MyList(list :+ elem)
  def ++(elem: MyList[T]): MyList[T] = MyList(list ++ elem.list)
