func maxDifference(s string) int {
    if len(s) == 0 {
        return 0
    }
    freq := make(map[string]int)
    for _, ch := range s {
        if _, ok := freq[string(ch)]; ok {
            freq[string(ch)]++
        } else {
            freq[string(ch)] = 1
        }
    }

    max_odd := 0
    min_even := math.MaxInt64
    for _, val := range freq {
        if val % 2 == 0 {
            min_even = min(min_even, val)
        } else {
            max_odd = max(max_odd, val)
        }
    }

    return max_odd - min_even
}