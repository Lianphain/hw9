public class Driver{
  public static void main(String[] args) {

    MyList list = new MyList();
    SLL sll = new SLL();
    DLL dll = new DLL();

    long startTimeBubbleArray;
    long startTimeBubbleSLL;
    long startTimeBubbleDLL;
    long endTimeBubbleArray;
    long endTimeBubbleSLL;
    long endTimeBubbleDLL;

    long startTimeInsertArray;
    long startTimeInsertSLL;
    long startTimeInsertDLL;
    long endTimeInsertArray;
    long endTimeInsertSLL;
    long endTimeInsertDLL;

    long totalBubbleArray = 0;
    long totalInsertArray = 0;
    long totalBubbleSLL = 0;
    long totalInsertSLL = 0;
    long totalBubbleDLL = 0;
    long totalInsertDLL = 0;
/*
    System.out.println("__________________________________________________________________");
    System.out.println("                    Array Testing                                 ");

    for(int i = 1; i <= 10; i++){
      System.out.println("List bubblesort " + i);
      list.addFile(args[0]);
      startTimeBubbleArray = System.currentTimeMillis();
      list.bubbleSort();
      endTimeBubbleArray = System.currentTimeMillis();
      System.out.print("Bubble Sort time is ");
      System.out.println(endTimeBubbleArray-startTimeBubbleArray +" Milliseconds");
      totalBubbleArray += (endTimeBubbleArray-startTimeBubbleArray);
      list = new MyList();
    }

    System.out.println();
    System.out.println();

    for(int i = 1; i <= 10; i++){
      System.out.println("List insertionsort " + i);
      list.addFile("unsorted.txt");
      startTimeInsertArray = System.currentTimeMillis();
      list.insertionSort();
      endTimeInsertArray = System.currentTimeMillis();
      System.out.print("Insertion Sort time is " );
      System.out.println(endTimeInsertArray-startTimeInsertArray + " Milliseconds");
      System.out.println();
      totalInsertArray += (endTimeInsertArray-startTimeInsertArray);
      list = new MyList();
    }

    System.out.println();
    System.out.println();

    Long averageBubbleArray = totalBubbleArray/10;
    Long averageInsertArray = totalInsertArray/10;
    System.out.println();
    System.out.println("The average time for all 10 bubblesorts for a an array is " + averageBubbleArray);
    System.out.println("The average time for all 10 insertionsorts for a an array is " + averageInsertArray);

    System.out.println();

    System.out.println("__________________________________________________________________");
    System.out.println("                    Array Testing End                             ");

    System.out.println();
    System.out.println();

    System.out.println("__________________________________________________________________");
    System.out.println("                      SLL Testing                                 ");

    for(int i = 1; i <= 10; i++){
      System.out.println("SLL bubblesort " + i);
      sll.addFile(args[0]);
      startTimeBubbleSLL = System.currentTimeMillis();
      sll.bubbleSort();
      endTimeBubbleSLL = System.currentTimeMillis();
      System.out.print("Bubble Sort time is ");
      System.out.println(endTimeBubbleSLL-startTimeBubbleSLL +" Milliseconds");
      totalBubbleSLL += (endTimeBubbleSLL-startTimeBubbleSLL);
      sll = new SLL();
    }

    System.out.println();
    System.out.println();

    for(int i = 1; i <= 10; i++){
      System.out.println("SLL insertionsort " + i);
      sll.addFile("unsorted.txt");
      startTimeInsertSLL = System.currentTimeMillis();
      sll.insertionSort();
      endTimeInsertSLL = System.currentTimeMillis();
      System.out.print("Insertion Sort time is " );
      System.out.println(endTimeInsertSLL-startTimeInsertSLL + " Milliseconds");
      System.out.println();
      totalInsertSLL += (endTimeInsertSLL-startTimeInsertSLL);
      sll = new SLL();
    }

    System.out.println();
    System.out.println();

    Long averageBubbleSLL = totalBubbleSLL/10;
    Long averageInsertSLL = totalInsertSLL/10;
    System.out.println();
    System.out.println("The average time for all 10 bubblesorts for a an array is " + averageBubbleSLL);
    System.out.println("The average time for all 10 insertionsorts for a an array is " + averageInsertSLL);

    System.out.println();

    System.out.println("__________________________________________________________________");
    System.out.println("                      SLL Testing End                             ");

    */


    System.out.println("__________________________________________________________________");
    System.out.println("                      DLL Testing                                 ");

    for(int i = 1; i <= 10; i++){
      System.out.println("DLL bubblesort " + i);
      dll.addFile(args[0]);
      startTimeBubbleDLL = System.currentTimeMillis();
      dll.bubbleSort();
      endTimeBubbleDLL = System.currentTimeMillis();
      System.out.print("Bubble Sort time is ");
      System.out.println(endTimeBubbleDLL-startTimeBubbleDLL +" Milliseconds");
      totalBubbleDLL += (endTimeBubbleDLL-startTimeBubbleDLL);
      dll = new DLL();
    }

    System.out.println();
    System.out.println();

    for(int i = 1; i <= 10; i++){
      System.out.println("DLL insertionsort " + i);
      dll.addFile("unsorted.txt");
      startTimeInsertDLL = System.currentTimeMillis();
      dll.insertionSort();
      endTimeInsertDLL = System.currentTimeMillis();
      System.out.print("Insertion Sort time is " );
      System.out.println(endTimeInsertDLL-startTimeInsertDLL + " Milliseconds");
      System.out.println();
      totalInsertDLL += (endTimeInsertDLL-startTimeInsertDLL);
      dll = new DLL();
    }

    System.out.println();
    System.out.println();

    Long averageBubbleDLL = totalBubbleDLL/10;
    Long averageInsertDLL = totalInsertDLL/10;
    System.out.println();
    System.out.println("The average time for all 10 bubblesorts for a an array is " + averageBubbleDLL);
    System.out.println("The average time for all 10 insertionsorts for a an array is " + averageInsertDLL);

    System.out.println();

    System.out.println("__________________________________________________________________");
    System.out.println("                      SLL Testing End                             ");

  }
}
