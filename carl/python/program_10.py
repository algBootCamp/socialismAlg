# for program_10.md
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

  def get_levelorder(self):
    if self.root is None:
      print("该树为空！")
      return
    res=[]
    queue=[self.root]
    while queue:
      cur_node=queue.pop(0)
      res.append(cur_node)
      if cur_node.lchild:
        queue.append(cur_node.lchild)
      if cur_node.rchild:
        queue.append(cur_node.rchild)
    return res

if __name__=='__main__':
  nums=[1,2,3,4,5,6,7]
  biTree=BiTree()
  for num in nums:
    biTree.add(num)
  res=biTree.get_levelorder()
  print([node.data for node in res ])