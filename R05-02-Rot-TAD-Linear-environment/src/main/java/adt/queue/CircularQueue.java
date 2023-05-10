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
		else if(this.isEmpty()) {
			tail++;
			head++;
			array[0] = element;
			elements++;
		}
		this.tail = (tail + 1) % array.length;
		array[tail] = element;
		elements++;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(this.isEmpty()) {
			throw new QueueUnderflowException();
		}
		T aux = array[head];
		this.head = (head + 1) % array.length;
		array[head] = null;
		elements--;
		return aux;
	}

	@Override
	public T head() {
		return array[head];
	}

	@Override
	public boolean isEmpty() {
		return (tail == -1 && head == -1);
		}

	@Override
	public boolean isFull() {
		return elements == array.length;
		}

}
