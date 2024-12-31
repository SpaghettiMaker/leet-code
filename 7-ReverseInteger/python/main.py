class Solution:
    def reverse(self, x: int) -> int:
        if abs(x) >= 2**31-1:
            return 0
        if x < 0:
            return self.reverseInt(str(x*-1), True)
        else:
            return self.reverseInt(str(x), False)
        

    def reverseInt(self, x: str, y: bool):
        solution = int(x[::-1])
        if y:
            solution = solution * -1
        return solution
