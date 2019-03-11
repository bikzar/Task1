package by.epam.training.javaweb.voitenkiv.task1.util.mycollection;

import by.epam.training.javaweb.voitenkiv.task1.util.mycollection.exception.IncorrectIndexOfElemException;
import by.epam.training.javaweb.voitenkiv.task1.util.mycollection.exception.InputElementIsNullException;
import by.epam.training.javaweb.voitenkiv.task1.util.mycollection.mycollectioninterface.MyList;

/**
 * @author Sergey Voitenkov March 10, 2019
 */

@SuppressWarnings("unchecked")
public class MyArrayList<E> implements MyList<E> {

	private Object[] list;
	private int indexOfPreviousElemOfList;
	private int indexOfNextElementOfList;
	private final static int DEFAULTSIZE = 10;

	{
		list = (E[]) new Object[DEFAULTSIZE];
	}

	public MyArrayList() {

	}

	public MyArrayList(int capacity) {
		if (capacity >= 0) {
			list = (E[]) new Object[capacity];
		}
	}

	public MyArrayList(Object[] list) {
		if (list != null && checkList(list)) {
			this.list = list;
			indexOfNextElementOfList = list.length;
			indexOfPreviousElemOfList = indexOfNextElementOfList - 1;
		}

	}

	public MyArrayList(MyList<? extends E> list) {
		this(list.toArray());
	}

	@Override
	public boolean add(E element) throws InputElementIsNullException {

		boolean resualt = false;

		if (element != null) {
			if (indexOfNextElementOfList < list.length) {

				list[indexOfNextElementOfList] = element;

			} else {

				E[] newList = (E[]) new Object[list.length * 2];

				int i;

				for (i = 0; i < list.length; i++) {
					newList[i] = (E) list[i];
				}

				newList[i] = element;

				list = newList;
			}

			resualt = true;

			indexOfNextElementOfList++;
			indexOfPreviousElemOfList = indexOfNextElementOfList - 1;

		} else {
			throw new InputElementIsNullException();
		}

		return resualt;
	}

	@Override
	public boolean contains(E searchingElement) {

		boolean resualt = false;

		if (indexOf(searchingElement) >= 0) {
			resualt = true;
		}

		return resualt;
	}

	@Override
	public boolean remove(E element) {

		boolean resualt = false;

		try {
			remove(indexOf(element));
			resualt = true;
		} catch (IncorrectIndexOfElemException e) {

		}

		return resualt;
	}

	@Override
	public Object[] toArray() {

		Object[] resualt = new Object[indexOfNextElementOfList];

		for (int i = 0; i < indexOfNextElementOfList; i++) {
			resualt[i] = list[i];
		}
		return resualt;
	}

	@Override
	public E get(int index) {

		if (index >= 0 && index < indexOfNextElementOfList) {
			return (E) list[index];
		}

		return null;
	}

	/*
	 * @return - (-1) if list doesen't have element or element is null. Index where
	 * element situated
	 */
	@Override
	public int indexOf(E element) {
		int resualt = -1;

		if (element != null) {
			for (int i = 0; i < indexOfNextElementOfList; i++) {
				if (list[i].equals(element)) {
					resualt = i;
					break;
				}
			}
		}
		return resualt;
	}

	@Override
	public boolean remove(int index)
			throws IncorrectIndexOfElemException {

		boolean resualt = false;

		if (index >= 0 && index <= indexOfPreviousElemOfList) {

			if (index != indexOfPreviousElemOfList) {

				for (int i = index; i < indexOfPreviousElemOfList; i++) {
					list[i] = list[i + 1];
					list[i + 1] = null;
				}
			}

			indexOfPreviousElemOfList--;
			indexOfNextElementOfList--;

			resualt = true;

		} else {
			throw new IncorrectIndexOfElemException();
		}

		return resualt;
	}

	@Override
	public boolean set(int index, E obj) {

		if (index >= 0 && index < indexOfNextElementOfList
				&& obj != null) {
			list[index] = obj;
		}

		return false;
	}

	/**
	 * @param list - range elements for check
	 * @return true - if list doesn't have null reference inside; false - list has
	 *         null reference inside;
	 */
	private boolean checkList(Object[] list) {

		boolean resualt = true;

		for (int i = 0; i < indexOfNextElementOfList; i++) {
			if (list[i] == null) {
				resualt = false;
			}
		}

		return resualt;
	}

}
