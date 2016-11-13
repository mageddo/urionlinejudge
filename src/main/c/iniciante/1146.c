#include<stdio.h>

#define space(curr, max){ if(curr != max)printf(" ");}

int main(){

	int x, i=1;
	do {
		scanf("%d", &x);

		for(i=1;i <= x; i++){
			printf("%d", i);
			space(i, x);
		}
		if(i!=1)
			printf("\n");

	}while(x != 0);

}