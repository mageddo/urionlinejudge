#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int cmpfunc (const void * a, const void * b);
int procurarTabuaQueEncaixe(int *tamanhoTabuasDoadas, int aPartir, int ate, int tamanhoBuscado);

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

	int tmp;

int main(){

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
		float larguraTabuasMetros = larguraTabuas / 100.0;
        if(larguraTabuasMetros - (int) larguraTabuasMetros != 0){
            printf("impossivel\n");
            goto proximoComando;
        }

		qsort(tamanhoTabuasDoadas, tabuasDoadas, sizeof(int), cmpfunc);
		int qtdTabuas = calculaQuantidadeTabuas(dimensaoX, dimensaoY, (int)larguraTabuasMetros, tabuasDoadas, tamanhoTabuasDoadas);
		tmp = dimensaoX;
		dimensaoX = dimensaoY;
		dimensaoY = tmp;
//		qsort(tamanhoTabuasDoadas, tabuasDoadas, sizeof(int), cmpfunc);
		int qtdTabuas2 = calculaQuantidadeTabuas(dimensaoX, dimensaoY, (int)larguraTabuasMetros, tabuasDoadas, tamanhoTabuasDoadas);

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

        proximoComando:
		scanf("%[^\n]%*c", cond);
	}while(strcmp(cond, "0 0") != 0);


	return 0;
}

int calculaQuantidadeTabuas(int dimensaoX, int dimensaoY, int larguraTabuasMetros, int tabuasDoadas, int *tamanhoTabuasDoadas){
	if(dimensaoX % larguraTabuasMetros != 0){
		return -1;
	}

	int qtdTabuasNecessariasLargura = dimensaoX / larguraTabuasMetros, i, j, qtdTabuasEncontradasLargura = 0; // ja pego as tabuas maiores e completo com o resto das tabuas
	int qtdTotalTabuas = 0;
	for(i=0; i < tabuasDoadas; i++){
		const int tamanho1aTabua = tamanhoTabuasDoadas[i];
        if(tamanho1aTabua == -1)continue;
		const int tamanhoFaltante = dimensaoY - tamanho1aTabua;
		if(tamanhoFaltante > 0){
            for (j = i+1; j < tabuasDoadas; ++j){
                int tamanhoTabua = tamanhoTabuasDoadas[j];
                if(tamanhoTabua != -1 && tamanhoTabua == tamanhoFaltante){
                    tamanhoTabuasDoadas[i] = -1;
                    tamanhoTabuasDoadas[j] = -1;
                    qtdTabuasEncontradasLargura++;
                    qtdTotalTabuas+=2;
                    break;
                }
            }
            tamanhoTabuasDoadas[i] = -1;
		}else if(tamanhoFaltante < 0){
            tamanhoTabuasDoadas[i] = -1;
		}else{
            qtdTotalTabuas++;
            qtdTabuasEncontradasLargura++;
		}

	}
	if(qtdTabuasEncontradasLargura == qtdTabuasNecessariasLargura){
        return qtdTotalTabuas;
	}else{
        return -1;
	}

}

int cmpfunc (const void * a, const void * b){
//    if(*(int *)a > dimensaoY){
//        return 1;
//    }

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
