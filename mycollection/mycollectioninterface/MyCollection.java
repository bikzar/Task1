package by.epam.training.javaweb.voitenkiv.task1.util.mycollection.mycollectioninterface;

import by.epam.training.javaweb.voitenkiv.task1.util.mycollection.exception.InputElementIsNullException;

public interface MyCollection<E> {
	
	public boolean add(E element) throws InputElementIsNullException;
	public boolean contains(E searchingElement);
	public boolean remove(E element);
	public Object[] toArray();
	
		
	/*public boolean add(Credit element) throws InputElementIsNullException;
	public boolean contains(Credit searchingElement);
	public boolean remove(Credit element);
	public Credit[] toArray();*/
}
