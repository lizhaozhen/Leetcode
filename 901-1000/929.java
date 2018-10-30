class Solution {
    public String parseEmail(String email){
        StringBuilder sb = new StringBuilder();
        boolean ignore = false;
        boolean isDomain = false;
        for(int i=0;i<email.length();i++){
            char ch = email.charAt(i);
            
            if(isDomain){
                sb.append(ch);
            }
            else{
                if(ch == '@'){
                    sb.append(ch);
                    isDomain = true;
                    continue;
                }
                
                if(!ignore){
                    if(ch == '.'){
                        
                    }
                    else if(ch == '+'){
                        ignore = true;
                    }
                    else{
                        sb.append(ch);
                    }
                }
            }
        }
        return sb.toString();
    }
    
    public int numUniqueEmails(String[] emails) {
        HashSet<String> hs = new HashSet<>();
        for(String email:emails){
            hs.add(parseEmail(email));
        }
        return hs.size();
    }
}