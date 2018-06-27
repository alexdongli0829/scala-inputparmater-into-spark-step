import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

/**
 * 统计字符出现次数
 */
object WordCount {
  def main(args: Array[String]) {
    if (args.length < 1) {
      System.err.println("Usage: <file>")
      System.exit(1)
    }

    val conf = new SparkConf()
    val sc = new SparkContext(conf)
    val line = sc.textFile(args(0))

    val test1 = sys.env.get("PASSWORD")
    println(test1.getOrElse("test1 failed"))

    val test2 = sc.getConf.getOption("spark.test.password")
    println(test2.getOrElse("test2 failed"))

    line.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_+_).collect().foreach(println)

    sc.stop()
  }
}
