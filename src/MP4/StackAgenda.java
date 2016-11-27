package MP4;

/**
 * Created by mmcalvarez on 11/27/2016.
 */

import java.util.Stack;

public class StackAgenda extends Agenda {
    private Stack<Square> stack;

    public StackAgenda() {
        super(StackAgenda.class);
        stack = new Stack<>();
    }

    @Override
    public void add(Square s) {
        stack.push(s);
    }

    @Override
    public Square remove() {
        if(stack.empty()){
            return null;
        }else{
            return stack.pop();
        }
    }

    @Override
    public int size() {
        return stack.size();
    }
}