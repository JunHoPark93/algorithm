#include <stdio.h>
/*
	실제로 매 비교마다 교환하기 때문에 똑같은 O(N*N) 의 시간복잡도라도 
	선택정렬 보다 더 효율이 좋지 않다. 
*/


int main(void) {
	int i,j,temp;
	int array[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
	
	for(i = 0; i < 10; i++) {
		for(j = 0; j < 10-i-1 ; j++) {
			if(array[j] > array[j+1]) {
				temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
			}
		}
	}
	
	for(i = 0; i < 10; i++) {
		printf("%d ", array[i]);
	}
}
