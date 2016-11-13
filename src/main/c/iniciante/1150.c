#include<stdio.h>

int main(){

	int x,z, sumIndex = 1, sum;
	scanf("%d", &x);
	sum = x;
	for(;;) {
		scanf("%d", &z);
		if(z <= x){
			continue;
		}
		for(;sum < z; sum += x + sumIndex++);
		printf("%d\n", sumIndex);
		break;
	}

}