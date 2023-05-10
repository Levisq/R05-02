package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull()) {
			throw new QueueOverflowException();
		}
		try {
			stack1.push(element);
			
		} catch (Exception e) {
			throw new QueueOverflowException();
		}
		
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T aux;
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		try {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			aux = stack2.pop();
			while(!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
			
		} catch (Exception e) {
			throw new QueueUnderflowException();
		}
		return aux;
	}

	@Override
	public T head() {
		T aux;
		while(!stack1.isEmpty()) {
			try {
				stack2.push(stack1.pop());
			} catch (StackOverflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (StackUnderflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		aux = stack2.top();
		while(!stack2.isEmpty()) {
			try {
				stack1.push(stack2.pop());
			} catch (StackOverflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (StackUnderflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return aux;
	}

	@Override
	public boolean isEmpty() {
		return stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return stack1.isFull();
	}

}

		