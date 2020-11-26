# for program_3.md
class Node(object):
  """
  linked list node define
  """
  def __new__(cls):
    return super(Node,cls).__new__(cls)
  def __init__(self):
    self