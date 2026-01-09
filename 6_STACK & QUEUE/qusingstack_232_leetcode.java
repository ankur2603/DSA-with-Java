Link : https://leetcode.com/problems/implement-queue-using-stacks/description/

class MyQueue {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MyQueue() {
    }
    
    public void push(int x) {

        // move everything to s2
        while (!s1.empty()) {
            s2.push(s1.pop());
        }

        s1.push(x);

        // move back so front stays on top
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
    }
    
    public int pop() {
        // front is always on top of s1
        return s1.pop();
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.empty();
    }
}
