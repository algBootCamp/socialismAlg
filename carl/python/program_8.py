# for program_8.md 三数之和
def mul_nums_sum(nums:[int],target=0)->[[int]]:
  if not nums or len(nums)<3:
    raise("nums illegal")
  #nums=sorted(nums)
  nums.sort()
  nums_len=len(nums)
  res=list()
  for i in range(nums_len-2):
    # sorted,nums[i] is smallest!
    if nums[i]>target:
      return res 
    
    mid_target=target-nums[i]
    # skip the same ele
    if i>0 and nums[i]==nums[i-1]:
      continue

    j,k=i+1,nums_len-1
    while j<k:
      tow_sum_res=nums[j]+nums[k]
      if tow_sum_res<mid_target:
        j+=1
        # skip the same ele
        while j<k and nums[j]==nums[j-1]:
          j+=1
      elif tow_sum_res>mid_target:
        k-=1
        # skip the same ele
        while j<k and nums[k]==nums[k+1]:
          k-=1
      else:
        res.append([nums[i], nums[j], nums[k]])
        j+=1
        k-=1
        # skip the same ele
        while j<k and nums[k]==nums[k+1]:
          k-=1
        while j<k and nums[j]==nums[j-1]:
          j+=1
  return res

# test
if __name__=='__main__':
  target1=0
  target2=2
  nums1=[-1,1,2,5,-9,-4,3,-9]
  nums2=[-1,1,0,5,-9,-4,3,2,1,0,6,-9]
  nums3=[-6,0,2,4,-9,-4,3,-9]

  print(mul_nums_sum(nums1,target1))
  print(mul_nums_sum(nums2,target1))
  print(mul_nums_sum(nums3,target1))
  print(mul_nums_sum(nums1,target2))
  print(mul_nums_sum(nums2,target2))
  print(mul_nums_sum(nums3,target2))







