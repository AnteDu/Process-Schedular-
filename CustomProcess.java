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
 * This class represents the type for the processes in our application
 * 
 * @author ante
 *
 */
public class CustomProcess implements Comparable<CustomProcess> {
  private static int nextProcessId = 1; // stores the id to be assigned to the next process 
                                        // to be created                                      
  private final int PROCESS_ID; // unique identifier for this process
  private int burstTime; // time required by this process for CPU execution

  /**
   * This constructor create a new CustomProcess with burstTime
   * 
   * @param burstTime
   */
  public CustomProcess(int burstTime) {
    this.PROCESS_ID = nextProcessId;// initial process id
    this.burstTime = burstTime;// initial burst time
    nextProcessId++; // let nextProcessId to be next
  }

  /**
   * This method is used to compare this CustomProcess to another one
   * 
   * @return
   * @param other
   */
  @Override
  public int compareTo(CustomProcess other) {
    if (this.burstTime < other.burstTime) {// this has higher priority than other
      return -1;
    } else if (this.burstTime == other.burstTime) {// while burst time has the same value
      if (this.PROCESS_ID < other.PROCESS_ID) // the process with the lower processId
                                              //should be run first                                       
        return -1;
      else
        return 1;
    } else if (this.burstTime > other.burstTime) {// other has higher priority than this
      return 1;
    } else
      return 0;
  }

  /**
   * Return the processId of the CustomProcess
   * 
   * @return processId
   */
  public int getProcessId() {
    return this.PROCESS_ID;
  }

  /**
   * Return the burstTime of the customProcess
   * 
   * @return burstTime
   */
  public int getBurstTime() {
    return this.burstTime;
  }
}
