#include<stdio.h>
#include<stdlib.h>

typedef struct Node {
	char qtd;
	char symbol;
	struct Node* next;
} Node;

typedef struct CardType {
	struct Node* last;
	struct Node* head;
} CardType;

void fillStruct(struct CardType* type, struct Node* node);

int main(){


	struct CardType
				*umQuadrado =  malloc(sizeof(CardType)), *doisQuadrado = malloc(sizeof(CardType)),
				*tresQuadrado = malloc(sizeof(CardType)),
				*umCirculo = malloc(sizeof(CardType)), *doisCirculos = malloc(sizeof(CardType)),
				*tresCirculo = malloc(sizeof(CardType)), *umTriangulo = malloc(sizeof(CardType)),
				*doisTriangulo = malloc(sizeof(CardType)), *tresTriangulo = malloc(sizeof(CardType));

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
			struct Node* node = malloc(sizeof(Node));
			(*node).qtd = qtd;
			(*node).symbol = c;
//			(*node).next = NULL;
			switch(c){

				case 't': // triangulo
					switch(qtd){
						case 'u': // um
							fillStruct(umTriangulo, node);
						break;

						case 'd': // dois
							fillStruct(doisTriangulo, node);
						break;

						case 't': // tres
							fillStruct(tresTriangulo, node);
						break;
					}
				break;

				case 'q': // quadrado
					switch(qtd){
						case 'u': // um
							fillStruct(umQuadrado, node);
						break;

						case 'd': // dois
							fillStruct(doisQuadrado, node);
						break;

						case 't': // tres
							fillStruct(tresQuadrado, node);
						break;
					}
				break;

				case 'c': // circulo
					switch(qtd){
						case 'u': // um
							fillStruct(umCirculo, node);
						break;

						case 'd': // dois
							fillStruct(doisCirculos, node);
						break;

						case 't': // tres
							fillStruct(tresCirculo, node);
						break;
					}
				break;

			}



			while((c = getchar())!= '\n');

		}
		int foundSets = 0;
//		printf("%p\n", NULL);
		for(; ((*umCirculo).head); (*umCirculo).head = (*(*umCirculo).head).next){
				if(doisCirculos)
		
			printf("%d\n", (*(*umCirculo).head).qtd);
		}


//		printf("%p\n", umCirculo.head);

//			printf("%c - %c\n", (*umCirculo.head).qtd, (*umCirculo.head).symbol);

//		}


//		printf("\n");
	}

}

void fillStruct(struct CardType* type, struct Node* node){

	if(!(*type).head){
		(*type).head = node;
	}else{
		(*(*type).last).next = node;
	}
	(*type).last = node;


}