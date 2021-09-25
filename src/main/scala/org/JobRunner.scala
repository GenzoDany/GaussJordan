
package org

import com.typesafe.scalalogging.LazyLogging
import org.engine.GaussJordan
import org.utils.Reader

trait JobRunnerTrait extends LazyLogging with Reader {

    def main(args: Array[String]): Unit = {

        val matrix = getMatrix(args.head)
        val r = new GaussJordan(matrix)()
        r

    }
}

object JobRunner extends JobRunnerTrait
