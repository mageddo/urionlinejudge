#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int cmpfunc (const void * a, const void * b);
int procurarTabuaQueEncaixe(int *tamanhoTabuasDoadas, int aPartir, int ate, int tamanhoBuscado);

int main(){

	char condArr[10];
	char *cond = condArr;

	/*
		dimensao do salao em metros  (1 ≤ N,M ≤ 104)
	*/
	int dimensaoX, dimensaoY;

	/*
		em cm (1 ≤ L ≤ 100)
	*/
	int larguraTabuas;

	/*
		(1 ≤ K ≤ 105)
	*/
	int tabuasDoadas;

	/*
		tamanho de cada tabua doada (1 ≤ Xi ≤ 104 para 1 ≤ i ≤ K)
	*/
	int *tamanhoTabuasDoadas;

	do{

		// primeira linha
		scanf("%d %d", &dimensaoX, &dimensaoY);
		if(dimensaoY < 1 || dimensaoX < 1){
			return -1;
		}

		// segunda linha
		scanf("%d", &larguraTabuas);
		if(larguraTabuas < 1 || larguraTabuas > 100){
			return -2;
		}

		// terceira linha
		scanf("%d", &tabuasDoadas);
		if(tabuasDoadas < 1){
			return -3;
		}

		// quarta linha
		tamanhoTabuasDoadas = (int *)malloc(sizeof(int)*tabuasDoadas);

		int i=0;
		for(; i < tabuasDoadas; i++){
			scanf("%d", &tamanhoTabuasDoadas[i]);
		}


		// processamento

		// somando as larguras chega exatamente na largura/altura do salao e nao fica faltando tabuas?
		int larguraTabuasMetros = larguraTabuas / 100;

		qsort(tamanhoTabuasDoadas, tabuasDoadas, sizeof(int), cmpfunc);
		int qtdTabuas = calculaQuantidadeTabuas(dimensaoX, dimensaoY, larguraTabuasMetros, tabuasDoadas, tamanhoTabuasDoadas);
		int qtdTabuas2 = calculaQuantidadeTabuas(dimensaoY, dimensaoX, larguraTabuasMetros, tabuasDoadas, tamanhoTabuasDoadas);

		int r = qtdTabuas > qtdTabuas2 ? qtdTabuas : qtdTabuas2;
		if(r == -1){
			printf("impossivel\n");
		}else{
            printf("%d\n", r);
		}

		// se sim acima pegando as tabuas maiores o tamanho bate com a largura/altura para poder usar sem emendar?
		// se nao para acima juntando uma tabua com a outra fecha o valor da largura/altura?

		// se sim para todos soh imprimir a quantidade usada de tabuas
		// se nao impossivel


		scanf("%[^\n]%*c", cond);
	}while(strcmp(cond, "0 0") != 0);


	return 0;
}

int calculaQuantidadeTabuas(int dimensaoX, int dimensaoY, int larguraTabuasMetros, int tabuasDoadas, int *tamanhoTabuasDoadas){
	if(dimensaoX % larguraTabuasMetros != 0){
		return -1;
	}

	int qtdTabuasNecessariasLargura = dimensaoX / larguraTabuasMetros, i, j; // ja pego as tabuas maiores e completo com o resto das tabuas
	int qtdTotalTabuas = qtdTabuasNecessariasLargura;
	for(i=0; i < qtdTabuasNecessariasLargura; i++){
		const int tamanhoTabuaUsada = tamanhoTabuasDoadas[i];
		const int tamanhoFaltante = dimensaoY - tamanhoTabuaUsada;
		if(tamanhoFaltante != 0){
            int r = procurarTabuaQueEncaixe(tamanhoTabuasDoadas, qtdTabuasNecessariasLargura-1, tabuasDoadas, tamanhoFaltante);
            if(r == -1){
                return -1;
            }
		}
		qtdTotalTabuas++;
	}
	return qtdTotalTabuas;
}

int cmpfunc (const void * a, const void * b){
	return ( *(int*)b - *(int*)a );
}

int procurarTabuaQueEncaixe(int *tamanhoTabuasDoadas, int aPartir, int ate, int tamanhoBuscado){
	int i;
	for (i = aPartir; i < ate; ++i){
		int tamanhoTabua = tamanhoTabuasDoadas[i];
		if(tamanhoTabua != -1 && tamanhoTabua == tamanhoBuscado){
			return tamanhoBuscado;
		}
	}
	return -1;
}
