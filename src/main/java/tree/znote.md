如何判断一颗二叉树是否是搜索二叉树？
如何判断一颗二叉树是完全二叉树？
如何判断一颗二叉树是否是满二叉树？
如何判断一颗二叉树是否是平衡二叉树？（二叉树题目套路）

#什么时候用套路？
dp问题——可以向左子树要信息&向右子树要信息

对任意节点，要左树什么信息，右树什么信息

## 平衡二叉树：
左isBBT，右isBBT，|左h - 右h| < 2
## 搜索二叉树：
左isBST，右isBST，左max，右min 
—— 左树和右树要求求全集 —— 
左isBST，右isBST，左max&min，右max&min 







直接或间接考察遍历 26 34 55 7 33
BFS 32
二叉搜索树 36 68
堆和红黑树 4000