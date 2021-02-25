# for program_9.md
class BiTreeNode(object):
  def __init__(self,data=None):
    self.data=data
    self.lchild=None
    self.rchild=None
  def __str__(self):
    return str(self.data)

class BiTree(object):
  def __init__(self,root=None):
    self.root=root
  def add(self,data_or_node):
    item=None
    if isinstance(data_or_node,BiTreeNode):
      item=data_or_node
    else:
      item=BiTreeNode(data=data_or_node)
    if data_or_node is None:
      item=None
    if self.root is None:
      self.root=item
      return
    
    queue=[self.root]
    while queue:
      cur_node=queue.pop(0)
      if cur_node.lchild is None:
        cur_node.lchild=item
        return
      else:
        queue.append(cur_node.lchild)
      if cur_node.rchild is None:
        cur_node.rchild=item
        return
      else:
        queue.append(cur_node.rchild)

  def get_max_depth(self,node:BiTreeNode)->int:
    if not node:
      return 0
    return max(self.get_max_depth(node.lchild),
               self.get_max_depth(node.rchild))+1

  def is_balanced(self,node:BiTreeNode)->bool:
    if node is None or (node.lchild is None and node.rchild is None):
      return True
    
    if abs(self.get_max_depth(node.lchild)-self.get_max_depth(node.rchild))<=1:
      return self.is_balanced(node.lchild) and self.is_balanced(node.rchild)
    else:
      return False

if __name__=='__main__':
  nums = [3,9,20,None,None,15,7]
  biTree=BiTree()
  for num in nums:
    biTree.add(num)
  print(biTree.is_balanced(biTree.root))
  print("-"*8)
  nums = [1,2,2,3,3,None,None,4,4]
  for num in nums:
    biTree.add(num)
  print(biTree.is_balanced(biTree.root))


