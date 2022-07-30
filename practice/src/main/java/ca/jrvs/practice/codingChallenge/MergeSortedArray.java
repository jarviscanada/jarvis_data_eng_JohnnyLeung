package ca.jrvs.practice.codingChallenge;

/* https://www.notion.so/jarvisdev/Merge-Sorted-Array-ed513f6c5f094dd08e0993297fe45d01 */
public class MergeSortedArray {

    /* O(n+m) Iterate through the array elements with O(1) overhead. */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = m - 1, ptr2 = n - 1, ptrSlot = m + n - 1;

        while (ptrSlot >= 0) {
            if (ptr1 < 0) {
                for (; ptrSlot >= 0 && ptr2 >= 0; ptrSlot--, ptr2--)
                    nums1[ptrSlot] = nums2[ptr2];
                return;
            }
            else if (ptr2 < 0)
                return;

            if (nums1[ptr1] > nums2[ptr2]) {
                nums1[ptrSlot] = nums1[ptr1];
                ptr1--;
            }
            else {
                nums1[ptrSlot] = nums2[ptr2];
                ptr2--;
            }
            ptrSlot--;
        }
    }

}
