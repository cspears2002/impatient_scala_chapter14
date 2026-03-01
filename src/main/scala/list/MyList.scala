package list

case class MyList[T](list: List[T]):
  def isEmpty: Boolean = list.isEmpty
  def nonEmpty: Boolean = list.nonEmpty
  def head: Option[T] = list.headOption
  def tail: List[T] = list.drop(1)
