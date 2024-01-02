class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] freq = new int[nums.length+1];
        ArrayList<List<Integer>> ans = new ArrayList<>();

        for(int n: nums) {
            if(freq[n] >= ans.size()) ans.add(new ArrayList<>());

            ans.get(freq[n]).add(n);
            freq[n]++;
        }

        return ans;
    }
}