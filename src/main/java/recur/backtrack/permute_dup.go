package main

import "sort"

func main() {

}

func permuteUnique(nums []int) [][]int {
	var res [][]int
	var track []int
	hasUsed := make([]bool, len(nums))
	sort.Ints(nums)
	var bt func()
	bt = func() {
		if len(track) == len(nums) {
			tmp := make([]int, len(nums))
			copy(tmp, track)
			res = append(res, tmp)
			/*			res = append(res, append([]int(nil), track...))*/
		}
		for i := 0; i < len(nums); i++ {
			if hasUsed[i] {
				continue
			}
			if i > 0 && nums[i-1] == nums[i] && !hasUsed[i-1] {
				continue
			}
			track = append(track, nums[i])
			hasUsed[i] = true
			bt()
			track = track[:len(track)-1]
			hasUsed[i] = false
		}
	}
	bt()
	return res
}
