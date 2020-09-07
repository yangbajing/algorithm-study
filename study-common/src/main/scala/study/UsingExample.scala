package study

import java.io.{ BufferedReader, FileReader }
import scala.util.{ Try, Using }

object UsingExample {
  val lines: Seq[String] =
    Using.resource(new BufferedReader(new FileReader("file.txt"))) { reader =>
      Iterator.continually(reader.readLine()).takeWhile(_ != null).toSeq
    }

  val lines1: Try[Seq[String]] = Using.Manager { use: Using.Manager =>
    val r1 = use(new BufferedReader(new FileReader("file1.txt")))
    val r2 = use(new BufferedReader(new FileReader("file2.txt")))
    val r3 = use(new BufferedReader(new FileReader("file3.txt")))
    val r4 = use(new BufferedReader(new FileReader("file4.txt")))

    // use your resources here
    def lines(reader: BufferedReader): Iterator[String] =
      Iterator.continually(reader.readLine()).takeWhile(_ != null)

    (lines(r1) ++ lines(r2) ++ lines(r3) ++ lines(r4)).toList
  }
}
