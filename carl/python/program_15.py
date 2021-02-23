# for program_15.md
def max_happy_people(customers:list,grumpy:list,X:int)->int:
  if not grumpy or len(grumpy)<1:
    return 0
  time_num=len(grumpy)
  origin_happy=sum([x for x,y in zip(customers,grumpy) if y==0])
  increase_happy=0
  for i in range(time_num-X+1):
    increase_happy=sum([x for x,y in zip(customers[i:i+X],grumpy[i:i+X]) if y==1])
  return origin_happy+increase_happy

if __name__=='__main__':
  customers = [1,0,1,2,1,1,7,5]
  grumpy =    [0,1,0,1,0,1,0,1]
  X = 3
  print(max_happy_people(customers,grumpy,X))