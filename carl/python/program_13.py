# for program_13.md
def find_num_in_2darr(matrix:list, target: int) -> bool:
  if not matrix:
    return False
  
  m,n=len(matrix),len(matrix[0])
  # 从右上角元素开始开始
  i,j=0,n-1
  while i<m and j>=0:
    # 比 target 小，i++
    if matrix[i][j]<target:
      i+=1
    # 比 target 大，j--
    elif matrix[i][j]>target:
      j-=1
    # 相对 返回True
    elif matrix[i][j]==target:
      return True
  # 没找到
  return False


if __name__=='__main__':
  matrix=[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
print(find_num_in_2darr(matrix=matrix,target=17))