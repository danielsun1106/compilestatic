package eu.plumbr;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class StreamBench {

  private long l1 = ThreadLocalRandom.current().nextLong();
  private long l2 = ThreadLocalRandom.current().nextLong();
  private long l3 = ThreadLocalRandom.current().nextLong();

  private JavaStream javaStream = new JavaStream();
  private StaticGroovyStream staticGroovyStream = new StaticGroovyStream();
  private DynamicGroovyStream dynamicGroovyStream = new DynamicGroovyStream();

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public double javaStream() {
    return javaStream.extractStart(l1++, l2--, l3++);
  }

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public double dynamicGroovyStream() {
    return dynamicGroovyStream.extractStart(l1++, l2--, l3++);
  }

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public double staticGroovyStream() {
    return staticGroovyStream.extractStart(l1++, l2--, l3++);
  }

}
