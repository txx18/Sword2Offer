package main

func main() {

}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isBalanced(root *TreeNode) bool {
	return postorderHeight(root) != -1
}

func postorderHeight(root *TreeNode) int {
	if root == nil {
		return 0
	}
	hLeft := postorderHeight(root.Left)
	if hLeft == -1 {
		return -1
	}
	hRight := postorderHeight(root.Right)
	if hRight == -1 {
		return -1
	}
	if abs(hLeft-hRight) > 1 {
		return -1
	}
	return 1 + max(hLeft, hRight)
}

func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
