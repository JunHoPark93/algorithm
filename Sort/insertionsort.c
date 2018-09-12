#include <stdio.h>

void InsertionSort(int arr[], int n) {

    int i,j;
    int insrtData;

    for(i=1; i<n; i++) {

        insrtData = arr[i];

        for(j=i-1; j>=0; j--) {

            if(arr[j] > insrtData) 
                arr[j+1] = arr[j];
            else 
                break;
        }

        arr[j+1] = insrtData;
    }
}

int main() {
    int arr[5] = {5,3,2,4,1};
    int i;

    InsertionSort(arr, sizeof(arr)/sizeof(int));

    for(i=0; i<5; i++) {
        printf("%d ", arr[i]);
    }

    
    return 0;
}