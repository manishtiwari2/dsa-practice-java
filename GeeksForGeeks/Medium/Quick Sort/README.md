# Quick Sort

## Difficulty: Medium

## Platform: GeeksForGeeks

## Problem Link
[View Problem](https://www.geeksforgeeks.org/problems/quick-sort/1)

## Solved On
29 Aug 2026 at 06:21 pm

<h2><a href="https://www.geeksforgeeks.org/problems/quick-sort/1">Quick Sort</a></h2><h3>Difficulty Level: Medium</h3><hr><p data-start="166" data-end="264"><span style="font-size: 14pt;">Given an array arr[], with starting index low and ending index high, complete the functions partition() and quickSort() so that the array becomes sorted in ascending order.</span></p>
<p><span style="font-size: 14pt;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>arr[] = [4, 1, 3, 9, 7]
<strong>Output: </strong>[1, 3, 4, 7, 9]<br><strong>Explanation:</strong> After sorting, all elements are arranged in ascending order.</span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>arr[] = [2, 1, 6, 10, 4, 1, 3, 9, 7]
<strong>Output: [</strong>1, 1, 2, 3, 4, 6, 7, 9, 10]<br><strong>Explanation:</strong> Duplicate elements (1) are retained in sorted order.</span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>arr[] = [5, 5, 5, 5]
<strong>Output: </strong>[5, 5, 5, 5]<br><strong>Explanation:</strong> All elements are identical, so the array remains unchanged.</span></pre>
<p><span style="font-size: 14pt;"><strong>Constraints:</strong><br>1 ≤ arr.size() ≤ 10<sup>5</sup><br>1 ≤ arr[i] ≤ 10<sup>5</sup></span></p>