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
 * This class used to test other class
 * 
 * @author ante
 *
 */
public class ProcessSchedulerTests {
  /**
   * test the correctness of the enqueue
   * 
   * @return
   */
  public static boolean testEnqueueCustomProcessQueue() {
    CustomProcessQueue queue = new CustomProcessQueue(); // operation implemented in the
                                                         // CustomProcessQueue class
    CustomProcess newObject = new CustomProcess(5);// create customProcess to be added
    queue.enqueue(newObject);// call enqueue method
    if (!queue.isEmpty()) {// checks the correctness of the enqueue
      return true;
    }
    return false;
  }

  /**
   * test the correctness of the dequeue
   * 
   * @return
   */
  public static boolean testDequeueCustomProcessQueue() {
    CustomProcessQueue queue = new CustomProcessQueue(); // operation implemented in the
                                                         // CustomProcessQueue class
    CustomProcess newObject = new CustomProcess(5);// create customProcess to be added
    queue.enqueue(newObject);// add object to queue
    if (queue.dequeue() == newObject) {// checks the correctness of the dequeue
      return true;
    }
    return false;
  }

  /**
   * test the correctness of the compareTo
   * 
   * @return
   */
  public static boolean testCompareTo() {
    CustomProcess cp = new CustomProcess(5);// create customProcess to be compared
    CustomProcess tp = new CustomProcess(6);// create customProcess to be compared
    if (cp.compareTo(tp) < 0) {// checks the correctness of the compareTo()
      return true;
    }
    return false;
  }

  /**
   * test the correctness of the Empty
   * 
   * @return
   */
  public static boolean isEmpty() {
    CustomProcessQueue queue = new CustomProcessQueue();// operation implemented in the
                                                        // CustomProcessQueue class
    if (queue.isEmpty()) {// check the correctness of the isEmpty
      return true;
    }
    return false;
  }

  /**
   * This is the main method of the test
   * 
   * @param args
   */
  public static void main(String[] args) {
    if (testEnqueueCustomProcessQueue())
      System.out.println("pass");// test the first test
    if (testDequeueCustomProcessQueue())
      System.out.println("pass");// test the second test
    if (testCompareTo()) {
      System.out.println("pass");// test the third test
    }
    if (testCompareTo()) {
      System.out.println("pass");// test the fourth test
    }
  }
}
