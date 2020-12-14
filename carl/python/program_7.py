# for program_7.md
def find_repeat_num(nums:list)->int:
  if not nums or len(nums)<1:
    raise("nums Illegal！")
  res=0
  for num in range(len(nums)):
    if num == 0:
      res^=nums[num]
      continue
    res^=nums[num]
    res^=num
  return res
    
if __name__=='__main__':
  arr1=[1,3,4,2,5,3]
  arr2=[ x for x in range(1,1001)]
  arr2.append(5)
  print(find_repeat_num(arr1))
  print("-"*6)
  print(find_repeat_num(arr2))