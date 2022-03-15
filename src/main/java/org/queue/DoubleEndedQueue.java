package org.queue;

public interface DoubleEndedQueue<T> {
    // Basic operations
    void append(DequeNode<T> node) ;
    void appendLeft(DequeNode<T> node) ;
    void deleteFirst() ;
    void deleteLast() ;
    DequeNode<T> peekFirst() ;
    DequeNode<T> peekLast() ;
    int size() ;

    // Complex operations
    // (Estas operaciones se incluirán más adelante para ser realizadas en la segunda
    // sesión de laboratorio de esta práctica.)
}