/*
Implement Stack using Queues 

Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
Update (2015-06-11):
The class name of the Java function had been updated to MyStack instead of Stack.
*/

class MyStack {
    LinkedList<Integer> current = new LinkedList<Integer>();
    LinkedList<Integer> buffer = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        while(current.size() != 0){
            buffer.add(current.remove());   // remove the head, add to the end
        }
        current.add(x);
        while(buffer.size() != 0){
            current.add(buffer.remove());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(current.size() != 0){
            current.remove();
        }
    }

    // Get the top element.
    public int top() {
        return current.get(0);
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return current.size() == 0;    
    }
}