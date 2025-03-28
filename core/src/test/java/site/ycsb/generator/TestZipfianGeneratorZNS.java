package site.ycsb.generator;

import org.testng.annotations.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Random;

import static org.testng.AssertJUnit.assertFalse;

public class TestZipfianGeneratorZNS {

  @Test
  public void Run() throws IOException {

//    final int zone_size = 1077 * 1024 * 1024;
//    final int num_zones = 100;
    final int zone_size = 1077 * 1024 * 1024;
    final int num_zones = 100;

    final String directory = "./target/workloads/";
    final Workload[] workloads = {
        new Workload((int) Math.pow(2, 16), 40632, 49_152_000, 8, 16, "ZN_EVICT_PROMOTE_ZONE"),
        new Workload((int) Math.pow(2, 29), 5413781, 6_000, 8, 16, "ZN_EVICT_PROMOTE_ZONE"),
    };

    final int[] workingSetRatios = new int[]{10, 2, 1};

    for (Workload w : workloads) {
        for(distributionType distributionType : distributionType.values()) {
          for (int workingSetRatio : workingSetRatios) {
            ZipfianWorkloadGenerator generator = new ZipfianWorkloadGenerator(
                w,
                distributionType,
                workingSetRatio,
                zone_size,
                num_zones,
                directory);

            generator.generateWorkloadFile();
        }
      }
    }
  }
}
