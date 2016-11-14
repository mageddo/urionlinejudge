#include<stdio.h>

int main(){

	int cards, i;
	int c;

	for(; ;){
		scanf("%d", &cards);
		if(cards == 0){
			break;
		}

		getchar();
		for(i=0; i < cards; i++){

			c = getchar();
			printf("card=%d, quantidade=%c, ", i+1, c);
			switch(c){
				case 'u': // um
				break;

				case 'd': // dois
				break;

				case 't': // tres
				break;

			}

			while((c = getchar()) != ' '); // segunda palavra

			c = getchar();
			printf("forma=%c\n", c);
			switch(c){

				case 't': // triangulo
				break;

				case 'q': // quadrado
				break;

				case 'c': // circulo
				break;

			}

			while((c = getchar())!= '\n');

		}
		printf("\n");
	}

}