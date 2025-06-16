%filme(Título, Gênero, Ano, Duração)

filme('Uma linda mulher', romance, 1990, 119).

filme('Sexto sentido', suspense, 2001, 108).

filme('A cor púrpura', drama, 1985, 152).

filme('Copacabana', romance, 2001, 92).

filme('E o vento levou', drama, 1939, 233).

filme('Vingadores', action, 2018, 148).

classico(NomeFilme,GeneroFilme) :- filme(NomeFilme, GeneroFilme, Ano, _), Ano =< 1985.

lancamento(NomeFilme) :- filme(NomeFilme, _ , Ano, _), Ano >=2024.