package demo

import java.util.concurrent.atomic.AtomicReference
import java.util.concurrent.{ CountDownLatch, Executors, TimeUnit }

import scala.util.Try

/**
 * @author Yang Jing <a href="mailto:yang.xunjing@qq.com">yangbajing</a>
 * @date 2020-11-09 14:41:51
 */
object Single {
  val countDownLatch = new CountDownLatch(1)
  private val executorService = Executors.newSingleThreadScheduledExecutor()

  executorService.scheduleAtFixedRate(() => {
    Try {
      println("running begin")
      countDownLatch.countDown()
      println("running end")
    }
  }, 0, 3, TimeUnit.SECONDS)

  val value = new AtomicReference[String]()

  countDownLatch.await()
  println("start")
}

object StaticCode {
  def main(args: Array[String]): Unit = {
    println(Single.value.get())
//    Single.countDownLatch.await()
  }
}
