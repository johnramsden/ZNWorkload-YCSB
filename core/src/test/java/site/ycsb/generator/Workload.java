package site.ycsb.generator;

public class Workload {
    public int chunkSize;
    public int latency;
    public int evictThresholdHigh;
    public int evictThresholdLow;
    public int iterations;
    public String evictionType;

    public String toString() {
        return "chunk_size=" + chunkSize +
               ",latency=" + latency +
               ",evict_high=" + evictThresholdHigh +
               ",evict_low=" + evictThresholdLow +
               ",eviction=" + evictionType +
               ",iterations=" + iterations;
    }

    Workload(int chunkSize, int latency, int iterations, int evictThresholdHigh, int evictThresholdLow, String evictionType) {
        this.chunkSize = chunkSize;
        this.latency = latency;
        this.iterations = iterations;
        this.evictThresholdHigh = evictThresholdHigh;
        this.evictThresholdLow = evictThresholdLow;
        this.evictionType = evictionType;
    }
}
