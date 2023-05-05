package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(this.isFull()) {
			throw new QueueOverflowException();
		}
		tail++;
		array[tail % array.length] = element;
		elements++;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(!this.isEmpty()) {
			head++;
			T aux = array[head];
			array[head] = null;
			return aux;
		}
		throw new QueueUnderflowException();
	}

	@Override
	public T head() {
		return array[head];
	}

	@Override
	public boolean isEmpty() {
		return tail == -1;
		}

	@Override
	public boolean isFull() {
		return elements == array.length;
		}

}
