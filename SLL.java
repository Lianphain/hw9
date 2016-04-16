/***************************************************************************************
 *
 * NAME: Alyssa Higuchi
 *
 * HOMEWORK: 4
 *
 * CLASS: ICS 211
 *
 * INSTRUCTOR: Scott Robertson
 *
 * DATE: February 22, 2016
 *
 * FILE: SLL.java
 *
 * DESCRIPTION: This file contains the SLL class
 *
 ***************************************************************************************/

import java.util.*;
import java.io.*;
public class SLL<E extends Comparable<E>> {
  private SLLNode<E> head;
  private int size;

  /********************************************************************
	*
	* Method: SLL
	*
	* Description: Constructs an empty SLL
	*
	* @param  None
	*
	* @return None
	*
	********************************************************************/

  public SLL() {
    head = null;
    size = 0;
  }

  /********************************************************************
	*
	* Method: add
	*
	* Description: Adds the element to the end of the list
	*
	* @param  element  The element which should be added to the list
	*
	* @return true   If the element was added
   *         false  If the element was not added
	*
	********************************************************************/

  public boolean add(E element) {
    boolean added = false;
    if(head == null) {
      head = new SLLNode(element);
      size++;
      added = true;
    }
    else {
      SLLNode curr = head;
      while(curr.getNext() != null) {
        curr = curr.getNext();
      }
      curr.setNext(new SLLNode(element));
      size++;
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
        add((E) fr.next());
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
  * Description: Sorts the SLL using an insertion sort
  *
  * @param  None
  *
  * @return None
  *
  ********************************************************************/

  public void insertionSort(){
    for (int i = 1; i < size(); i++) {
      for(int j = i ; j > 0 ; j--){
        if(get(j).compareTo(get(j-1)) < 0){
          System.out.println(get(j));
          swapNode(getNode(j), getNode(j-1));
        }
      }
    }
  }

  /********************************************************************
  *
  * Method: bubbleSort
  *
  * Description: Sorts the SLL using a bubble sort
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
        if(get(i).compareTo(get(i+1)) > 0){
          System.out.println(get(i));
          swapNode(getNode(i+1), getNode(i));
          check = true;
        }
      }
    }
  }
  /********************************************************************
  *
  * Method: swapNode
  *
  * Description: Swaps nodes indicated in the parameters
  *
  * @param  SLLNode<E> target, SLLNode<E> replace
  *
  * @return None
  *
  ********************************************************************/

  private void swapNode(SLLNode<E> target, SLLNode<E> replace){
    if(replace == head){
      replace.setNext(target.getNext());
      target.setNext(replace);
      head = target;
    }
    else{
      SLLNode<E> temp = head;
      while(temp.getNext() != replace){
        temp = temp.getNext();
      }
      temp.setNext(target);
      replace.setNext(target.getNext());
      target.setNext(replace);
    }
  }

  /********************************************************************
	*
	* Method: add
	*
	* Description: Adds the element to the given index
	*
	* @param  index    The index to which the element should be added
   *         element  The element which should be added to the list
	*
	* @return true   If the element was added
   *         false  If the element was not added
	*
	********************************************************************/

  public boolean add(int index, E element) {
    boolean added = false;
    SLLNode curr = head;
    SLLNode temp = new SLLNode(element);
    if(index >= 0 && index < size) {
      if(index == 0) {
        temp.setNext(head);
        head = temp;
      }
      else {
        for(int i = 0; i < index - 1; i++) {
          curr = curr.getNext();
        }
        temp.setNext(curr.getNext());
        curr.setNext(temp);
      }
      size++;
      added = true;
    }
    return added;
  }

  /********************************************************************
	*
	* Method: clear
	*
	* Description: Clears all the elements in the list
	*
	* @param  None
	*
	* @return None
	*
	********************************************************************/

  public void clear() {
    head = null;
    size = 0;
  }

  /********************************************************************
	*
	* Method: contains
	*
	* Description: Checks if the list contains a given element
	*
	* @param  element  The element which is checked for
	*
	* @return true  If the list contains the element
   *         false If the list does not contain the element
	*
	********************************************************************/

  public boolean contains(E element) {
    boolean contains = false;
    E data;
    SLLIterator it = (SLLIterator) Iterator();
    while(it.hasNext()) {
      data = it.next();
      if(data == element) {
        contains = true;
      }
    }
    return contains;
  }

  /********************************************************************
	*
	* Method: get
	*
	* Description: Gets the element at the given index
	*
	* @param  index  The index of the desired element
	*
	* @return data  The data of the SLLNode at the given index. If the
   *               index is out of bounds, then returns null
	*
	********************************************************************/

  public E get(int index) {
    E data = null;
    SLLIterator it = (SLLIterator) Iterator();
    if(index >= 0 && index < size) {
      for(int i = 0; i <= index; i++) {
        data = it.next();
      }
    }
    return data;
  }

  /********************************************************************
  *
  * Method: getNode
  *
  * Description: Gets the node at the given index
  *
  * @param  index  The index of the desired node
  *
  * @return data  The node of the SLLNode at the given index. If the
   *               index is out of bounds, then returns null
  *
  ********************************************************************/

  public SLLNode<E> getNode(int index) {
    SLLNode<E> node = null;
    SLLIterator it = (SLLIterator) Iterator();
    if(index >= 0 && index < size) {
      for(int i = 0; i <= index; i++) {
        node = it.nextNode();
      }
    }
    return node;
  }

  /********************************************************************************
	*
	* Method: indexOf
	*
	* Description: Gets the index of the first occurrence of the given element
	*
	* @param  element  The element that is being searched for
	*
	* @return index  The index of the first occurrence of the given element. If the
   *                given element does not exist, then index = -1
	*
	********************************************************************************/

  public int indexOf(E element) {
    int index = -1;
    int currIndex = -1;
    E data;
    SLLIterator it = (SLLIterator) Iterator();
    while(it.hasNext()) {
      data = it.next();
      currIndex++;
      if(data == element && index == -1) {
        index = currIndex;
      }
    }
    return index;
  }

  /********************************************************************************
	*
	* Method: isEmpty
	*
	* Description: States whether or not the list is empty
	*
	* @param  None
	*
	* @return true  If the list is empty
   *         false If the list is not empty
	*
	********************************************************************************/

  public boolean isEmpty() {
    boolean isEmpty = false;
    if(size == 0) {
      isEmpty = true;
    }
    return isEmpty;
  }

  /********************************************************************************
	*
	* Method: indexOf
	*
	* Description: Gets the index of the last occurrence of the given element
	*
	* @param  element  The element that is being searched for
	*
	* @return index  The index of the last occurrence of the given element. If the
   *                given element does not exist, then index = -1
	*
	********************************************************************************/

  public int lastIndexOf(E element) {
    int index = -1;
    int currIndex = -1;
    E data;
    SLLIterator it = (SLLIterator) Iterator();
    while(it.hasNext()) {
      data = it.next();
      currIndex++;
      if(data == element) {
        index = currIndex;
      }
    }
    return index;

  }

  /********************************************************************************
	*
	* Method: removeIndex
	*
	* Description: Removes the element at the given index
	*
	* @param  index  The index that the element that should be removed is located
	*
	* @return data  The element that was removed
   *         null  If no element was removed
	*
	********************************************************************************/

  public E removeIndex(int index) {
    E data = null;
    E tempData = null;
    SLLIterator it = (SLLIterator) Iterator();
    if(index < size && index >= 0) {
      for(int i = 0; i <= index; i++) {
        tempData = it.next();
      }
      data = tempData;
      it.remove();
      size--;
    }
    return data;
  }

  /********************************************************************************
	*
	* Method: removeElement
	*
	* Description: Removes the first occurrence of the given element
	*
	* @param  element  The element that should be removed
	*
	* @return data  The element that was removed
   *         null  If no element was removed
	*
	********************************************************************************/

  public E removeElement(E element) {
    E data = null;
    E tempData = null;
    SLLIterator it = (SLLIterator) Iterator();
    boolean removed = false;
    while(it.hasNext() && !removed) {
      tempData = it.next();
      if(tempData == element) {
        data = tempData;
        it.remove();
        removed = true;
        size--;
      }
    }
    return data;
  }

  /***********************************************************************************
	*
	* Method: set
	*
	* Description: Sets the value at the given index to the given element
	*
	* @param  index    The index of the element that should be changed
   *         element  The value that the element at the given index should be set to
	*
	* @return data  The value of the element at the given index before it was changed
   *         null  If the index was out of bounds
	*
	***********************************************************************************/

  public E set(int index, E element) {
    E data = null;
    if (index < size) {
      SLLNode curr = head;
      for(int i = 0; i < index; i++) {
        curr = curr.getNext();
      }
      data = (E) curr.getData();
      curr.setData(element);
    }
    return data;
  }

  /***********************************************************************************
	*
	* Method: size
	*
	* Description: Returns the size of the list
	*
	* @param  None
	*
	* @return size  The number of elements in the list
	*
	***********************************************************************************/

  public int size() {
    return size;
  }

  /***********************************************************************************
	*
	* Method: toString
	*
	* Description: Returns a String representation of the list
	*
	* @param  None
	*
	* @return str  The String representation of this list
	*
	***********************************************************************************/

  public String toString() {
    SLLIterator it = (SLLIterator) Iterator();
    String str = "[";
    while(it.hasNext()) {
      str += it.next();
      if(it.hasNext()) {
        str += ", ";
      }
    }
    str += "]";
    return str;
  }

  /***********************************************************************************
	*
	* Method: Iterator
	*
	* Description: Returns a SLLIterator
	*
	* @param  None
	*
	* @return A new SLLIterator object
	*
	***********************************************************************************/

  public Iterator<E> Iterator() {
    return new SLLIterator();
  }

  /*Private inner Iterator class*/
  private class SLLIterator implements Iterator {

    private SLLNode<E> next;

    /***********************************************************************************
	  *
	  * Method: SLLIterator
	  *
	  * Description: Constructs a SLLIterator
	  *
	  * @param  None
	  *
	  * @return None
	  *
	  ***********************************************************************************/

    public SLLIterator() {
      next = head;
    }

    /***********************************************************************************
	  *
	  * Method: hasNext
	  *
	  * Description: Determines if this SLLIterator has a next element
	  *
	  * @param  None
	  *
	  * @return true  If this SLLIterator has a next element
     *         false If this SLLIterator does not have a next element
	  *
	  ***********************************************************************************/

    public boolean hasNext() {
      boolean hasNext = false;
      if(next != null) {
        hasNext = true;
      }
      return hasNext;
    }

    /***********************************************************************************
  	  *
	  * Method: next
	  *
	  * Description: Returns the next element of this SLLIterator
	  *
	  * @param  None
	  *
	  * @return data  The next element, if this DLLIterator has a next element
     *         null  If this DLLIterator does not have a next element
	  *
	  ***********************************************************************************/

    public E next() {
      E data = null;
      if(next != null) {
        SLLNode curr = next;
        next = next.getNext();
        data = (E) curr.getData();
      }
      return data;
    }

    /***********************************************************************************
      *
    * Method: nextNode
    *
    * Description: Returns the next node of this SLLIterator
    *
    * @param  None
    *
    * @return node  The next node, if this DLLIterator has a next node
     *         null  If this DLLIterator does not have a next node
    *
    ***********************************************************************************/

    public SLLNode<E> nextNode() {
      SLLNode<E> node = null;
      if(next != null) {
        SLLNode curr = next;
        next = next.getNext();
        node = curr;
      }
      return node;
    }

    /***********************************************************************************
	  *
	  * Method: remove
	  *
	  * Description: Removes the last element returned by the next() or previous()
	  *
	  * @param  None
	  *
	  * @return None
	  *
	  ***********************************************************************************/

    public void remove() {
      SLLNode curr = head;
      if(head != next) {
        if(head.getNext() == next) {
          head = next;
        }
        else {
          while(curr.getNext().getNext() != next) {
            curr = curr.getNext();
          }
          curr.setNext(next);
        }
      }
    }
  }
}
