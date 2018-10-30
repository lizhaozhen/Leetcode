class Solution {
    public int[] beautifulArray(int N) {
        ArrayList<Integer> p = new ArrayList<>();
        p.add(1);
        
        while(p.size() < N){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int num: p){
                if(num * 2 - 1 <= N){
                    temp.add(num*2-1);
                }
            }
            for(int num: p){
                if(num * 2 <= N){
                    temp.add(num*2);
                }
            }
            p = temp;
        }
        return p.stream().mapToInt(i -> i).toArray();
    }
}