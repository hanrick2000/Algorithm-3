package probability;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedReservoirSampling {
  private final int k;
  private int count;
  private List<Integer> sample;

  public GeneralizedReservoirSampling(int k) {
    // we need to sample k elements instead of just one element.
    // usually we will need this validation in the constructor.
    if (k < 0) {
      throw new IllegalArgumentException("k must be > 0");
    }
    this.k = k;
    this.count = 0;
    sample = new ArrayList<Integer>();
  }

  public void read(int value) {
    count++;
    if (count <= k) {
      // for the first k elements, we just add them into the sample list.
      sample.add(value);
    } else {
      int random = (int) (Math.random() * count);
      // for the recent read element, it should have the probability of
      // k / count to be as one of the samples.
      if (random < k) {
        // replace the sample at the corresponding position.
        sample.set(random, value);
      }
    }
  }

  public List<Integer> sample() {
    return sample;
  }
}
