#include <stdlib.h>
#include <stdio.h>
#include <string.h>

static void setup(u_char *, u_char *, size_t, size_t,
    int (*)(const void *, const void *));
static void insertionsort(u_char *, size_t, size_t,
    int (*)(const void *, const void *));

#define EINVAL 255
#define ISIZE sizeof(int)
#define PSIZE sizeof(u_char *)
#define ICOPY_LIST(src, dst, last)				\
	do							\
	*(int*)dst = *(int*)src, src += ISIZE, dst += ISIZE;	\
	while(src < last)

#define ICOPY_ELT(src, dst, i)					\
	do							\
	*(int*) dst = *(int*) src, src += ISIZE, dst += ISIZE;	\
	while (i -= ISIZE)
#define CCOPY_LIST(src, dst, last)		\
	do					\
		*dst++ = *src++;		\
	while (src < last)
#define CCOPY_ELT(src, dst, i)			\
	do					\
		*dst++ = *src++;		\
	while (i -= 1)

	#define	swap(a, b) {					\
		s = b;					\
		i = size;				\
		do {					\
			tmp = *a; *a++ = *s; *s++ = tmp; \
		} while (--i);				\
		a -= size;				\
	}
#define reverse(bot, top) {				\
	s = top;					\
	do {						\
		i = size;				\
		do {					\
			tmp = *bot; *bot++ = *s; *s++ = tmp; \
		} while (--i);				\
		s -= size2;				\
	} while(bot < s);				\
}

/*
 * Find the next possible pointer head.  (Trickery for forcing an array
 * to do double duty as a linked list when objects do not align with word
 * boundaries.
 */
/* Assumption: PSIZE is a power of 2. */
#define EVAL(p) (u_char **)						\
	((u_char *)0 +							\
	    (((u_char *)p + PSIZE - 1 - (u_char *) 0) & ~(PSIZE - 1)))

int cmpfunc (const void * a, const void * b);
int calculaQuantidadeTabuas(int dimensaoX, int dimensaoY, float larguraTabuasMetros, int tabuasDoadas, int *tamanhoTabuasDoadas);

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

	int tmp;

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
        /*if(larguraTabuasMetros - (int) larguraTabuasMetros != 0){
            printf("impossivel\n");
            goto proximoComando;
        }*/

		//qsort(tamanhoTabuasDoadas, tabuasDoadas, sizeof(int), cmpfunc);
		mergesort(tamanhoTabuasDoadas, tabuasDoadas, sizeof(int), cmpfunc);
		int qtdTabuas = calculaQuantidadeTabuas(dimensaoX, dimensaoY, larguraTabuasMetros, tabuasDoadas, tamanhoTabuasDoadas);
		tmp = dimensaoX;
		dimensaoX = dimensaoY;
		dimensaoY = tmp;
		int qtdTabuas2 = calculaQuantidadeTabuas(dimensaoX, dimensaoY, larguraTabuasMetros, tabuasDoadas, tamanhoTabuasDoadas);

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

