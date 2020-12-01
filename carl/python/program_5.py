# for program_5.md
def repeated_substr1(parent_str):
  '''
  法1
  '''
  if not parent_str:
    return False
  parent_str_len=len(parent_str)
  if parent_str_len==1:
    return True
  # 遍历长度(1,parent_str_len//2+1)的所有子字符串
  # 所取的子字符串乘以切片数parent_str_len//i,得到的字符串若==原字符串，则返回True
  for i in range(1,parent_str_len//2+1):
    sub_str=parent_str[:i]
    if parent_str_len%i==0 and sub_str*(parent_str_len//i)==parent_str:
      return True
  return False

def repeated_substr2(parent_str):
  '''
  法 2
  '''
  pass

if __name__=="__main__":
  # case 1
  parent_str1="a"
  # case 2
  parent_str2="aa"
  # case 3
  parent_str3="abcabcabc"
  # case 4
  parent_str4="aabaabaab"
  # case 5
  parent_str5="abcabcdabcabdc"
  for s in [parent_str1,parent_str2,parent_str3,parent_str4,parent_str5]:
    # print(s)
    print(repeated_substr1(s))
    print(repeated_substr2(s))
    print("-----")


  
  
  