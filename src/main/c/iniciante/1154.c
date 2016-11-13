#include<stdio.h>

#define scan(){}

int main(){

	int v=0, n=0;
	double x=0.0;

	for(scanf("%d", &v); v > 0; scanf("%d", &v),n++){
		x += v;
	};
	printf("%.2lf\n", x / n);

}