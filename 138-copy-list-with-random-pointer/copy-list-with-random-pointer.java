/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)return head;
        Node temp=head;
        while(temp!=null){
            Node copy=new Node(temp.val);
            copy.next=temp.next;
            temp.next=copy;
            temp=copy.next;
        }
        temp=head;
        while(temp!=null){
            if(temp.random!=null){
                temp.next.random=temp.random.next;
            }
            temp=temp.next.next;
        }
        Node ans=new Node(-1);
        Node dummy=ans;
        temp=head;
        while(temp!=null){
            dummy.next=temp.next;
            temp.next=temp.next.next;
            dummy=dummy.next;
            temp=temp.next;
        }
        return ans.next;
    }
}