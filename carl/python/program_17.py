# for program_17.md

# 蛮力法
def find_super_small_list1(big:list,small:list)->list:
  # 特殊情况处理
  if not small or not big:
    raise('param illegal')
  for i in small:
    if i not in big:
      return []
  # 找出big中所有包含small元素的字串以及其位置 选择len最小的
  small_len=len(small)
  big_len=len(big)
  #enumerate
  sub_lists=list()
  sub_list=list()
  rear=small_len
  for i in range(big_len):
    count=0
    for ele in small:
      sub_list=big[i:rear]
      while ele not in sub_list:
        rear+=1
        sub_list=big[i:rear]
        if rear>=big_len:
          break
      if ele in sub_list:
        count+=1
      if count==small_len:
        sub_list_index=[i,rear-1]
        sub_list_info=(sub_list,sub_list_index)
        sub_lists.append(sub_list_info)
    i+=1
    

  min_len=len(sub_lists[0][0])
  min_index=sub_lists[0][1]
  for sub_list_info in sub_lists:
    now_len=len(sub_list_info[0])
    if now_len<min_len:
      min_len=now_len
      min_index=sub_list_info[1]
  return min_index

# 
def find_super_small_list2(big:list,small:list)->list:
  pass

if __name__=='__main__':
  big1 = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
  small1 = [1,5,9]
  big2 = [1,2,3]
  small2 = [1,2,3]
  print(find_super_small_list1(big1,small1))
  print(find_super_small_list1(big2,small2))