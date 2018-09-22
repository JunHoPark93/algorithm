#include <stdio.h>

int num = 8;
int sorted[8];

void Merge(int a[], int start, int middle, int end) {
	int i = start;
	int j = middle + 1;
	int k = start;
	
	while(i<=middle && j<=end) {
		if(a[i] <= a[j]) {
			sorted[k] = a[i++];
		} else {
			sorted[k] = a[j++];
		}
		
		k++;
	}	
	
	if(i>middle) {
		for(int t = j; t<=end; t++) {
			sorted[k++] = a[t];
		}
	} else {
		for(int t = i; t<=middle; t++) {
			sorted[k++] = a[t];
		}
	}
	
	for(int t = start; t<=end; t++) {
		a[t] = sorted[t];
	}
}

void MergeSort(int a[], int m, int n) {
	if(m<n) {
		int middle = (m+n) / 2;
		MergeSort(a, m, middle);
		MergeSort(a, middle+1, n);
		Merge(a, m, middle, n);
	}
}

int main() {
	int arr[num] = {7,6,5,8,3,5,9,1};
	MergeSort(arr, 0, num-1);
	for(int i=0; i<num; i++) {
		printf("%d ", arr[i]);
	}
}
