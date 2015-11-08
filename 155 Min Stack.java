/*
Min Stack 

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/

class MinStack {
     private Stack<Integer> s = new Stack<>();
    private Stack<Integer> sNew = new Stack<>();
    
    public void push(int x) {
       if(sNew.isEmpty() || (x < sNew.peek())) 
            sNew.push(x);
        s.push(x);    
    }

    public void pop() {
        if(sNew.peek().equals(s.peek()))//do not pop at first, it ill throw a exception if the stack is empty.
            sNew.pop();
        s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
       return sNew.peek(); 
    }
}
