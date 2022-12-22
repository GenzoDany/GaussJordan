
package org.utils

import org.engine.Matrix2D


trait Reader {
  def getMatrix(path: String): Matrix2D = {
    val file = scala.io.Source.fromFile(path)

    file.getLines.toList map {
      _.split(",").toList map {
        _.toDouble
      }
    }
  }
}
