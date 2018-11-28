package eu.plumbr

import groovy.transform.CompileStatic
import java.util.stream.LongStream

@CompileStatic
class StaticGroovyStream {

  public long extractStart(long l1, long l2, long l3) {
    LongStream.of(l1, l2, l3)
        .filter { it > 0 }
        .min()
        .orElse(0)
  }
}
