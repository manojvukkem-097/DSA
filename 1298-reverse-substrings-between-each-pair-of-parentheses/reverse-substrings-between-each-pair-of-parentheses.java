class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder>s1=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                s1.push(sb);
                sb=new StringBuilder();
            }else if(ch==')'){
                sb=sb.reverse();
                sb=s1.pop().append(sb);
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}