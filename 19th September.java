class Solution {
    private Set<Character> operators = new HashSet<>(Arrays.asList('+', '-', '*'));
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<expression.length(); i++) {
            char op = expression.charAt(i);
            if(operators.contains(op)) {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                for (int l: left) {
                    for (int r: right) {
                        if (op == '+') {
                            ans.add(l+r);
                        }
                        else if(op == '-') {
                            ans.add(l-r);
                        }
                        else if(op == '*') {
                            ans.add(l*r);
                        }
                    }
                }
            }
        }
        if(ans.isEmpty()) {
            ans.add(Integer.parseInt(expression));
        }
        
        return ans;
    }
}
