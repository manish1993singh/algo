package heap;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity){
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    private void swap(int i, int j){
        int temp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = temp; 
    }

    private void bubbleDown(int i){
        int smallest = i;
        int left = i*2+1;
        int right = i*2+2;

        if(left < size && heap[left] < heap[smallest]) smallest = left;
        if(right < size && heap[right] < heap[smallest]) smallest = right;

        if(smallest !=i){
            swap(i, smallest);
            bubbleDown(smallest);
        }
    }

    private void bubbleUp(int i){
        int parentIndex = (i-1)/2;
        while(i>0 && heap[i] < heap[parentIndex]){
            swap(i, parentIndex);
            i = parentIndex;
        }
    }

    public int extractMin(){
        if(size == 0) throw new IllegalStateException();
        int min = this.heap[0];

        this.heap[0] = this.heap[size - 1];
        size--;
        bubbleDown(0);
        return min;
    }

    public int getMin(){
        return heap[0];
    }

    public void insert(int value){
        if(size == capacity) return;
        heap[size] = value;
        bubbleUp(size);
        size++;
    }

    public static void main(String[] args){
        MinHeap minHeap = new MinHeap(20);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(15);
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(45);
        System.out.println(minHeap.getMin());
        for(int i: minHeap.heap)
            System.out.println(i);
    }
    
}
