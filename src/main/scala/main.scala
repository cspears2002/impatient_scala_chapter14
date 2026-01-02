import java.io.File

import scala.io.Source
import scala.util.Using
import scala.util.matching.Regex


@main
def main(): Unit = {
  val srcPath = File(System.getenv("JAVA_HOME") + "/src")
  val files: List[File] = FileFinder.findFilesInDirectoryTree(srcPath)
  val javaFiles: List[File] = files.filter(_.getPath.endsWith(".java"))
  findCaseLabels(javaFiles)
}


def findCaseLabels(myFiles: List[File]): Unit = {
  val casePattern: Regex = """case [^:]+:""".r

  for f <- myFiles do {
    val lines: Array[String] = Using(Source.fromFile(f))(source =>
      source.getLines.toArray).getOrElse(Array.empty[String])
    for ((line, idx) <- lines.zipWithIndex) do {
      if casePattern.findFirstIn(line).isDefined then {
        val nextIdx = idx + 1
        val nextLine = lines(nextIdx)
        if lines(nextIdx).startsWith("//") then println(s"($nextIdx) $nextLine")
      }
    }
  }
}


object FileFinder {
  def findFilesInDirectoryTree(directory: File): List[File] = {
    if (!directory.exists || !directory.isDirectory) {
      List.empty[File]
    } else {
      val files = directory.listFiles.toList
      val (subdirectories, regularFiles) = files.partition(_.isDirectory)
      regularFiles ++ subdirectories.flatMap(findFilesInDirectoryTree)
    }
  }
}

