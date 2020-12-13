arr = [9, 67,0, 1,  67, 77, 8,9,2, 3, 4, 5, 1,6, 45, 67, 77, 8]

def solution1(arr):
    res = []
    for x in arr:
        if x in res:
            continue
        else:
            res.append(x)
    return res

print(solution1(arr))