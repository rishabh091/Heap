package maxheap;

public class Maxheap {
    private int[] heap;
    private int size;
    private int maxSize;

    public Maxheap(int size){
        this.maxSize=size;                  //the actual size of heap array
        this.size=0;                        //the size which is decided while adding elements
        heap=new int[this.maxSize+1];       //initializing the heap array
        heap[0]=Integer.MAX_VALUE;          //setting the first root as highest element in integer
    }

    //returns position of parent
    private int parent(int pos){
        return pos/2;
    }

    //left child elements
    private int leftChild(int pos){
        return 2*pos;
    }

    //right child elements
    private int rightChild(int pos){
        return (2*pos)+1;
    }

    //returns true if node is a leaf
    private boolean isLeaf(int pos){
        if(pos>=(size/2) && pos<=size){
            return true;
        }
        return false;
    }

    //move the largest element to the root
    private void maxHeapify(int pos){
        if(isLeaf(pos)){
            return;
        }
        else if((heap[pos] < heap[leftChild(pos)]) || (heap[pos] < heap[rightChild(pos)])){
            if(heap[leftChild(pos)] > heap[rightChild(pos)]){
                swap(pos,leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else{
                swap(pos,rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    //swap elements with root
    private void swap(int pos,int pos1){
        int temp=heap[pos];
        heap[pos]=heap[pos1];
        heap[pos1]=temp;
    }

    public void insert(int data){
        heap[++size]=data;

        //traversing and fixing violated property
        int current=size;
        while (heap[current]>heap[parent(current)]){
            swap(current,parent(current));
            current=parent(current);
        }
    }

    public int deleteMax(){
        int popped=heap[1];
        heap[1]=heap[size--];
        maxHeapify(1);
        return popped;
    }

    public void display(){
        System.out.println("Heap : ");

        for(int i=1;i<=size;i++){
            System.out.println(heap[i]);
        }
    }
}
