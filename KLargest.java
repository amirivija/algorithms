import java.util.PriorityQueue;

// https://leetcode.com/submissions/detail/735501909/
class KthLargest {
    private int[] nums;
    private int k;
    private PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
    this.nums = nums;
    this.k = k;
    this.minHeap = new PriorityQueue<Integer>();
        
        if(nums.length == 0) return;

    // Initialize the minHeap with the first k elements from the array
     for(int i = 0; i < k && i <= nums.length - 1; i++) { 
      minHeap.add(nums[i]);
    }

    for( int i = k; i < nums.length; i++) {

      if( nums[i] > minHeap.peek()) {
        minHeap.poll();
        minHeap.add(nums[i]);
      }

    }
    }
    
    public int add(int val) {
        
        if(minHeap.peek() == null || minHeap.size() <k) {
            minHeap.add(val);
            return minHeap.peek();
        }
        
    if(val > minHeap.peek()) {
      minHeap.poll();
      minHeap.add(val);
    }
    return minHeap.peek();

    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
