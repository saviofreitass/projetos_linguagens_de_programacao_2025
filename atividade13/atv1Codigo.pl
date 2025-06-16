pai(paulo, aurora).
pai(paulo, 'ana luiza').
mae(rafaela, aurora).
mae(rafaela, 'ana luiza').

mulher(rafaela).
mulher('ana luiza').
mulher(aurora).

homem(paulo).

gerou(X, Y) :- pai(X, Y) ; mae(X, Y).

feliz(X) :- gerou(X,_).

casal(X,Y) :- pai(X,Z), mae(Y,Z).