package by.epam.training.javaweb.voitenkiv.task1.util.mycollection;

public class MyLinkedList<E> {
	
	private int size = 0;
	private Elem<E> first;
	private Elem<E> last;
	
	
	
	
	
	private static class Elem<E>{
		E item;
		Elem<E> next;
		Elem<E> prev;
		
		Elem(Elem<E> prev, E element, Elem<E> next){
			this.item = element;
			this.prev = prev;
			this.next = next;
		}
	}
	
}

/* add(E h)
 * add (index ,e)
 * addFirst (E f)
 * addLast(E g)
 * contains
 * 
 */
