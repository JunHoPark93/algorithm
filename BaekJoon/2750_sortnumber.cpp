#include <stdio.h>

int arr[1001];

/* selection sort*/
int main(void) {
    int number, i,j,min,index, temp;
    scanf("%d", &number);
    for(i=0; i<number; i++){
        scanf("%d", &arr[i]);
    }

    for(i=0; i<number; i++) {
        min = 1001;
        for(j=i; j<number; j++) {
            if(min > arr[j]) {
                min=arr[j];
                index = j;
            }
        }
        temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }

    for(i=0; i<number; i++) {
        printf("%d\n", arr[i]);
    }
}