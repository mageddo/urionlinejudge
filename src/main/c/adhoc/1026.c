#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>

int main(){

	char *buf = malloc(sizeof(char) * BUFSIZ);
	setbuf(stdout, buf);
	setvbuf(stdout, buf, _IOFBF, BUFSIZ);

	int a,b, len = 1 + sizeof(int);
//	char *str;
//	str = malloc(len);

	for(; scanf("%u %u", &a, &b) != EOF; ){
		printf("%u\n", a ^ b);
//		sprintf(str, "%u\n", a ^ b);
//		write(STDOUT_FILENO, str, len);
	}
	fflush(stdout);

}