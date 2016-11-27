package MP4;

/**
 * Created by mmcalvarez on 11/27/2016.
 */

public abstract class Agenda {
    private Class agClass;

    protected Agenda(Class agClass) {
        this.agClass = agClass;
    }

    public Agenda newInstance() throws IllegalAccessException, InstantiationException {
        return (Agenda) agClass.newInstance();
    }

    public abstract void add(Square s);

    public abstract Square remove();

    public abstract int size();
}
