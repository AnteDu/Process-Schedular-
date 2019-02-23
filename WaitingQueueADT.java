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
 * This interface is Abstract Data Type that represents the pattern for our ready processes
 * waiting list
 * 
 * @author ante
 *
 * @param <T>
 */
public interface WaitingQueueADT<T extends Comparable<T>> {

  public void enqueue(T newObject); // inserts a newObject in the priority queue

  public T dequeue(); // removes and returns the item with the highest priority

  public T peek(); // returns without removing the item with the highest priority

  public int size(); // returns size of the waiting queue

  public boolean isEmpty(); // checks if the waiting queue is empty
}
