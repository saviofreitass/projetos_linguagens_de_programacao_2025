%info(Nome, Sexo, Idade, Altura, Peso).

info(ana, fem, 23, 1.55, 56).
info(bia, fem, 19, 1.71, 61.2).
info(ivo, masc, 22, 1.80, 70.5).
info(lia, fem, 17, 1.85, 57.3).
info(eva, fem, 28, 1.75, 68.7).
info(ary, masc, 25, 1.72, 79).

modelo(Nome) :- info(Nome, fem, Idade, Altura, Peso), Peso =<(62.1*Altura-44.7), Altura > 1.7, Idade < 25.

casalRegra(X, Y) :- info(X, masc, _, AlturaM ,_), info(Y, fem, _, AlturaF, _), AlturaM > AlturaF.