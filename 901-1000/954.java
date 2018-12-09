class Solution {
    public boolean canReorderDoubled(int[] A) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();
        for(int a: A){
            hm.put(a, hm.getOrDefault(a, 0) + 1);
            hs.add(a);
        }
        
        Integer[] B = hs.toArray(new Integer[hs.size()]);
        Arrays.sort(B);
        
        for(int num: B){
            if(num == 0){
                if(hm.get(0) % 2 != 0) return false;
            }
            else{
                int cur = hm.getOrDefault(num, 0);
                if(num < 0){
                    if(num%2 != 0){
                        if(cur == 0) continue;
                        return false;
                    }
                }
                int nextNum = num < 0 ? num / 2 : num * 2;
                int next = hm.getOrDefault(nextNum, 0);
                if(cur > next) return false;
                hm.put(nextNum, next-cur);
            }
        }
        
        return true;
    }
}