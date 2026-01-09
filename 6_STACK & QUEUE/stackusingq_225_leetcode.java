Link : https://leetcode.com/problems/implement-stack-using-queues/description/

class MyStack {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {
        // push into the active queue
        if (!q1.isEmpty()) {
            q1.add(x);
        } else {
            q2.add(x);
        }
    }

    public int pop() {
        if (empty()) return -1;

        int top = -1;

        // leave last element behind
        if (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                top = q1.remove();
                if (!q1.isEmpty()) q2.add(top);
            }
        } else {
            while (!q2.isEmpty()) {
                top = q2.remove();
                if (!q2.isEmpty()) q1.add(top);
            }
        }

        return top;
    }

    public int top() {
        if (empty()) return -1;

        int top = pop();   // reuse pop logic
        push(top);         // restore stack
        return top;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
