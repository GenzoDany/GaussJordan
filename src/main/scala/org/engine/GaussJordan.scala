
package org.engine


class GaussJordan(matrix: List[List[Double]]) {

    def apply(matrix: List[List[Double]] = matrix, x: Int = 0, y: Int = 0): List[List[Double]] = {
        if (x < matrix.size) {
            apply(
                matrix.zipWithIndex.map {
                    case (row: List[Double], i: Int) => {
                        if (i == x) {
                            row.map(_ / matrix(x)(y))
                        } else {
                            row.zipWithIndex.map {
                                case (value: Double, j: Int) => {
                                    value - (matrix(i)(y) * (matrix(x)(j) / matrix(x)(y)))
                                }
                            }
                        }
                    }
                }, x + 1, y + 1
            )
        } else {
            matrix
        }
    }
}
