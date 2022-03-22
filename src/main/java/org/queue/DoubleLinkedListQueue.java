package org.queue;

import java.util.Comparator;

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

    @Override
    public DequeNode<T> getAt(int position) {
        if(first==null){
            throw new RuntimeException("Lista vacía");
        }else if(size < position){
            throw new RuntimeException("La lista es más pequeña que la posición");
        } else if(position<=0){
            throw new RuntimeException("Posición no válida");
        }

        DequeNode<T> aux= first;
        while(position!=1){
            aux= aux.getNext();
            position--;
        }
        return aux;
    }

    @Override
    public DequeNode<T> find(T item) {
        if(size==0){
            throw new RuntimeException("Lista vacía");
        }
        DequeNode<T> aux = first;
        boolean encontrado = false;
        while(!encontrado && aux!=null){
            if(aux.getItem().equals(item)) encontrado = true;
            else aux = aux.getNext();
        }
        if(!encontrado) throw new RuntimeException("Item no encontrado");

        return aux;
    }

    @Override
    public void delete(DequeNode<T> node) {
        if(size==0) throw new RuntimeException("Lista vacía");
        DequeNode<T> aux = find(node.getItem());
        DequeNode<T> next = aux.getNext();
        aux = aux.getPrevious();
        aux.setNext(next);
        next.setPrevious(aux);
    }

    @Override
    public void sort(Comparator<T> comparator) {
        if(size==0) throw new RuntimeException("Lista vacía");
        DequeNode<T> actual, index;
        T aux;
        actual= first;
        index = actual.getNext();
        while(actual != null){
            while(index !=null){
                if(comparator.compare(actual.getItem(),index.getItem())>0){
                    aux = actual.getItem();
                    actual.setItem(index.getItem());
                    index.setItem(aux);
                }
                index = index.getNext();
            }
            actual= actual.getNext();
            index = actual.getNext();
        }
    }
}
