package roundone;

public class Solution1381 {

    static class CustomStack {
        int[] stack ;
        int size=0;
        int currentIndex =0;
        public CustomStack(int maxSize) {
            stack= new int[maxSize];
            this.size = maxSize;
        }

        public void push(int x) {
            if(currentIndex==size){
                return;
            }
            stack[currentIndex++]=x;
        }

        public int pop() {
            if(currentIndex==0){
                return -1;
            }
            return stack[--currentIndex];
        }

        public void increment(int k, int val) {
            if(k>size){
                for(int i=0;i<stack.length;i++){
                    stack[i]+=val;
                }
                return;
            }
            for(int i=0;i<k;i++){
                stack[i]+=val;
            }
        }
    }

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3); // Stack is Empty []
        customStack.push(1);                          // stack becomes [1]
        customStack.push(2);                          // stack becomes [1, 2]
        System.out.println(customStack.pop());;                            // return 2 --> Return top of the stack 2, stack becomes [1]
        customStack.push(2);                          // stack becomes [1, 2]
        customStack.push(3);                          // stack becomes [1, 2, 3]
        customStack.push(4);                          // stack still [1, 2, 3], Don't add another elements as size is 4
        customStack.increment(5, 100);                // stack becomes [101, 102, 103]
        customStack.increment(2, 100);                // stack becomes [201, 202, 103]
        System.out.println(customStack.pop());                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
        System.out.println(customStack.pop());                            // return 202 --> Return top of the stack 102, stack becomes [201]
        System.out.println(customStack.pop());                            // return 201 --> Return top of the stack 101, stack becomes []
        System.out.println(customStack.pop());
    }

}
