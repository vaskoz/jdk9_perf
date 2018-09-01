package com.vaskoz;

import org.openjdk.jmh.annotations.*;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class MapsBenchmark {
    private HashMap<Integer, Integer> hm;
    private ConcurrentHashMap<Integer, Integer> chm;

    @Setup
    public void setup() {
        this.hm = new HashMap<>();
        this.chm = new ConcurrentHashMap<>();
    }

    @Benchmark
    public void testHashMap() {
        for (int i = 0; i < 1000; i++) {
            hm.put(i, i+1);
        }
    }

    @Benchmark
    public void testConcurrentHashMap() {
        for (int i = 0; i < 1000; i++) {
            chm.put(i, i+1);
        }
    }
}
