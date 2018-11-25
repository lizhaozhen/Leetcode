class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> hs = new HashSet<>();
        int ac = 0;
        int bc = 0;
        while(bc<popped.length){
            if(hs.contains(popped[bc])){
                int t = stack.pop();
                if(t != popped[bc]) return false;
                bc++;
            }
            else{
                stack.push(pushed[ac]);
                hs.add(pushed[ac++]);
            }
        }
        return true;
    }
}