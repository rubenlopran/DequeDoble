package org.queue;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListQueueTest<T> {

    private T item;
    private T item1;
    private T item2;
    private DequeNode<T> next ;
    private DequeNode<T> previous;
    private DequeNode<T> node = new DequeNode<>(item,next,previous);
    private DequeNode<T> first;
    private DequeNode<T> last;
    int size=0;
    private DoubleLinkedListQueue<T>dlink= new DoubleLinkedListQueue<>();


    Comparator<Integer> comparator=new Comparator<Integer>() {
        @Override
        public int compare(Integer item1, Integer item2) {
            if(item1<item2){
                return 1;
            }else{
                return 0;
            }
        }
    };

    @Test
    public void checkSizeEmpty(){
        assertEquals(0,dlink.size());
    }

    @Test
    public void checkSize(){
        dlink.append(node);
        DequeNode<T> node1=new DequeNode<>(item1,null,node);
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
    public void checkPeekFirst2Nodes(){
        dlink.append(node);
        DequeNode<T> node1=new DequeNode<>(item1,null,node);
        dlink.append(node1);
        assertEquals(node,dlink.peekFirst());
    }


    @Test
    public void checkPeekLast(){
        assertEquals(last,dlink.peekLast());
    }

    @Test
    public void checkPeekLast2Nodes(){
        dlink.append(node);
        DequeNode<T> node1=new DequeNode<>(item1,null,node);
        dlink.append(node1);
        assertEquals(node1,dlink.peekLast());
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
        DequeNode<T> node1=new DequeNode<>(item1,null,node);
        dlink.append(node1);
        dlink.deleteLast();
        assertNull(node.getNext());
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
        DequeNode<T> node1=new DequeNode<>(item1,null,node);
        dlink.append(node1);
        dlink.deleteFirst();
        assertNull(node.getPrevious());
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
        dlink.appendLeft(node1);
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

    //Segunda parte testing Operaciones complejas

    @Test
    public void checkgetAtSize0(){
        assertThrows(RuntimeException.class,()->dlink.getAt(4));
    }

    @Test
    public void checkgetAtBadIndex(){
        dlink.append(node);
        assertThrows(RuntimeException.class,()->dlink.getAt(2));
    }

    @Test
    public void checkgetAt(){
        dlink.append(node);
        DequeNode<T> node1=new DequeNode<>(item,null,node);
        dlink.append(node1);
        assertEquals(node1,dlink.getAt(2));
    }

    @Test
    public void checkgetAtNegativeIndex(){
        dlink.append(node);
        assertThrows(RuntimeException.class,()->dlink.getAt(-1));
    }

    @Test
    public void checkgetAt0Index(){
        dlink.append(node);
        assertThrows(RuntimeException.class,()->dlink.getAt(0));
    }

    @Test
    public void checkFind(){
        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>();
        DequeNode<Integer> n=new DequeNode<>(1,null,null);
        lista.append(n);
        DequeNode<Integer> node1=new DequeNode<>(4,null,n);
        lista.append(node1);
        assertEquals(node1,lista.find(4));
    }

    @Test
    public void checkFindNoItemFound(){
        dlink.append(node);
        DequeNode<T> node1=new DequeNode<>(item1,null,node);
        dlink.append(node1);
        assertThrows(RuntimeException.class,()->dlink.find(item2));
    }

    @Test
    public void checkFindEmpty(){
        assertThrows(RuntimeException.class,()->dlink.find(item2));
    }

    @Test
    public void checkDeleteEmpty(){
        assertThrows(RuntimeException.class,()->dlink.delete(node));
    }

    @Test
    public void checkDelete(){
        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>();
        DequeNode<Integer> n=new DequeNode<>(1,null,null);
        lista.append(n);
        DequeNode<Integer> node1=new DequeNode<>(4,null,n);
        lista.append(node1);
        DequeNode<Integer> node2=new DequeNode<>(5,null,node1);
        lista.append(node2);
        lista.delete(node1);
        assertEquals(n.getNext(),node2);
    }

    @Test
    public void checkDeleteNodeOutOfList(){
        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>();
        DequeNode<Integer> n=new DequeNode<>(1,null,null);
        lista.append(n);
        DequeNode<Integer> node1=new DequeNode<>(4,null,n);
        DequeNode<Integer> node2=new DequeNode<>(5,null,node1);
        lista.append(node2);
        assertThrows(RuntimeException.class,()->lista.delete(node1));
    }

    @Test
    public void checkSortEmpty(){
        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>();
        assertThrows(RuntimeException.class,()->lista.sort(comparator));
    }
    //ordenado de mayor a menor
    @Test
    public void checkSort(){
        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>();
        DequeNode<Integer> n=new DequeNode<>(1,null,null);
        lista.append(n);
        DequeNode<Integer> node1=new DequeNode<>(4,null,n);
        lista.append(node1);
        DequeNode<Integer> node2 = new DequeNode<>(3,null,node1);
        lista.append(node2);
        lista.sort(comparator);
        assertTrue(lista.first.getItem()==4 && lista.last.getItem()==1);

    }
    //ordenado de mayor a menor
    @Test
    public void checkSort2Nodes(){
        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>();
        DequeNode<Integer> n=new DequeNode<>(1,null,null);
        lista.append(n);
        DequeNode<Integer> node1=new DequeNode<>(4,null,n);
        lista.append(node1);
        lista.sort(comparator);
        assertTrue(lista.first.getItem()==4 && lista.last.getItem()==1);

    }

    //ordenado de mayor a menor
    @Test
    public void checkSort3Nodes(){
        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>();
        DequeNode<Integer> n=new DequeNode<>(1,null,null);
        lista.append(n);
        DequeNode<Integer> node1=new DequeNode<>(4,null,n);
        lista.append(node1);
        DequeNode<Integer> node2=new DequeNode<>(5,null,node1);
        lista.append(node2);
        lista.sort(comparator);
        assertTrue(lista.first.getItem()==5 && lista.last.getItem()==1);

    }
    //ordenado de mayor a menor
    @Test
    public void checkSort1Node(){
        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>();
        DequeNode<Integer> n=new DequeNode<>(1,null,null);
        lista.append(n);
        lista.sort(comparator);
        assertTrue(lista.first.getItem()==1 && lista.last.getItem()==1);
    }

}
