package main

func main() {

}

func isPowerOfTwo1(n int) bool {
	if n <= 0 {
		return false
	}
	t := n & (-n)
	return n == t
}

func isPowerOfTwo2(n int) bool {
	if n <= 0 {
		return false
	}
	t := n & (n - 1)
	return t == 0
}
