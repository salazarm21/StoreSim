/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storesimulation;

/**
 *
 * @author timmermank1
 */
class MyHeap<T> {

    private final Event[] myHeap = new Event[100000];
    private int items = 0;
    private int heapSize;
    private int Cindex;
    private Event root;
    private Event leftChild;
    // leftChild = myHeap[(2 * Cindex) + 1];
    private Event rightChild;
    // rightChild = 2 * parent + 2;
    private Event parent;
    private Event child;

    int getSize() {
        return items;
    }

    Event remove() {
        root = myHeap[0];
        myHeap[0] = myHeap[items - 1];
        items--;
        Cindex = 0;
        while (Cindex < items) {
            if (((2 * Cindex) + 2 < items) && 
                    (myHeap[Cindex].compareTo(myHeap[(2 * Cindex) + 1]) > 0 || 
                    (myHeap[Cindex].compareTo(myHeap[(2 * Cindex) + 2]) > 0))) {

                if (myHeap[(Cindex * 2) + 1].compareTo(myHeap[(2 * Cindex) + 2]) < 0) {
                    swap(Cindex, 2 * Cindex + 1);
                    Cindex = (2 * Cindex) + 1;

                } else {
                    swap(Cindex, 2 * Cindex + 2);
                    Cindex = (2 * Cindex) + 2;
                }
            } else if ((2 * Cindex) + 1 < items && myHeap[Cindex].compareTo(myHeap[(2 * Cindex) + 1]) > 0) {
                swap(Cindex, 2 * Cindex + 1);
                Cindex = (2 * Cindex) + 1;
            } else {
                break;
            }

        }
        return root;

    }

    void swap(int index1, int index2) {
        Event e1 = myHeap[index1];
        myHeap[index1] = myHeap[index2];
        myHeap[index1] = e1;
    }

    void insert(Event event) {
        myHeap[items] = event;
        Cindex = items;
        while (Cindex > 0) {
            int parentIndex = (int) Math.floor((Cindex - 1) / 2);
            if (myHeap[Cindex].compareTo(myHeap[parentIndex]) < 0) {
                parent = myHeap[(int) Math.floor((Cindex - 1) / 2)];
                myHeap[(int) Math.floor((Cindex - 1) / 2)] = myHeap[Cindex];
                myHeap[Cindex] = parent;
                Cindex = (int) Math.floor((Cindex - 1) / 2);
            } else {
                break;
            }

        }
        items++;
    }
}
