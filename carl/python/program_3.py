# for program_3.md
# 写了一个小时 有点尴尬😅。。。。。。
class Node(object):
  """
  ChainTable node define
  """
  # def __new__(cls):
  #   return super(Node,cls).__new__(cls)
  def __init__(self,val,_next=None):
    self.val=val
    self._next=_next

class ChainTable(object):
  '''
  ChainTable  define 
  '''
  def __init__(self):
    self.head = None
    self.length = 0
 
  def is_empty(self):
    '''链表判空'''
    return (self.length == 0)
        
  def add(self,data_or_node):
    '''新增节点'''
    item = None
    if isinstance(data_or_node,Node):
      item = data_or_node
    else:
      item = Node(data_or_node)

    if not self.head: #若链表的头为空
      self.head = item
      self.length += 1
    else:
      cur_node = self.head
      while cur_node._next: #当有节点时，新增下一个节点
        cur_node = cur_node._next
      cur_node._next = item
      self.length += 1
  
  def delete(self,index):
    '''根据索引删除对应节点'''
    if self.is_empty():
      print("链表是空的")
      return
    if index < 0 or index >= self.length:
      print("超出索引长度")
      return
    #删除第一个节点
    if index == 0:
      self.head = self.head._next
      self.length -= 1
      return
    #pre_node为保存前导节点 cur_node为保存当前节点 当j与index相等时就相当于找到要删除的节点
    j = 0
    cur_node = self.head
    pre_node = self.head
    while cur_node._next and j<index:
      pre_node = cur_node
      cur_node = cur_node._next
      j += 1
    if j == index:#找到节点后将下一个节点覆盖到本节点
      pre_node._next = cur_node._next
      self.length -= 1
  
  def print_chain_info(self):
    '''从头到尾打印链表'''
    if self.is_empty():
      print('链表为空')
    nums = []
    cur_node = self.head
    while cur_node:
      nums.append(cur_node)
      cur_node = cur_node._next
    for node in nums:
      print("\nnode_val=",node.val,' node_info:',node) 

  def remove_duplicate_node(self):
    '''删除重复节点'''
    if self.is_empty():
      raise('链表为空')
    duplicate_val_indexs=[]
    index=0
    nodes_val=[]
    cur_node = self.head
    while cur_node._next:
      index+=1
      nodes_val.append(cur_node.val)
      cur_node = cur_node._next
      if cur_node is not None and cur_node.val in nodes_val:
        duplicate_val_indexs.append(index)
    j=0 #这个很关键 因为删除之后 链表长度会变化  所以后续删除的节点索引会变化
    for i in duplicate_val_indexs:
      # print(i)
      self.delete(i-j)
      j+=1
      
if __name__=='__main__':
  nums=[1,3,1,5,5,5,5,7,8,7,7,8,8,8,9,9,7]
  # 建立链表1 -> 3 -> 1 -> 5 -> 5 ->7 ->None
  chain_table=ChainTable()
  for i in nums:
    chain_table.add(i)
  chain_table.print_chain_info()
  print("-------------------------------------")
  # 删除重复节点
  chain_table.remove_duplicate_node()
  chain_table.print_chain_info()
  