#include<stdio.h>

int main(){

	int x, r=1;
	scanf("%d", &x);

	for(;r <= x; r++){
		printf("%d %d %d\n", r, r * r, r * r * r);
	}


}