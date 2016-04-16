/***************************************************************************************
 *
 * NAME: Alyssa Higuchi
 *
 * HOMEWORK: 3
 *
 * CLASS: ICS 211
 *
 * INSTRUCTOR: Scott Robertson
 *
 * DATE: February 18, 2016
 *
 * FILE: MyList.java
 *
 * DESCRIPTION: This file contains the MyList data structure for homework 3
 *
 ***************************************************************************************/
 import java.io.*;
 import java.util.*;
public class MyList {
  private Integer[] list;

  /********************************************************************
	*
	* Method: MyList
	*
	* Description: Initializes the list to an array of size 0
	*
	* @param  None
	*
	* @return None
	*
	********************************************************************/

  public MyList() {
    list = new Integer[0];
  }

  /********************************************************************
	*
	* Method: add
	*
	* Description: Adds an element to the end of the list
	*
	* @param  element  the element to be added to the list
	*
	* @return None
	*
	********************************************************************/

  public void add(int element) {
    Integer[] newList = new Integer[list.length + 1];
    System.arraycopy(list, 0, newList, 0, list.length);
    newList[newList.length - 1] = element;
    list = newList;
  }
  /********************************************************************
	*
	* Method: add
	*
	* Description: Adds an element to a given index
	*
	* @param  index   the index at which the element should be added
   *         element the element to be added to the list
	*
	* @return true    if the element was added
   *         false   if the element was not added
	*
	********************************************************************/

  public boolean add(int index, int element) {
    boolean added;
    if (index < 0 || index >= list.length) {
      added = false;
    }
    else {
      Integer[] newList = new Integer[list.length + 1];
      System.arraycopy(list, 0, newList, 0, index);
      System.arraycopy(list, index, newList, index + 1, list.length - index);
      newList[index] = element;
      list = newList;
      added = true;
    }
    return added;
  }

  /********************************************************************
  *
  * Method: addFile
  *
  * Description: Reads a file and adds the numbers from file
  *
  * @param  String filename
  *
  * @return None
  *
  ********************************************************************/

  public void addFile(String filename){
    try{
      Scanner fr = new Scanner(new FileReader(filename));
      for(int i = 0; i <= 50000; i++){
        add(fr.nextInt());
      }
    }
    catch(Exception e){
      System.out.println("Please insert a file.");
    }
  }

  /********************************************************************
  *
  * Method: insertionSort
  *
  * Description: Sorts the list using an insertion sort
  *
  * @param  None
  *
  * @return None
  *
  ********************************************************************/

  public void insertionSort(){
    int temp;
    for (int i = 1; i < size(); i++) {
      for(int j = i ; j > 0 ; j--){
        if(get(j) < get(j-1)){
            temp = get(j);
            set(j, get(j-1));
            set(j-1, temp);
        }
      }
    }
  }

  /********************************************************************
  *
  * Method: bubbleSort
  *
  * Description: Sorts the list using a bubble sort
  *
  * @param  None
  *
  * @return None
  *
  ********************************************************************/

  public void bubbleSort(){
    int temp;
    boolean check = true;
    while(check){
      check = false;
      for(int i = 0; i < size()-1; i++){
        if(get(i) > get(i+1)){
          temp = get(i);
          set(i, get(i+1));
          set(i+1, temp);
          check = true;
        }
      }
    }
  }

  /********************************************************************
	*
   * Method: clear
	*
	* Description: Clears the contents of the list
	*
	* @param  None
	*
	* @return None
	*
	********************************************************************/

  public void clear() {
    list = new Integer[0];
  }

  /********************************************************************
	*
   * Method: contains
	*
	* Description: Checks if the list contains the given element
	*
	* @param  element  the element which the list should be checked for
	*
	* @return true     if the list contains the element
   *         false    if the list does not contain the element
	*
	********************************************************************/

  public boolean contains(int element) {
    boolean contains = false;
    for(int i = 0; i < list.length; i++) {
      if(list[i] == element) {
        contains = true;
      }
    }
    return contains;
  }

  /******************************************************************************************************
	*
   * Method: get
	*
	* Description: Returns the element at the given index. Throws an IndexOutOfBoundsException otherwise.
	*
	* @param  index    the index that the element should be retrieved from
	*
	* @return the element at the given index
   *         throws an IndexOutOfBoundsException if the index is out of bounds
	*
	******************************************************************************************************/

