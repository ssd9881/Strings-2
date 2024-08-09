// TC-O(m+n), sc -O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int match=0;
        for(int i =0;i<p.length();i++){
            char c = p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i=0;i<s.length();i++){
            // in
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int cnt = map.get(in)-1;
                map.put(in,cnt);
                if(cnt==0){
                    match++;
                }
            }
            // out
            if(i>=p.length()){
            char out = s.charAt(i-p.length());
            if(map.containsKey(out)){
                int cnt = map.get(out)+1;
                map.put(out,cnt);
                if(cnt==1){
                    match--;
                }
            }
            }

            if(match==map.size()){
                result.add(i-p.length()+1);
            }
        }
        return result;
    }
}