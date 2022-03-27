package org.queue;

import org.junit.jupiter.api.Test;

import java.util.Deque;

import static org.junit.jupiter.api.Assertions.*;

class DequeNodeTest<T> {

    //Según las capturas de sonarqube he quitado las declaraciones 'public' y funciona de forma correcta.
    private T item;
    private DequeNode<T> next ;
    private DequeNode<T> previous;
    private DequeNode<T> node;

    @Test
    void checkGetPrevious(){
        node= new DequeNode<>(item,next,previous);
        assertEquals(previous,node.getPrevious());
    }

    @Test
    void checkGetNext(){
        node= new DequeNode<>(item,next,previous);
        assertEquals(next,node.getNext());
    }

    @Test
    void checkGetItem(){
        node= new DequeNode<>(item,next,previous);
        assertEquals(item,node.getItem());
    }

    @Test
    void checkFirstNodeEmpty(){
         node= new DequeNode<>(null,null,null);
        assertTrue(node.isFirstNode());
    }

    @Test
    void checkFirstNodeNotEmpty(){
         node= new DequeNode<>(item,next,null);
        assertTrue(node.isFirstNode());
    }

    @Test
    void checkIsLastNodeEmpty(){
         node= new DequeNode<>(null,null,null);
        assertTrue(node.isLastNode());
    }

    @Test
    void checkIsLastNodeNotEmpty(){
         node= new DequeNode<>(item,null,previous);
        assertTrue(node.isLastNode());
    }

    @Test
    void checkIsNotATerminalNode(){
         node= new DequeNode<>(item,next,previous);
        assertFalse(node.isNotATerminalNode());
    }

    @Test
    void checkIsNotATerminalNodeEmpty(){
         node= new DequeNode<>(null,null,null);
        assertFalse(node.isNotATerminalNode());
    }

    @Test
    void checkIsNotATerminalNodeOneElement(){
         node= new DequeNode<>(item,next,null);
        assertFalse(node.isNotATerminalNode());
    }


    @Test
    void checkSetNext(){
        node= new DequeNode<>(item,next,previous);
        DequeNode<T> check = null;
        DequeNode<T> node1 = new DequeNode<>(item,check,previous);
        node.setNext(check);
        assertEquals(node.getNext(),node1.getNext());
    }

    @Test
    void checkSetPrevious(){
        node= new DequeNode<>(item,next,previous);
        DequeNode<T> check = null;
        DequeNode<T> node1 = new DequeNode<>(item,next,check);
        node.setPrevious(check);
        assertEquals(node.getPrevious(),node1.getPrevious());
    }

    @Test
    void checkSetItem(){
        node=new DequeNode<>(null,null,null);
        node.setItem(item);
        assertEquals(item,node.getItem());
    }

}
