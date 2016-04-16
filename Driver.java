public class Driver{
  public static void main(String[] args) {

    DLL test = new DLL();

    test.add(79);
    //test.add(2);
    //test.add(78);
    //test.add(56);
    test.add(22);
    //test.add(100);
    //test.add(25);
    test.add(5);

    System.out.println(test.size());

    System.out.println(test.toString());
    test.insertionSort();
    System.out.println(test.toString());



/*
    MyList test = new MyList();
    MyList testg = new MyList();

    for(int i = 1; i <= 10; i++){
      System.out.println("Test " + i);
      test.addFile(args[0]);
      long startTimeBubble = System.currentTimeMillis();
      test.bubbleSort();
      long endTimeBubble = System.currentTimeMillis();
      System.out.print("Bubble Sort time is ");
      System.out.println(endTimeBubble-startTimeBubble + " Milliseconds");
      test = new MyList();

    }

    for(int i = 1; i <= 10; i++){
      System.out.println("Test " + i);
      testg.addFile("unsorted.txt");
      long startTimeInsert = System.currentTimeMillis();
      testg.insertionSort();
      long endTimeInsert = System.currentTimeMillis();
      System.out.print("Insertion Sort time is " );
      System.out.println(endTimeInsert-startTimeInsert + " Milliseconds");
      testg = new MyList();
      */
  //  }
  }
}
