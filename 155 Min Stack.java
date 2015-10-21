/*
Min Stack 

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/

class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> mini = new Stack<Integer>();
    public void push(int x) {
        if(mini.empty()){
            mini.push(x);
        }else{
            if((mini.peek()) > x){
                mini.push(x);
            }else{
                mini.push(mini.peek());
            }
        }
        stack.push(x);
    }

    public void pop() {
        mini.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return mini.peek();
    }
}
