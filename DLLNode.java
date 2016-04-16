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
 * FILE: DLLNode.java
 *
 * DESCRIPTION: This file contains the DLLNode class
 *
 ***************************************************************************************/
 
public class DLLNode<E> {
  private E data;
  private DLLNode<E> prev;
  private DLLNode<E> next;
  
  /********************************************************************
	*
	* Method: DLLNode
	*
	* Description: Costructs an DLLNode object
	*
	* @param  newData  The data which the DLLNode should contain
	* 			
	* @return None
	* 		
	********************************************************************/
   
  public DLLNode(E newData) {
    this.data = newData;
    this.prev = null;
    this.next = null;
  }
  
  /********************************************************************
	*
	* Method: setData
	*
	* Description: Sets the data of this DLLNode to the given data
	*
	* @param  newData  The data which the DLLNode should contain
	* 			
	* @return None
	* 		
	********************************************************************/
   
  public void setData(E newData) {
    this.data = newData;
  }
  
  /********************************************************************
	*
	* Method: setPrevious
	*
	* Description: Sets the prev field of this DLLNode to the given DLLNode
	*
	* @param  newPrev  The DLLNode that prev should point to
	* 			
	* @return None
	* 		
	********************************************************************/
   
  public void setPrevious(DLLNode newPrev) {
    this.prev = newPrev;
  }
  
  /********************************************************************
	*
	* Method: setNext
	*
	* Description: Sets the next field of this DLLNode to the given DLLNode
	*
	* @param  newNext  The DLLNode that next should point to
	* 			
	* @return None
	* 		
	********************************************************************/
   
  public void setNext(DLLNode newNext) {
    this.next = newNext;
  }
  
  /********************************************************************
	*
	* Method: getData
	*
	* Description: Gets the data of this DLLNode
	*
	* @param  None
	* 			
	* @return this.data  The data that this DLLNode contains
	* 		
	********************************************************************/
   
  public E getData() {
    return this.data;
  }
  
  /********************************************************************
	*
	* Method: getPrevious
	*
	* Description: Gets the DLLNode in the prev field of this DLLNode
	*
	* @param  None
	* 			
	* @return this.prev  The DLLNode that prev points to
	* 		
	********************************************************************/
   
  public DLLNode getPrevious() {
    return this.prev;
  }
  
  /********************************************************************
	*
	* Method: getNext
	*
	* Description: Gets the DLLNode in the next field of this DLLNode
	*
	* @param  None
	* 			
	* @return this.next  The DLLNode that next points to
	* 		
	********************************************************************/
   
  public DLLNode getNext() {
    return this.next;
  }
}