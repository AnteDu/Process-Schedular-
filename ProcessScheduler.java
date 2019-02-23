//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: SJF PROCESS SCHEDULER
// Files: WaitingQueueADT.java,CustomProcess.java, CustomProcessQueue.java,
// ProcessScheduler.java, and ProcessSchedulerTests.java
// Course: 300,fall,2018
//
// Author: Ante Du
// Email: adu3@wisc.edu
// Lecturer's Name: Gary
//
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: None
// Online Sources: None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.Scanner;

/**
 * This class run a process scheduler
 * 
 * @author ante
 *
 */
public class ProcessScheduler {
  private int currentTime; // stores the current time after the last run
  private int numProcessesRun; // stores the number of processes run so far
  private CustomProcessQueue queue; // this processing unit's custom process queue

  /**
   * Constructor create to present processScheduler
   */
  public ProcessScheduler() {
    queue = new CustomProcessQueue();// initial queue
    this.currentTime = 0;// initial currentTime
    this.numProcessesRun = 0;// initial numProcessRun
  }

  /**
   * This method help us get numProcessRun
   * 
   * @return
   */
  public int getNumProcessesRun() {
    return numProcessesRun;
  }

  /**
   * This method help us get currentTime
   * 
   * @return
   */
  public int currentTime() {
    return currentTime;
  }

  /**
   * This method enqueue the given process in the CustomProcessQueue queue
   * 
   * @param process
   */
  public void scheduleProcess(CustomProcess process) {
    queue.enqueue(process);// enqueue the given process in the CustomProcessQueue queue
    numProcessesRun++;// calculate number of process run
  }

  /**
   * This method starts running the ready processes already scheduled in the queue according to the
   * SJF scheduling policy.
   * 
   * @return
   */
  public String run() {
    // when there is only one process
    if (queue.size() == 0) {
      return "You cannot run a empty queue.";
    }
    if (queue.size() < 2)
      System.out.println("Starting " + queue.size() + " process\n\n");
    else {// when there are more than one process
      System.out.println("Starting " + queue.size() + " processes\n\n");
    }
    // while queue is not empty
    while (queue.size() > 0) {
      CustomProcess current = queue.dequeue();// get customProcess that be bandoned
      System.out.println(
          "Time " + currentTime + " : ProcessID" + current.getProcessId() + " Starting.\n");// output
                                                                                            // id
                                                                                            // and
                                                                                            // time
                                                                                            // before
                                                                                            // dequeue
      currentTime = currentTime + current.getBurstTime();
      System.out.println(
          "Time " + currentTime + " : ProcessID" + current.getProcessId() + " Completed.\n");// output
                                                                                             // id
                                                                                             // and
                                                                                             // time
                                                                                             // after
                                                                                             // dequeue
    }
    System.out.println("\nTime " + currentTime + ": All scheduled processes completed.\n");
    // when there is no element to be dequeue, output completed
    return null;
  }

  /**
   * This method used to let main method implement the game demonstrated in the log
   */
  public static void application() {
    ProcessScheduler scheduler = new ProcessScheduler();
    boolean over = false;// decide over or not
    Scanner scnr = new Scanner(System.in);// initial scanner
    String command;// command get by scanner
    while (!over) {// check if it is can be run
      print();// call print method
      command = scnr.nextLine();// scan in
      String[] schedule = command.split(" ");// build string array to store number and operator
                                             // sperately

      // when input command fit schedule
      if (schedule[0].equals("schedule") || schedule[0].equals("s")) {
        try {
          if (Integer.parseInt(schedule[1]) <= 0) {
            System.out.println("WARNING: burst time MUST be greater than 0!\n");
            // check if burst time of a process is not a non-zero, positive integer
          } else {
            CustomProcess newone = new CustomProcess(Integer.parseInt(schedule[1]));// create a new
                                                                                    // CustomProcess
            scheduler.scheduleProcess(newone);// call scheduleProcess method
            System.out.println("Process ID " + newone.getProcessId() + " scheduled. Burst Time = "
                + newone.getBurstTime() + "\n");// output the current id and burstTime
          }
        } catch (NumberFormatException e) {
          System.out.println("WARNING: burst time MUST be an integer!\n");
          // check if the burst time of a process is not an integer
        }
      }
      // when input command fit run
      else if (command.equals("r") || command.equals("run")) {
        scheduler.run();// call the run method
      }
      // when input command fit quit
      else if (command.equals("q") || command.equals("quit")) {
        over = true;
        System.out.println(scheduler.getNumProcessesRun() + " processes run in "
            + scheduler.currentTime() + " units of time!\n");// output the number of process and
                                                             // time
        System.out.println("Thank you for using our scheduler!\n");
        System.out.println("Goodbye!\n");
      }
      // check if the user enters a wrong command or if the format
      // of the command is not valid
      else {
        System.out.println("WARNING: Please enter a valid command!\n");
      }
    }
  }

  /**
   * This method is used to output command
   */
  public static void print() {

    System.out.println("Enter command:");// enter command
    System.out.println("[schedule <burstTime>] or [s <burstTime>]");// schedule burstTime when
                                                                    // enqueue
    System.out.println("[run] or [r]");// run when dequeue
    System.out.println("[quit] or [q]");// quit than show whole completed
  }

  /**
   * This main method used to call other method
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("==========   Welcome to the SJF Process Scheduler App   ======== ");
    // create process Scheduler
    application();// call application method
  }
}
