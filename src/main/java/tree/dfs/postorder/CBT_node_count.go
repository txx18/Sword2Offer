package main

import "math"

func main() {

}

func countNodes(root *TreeNode) int {
	dl, dr := 0, 0
	pl, pr := root, root
	for pl.Left != nil {
		dl++
		pl = pl.Left
	}
	for pr.Right != nil {
		dr++
		pr = pr.Right
	}
	if dl == dr {
		return int(math.Pow(2, float64(dr-1)))
	}
	left := countNodes(root.Left)
	right := countNodes(root.Right)
	return 1 + left + right
}
