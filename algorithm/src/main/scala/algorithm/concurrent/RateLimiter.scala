package algorithm.concurrent

import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.{ Executors, TimeUnit }

import com.typesafe.scalalogging.StrictLogging

/**
 * @author Yang Jing <a href="mailto:yang.xunjing@qq.com">yangbajing</a>
 * @date 2020-10-23 15:34:11
 */
class RateLimiter(val permitsPerSecond: Int) extends StrictLogging {
  val period = 50
  private val scheduler = Executors.newScheduledThreadPool(2)
  private val tokens = new AtomicInteger(0)
  private val permitsPerDur = permitsPerSecond / period
  private val extPermitsPerDur = permitsPerSecond % period

  if (permitsPerDur > 0) {
    logger.info(s"The permitsPerDur is $permitsPerDur")
    scheduler.scheduleAtFixedRate(() => pushBucket(permitsPerDur), period, period, TimeUnit.MILLISECONDS)
  }
  if (extPermitsPerDur > 0) {
    logger.info(s"The extPermitsPerDur is $extPermitsPerDur")
    scheduler.scheduleAtFixedRate(() => pushBucket(extPermitsPerDur), 1, 1, TimeUnit.SECONDS)
  }

  def pushBucket(needValue: Int): Unit = {
    if (tokens.get() >= permitsPerSecond) {
      return
    }

    var complete = false
    while (!complete) {
      val cur = tokens.get()
      var value = cur + needValue
      if (value > permitsPerSecond) {
        value = permitsPerSecond
      }
      complete = tokens.compareAndSet(cur, value)
//      logger.info(s"Set tokens current $cur to $value, $complete.")
    }
  }

  def acquire(): Boolean = acquire(1)
  def acquire(permits: Int): Boolean = {
    var complete = false
    while (!complete) {
      val cur = tokens.get()
      if (cur >= permits) {
        complete = tokens.compareAndSet(cur, cur - permits)
      }
    }

    true
  }

  def tryAcquire(permits: Int): Boolean = {
    val cur = tokens.get()
    cur >= permits && tokens.compareAndSet(cur, cur - permits)
  }
}
