package hw3.hash;

import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        int[] bucket = new int[M];
        for (Oomage o : oomages) {
            int bucketNum = (o.hashCode() & 0x7FFFFFFF) % M;
            bucket[bucketNum]++;
        }
        for (int i = 0; i < M; i++) {
            if (bucket[i] < (oomages.size() / 50) || bucket[i] > (oomages.size() / 2.5)) {
                return false;
            }
        }
        return true;
    }
}
