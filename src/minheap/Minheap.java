package minheap;

public class Minheap {
    private int size;
    private int maxsize;
    private int[] arr;

    public Minheap(int size){
        maxsize=0;
        this.size=size;
        arr=new int[this.size];

        arr[maxsize]=Integer.MAX_VALUE;
        maxsize++;
    }

    private int parent(int pos){
        return pos/2;
    }
    private int leftChild(int pos){
        return 2*pos;
    }
    private int rightChild(int pos){
        return (2*pos)+1;
    }

    private boolean isLeaf(int pos){
        if(pos>=(size/2) && pos<size){
            return true;
        }
        return false;
    }
    private void swap(int pos,int pos1){
        int temp=arr[pos];
        arr[pos]=arr[pos1];
        arr[pos1]=temp;
    }
    private void heapify(int pos){
        if(isLeaf(pos)){
            return;
        }
        else if(arr[pos]>arr[leftChild(pos)] || arr[pos]>arr[rightChild(pos)]){
            if(arr[leftChild(pos)] > arr[rightChild(pos)]){
                swap(pos,leftChild(pos));

                heapify(leftChild(pos));
            }
            else{
                swap(pos,rightChild(pos));

                heapify(rightChild(pos));
            }
        }
    }

    public void insert(int data){
        arr[++maxsize]=data;
        int current=maxsize;

        while(arr[current]<arr[parent(current)]){
            swap(current,parent(current));
            current=parent(current);
        }
    }

    public void delete(){
        arr[1]=arr[size--];
        heapify(1);
    }
}
