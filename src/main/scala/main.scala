
import java.io.File

@main
def main(): Unit = {
  val srcPath = File(System.getenv("JAVA_HOME") + "/src")
  val files: List[File] = FileFinder.findFilesInDirectoryTree(srcPath)
  val javaFiles: List[File] = files.filter(_.getPath.endsWith(".java"))
  println(javaFiles)
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

