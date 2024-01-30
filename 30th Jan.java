class Solution {
    public int evalRPN(String[] tokens) {
        Stack stack = new Stack();
        for (int i=0; i<tokens.length; i++) {
            if (tokens[i].equals("+")) {
              
                    int num1 = Integer.parseInt((String)stack.pop());
                    int num2 = Integer.parseInt((String)stack.pop());
                
                stack.push((num1+num2)+"");
                System.out.println(num1+num2);
            }
            else if (tokens[i].equals("-")) {

                    int num1 = Integer.parseInt((String)stack.pop());
                
                    int num2 = Integer.parseInt((String)stack.pop());
                
                stack.push((num2-num1)+"");
            }
            else if (tokens[i].equals("*")) {
            
                    int num1 = Integer.parseInt((String)stack.pop());
                
                    int num2 = Integer.parseInt((String)stack.pop());
                
                stack.push((num1*num2)+"");
            }
            else if (tokens[i].equals("/")) {
                
                    int num1 = Integer.parseInt((String)stack.pop());
                    int num2 = Integer.parseInt((String)stack.pop());
                    if (num2==0) {
                        stack.push(0+"");
                    } else {
                        stack.push((num2/num1)+"");
                    }
                
                
                // System.out.println((int)num1/num2);
            }
            else {
                stack.push(tokens[i]);
            }
        }

        // while (!stack.isEmpty()) {
        //     System.out.println(stack.pop());
        // }
        
        return Integer.parseInt((String)stack.peek()); 
            
        
    }
}
