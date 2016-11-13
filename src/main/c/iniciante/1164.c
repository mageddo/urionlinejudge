#include<stdio.h>

int main(){

	int cases,i,x, dividersSum;
	for(scanf("%d", &cases); cases > 0; cases--){

		dividersSum = 0;
		scanf("%d", &x);

		for(i=1; i < x; i++){
			if(x % i == 0){
				dividersSum += i;
			}
		}
		if( dividersSum == x ){
			printf("%d eh perfeito\n", x);
		}else{
			printf("%d nao eh perfeito\n", x);
		}
	}

}