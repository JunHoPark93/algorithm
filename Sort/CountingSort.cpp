#include <stdio.h>

int main() {
	int temp;
	int count[5];
	int array[30] = {
		1,4,5,3,2,1,4,3,2,5,
		2,3,4,5,1,2,3,4,5,2,
		1,1,1,2,3,4,5,4,2,3,
	};
	for(int i = 0; i < 5; i++) {
		count[i] =  0;
	}
	for(int i = 0; i < 30; i++) {
		count[array[i]-1]++;	
	}
	for(int i = 0; i < 5; i++) {
		if(count[i] != 0) {
			for(int j = 0; j < count[i]; j++ ) {
				printf("%d", i+1);
			}
		}	
	}
}
