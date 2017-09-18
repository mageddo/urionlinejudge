Deprecated in favor https://github.com/mageddo/algorithms

Soluções dos problemas dos Algoritmos da URI Online Judge

# Compilando e rodando

Para compilar e testar com performance

Soluções em C

	$ export ID=1154 && gcc src/main/c/iniciante/$ID.c -lm -o bin/$ID
	$ time ./bin/$ID < src/main/c/iniciante/$ID.in
	$ time java ./bin/$ID < src/main/resources/$ID/1.in

Soluções em Java

	$ cd src/main/java
	$ export ID=1156 && javac iniciante/P$ID/Main.java
	$ time java iniciante/P$ID/Main < iniciante/P$ID/in/1
	# ou
	$ time java iniciante/P$ID/Main < ../resources/$ID/1.in
