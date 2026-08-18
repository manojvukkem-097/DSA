class Solution {
    public boolean isValid(String s) {
        Stack<Character>a=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                a.push(ch);
            }else{
                if(a.isEmpty()){
                    return false;
                }
                char top=a.peek();
                if((ch==')'&& top=='(')||(ch=='}'&& top=='{')||(ch==']'&& top=='[')){
                    a.pop();
                }else{
                    return false;
                }
            }
        }
        return a.isEmpty();
    }
}