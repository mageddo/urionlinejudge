#include<stdio.h>

int main(){
	int cases, aQtd, bQtd, i, aSum=0, bSum=0;
	double aPer, bPer;

	for(scanf("%d", &cases); cases > 0; cases--){

		scanf("%d %d %lf %lf", &aQtd, &bQtd, &aPer, &bPer);
		aPer /= 100.0;
		bPer /= 100.0;
		aSum = aQtd;
		bSum = bQtd;

		for(i=1; i <= 100; i++){
			if( (aSum += aSum * aPer) > (bSum += bSum * bPer) ){
				printf("%d anos.\n", i);
				break;
			}
		}
		if(i == 101)
			printf("Mais de 1 seculo.\n");
	}

}