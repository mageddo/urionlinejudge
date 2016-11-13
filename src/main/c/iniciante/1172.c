#include<stdio.h>

int main(){

	int x[10];
	int i=0;

	scanf("%d\n%d\n%d\n%d\n%d\n%d\n%d\n%d\n%d\n%d", &x[0], &x[1], &x[2], &x[3], &x[4], &x[5], &x[6], &x[7], &x[8], &x[9]);
	for(; i < 10; i++){
		if(x[i] < 1){
			printf("X[%d] = 1\n", i);
		}else{
			printf("X[%d] = %d\n", i, x[i]);
		}
	}

}