package MP4;

/**
 * Created by mmcalvarez on 11/27/2016.
 */

import java.util.LinkedList;
import java.util.Queue;

public class QueueAgenda extends Agenda {
    private Queue<Square> queue;

    public QueueAgenda() {
        super(QueueAgenda.class);
        queue = new LinkedList<>();
    }

    @Override
    public void add(Square s) {
        queue.add(s);
    }

    @Override
    public Square remove() {
        if(queue.isEmpty()){
            return null;
        }else{
            return queue.remove();
        }
    }

    @Override
    public int size() {
        return queue.size();
    }
}