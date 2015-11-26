
##
#
# date: Qua Nov 25 11:09:58 BRST 2015
# author: Joao Gustavo Cabral de Marins
# e-mail: jgcmarins@gmail.com
# https://github.com/jgcmarins
#
##

all: compile jar
clean:
	rm -rf build
	mkdir build
compile: clean
	javac -cp build src/dtw/**/*.java -d build
clean_jar:
	rm -rf package
	mkdir package
jar: clean_jar
	echo "Main-Class: dtw.main.Main" > build/manifest.txt
	jar -cvfm package/dtw.jar build/manifest.txt -C build .
run:
	java -jar package/dtw.jar files/treino.txt files/teste.txt
run3D:
	java -jar package/dtw.jar files/treino3D.txt files/teste3D.txt
