package org.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubleLinkedListQueueTest<T> {

    private DequeNode<T> first = null;
    private DequeNode<T> last = null;
    int size=0;
    private DoubleLinkedListQueue<T>dlink;

    @Test
    public void checkSizeEmpty(){
        dlink=new DoubleLinkedListQueue<>();
        assertEquals(0,dlink.size());
    }




}
