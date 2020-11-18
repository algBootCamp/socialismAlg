# for program_2
class Solution(object):
    def find_len_for_lis_nums(self, nums):
        '''
        1 先找出以每个下标为起点的递增子序列
        2 统计以每个下标为起点的递增子序列的长度
        3 取最长递增子序列的个数
        '''
        if nums is None or len(nums) == 0:
            return 0

        len_list = []
        lens = len(nums)
        for i in range(lens-1):
            now_len = 1
            max_len = 1
            # 哨兵
            index = i
            for j in range(i + 1, lens):
                if nums[index] < nums[j]:
                    now_len += 1
                    index = j

            if max_len < now_len:
                max_len = now_len
            len_list.append(max_len)
        # 最后一个元素的最长递增子序列的个数
        len_list.append(1)
        max_len = 1
        len_list.sort(reverse=True)
        # print(len_list)
        for num in len_list[1:]:
            if len_list[0] == num:
                max_len += 1
        return max_len


if __name__ == "__main__":
    nums1 = [1, 0, 3, 2, 5, 4, 7]
    nums2 = [2, 2, 2, 2, 2]
    solution = Solution()
    print(solution.find_len_for_lis_nums(nums=nums1))
    print(solution.find_len_for_lis_nums(nums=nums2))