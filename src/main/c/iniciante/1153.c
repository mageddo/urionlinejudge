#include<stdio.h>

int main(){

	int n, fat=1;
	scanf("%d", &n);

	for(;n > 0; n--) {
		fat *= n;
	}
	printf("%d\n", fat);

}