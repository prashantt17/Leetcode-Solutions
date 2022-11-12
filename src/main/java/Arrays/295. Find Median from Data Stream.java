class MedianFinder {

    PriorityQueue<Integer> min=new PriorityQueue<>(); 
    PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());
    boolean even=true;
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(even){ 
            min.offer(num);
            max.offer(min.poll());
        }
        else{
            max.offer(num);    
            min.offer(max.poll());
        }
        even=!even; 
    }
    
    public double findMedian() {
        if(even){
            return (min.peek()+max.peek())/2.0;
        }
        else{
            return max.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
