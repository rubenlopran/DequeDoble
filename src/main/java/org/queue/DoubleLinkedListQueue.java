package org.queue;

public class DoubleLinkedListQueue<T> implements DoubleEndedQueue<T>{

     DequeNode<T> first;
     DequeNode<T> last;
     int size;

    public DoubleLinkedListQueue(){
        first = null;
        last = null;
        size=0;
    }

    @Override
    public void append(DequeNode<T> node) {
        if(size==0){
            first = node;
            first.setNext(null);
            last = node;
            last.setNext(null);
            size++;
        } else{
            //last.next = node
            last.setNext(node);
            //node.previous = last
            node.setPrevious(last);
            last = node;
            last.setNext(null);
            size++;
        }
    }

    @Override
    public void appendLeft(DequeNode<T> node) {
        if(size==0){
            first = node;
            last = node;
            size++;
        } else{
            //first.previous = node
            first.setPrevious(node);
            //node.next = first
            node.setNext(first);
            first = node;
            first.setPrevious(null);
            size++;
        }
    }

    @Override
    public void deleteFirst() {
        if(size==0){
            throw new RuntimeException("Eliminar de lista vacia");
        } else if (size == 1){
            first = null;
            last = null;
            size--;
        }
        else{
            first = first.getNext();
            first.setPrevious(null);
            size--;
        }
    }

    @Override
    public void deleteLast() {
        if(size==0){
            throw new RuntimeException("Eliminar de lista vacia");
        } else if (size == 1){
            first = null;
            last = null;
            size--;
        }
        else{
            last = last.getPrevious();
            last.setNext(null);
            size--;
        }

    }

    @Override
    public DequeNode<T> peekFirst() {
        return first;
    }

    @Override
    public DequeNode<T> peekLast() {
        return last;
    }

    @Override
    public int size() {
        return size;
    }
}
