
package org

import com.typesafe.scalalogging.LazyLogging


package object engine {

    type Matrix2D = List[List[Double]]

    implicit class GaussJordan(matrix: Matrix2D) extends LazyLogging {

        def resolveGaussJordan(x: Int = 0, y: Int = 0): Matrix2D = {
            if (x < matrix.size) {
                val newMatrix = matrix.zipWithIndex.map {
                    case (row: List[Double], i: Int) => if (i == x) {
                        row.map(_ / matrix(x)(y))
                    } else {
                        row.zipWithIndex.map {
                            case (value: Double, j: Int) => value - (matrix(i)(y) * (matrix(x)(j) / matrix(x)(y)))
                        }
                    }
                }
                newMatrix resolveGaussJordan(x + 1, y + 1)
            } else {
                matrix
            }
        }

        def printMatrix(): Unit = {
            logger.info("--------------------------------------------------------------------")
            matrix foreach { row => logger.info(s"[${row.mkString(", ")}]") }
            logger.info("--------------------------------------------------------------------")
        }
    }
}
