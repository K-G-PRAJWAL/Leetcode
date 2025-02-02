func twoSum(nums []int, target int) []int {
    hash := make(map[int]int)

    for i, n := range(nums) {
        diff := target - n

        if j, ok := hash[diff]; ok {
            return []int{j, i}
        }

        hash[n] = i
    }
    return nil
}