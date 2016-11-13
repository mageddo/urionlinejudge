#include<stdio.h>

int main(){

	int n, i=1, r;
	for(scanf("%d", &n); i <= n; i++){
		r = n % i;
		if(r == 0){
			printf("%d\n", i);
		}
	}

}