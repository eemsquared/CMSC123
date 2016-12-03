package HashTable;

/**
 * Created by mmcalvarez on 12/3/2016.
 */
public class MyIntMul extends MyInt{

    private static final int a = (int) 2654435769L;
    private static final int m = (int) Math.pow(2, 14);

    public MyIntMul(int val) {
        super(val);
    }

    @Override
    public int hashCode() {
        val = m * ((val * a) % 1);
        return super.hashCode();
    }
}
