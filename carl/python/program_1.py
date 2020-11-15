# for program_1 
class Solution(object):
    def find_leng_for_lcis(self,nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #假设初始最长且连续的的递增序列为0
        lens = len(nums)
        if lens == 0:
            return 0
        max_lengs = 1
        now_lengs = 1
        for i in range(lens-1):
            if nums[i] < nums[i+1]:
                #当前递增长度加1
                now_lengs += 1
                #与最大长度对比，看是否更新
                if now_lengs > max_lengs:
                    max_lengs = now_lengs
            else:
                now_lengs = 1
        return max_lengs 
        
if __name__ == "__main__":
  nums=[1,3,5,4,7]
  solution=Solution().find_leng_for_lcis(nums)
  print(solution)