int calculaQuantidadeTabuas(int dimensaoX, int dimensaoY, float larguraTabuasMetros, int tabuasDoadas, int *tamanhoTabuasDoadas){
	if(dimensaoX * 100 % (int)(larguraTabuasMetros * 100) != 0){
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
	return ( *(int*)b - *(int*)a );
}


/*
 * Arguments are as for qsort.
 */
int
mergesort(base, nmemb, size, cmp)
	void *base;
	size_t nmemb;
	size_t size;
	int (*cmp)(const void *, const void *);
{
	size_t i;
	int sense;
	int big, iflag;
	u_char *f1, *f2, *t, *b, *tp2, *q, *l1, *l2;
	u_char *list2, *list1, *p2, *p, *last, **p1;

	if (size < PSIZE / 2) {		/* Pointers must fit into 2 * size. */
		return (-1);
	}

	if (nmemb == 0)
		return (0);

	/*
	 * XXX
	 * Stupid subtraction for the Cray.
	 */
	iflag = 0;
	if (!(size % ISIZE) && !(((char *)base - (char *)0) % ISIZE))
		iflag = 1;

	if ((list2 = malloc(nmemb * size + PSIZE)) == NULL)
		return (-1);

	list1 = base;
	setup(list1, list2, nmemb, size, cmp);
	last = list2 + nmemb * size;
	i = big = 0;
	while (*EVAL(list2) != last) {
	    l2 = list1;
	    p1 = EVAL(list1);
	    for (tp2 = p2 = list2; p2 != last; p1 = EVAL(l2)) {
	    	p2 = *EVAL(p2);
	    	f1 = l2;
	    	f2 = l1 = list1 + (p2 - list2);
	    	if (p2 != last)
	    		p2 = *EVAL(p2);
	    	l2 = list1 + (p2 - list2);
	    	while (f1 < l1 && f2 < l2) {
	    		if ((*cmp)(f1, f2) <= 0) {
	    			q = f2;
	    			b = f1, t = l1;
	    			sense = -1;
	    		} else {
	    			q = f1;
	    			b = f2, t = l2;
	    			sense = 0;
	    		}
	    		if (!big) {	/* here i = 0 */
				while ((b += size) < t && cmp(q, b) >sense)
	    				if (++i == 6) {
	    					big = 1;
	    					goto EXPONENTIAL;
	    				}
	    		} else {
EXPONENTIAL:	    		for (i = size; ; i <<= 1)
	    				if ((p = (b + i)) >= t) {
	    					if ((p = t - size) > b &&
						    (*cmp)(q, p) <= sense)
	    						t = p;
	    					else
	    						b = p;
	    					break;
	    				} else if ((*cmp)(q, p) <= sense) {
	    					t = p;
	    					if (i == size)
	    						big = 0;
	    					goto FASTCASE;
	    				} else
	    					b = p;
				while (t > b+size) {
	    				i = (((t - b) / size) >> 1) * size;
	    				if ((*cmp)(q, p = b + i) <= sense)
	    					t = p;
	    				else
	    					b = p;
	    			}
	    			goto COPY;
FASTCASE:	    		while (i > size)
	    				if ((*cmp)(q,
	    					p = b + (i >>= 1)) <= sense)
	    					t = p;
	    				else
	    					b = p;
COPY:	    			b = t;
	    		}
	    		i = size;
	    		if (q == f1) {
	    			if (iflag) {
	    				ICOPY_LIST(f2, tp2, b);
	    				ICOPY_ELT(f1, tp2, i);
	    			} else {
	    				CCOPY_LIST(f2, tp2, b);
	    				CCOPY_ELT(f1, tp2, i);
	    			}
	    		} else {
	    			if (iflag) {
	    				ICOPY_LIST(f1, tp2, b);
	    				ICOPY_ELT(f2, tp2, i);
	    			} else {
	    				CCOPY_LIST(f1, tp2, b);
	    				CCOPY_ELT(f2, tp2, i);
	    			}
	    		}
	    	}
	    	if (f2 < l2) {
	    		if (iflag)
	    			ICOPY_LIST(f2, tp2, l2);
	    		else
	    			CCOPY_LIST(f2, tp2, l2);
	    	} else if (f1 < l1) {
	    		if (iflag)
	    			ICOPY_LIST(f1, tp2, l1);
	    		else
	    			CCOPY_LIST(f1, tp2, l1);
	    	}
	    	*p1 = l2;
	    }
	    tp2 = list1;	/* swap list1, list2 */
	    list1 = list2;
	    list2 = tp2;
	    last = list2 + nmemb*size;
	}
	if (base == list2) {
		memmove(list2, list1, nmemb*size);
		list2 = list1;
	}
	free(list2);
	return (0);
}


/*
 * Optional hybrid natural/pairwise first pass.  Eats up list1 in runs of
 * increasing order, list2 in a corresponding linked list.  Checks for runs
 * when THRESHOLD/2 pairs compare with same sense.  (Only used when NATURAL
 * is defined.  Otherwise simple pairwise merging is used.)
 */
void
setup(list1, list2, n, size, cmp)
	size_t n, size;
	int (*cmp)(const void *, const void *);
	u_char *list1, *list2;
{
	int i, length, size2, tmp, sense;
	u_char *f1, *f2, *s, *l2, *last, *p2;

	size2 = size*2;
	if (n <= 5) {
		insertionsort(list1, n, size, cmp);
		*EVAL(list2) = (u_char*) list2 + n*size;
		return;
	}
	/*
	 * Avoid running pointers out of bounds; limit n to evens
	 * for simplicity.
	 */
	i = 4 + (n & 1);
	insertionsort(list1 + (n - i) * size, i, size, cmp);
	last = list1 + size * (n - i);
	*EVAL(list2 + (last - list1)) = list2 + n * size;

#ifdef NATURAL
	p2 = list2;
	f1 = list1;
	sense = (cmp(f1, f1 + size) > 0);
	for (; f1 < last; sense = !sense) {
		length = 2;
					/* Find pairs with same sense. */
		for (f2 = f1 + size2; f2 < last; f2 += size2) {
			if ((cmp(f2, f2+ size) > 0) != sense)
				break;
			length += 2;
		}
		if (length < THRESHOLD) {		/* Pairwise merge */
			do {
				p2 = *EVAL(p2) = f1 + size2 - list1 + list2;
				if (sense > 0)
					swap (f1, f1 + size);
			} while ((f1 += size2) < f2);
		} else {				/* Natural merge */
			l2 = f2;
			for (f2 = f1 + size2; f2 < l2; f2 += size2) {
				if ((cmp(f2-size, f2) > 0) != sense) {
					p2 = *EVAL(p2) = f2 - list1 + list2;
					if (sense > 0)
						reverse(f1, f2-size);
					f1 = f2;
				}
			}
			if (sense > 0)
				reverse (f1, f2-size);
			f1 = f2;
			if (f2 < last || cmp(f2 - size, f2) > 0)
				p2 = *EVAL(p2) = f2 - list1 + list2;
			else
				p2 = *EVAL(p2) = list2 + n*size;
		}
	}
#else		/* pairwise merge only. */
	for (f1 = list1, p2 = list2; f1 < last; f1 += size2) {
		p2 = *EVAL(p2) = p2 + size2;
		if (cmp (f1, f1 + size) > 0)
			swap(f1, f1 + size);
	}
#endif /* NATURAL */
}

/*
 * This is to avoid out-of-bounds addresses in sorting the
 * last 4 elements.
 */
static void insertionsort(a, n, size, cmp)
	u_char *a;
	size_t n, size;
	int (*cmp)(const void *, const void *);
{
	u_char *ai, *s, *t, *u, tmp;
	int i;

	for (ai = a+size; --n >= 1; ai += size)
		for (t = ai; t > a; t -= size) {
			u = t - size;
			if (cmp(u, t) <= 0)
				break;
			swap(u, t);
		}
}




