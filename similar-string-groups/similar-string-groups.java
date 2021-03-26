class Solution {
    
     public int numSimilarGroups(String[] A) {
        if(A.length < 2) return A.length;
        int res = 0;
        for(int i=0;i<A.length;i++){
            if(A[i] == null) continue;
            String str = A[i];
            A[i] = null;
            res++;
            dfs(A,str);
        }
        return res;
    }
    public void dfs(String[] arr,String str){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == null) continue;
            if(helper(str,arr[i])){// both string str and arr[i] belong in same group
                String s = arr[i];
                arr[i] = null;
                dfs(arr,s);
            }
        }
    }
    public boolean helper(String s,String t){
        int res = 0, i = 0;
        while(res <= 2 && i < s.length()){
            if(s.charAt(i) != t.charAt(i)) res++;
            i++;
        }
        return res == 2 || res == 0;
    }
    
    
//     public int numSimilarGroups(String[] strs) {
//         List<List<String>> groupList = new LinkedList();
        
//         groupList.add(new ArrayList(List.of(strs[0])));
        
//         for(int i = 1; i < strs.length; i++){
//             boolean isSimilar = false;
//             for(int j = 0; j < groupList.size(); j++){
//                 for(int k = 0; k < groupList.get(j).size(); k++){
//                     if(isSimilar(groupList.get(j).get(k), strs[i])){
//                        groupList.get(j).add(strs[i]);
//                        isSimilar = true; 
//                        break;
//                     }
//                 }
//                 //if(isSimilar) break;
//             }
            
//             if(!isSimilar){
//                 groupList.add(new ArrayList(List.of(strs[i])));
//             }
            
//         }
        
//         return  groupList.size();
//     }
    
//     public boolean isSimilar(String s1, String s2){
//         int count = 0;
        
//         for(int i = 0; i < s1.length(); i++){
//             if(s1.charAt(i) != s2.charAt(i)){
//                 count++;
//             }
//         }
//         //System.out.println(s1 + " | " + s2 + " | " + count);
//         if(count == 0 || count == 2) total++;
//         return count == 0 || count == 2;
//     }
}