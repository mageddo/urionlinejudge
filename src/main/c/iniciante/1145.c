#include<stdio.h>

int main(){

	int x, y, i=1,j=1;
	scanf("%d %d", &x, &y);

	for(;i <= y; i++, j++){

		printf("%d", i);
		if(j == x){
			printf("\n");
			j = 0;
		}else{
			printf(" ");
		}
	}

}