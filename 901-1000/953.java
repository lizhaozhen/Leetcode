class Solution {
    public String transform(String word, HashMap<Character,Character> hm){
        StringBuilder sb = new StringBuilder();
        for(char ch: word.toCharArray()){
            sb.append(hm.get(ch));
        }
        return sb.toString();
    }
    
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Character> hm = new HashMap<>();
        for(int i=0;i<order.length();i++){
            hm.put(order.charAt(i), (char)('a' + i));
        }
        
        for(int i=0;i<words.length-1;i++){
            if(transform(words[i], hm).compareTo(transform(words[i+1], hm)) > 0) return false;
        }
        return true;
    }
}