# 数组类题目
## 找出数组中唯一的重复元素
### 题目描述：
数字1～n（n<=1000）放置进含有n+1个元素的数组中，其中只有一个元素重复，其余元素均出现一次。设计一个算法，将重复的元素找出。\
要求：
- 每个数组元素只能访问一次
- 不能使用辅助空间（即：空间复杂度O(1)）

示例1：
```
输入：
arr=[1,3,4,2,5,3]
```
```
输出：
3
```
示例2：
```
输入：
arr=[1,2,3,4,5,...,995,5,996,997,998,999,1000]
```
```
输出：
5
```