  public int get(int index) {
    if(index < 0 || index >= list.length) {
      throw new IndexOutOfBoundsException();
    }
    else {
      return list[index];
    }
  }

  /**************************************************************************************************************
	*
   * Method: indexOf
	*
	* Description: Returns the index of the first occurrence of the element or -1 if the element does not exist.
	*
	* @param  element  the element that we want to find the index of
	*
	* @return the index of the first occurrence of the given element
   *         -1 if the element does not exist
	*
	**************************************************************************************************************/

  public int indexOf(int element) {
    int index = -1;
    for(int i = 0; i < list.length; i++) {
      if(list[i] == element) {
        if(index < 0) {
          index = i;
        }
      }
    }
    return index;
  }

  /**************************************************************************************************************
	*
   * Method: isEmpty
	*
	* Description: Returns true if the list is empty or false if the list is not empty.
	*
	* @param  None
	*
	* @return true if the list is empty
   *         false if the list is not empty
	*
	**************************************************************************************************************/

  public boolean isEmpty() {
    boolean empty;
    if(list.length == 0) {
      empty = true;
    }
    else {
      empty = false;
    }
    return empty;
  }

  /**************************************************************************************************************
	*
   * Method: lastIndexOf
	*
	* Description: Finds the index of the last occurrence of a given element
	*
	* @param  element
	*
	* @return the index of the first occurrence of the given element
   *         -1 if the element does not exist
	*
	**************************************************************************************************************/

  public int lastIndexOf(int element) {
    int index = -1;
    for(int i = list.length - 1; i >= 0; i--) {
      if(list[i] == element) {
        if(index < 0) {
          index = i;
        }
      }
    }
    return index;
  }

  /***************************************************************************************************************************
	*
   * Method: removeIndex
	*
	* Description: Removes the element at the given index. Returns true if the element was removed. Returns false otherwise.
	*
	* @param  index  the index of the element which should be removed
	*
	* @return true   if the element was removed
   *         false  if the element was not removed
	*
	***************************************************************************************************************************/

  public boolean removeIndex(int index) {
    boolean removed = false;
    if(index >= 0 && index < list.length) {
      Integer[] newList = new Integer[list.length - 1];
      System.arraycopy(list, 0, newList, 0, index);
      System.arraycopy(list, index + 1, newList, index, list.length - index - 1);
      list = newList;
      removed = true;
    }
    return removed;
  }

  /****************************************************************************************************************************
	*
   * Method: removeElement
	*
	* Description: Removes the first occurrence of the element. Returns true if the element was removed. Returns false otherwise.
	*
	* @param  element  the element which should be removed
	*
	* @return true     if the element was removed
   *         false    if the element was not removed
	*
	****************************************************************************************************************************/

  public boolean removeElement(int element) {
    boolean removed = false;
    int index = indexOf(element);
    if(index >= 0 && index < list.length) {
      Integer[] newList = new Integer[list.length - 1];
      System.arraycopy(list, 0, newList, 0, index);
      System.arraycopy(list, index + 1, newList, index, list.length - index - 1);
      list = newList;
      removed = true;
    }
    return removed;
  }

  /****************************************************************************************************************************
	*
   * Method: set
	*
	* Description: Sets the value at the given index to the given element. Returns true if the value was successfully set.
   *              Returns false otherwise.
	*
	* @param  index    the index of the element whose value should be changed
   *         element  the element which should replace the old element
	*
	* @return true     if the element was set
   *         false    if the element was not set
	*
	****************************************************************************************************************************/

  public boolean set(int index, int element) {
    boolean set = false;
    if(index >= 0 && index < list.length) {
      list[index] = element;
      set = true;
    }
    return set;
  }

  /****************************************************************************************************************************
	*
   * Method: size
	*
	* Description: Returns the size of the list
	*
	* @param  None
	*
	* @return the size of the list
	*
	****************************************************************************************************************************/

  public int size() {
    return list.length;
  }

  /****************************************************************************************************************************
	*
   * Method: size
	*
	* Description:
	*
	* @param  None
	*
	* @return None
	*
	****************************************************************************************************************************/

  public String toString(MyList lists) {
    String output = "";
    output += "[";
    for(int i = 0; i < lists.size(); i++) {
      output += lists.get(i);
      if(i != lists.size() - 1) {
        output += ", ";
      }
    }
    output += "]";
    return output;
  }
}
