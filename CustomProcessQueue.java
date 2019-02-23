//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           SJF PROCESS SCHEDULER
// Files:           WaitingQueueADT.java,CustomProcess.java, CustomProcessQueue.java, 
//                  ProcessScheduler.java, and ProcessSchedulerTests.java
// Course:          300,fall,2018
//
// Author:          Ante Du
// Email:           adu3@wisc.edu
// Lecturer's Name: Gary
//
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         None
// Online Sources:  None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * This class implements WaitingQueueADT interface of CustomProcesses
 * 
 * @author ante
 *
 */
public class CustomProcessQueue implements WaitingQueueADT<CustomProcess> {

  private static final int INITIAL_CAPACITY = 20; // the initial capacity of the heap
  private CustomProcess[] heap; // array-based min heap storing the data. This is an oversize array
  private int size; // number of CustomProcesses present in this CustomProcessQueue

  /**
   * This constructor create a new CustomProcessQueue
   */
  public CustomProcessQueue() {
    size = 0;// initial size
    heap = new CustomProcess[INITIAL_CAPACITY];// initial heap
  }

  /**
   * This method respectively bubble up and bubble down the element at the given index in the heap.
   * 
   * @param index
   */
  private void minHeapPercolateUp(int index) {
    int parentIndex;// create parent index
    while (index > 0) {// check if index greater than 0
      parentIndex = getParentIndex(index); // get parent node index
      if (parentIndex <= 0)
        break;
      if (heap[index].compareTo(heap[parentIndex]) >= 0)// compare each other's value
        break;
      swap(index, parentIndex);// if parent less than child node, swap each other
      index = parentIndex;
    }
  }

  /**
   * This method respectively bubble up and bubble down the element at the given index in the heap.
   * 
   * @param index
   */
  private void minHeapPercolateDown(int index) {
    while (hasLeftChild(index)) {// check parent node has left child or not
      int leftIndex = getLeftChildIndex(index); // get left child index
      int smallChildIndex = leftIndex; // initial smallest value node
      if (hasRightChild(index)) {// check parent node has right child or not
        int rightIndex = getRightChildIndex(index);// get left child index
        if (heap[leftIndex].compareTo(heap[rightIndex]) > 0)// compare each other's value
          smallChildIndex = rightIndex; // if right less than left, initial smallest node again
      }
      if (heap[smallChildIndex].compareTo(heap[index]) >= 0)// compare each other's value
        break;
      swap(index, smallChildIndex);// if parent less than child node, swap each other
      index = smallChildIndex;
    }
  }

  /**
   * This method add new object to the heap
   */
  @Override
  public void enqueue(CustomProcess newObject) {
    // check if heap array is full
    if (heap[heap.length - 1] != null) {// array is full
      CustomProcess[] biggerHeap = new CustomProcess[heap.length * 2];
      // new array with twice the length of the current heap array
      for (int i = 1; i < heap.length; ++i)
        biggerHeap[i] = heap[i];// copy contents of heap into new heap
      heap = biggerHeap;// set heap reference to the bigger array
    }

    heap[size + 1] = newObject;// add new object
    minHeapPercolateUp(size + 1);// bubble up the new element if needed
    size++;
  }

  /**
   * This method abandon the first object in the heap
   */
  @Override
  public CustomProcess dequeue() {
    CustomProcess top;// create custom process
    if (size == 0)// return null if they are called on an empty CustomProcessQueue.
      return null;
    top = heap[1];// initial top
    heap[1] = heap[size];// let first one to be last one
    heap[size] = null;// dequeue one
    size--;// decrease size
    minHeapPercolateDown(1);// bubble up the new element if needed
    return top;// return dequeue element
  }

  /**
   * This method return the first object in the heap
   */
  @Override
  public CustomProcess peek() {
    if (size == 0)// check if heap is empty
      return null;
    return heap[1];// return the first object
  }

  /**
   * This method return the size of the heap
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * This method check if heap is empty
   */
  @Override
  public boolean isEmpty() {
    return (size == 0);// size equal 0 if is empty
  }

  /**
   * This method exchange the position of two node
   * 
   * @param indexA
   * @param indexB
   */
  private void swap(int indexA, int indexB) {
    CustomProcess temp = heap[indexA];// temparary be A value
    heap[indexA] = heap[indexB];// let A be B value
    heap[indexB] = temp;// let B get A previous value
  }

  /**
   * This method get parent index
   * 
   * @param index
   * @return
   */
  private int getParentIndex(int index) {
    return index / 2;// get child index
  }

  /**
   * This method get right child index
   * 
   * @param index
   * @return
   */
  private int getRightChildIndex(int index) {
    return index * 2 + 1;// get child index
  }

  /**
   * This method get left child index
   * 
   * @param index
   * @return
   */
  private int getLeftChildIndex(int index) {
    return index * 2;// get child index
  }

  /**
   * This method check if has right child
   * 
   * @param index
   * @return
   */
  private boolean hasRightChild(int index) {
    return heap[getRightChildIndex(index)] != null;// return non null left child
  }

  /**
   * THis method check if has left child
   * 
   * @param index
   * @return
   */
  private boolean hasLeftChild(int index) {
    return heap[getLeftChildIndex(index)] != null;// return non null left child
  }
}
