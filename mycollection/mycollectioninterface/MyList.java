package by.epam.training.javaweb.voitenkiv.task1.util.mycollection.mycollectioninterface;

import by.epam.training.javaweb.voitenkiv.task1.util.mycollection.exception.IncorrectIndexOfElemException;

public interface MyList<E> extends MyCollection<E> {

	public E get(int index);

	public int indexOf(E element);

	public boolean remove(int index)
			throws IncorrectIndexOfElemException;

	public boolean set(int index, E obj);

	/*
	 * public Credit get(int index); public int indexOf(Credit element); public
	 * boolean remove(int index) throws IncorrectIndexOfElemException; public
	 * boolean set(int index, Credit obj);
	 */
}
