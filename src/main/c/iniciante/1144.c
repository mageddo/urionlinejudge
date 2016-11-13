#include<stdio.h>

int main(){

	int x, i=1;
	scanf("%d", &x);

	for(;i <= x; i++){
		printf("%d %d %d\n", i, i * i, i * i * i);
		printf("%d %d %d\n", i, i * i + 1, i * i * i + 1);
	}

}