Link : https://leetcode.com/problems/min-stack/description/

class MinStack {

    long min;                     // use long to avoid overflow
    Stack<Long> s = new Stack<>();

    public MinStack() {
    }
    
    public void push(int val) {
        // first element
        if(s.isEmpty()){
            min = val;
            s.push((long)val);
        }
        else{
            // encode when new value is smaller
            if(val < min){
                s.push(2L * val - min);
                min = val;
            }
            else{
                s.push((long)val);
            }
        }
    }
    
    public void pop() {
        // if encoded value, restore previous min
        if(s.peek() < min){
            min = 2 * min - s.peek();
        }
        s.pop();
    }
    
    public int top() {
        // encoded value represents current min
        if(s.peek() < min){
            return (int)min;
        }
        return s.peek().intValue();
    }
    
    public int getMin() {
        return (int)min;
    }
}
