# for program_4.md
class Node(object):
  '''
  define node
  '''
  def __init__(self,val,_next=None):
    self.val=val
    self._next=_next

class ChainTable(object):
  '''
  define ChainTable
  '''
  def __init__(self,head,length=0):
    self.head=head
    self.length=length
  
  def add(self,data_or_node):
    '''add node'''
    item=None
    if isinstance(data_or_node,Node):
      item=data_or_node
    else:
      item=Node(data_or_node)
    
    if not self.head:
      self.head=item
      self.length+=1
    else:
      cur_node=self.head
      while cur_node._next:
        cur_node=cur_node._next
      cur_node._next=item
      self.length+=1
  
  def split_chain_table_by_k(self,k):
    '''split chain_table by k'''
    if not isinstance(k,int):
      raise("type of k error!")
    if k<1 or k>50:
      raise("param of k out of range!")
    
    res=[]
    remainder=0
    split_num=1
    if k>=self.length:
      split_num=k
      cur_node=self.head
      while split_num>0:
        if cur_node:
          res.append([cur_node.val])
        else:
          res.append([])
        if cur_node:
          cur_node=cur_node._next
        split_num-=1
      return res

    split_num=self.length//k
    print(split_num)
    remainder=self.length%k
    print(remainder)
    print(self.length)
    cur_node=self.head
    count=0
    while cur_node:
      ele=[]
      if remainder>0:
        count=split_num+1
      else:
        count=split_num
      while count>0:
        ele.append(cur_node.val)
        count-=1
        cur_node=cur_node._next
      res.append(ele)
      remainder-=1
    return res

if __name__=='__main__':
  nums=[1,2,3,4,5,6,7,8,9,10,11]
  k1=15
  k2=3
  root=Node(nums[0])
  chain_table=ChainTable(root,1)
  for num in nums[1:]:
    chain_table.add(num)
  # case 1
  print(chain_table.split_chain_table_by_k(k=k1))
  print("--------------------------------- ----------------------------")
  # case 2
  print(chain_table.split_chain_table_by_k(k=k2))


  

    



      