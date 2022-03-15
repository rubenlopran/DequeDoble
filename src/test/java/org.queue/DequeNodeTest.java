package org.queue;

import org.junit.jupiter.api.Test;

import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DequeNodeTest<T> {

    private T item;
    private T next ;
    private T previous;
    private DequeNode node;

    @Test
    public void checkGetPrevious(){
        node= new DequeNode<>(item,next,previous);
        assertEquals(previous,node.getPrevious());
    }

    @Test
    public void checkGetNext(){
        node= new DequeNode<>(item,next,previous);
        assertEquals(next,node.getNext());
    }

    @Test
    public void checkGetItem(){
        node= new DequeNode<>(item,next,previous);
        assertEquals(item,node.getItem());
    }

    @Test
    public void checkFirstNodeEmpty(){
         node= new DequeNode<>(null,null,null);
        assertEquals(true,node.isFirstNode());
    }

    @Test
    public void checkFirstNodeNotEmpty(){
         node= new DequeNode<>(item,next,null);
        assertEquals(true,node.isFirstNode());
    }

    @Test
    public void checkIsLastNodeEmpty(){
         node= new DequeNode<>(null,null,null);
        assertEquals(true,node.isLastNode());
    }

    @Test
    public void checkIsLastNodeNotEmpty(){
         node= new DequeNode<>(item,null,previous);
        assertEquals(true,node.isLastNode());
    }

    @Test
    public void checkIsNotATerminalNode(){
         node= new DequeNode<>(item,next,previous);
        assertEquals(false,node.isNotATerminalNode());
    }

    @Test
    public void checkIsNotATerminalNodeEmpty(){
         node= new DequeNode<>(null,null,null);
        assertEquals(false,node.isNotATerminalNode());
    }

    @Test
    public void checkIsNotATerminalNodeOneElement(){
         node= new DequeNode<>(item,next,null);
        assertEquals(false,node.isNotATerminalNode());
    }


}
