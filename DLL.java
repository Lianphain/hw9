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
 * FILE: DLL.java
 *
 * DESCRIPTION: This file contains the DLL class for homework 4
 *
 ***************************************************************************************/

import java.util.*;
import java.io.*;
public class DLL<E extends Comparable<E>> {
  private DLLNode<E> head;
  private DLLNode<E> tail;
  private int size;

  /********************************************************************
	*
	* Method: DLL
	*
	* Description: Constructs an empty DLL
	*
	* @param  None
	*
	* @return None
	*
	********************************************************************/

  public DLL() {
    head = null;
    tail = null;
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
      head = new DLLNode(element);
      tail = head;
      added = true;
      size++;
    }
    else {
      tail.setNext(new DLLNode(element));
      tail.getNext().setPrevious(tail);
      tail = tail.getNext();
      added = true;
      size++;
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
      System.out.println(i + "in between for's");
      for(int j = i ; j > 0 ; j--){

        System.out.println(i + "After second for");
        System.out.println(size() + "Size");
        System.out.println("Before if " + get(j));
        if(get(j).compareTo(get(j-1)) < 0){
          System.out.println(get(j));
          swapNode(getNode(j), getNode(j-1));
        //  System.out.println(toString());
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

  private void swapNode(DLLNode<E> target, DLLNode<E> replace){
    if(replace == head){
      replace.setNext(target.getNext());
      if(replace.getNext() != null){
        replace.getNext().setPrevious(replace);
      }
      target.setNext(replace);
      replace.setPrevious(target);
      target.setPrevious(null);
      head = target;
    }
    else{
      replace.setNext(target.getNext());
      target.setPrevious(replace.getPrevious());
      replace.setPrevious(target);
      target.setNext(replace);
      target.getPrevious().setNext(target);
      if(replace.getNext() != null){
        replace.getNext().setPrevious(replace);
      }
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
    DLLNode temp = new DLLNode(element);
    if(index >= 0 && index < size) {
      if(index == 0) {
        temp.setNext(head);
        head.setPrevious(temp);
        head = temp;
      }
      else {
        DLLNode curr = head;
        for(int i = 0; i < index - 1; i++) {
          curr = curr.getNext();
        }
        temp.setNext(curr.getNext());
        if(temp.getNext() != null) {
          temp.getNext().setPrevious(temp);
        }
        curr.setNext(temp);
        temp.setPrevious(curr);
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
    tail = null;
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
    DLLIterator it = (DLLIterator) Iterator();
    while(it.hasNext() && !contains) {
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
	* @return data  The data of the DLLNode at the given index. If the
   *               index is out of bounds, then returns null
	*
	********************************************************************/

  public E get(int index) {
    E data = null;
    if(index >= 0 && index < size) {
      if(index < size/2) {
        DLLIterator it = (DLLIterator) Iterator();
        for(int i = 0; i <= index; i++) {
          data = it.next();
        }
      }
      else {
        DLLNode curr = tail;
        for(int i = size - 1; i > index; i--) {
          curr = curr.getPrevious();
        }
        data = (E) curr.getData();
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

  public DLLNode<E> getNode(int index) {
    DLLNode<E> node = null;
    if(index >= 0 && index < size) {
      if(index < size/2) {
        DLLIterator it = (DLLIterator) Iterator();
        for(int i = 0; i <= index; i++) {
          node = it.nextNode();
        }
      }
      else {
        DLLNode curr = tail;
        for(int i = size - 1; i > index; i--) {
          curr = curr.getPrevious();
        }
        node = curr;
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
    DLLIterator it = (DLLIterator) Iterator();
    while(it.hasNext() && index == -1) {
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
    int currIndex = size;
    E data;
    DLLNode curr = tail;
    while(curr != null && index == -1) {
      data = (E) curr.getData();
      currIndex -= 1;
      if(data == element) {
        index = currIndex;
      }
      curr = curr.getPrevious();
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
    DLLIterator it = (DLLIterator) Iterator();
    if(index >= 0 && index < size) {
      if(index == size - 1) {
        data = (E) tail.getData();
        tail = tail.getPrevious();
        if(tail != null) {
          tail.setNext(null);
        }
        size--;
      }
      else {
        for(int i = 0; i <= index; i++) {
          tempData = it.next();
        }
        data = tempData;
        it.remove();
        size--;
      }
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
    DLLIterator it = (DLLIterator) Iterator();
    if(head != null) {
      tempData = it.next();
      while(tempData != element && it.hasNext()) {
        tempData = it.next();
      }
      if(tempData == element) {
        data = tempData;
        it.remove();
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
    if(index >= 0 && index < size) {
      if(index == 0) {
        data = head.getData();
        head.setData(element);
      }
      else if(index == size - 1) {
        data = tail.getData();
        tail.setData(element);
      }
      else {
        DLLNode curr = head;
        for(int i = 0; i < index; i++) {
          curr = curr.getNext();
        }
        data = (E) curr.getData();
        curr.setData(element);
      }
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
    DLLIterator it = (DLLIterator) Iterator();
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
	* Description: Returns a DLLIterator
	*
	* @param  None
	*
	* @return A new DLLIterator object
	*
	***********************************************************************************/

  public Iterator<E> Iterator() {
    return new DLLIterator();
  }

  /*Private inner Iterator class*/
  private class DLLIterator implements ListIterator {

    private DLLNode<E> next;
    private DLLNode<E> prev;
    private DLLNode<E> last;

  /***********************************************************************************
	*
	* Method: DLLIterator
	*
	* Description: Constructs a DLLIterator
	*
	* @param  None
	*
	* @return None
	*
	***********************************************************************************/

    public DLLIterator() {
      next = head;
      prev = null;
      last = null;
    }

    /***********************************************************************************
	  *
	  * Method: hasNext
  	  *
	  * Description: Determines if this DLLIterator has a next element
 	  *
	  * @param  None
	  *
	  * @return true  If this DLLIterator has a next element
     *         false If this DLLIterator does not have a next element
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
	* Method: hasPrevious
	*
	* Description: Determines if this DLLIterator has a previous element
	*
	* @param  None
	*
	* @return true  If this DLLIterator has a previous element
   *         false If this DLLIterator does not have a previous element
	*
	***********************************************************************************/

      public boolean hasPrevious() {
      boolean hasPrevious = false;
      if(prev != null) {
        hasPrevious = true;
      }
      return hasPrevious;
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
        data = next.getData();
        last = next;
        prev = next;
        next = next.getNext();
      }
      return data;
    }

    /***********************************************************************************
    *
    * Method: nextNode
    *
    * Description: Returns the next element of this SLLIterator
    *
    * @param  None
    *
    * @return data  The next element, if this DLLIterator has a next element
     *         null  If this DLLIterator does not have a next element
    *
    ***********************************************************************************/
      public DLLNode<E> nextNode() {
        DLLNode<E> node = null;
        if(next != null) {
          node = next;
          last = next;
          prev = next;
          next = next.getNext();
        }
        return node;
      }

    /***********************************************************************************
	  *
	  * Method: previous
  	  *
	  * Description: Returns the previous element of this DLLIterator
	  *
	  * @param  None
	  *
	  * @return data  The previous element, if this DLLIterator has a next element
     *         null  If this DLLIterator does not have a next element
	  *
	  ***********************************************************************************/

    public E previous() {
      E data = null;
      if(prev != null) {
        data = prev.getData();
        last = prev;
        next = prev;
        prev = prev.getPrevious();
       }
      return data;
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
      if(last != null) {
        if(next == last) {
          if(next == head) {
            if(head == tail) {
              head = null;
              tail = null;
              next = null;
            }
            else {
              head = next.getNext();
              head.setPrevious(null);
              if(head.getNext() != null) {
                head.getNext().setPrevious(head);
              }
              next = head;
            }
          }
          else {
            prev.setNext(next.getNext());
            if(prev.getNext() != null) {
              prev.getNext().setPrevious(prev);
              next = next.getNext();
            }
            else {
              tail = null;
              next = null;
            }
          }
        }
        else if(prev == last) {
          if(prev == head) {
            if(head == tail) {
              prev = null;
              next = null;
              head = null;
              tail = null;
            }
            else {
              head = next;
              prev = null;
              next.setPrevious(prev);
            }
          }
          else {
            prev.getPrevious().setNext(next);
            if(next != null) {
              next.setPrevious(prev.getPrevious());
              prev = prev.getPrevious();
            }
            else {
              prev = prev.getPrevious();
              prev.setNext(next);
              tail = prev;
            }
          }
        }
        last = null;
      }
    }

    public void add(Object o) {
    }

    public void set(Object o) {
    }

    public int previousIndex() {
      return -1;
    }

    public int nextIndex() {
      return -1;
    }
  }
}
