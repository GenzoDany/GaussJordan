
package org.utils


trait Reader {
  def getMatrix(path: String): List[List[Double]] = {
    val file = scala.io.Source.fromFile(path)

    file.getLines.toList map {
      _.split(",").toList map {
        _.toDouble
      }
    }
  }
}
