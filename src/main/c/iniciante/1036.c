#include<stdlib.h>
#include<stdio.h>
#include<math.h>

int main(){

	double a,b,c, squareRoot, tmpA, tmpB;

	scanf("%lf %lf %lf", &a, &b, &c);

	squareRoot = sqrt(pow(b,2) - 4 * a * c);

	tmpA = (-b + squareRoot);
	tmpB = (-b - squareRoot);

	if(squareRoot != squareRoot || tmpA == 0 || tmpB == 0){
		printf("Impossivel calcular\n");
		return 0;
	}
	printf("R1 = %.5lf\nR2 = %.5lf\n", tmpA / (2 * a),  tmpB / (2 * a));

}