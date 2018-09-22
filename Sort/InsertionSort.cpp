#include <stdio.h> 

/*
	삽입정렬 
	이미 정렬되어 있는 배열에 대해서는 매우 빠르다. 
*/

int main(void) {
	int i, j, temp;
	
	int arr[10] = {1,10,5,8,7,6,4,3,2,9};
	
	for(i=0; i<9; i++) {
		j=i;
		while(arr[j] > arr[j+1]) {
			temp = arr[j];
			arr[j] = arr[j+1];
			arr[j+1] = temp;
			j--;
		}
	}
	
	for(i=0; i<10; i++) {
		printf("%d ", arr[i]);
	}
}
