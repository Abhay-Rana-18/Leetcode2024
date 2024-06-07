class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String>set = new HashSet<>(dictionary);
        List<String> temp = new ArrayList<>(Arrays.asList(sentence.split(" ")));
        StringBuilder sb = new StringBuilder();

        for (String str: temp) {
            int i=1;
            while (i<=str.length()) {
                String sub = str.substring(0, i);
                if (set.contains(sub)) {
                    sb.append(sub).append(" ");
                    break;
                }
                i++;
            }
            if (i==str.length()+1) {
                sb.append(str).append(" ");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
