package org.queue;

/**
 * Class representing a node of a double-ended queue (deque). Each node has pointers to
 * the next and previous nodes.
 * The previous and next of the first and last node of the deque is null.
 *
 * @param <T>
 */
public class DequeNode<T> {
    private T item ;
    private T next ;
    private T previous ;

    public T getItem() {
        return item;
    }

    public T getNext() {
        return next;
    }

    public T getPrevious() {
        return previous;
    }

    public DequeNode(T item, T next, T previous) {
        this.item = item ;
        this.next = next ;
        this.previous = previous ;
    }

    public boolean isFirstNode() {
        return previous == null ;
    }

    public boolean isLastNode() {
        return next == null ;
    }

    public boolean isNotATerminalNode() {
        return (!isFirstNode() && !isLastNode()) ;
    }
}