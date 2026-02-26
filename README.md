# Prompt utilizado para generar el código

Desarrolla una implementación completa en Java del algoritmo Bubble Sort
optimizado utilizando una marca o índice que indique la posición del
último intercambio realizado, con el objetivo de reducir el número de
pasadas y comparaciones.
El programa debe:
Implementar Bubble Sort optimizado usando el índice del último
intercambio.
Medir el tiempo de ejecución utilizando System.nanoTime().
Contar el número de comparaciones realizadas.
Contar el número de intercambios realizados.
Evaluar tres escenarios:
Arreglo aleatorio (caso promedio)
Arreglo ya ordenado (mejor caso)
Arreglo ordenado en forma inversa (peor caso)
Ejecutar cada escenario múltiples veces (mínimo 5) y calcular el
promedio de tiempo, comparaciones e intercambios.
Imprimir los resultados en formato CSV con la siguiente estructura:
Escenario,Tamaño,Tiempo(ns),Comparaciones,Intercambios
Probar diferentes tamaños de arreglo: 1000, 2000, 5000 y 10000
elementos.
Mantener el código estructurado y modular.
Incluir una clase interna para almacenar los resultados del
análisis.
El objetivo es realizar un análisis empírico de la complejidad temporal
del algoritmo y comparar los resultados experimentales con la teoría
(O(n) para el mejor caso y O(n²) para el caso promedio y peor caso).
