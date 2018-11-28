package eu.plumbr;

import java.util.stream.LongStream;

public class JavaStream {

  public long extractStart(long l1, long l2, long l3) {
    return LongStream.of(l1, l2, l3)
        .filter(v -> v > 0)
        .min()
        .orElse(0);
  }

}
