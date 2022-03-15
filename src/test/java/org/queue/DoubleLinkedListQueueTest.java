package org.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListQueueTest<T> {

    private T item;
    private DequeNode<T> next ;
    private DequeNode<T> previous;
    private DequeNode<T> node = new DequeNode<>(item,next,previous);
    private DequeNode<T> first;
    private DequeNode<T> last;
    int size=0;
    private DoubleLinkedListQueue<T>dlink= new DoubleLinkedListQueue<>();

    @Test
    public void checkSizeEmpty(){
        assertEquals(0,dlink.size());
    }

    @Test
    public void checkSize(){
        dlink.append(node);
        DequeNode<T> node1=new DequeNode<>(item,first,previous);
        dlink.append(node1);
        assertEquals(2,dlink.size());
    }


    @Test
    public void checkSizeOne(){
    dlink.append(node);
    assertEquals(1,dlink.size());

    }

    @Test
    public void checkPeekFirst(){
        assertEquals(first,dlink.peekFirst());
    }

    @Test
    public void checkPeekLast(){
        assertEquals(last,dlink.peekLast());
    }

    @Test
    public void checkDeleteLastEmpty(){
        assertThrows(RuntimeException.class,()->dlink.deleteLast());
    }

    @Test
    public void checkDeleteLastSize1(){
        dlink.append(node);
        dlink.deleteLast();
        assertThrows(RuntimeException.class,()->dlink.last.getNext());
    }

    @Test
    public void checkDeleteLast(){
        dlink.append(node);
        DequeNode<T> node1=new DequeNode<>(item,first,previous);
        dlink.append(node1);
        dlink.deleteLast();
        assertEquals(null,node.getNext());
    }

    @Test
    public void checkDeleteFirstEmpty(){
        assertThrows(RuntimeException.class,()->dlink.deleteFirst());
    }

    @Test
    public void checkDeleteFirstSize1(){
        dlink.append(node);
        dlink.deleteFirst();
        assertThrows(RuntimeException.class,()->dlink.last.getPrevious());
    }

    @Test
    public void checkDeleteFirst(){
        dlink.append(node);
        DequeNode<T> node1=new DequeNode<>(item,first,previous);
        dlink.append(node1);
        dlink.deleteFirst();
        assertEquals(null,node.getPrevious());
    }

    @Test
    public void checkAppendLeftSize0(){
        dlink.appendLeft(node);
        assertEquals(dlink.first,dlink.last);
    }

    @Test
    public void checkAppendLeft(){
        dlink.append(node);
        DequeNode<T> node1=new DequeNode<>(item,node.getNext(),node);
        dlink.appendLeft(node1);;
        assertEquals(dlink.first,node1);
    }

    @Test
    public void checkAppendSize0(){
        dlink.append(node);
        assertEquals(dlink.first,dlink.last);
    }

    @Test
    public void checkAppend(){
        dlink.append(node);
        DequeNode<T> node1=new DequeNode<>(item,node.getNext(),node);
        dlink.append(node1);
        DequeNode<T> aux= node1.getPrevious();
        assertEquals(dlink.first,aux);
    }

}
