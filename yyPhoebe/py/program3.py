
# coding: utf-8


class ListNode:
    def __init__(self):
        self.data = None
        self.next = None
        
def removeDulNode(head):
    if head == None or head.next == None:
        return
    first = head
    second = head.next
    dic = {}
    dic[first.data] = 0
    while first.next!= None:
        if second.data in dic:
            second = second.next
            first.next = second
            continue
        dic[second.data]=0
        first = first.next
        secnd = second.next

        
if __name__ == '__main__':
    i = 1
    head = ListNode()
    cur = head
    lists = [1,3,1,5,5,7]
    for i in range(6):
        tmp = ListNode()
        tmp.data = lists[i]
        cur.next = tmp
        cur = tmp
        
    removeDulNode(head.next)
    cur = head.next
    print('删除重复节点后：',end='')
    while cur != None:
        print(cur.data,end=' ')
        cur = cur.next
        






