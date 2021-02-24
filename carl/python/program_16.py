# for program_16.md

def median_slidingWindow(nums:list,k:int)->list:
  if not nums or len(nums)<1 or k<1:
    raise('param illegal')
  
  nums_len=len(nums)
  median_list=list()
  for i in range(nums_len-k+1):
    temp_list=sorted(nums[i:i+k])
    if k%2==0:
      median_list.append((temp_list[int(k/2)]+temp_list[int(k/2-1)])/2)
    else:
      median_list.append(temp_list[k//2])
  return median_list


if __name__=='__main__':
  nums = [1,3,-1,-3,5,3,6,7]
  k0 = 2
  k1 = 3
  k2 = 4
  print(median_slidingWindow(nums,k0))
  print(median_slidingWindow(nums,k1))
  print(median_slidingWindow(nums,k2))