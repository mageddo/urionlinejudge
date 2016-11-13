#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int cmp(const void *a, const void *b);

int main(){
	int SIZE = 3, i;
	double arr[SIZE];
	double a2, bc2;

	for(i=0; i < SIZE; i++){
		scanf("%lf", &arr[i]);
	}
	qsort(arr, SIZE, sizeof(double), cmp);

	a2 = pow(arr[0], 2);
	bc2 = pow(arr[1], 2) + pow(arr[2], 2);

	if(arr[0] >= arr[1] + arr[2]){
		printf("NAO FORMA TRIANGULO\n");
		return 0;
	}
	if(a2 == bc2){
		printf("TRIANGULO RETANGULO\n");
	}
	if(a2 > bc2){
		printf("TRIANGULO OBTUSANGULO\n");
	}
	if(a2 < bc2){
		printf("TRIANGULO ACUTANGULO\n");
	}

	if(arr[0] == arr[1] && arr[0] == arr[2]){
		printf("TRIANGULO EQUILATERO\n");
	}else if(arr[0] == arr[1] || arr[0] == arr[2] || arr[1] == arr[2]){
		printf("TRIANGULO ISOSCELES\n");
	}

//	printf("%lf, %lf, %lf - %f %f", arr[0], arr[1], arr[2], a2, bc2);

}

int cmp(const void *a, const void *b){
	return (int) *(double*) b - *(double*) a;
}