#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>

int main(){

	int a,b, len = 1 + sizeof(int);
	char *str;
	str = malloc(len);

	for(; scanf("%u %u", &a, &b) != EOF; ){
		sprintf(str, "%u\n", a ^ b);
		write(STDOUT_FILENO, str, len);
	}
	fflush(stdout);

}