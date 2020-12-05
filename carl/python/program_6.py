# for program_6.md
def find_max_sub_str1(parent_str:str)->int:
  if not parent_str:
    raise("parent_str is None!")
  parent_str_len=len(parent_str)
  now_len=0
  max_len=0
  for i in range(parent_str_len):
    sub_str=parent_str[i:]
    sub_str_len=len(sub_str)+1
    for j in range(1,sub_str_len):
      sub_sub_str=sub_str[i:j]
      if not is_repeatd(sub_sub_str):
        now_len=len(sub_sub_str)
      if now_len>=max_len:
        max_len=now_len
  return max_len

def is_repeatd(sub_str:str)->bool:
  if len(sub_str)==1:
    return False
  for i in sub_str:
    if sub_str.count(i)>1:
      return True
  return False

def find_max_sub_str2(parent_str:str)->int:
  '''双指针 滑动窗口'''
  parent_str_len=len(parent_str)
  next_index_map=dict()
  head,max_len=0,0
  for tail in range(parent_str_len):
    if parent_str[tail] in next_index_map:
      head=max(head,next_index_map[parent_str[tail]])
    next_index_map[parent_str[tail]]=tail+1
    max_len=max(max_len,tail-head+1)
  return max_len

if __name__=='__main__':
  parent_str1="aaaa"
  parent_str2="abcabcabcd"
  parent_str3="pwwkew"

  for parent_str in [parent_str1,parent_str2,parent_str3]:
    print(find_max_sub_str1(parent_str))
    print('-'*2)
    print(find_max_sub_str2(parent_str))
    print('- -'*8)
