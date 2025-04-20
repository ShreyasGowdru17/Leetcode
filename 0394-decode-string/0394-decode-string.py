class Solution:
    def decodeString(self, s: str) -> str:
        stack=[]
        curStr=""
        curNum=0
        prevStr=""
        prevNum=0
        for char in s:
            if char=="[":
                stack.append(curStr)
                stack.append(curNum)
                curStr=""
                curNum=0
            elif char.isdigit():
                curNum=curNum*10+int(char)
            elif char.isalpha():
                curStr+=char
            elif char=="]":
                prevNum=stack.pop()
                prevStr=stack.pop()
                curStr=prevStr+curStr*prevNum
        return curStr
        