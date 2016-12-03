package HashTable;

import java.util.Random;

/**
 * Created by mmcalvarez on 12/3/2016.
 */
public class MyIntUniv extends MyInt{
    private static final Random rand = new Random();
    private static final int a = rand.nextInt();
    private static final int b = rand.nextInt();


    public MyIntUniv(int val) {
        super(val);
    }

    @Override
    public int hashCode() {
        val = (((a * b) + val) % 31) % 1;
        return super.hashCode();
    }
}
