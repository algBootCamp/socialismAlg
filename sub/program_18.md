# 滑动窗口[与17一样]
## 最小覆盖子串
### 题目描述
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。

示例 1：

输入：
```
s = "ADOBECODEBANC", t = "ABC"
```
输出：
```
"BANC"
```
示例 2：

输入：
```
s = "a", t = "a"
```
输出：
```
"a"
```

提示：

1 <= s.length, t.length <= 10^5
s 和 t 由英文字母组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-window-substring
