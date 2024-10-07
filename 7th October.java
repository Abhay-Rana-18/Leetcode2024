class Solution {
    public int minLength(String s) {
        
        while(s.indexOf("AB") != -1 || s.indexOf("CD") != -1){
            if(s.indexOf("AB") != -1){
                s = s.replace("AB","");
            }
            if(s.indexOf("CD") != -1){
                s = s.replace("CD","");
            }
        }

        return s.length();

    }
}
