package algorithm.concurrent

import java.time.{ Instant, LocalTime }

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

/**
 * @author Yang Jing <a href="mailto:yang.xunjing@qq.com">yangbajing</a>
 * @date 2020-10-23 16:38:06
 */
class RateLimiterTest extends AnyWordSpec with Matchers {
  "Rate Limiter" should {
    "first" in {
      val rateLimiter = new RateLimiter(52)

      for (i <- 0 until 10) {
        rateLimiter.tryAcquire(1)
        println(s"${Instant.now()} $i")
      }

      var prev = System.currentTimeMillis()
      for (i <- 0 until 10) {
        val permits = if (i % 2 == 0) 10 else 5
        rateLimiter.acquire(permits)
        val now = System.currentTimeMillis()
        println(s"${now - prev} $i")
        prev = now
      }
    }
  }
}
