# towSum
def tow_sum1(target:int,nums:list)->list:
  if not nums or len(nums)<2:
    raise("input nums illegal")
  
  nums_len=len(nums)
  j=-1
  for i in range(1,nums_len):
    temp_list=nums[:i]
    if (target-nums[i]) in temp_list:
      j=temp_list.index(target-nums[i])
      break
  if j>0:
    return[j,i]
    
def tow_sum2(target:int,nums:list)->list:
  if not nums or len(nums)<2:
    raise("input nums illegal")
  hash_map=dict()
  for i,num in enumerate(nums):
    if hash_map.get(target-num) is not None:
      return [i,hash_map.get(target-num)]
    hash_map[num]=i

