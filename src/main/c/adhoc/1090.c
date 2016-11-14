#include<stdio.h>

int main(){

	typedef struct Node {
		char qtd;
		char symbol;
		struct Node* next;
	} Node;

	typedef struct CardType {
		struct Node* last;
		struct Node* head;
	} CardType;

	struct CardType
				umQuadrado, doisQuadrado, tresQuadrado,
				umCirculo, doisCiruclo, tresCirculo,
				umTriangulo, doisTriangulo, tresTriangulo;

	int cards, i;
	char c, qtd;

	for(; ;){
		scanf("%d", &cards);
		if(cards == 0){
			break;
		}

		getchar();
		for(i=0; i < cards; i++){

			qtd = getchar();
//			printf("card=%d, quantidade=%c, ", i+1, c);


			while((c = getchar()) != ' '); // segunda palavra

			c = getchar();
//			printf("forma=%c\n", c);
			struct Node node;
			node.qtd = qtd;
			node.symbol = c;

			switch(c){

				case 't': // triangulo
					switch(qtd){
						case 'u': // um
							umTriangulo.last = &node;
							if(!umTriangulo.head)
								umTriangulo.head = &node;
						break;

						case 'd': // dois
							doisTriangulo.last = &node;
							if(!doisTriangulo.head)
								doisTriangulo.head = &node;
						break;

						case 't': // tres
							tresTriangulo.last = &node;
							if(!tresTriangulo.head)
								tresTriangulo.head = &node;
						break;
					}
				break;

				case 'q': // quadrado
					switch(qtd){
						case 'u': // um
							umQuadrado.last = &node;
							if(!umQuadrado.head)
								umQuadrado.head = &node;
						break;

						case 'd': // dois
							doisQuadrado.last = &node;
							if(!doisQuadrado.head)
								doisQuadrado.head = &node;
						break;

						case 't': // tres
							tresQuadrado.last = &node;
							if(!tresQuadrado.head)
								tresQuadrado.head = &node;
						break;
					}
				break;

				case 'c': // circulo
					switch(qtd){
						case 'u': // um
							umCirculo.last = &node;
							if(!umCirculo.head)
								umCirculo.head = &node;
						break;

						case 'd': // dois
							doisCiruclo.last = &node;
							if(!doisCiruclo.head)
								doisCiruclo.head = &node;
						break;

						case 't': // tres
							tresCirculo.last = &node;
							if(!tresCirculo.head)
								tresCirculo.head = &node;
						break;
					}
				break;

			}

			while((c = getchar())!= '\n');

		}

		

//		printf("\n");
	}

}