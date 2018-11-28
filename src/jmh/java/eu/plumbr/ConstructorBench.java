package eu.plumbr;

import eu.plumbr.DynamicGroovy;
import eu.plumbr.MainJava;
import eu.plumbr.StaticGroovy;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

public class ConstructorBench {

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public MainJava initJava() {
    return new MainJava();
  }

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public StaticGroovy initStaticGroovy() {
    return new StaticGroovy();
  }

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public DynamicGroovy initDynamicGroovy() {
    return new DynamicGroovy();
  }
}
