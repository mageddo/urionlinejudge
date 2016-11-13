#include<stdio.h>

int main(){

	const char * months[12] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	int month;
	scanf("%d", &month);
	printf("%s\n", months[month-1]);

}