#include<stdio.h>
#include<stdlib.h>

int main(){

	char *buf = malloc(sizeof(char) * BUFSIZ);
	setbuf(stdout, buf);
	setvbuf(stdout, buf, _IOFBF, BUFSIZ);

	int a,b;
	for(; scanf("%u %u", &a, &b) != EOF; ){
		printf("%u\n", a ^ b);
	}

}