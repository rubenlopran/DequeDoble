package org.queue;

import org.junit.jupiter.api.Test;

import java.util.Deque;

import static org.junit.jupiter.api.Assertions.*;

public class DequeNodeTest<T> {

    private T item;
    private DequeNode<T> next ;
    private DequeNode<T> previous;
    private DequeNode<T> node;

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
        assertTrue(node.isFirstNode());
    }

    @Test
    public void checkFirstNodeNotEmpty(){
         node= new DequeNode<>(item,next,null);
        assertTrue(node.isFirstNode());
    }

    @Test
    public void checkIsLastNodeEmpty(){
         node= new DequeNode<>(null,null,null);
        assertTrue(node.isLastNode());
    }

    @Test
    public void checkIsLastNodeNotEmpty(){
         node= new DequeNode<>(item,null,previous);
        assertTrue(node.isLastNode());
    }

    @Test
    public void checkIsNotATerminalNode(){
         node= new DequeNode<>(item,next,previous);
        assertFalse(node.isNotATerminalNode());
    }

    @Test
    public void checkIsNotATerminalNodeEmpty(){
         node= new DequeNode<>(null,null,null);
        assertFalse(node.isNotATerminalNode());
    }

    @Test
    public void checkIsNotATerminalNodeOneElement(){
         node= new DequeNode<>(item,next,null);
        assertFalse(node.isNotATerminalNode());
    }


}
