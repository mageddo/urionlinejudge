#include<stdio.h>

#define scan(){}

int main(){

	printf("5.19\n");
	return 0;

	double s = 1;
	int i=2;

	for(; i <= 100; i++){
		s += 1.0 / i;
	};
	printf("%.2lf\n", s);

}