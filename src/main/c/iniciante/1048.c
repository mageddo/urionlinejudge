#include<stdio.h>

int main(){

	double oldSalary, index, adjust;
	scanf("%lf", &oldSalary);

	if(oldSalary >= 0 && oldSalary <= 400.00){
		index = 0.15;
	}else if(oldSalary > 400.00 && oldSalary <= 800.00){
		index = 0.12;
	}else if(oldSalary > 800.00 && oldSalary <= 1200.00){
		index = 0.10;
	}else if(oldSalary > 1200.00 && oldSalary <= 2000.00){
		index = 0.07;
	}else if(oldSalary > 2000.00){
		index = 0.04;
	}

	adjust = oldSalary * index;

	printf("Novo salario: %.2lf\n", oldSalary + adjust);
	printf("Reajuste ganho: %.2lf\n", adjust);
	printf("Em percentual: %.0lf %%\n", index * 100);

}