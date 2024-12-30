class Solution:

    def lengthOfLongestSubstring(self, s: str) -> int:
        max = ""
        for index in range(len(s)):
            temp = self.getSequence(s[index:])
            if len(temp) > len(max):
                max = temp
        return len(max)

    def getSequence(self, s:str):
        temp = ""
        for i in range(len(s)):
            if temp.find(s[i]) != -1:
                break
            temp += s[i]
        return temp

