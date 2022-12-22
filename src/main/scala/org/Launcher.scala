
package org

import com.typesafe.scalalogging.LazyLogging
import org.engine.{GaussJordan, Matrix2D}
import org.utils.Reader

import scala.util.{Failure, Success, Try}

object Launcher extends LazyLogging with Reader {

    def main(args: Array[String]): Unit = {
        Try {
            val matrix: Matrix2D = getMatrix(args.head)
            matrix.printMatrix()
            matrix.resolveGaussJordan()
        } match {
            case Success(responseMatrix: Matrix2D) => {
                responseMatrix.printMatrix()
            }
            case Failure(exception) => exception.printStackTrace()
        }
    }
}

