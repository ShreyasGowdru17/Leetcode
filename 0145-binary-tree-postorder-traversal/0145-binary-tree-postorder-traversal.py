# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        cur=root
        stack=[]
        ans=[]
        last=None

        while stack or cur:
            if cur:
                stack.append(cur)
                cur=cur.left
            else:
                peek=stack[-1]
                if peek.right and last!=peek.right:
                    cur=peek.right
                else:
                    ans.append(peek.val)
                    last=stack.pop()
        return ans
        