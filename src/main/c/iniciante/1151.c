#include<stdio.h>

int main(){

	int n, sum=1, last = 0, tmp;
	scanf("%d", &n);

	switch(n){
		case 1:
		 printf("0\n");
		 return;
	}
	n -= 2;
	printf("0 1");
	for(;n > 0; n--) {
		tmp = sum;
		printf(" %d", sum += last);
		last = tmp;
	}
	printf("\n");

}