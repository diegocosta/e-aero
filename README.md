##Trabalho de Linguagens de Programação 2

#####Objetivo

Desenvolver os conceitos estudados na disciplina em uma aplicação.   



#####Organização



O trabalho será desenvolvido em grupos de 3 a 4 pessoas   

A primeira etapa (primeira unidade) representa 30% do trabalho, mas a nota será entregue apenas após a apresentação da segunda etapa.   



#####Disposição

**Primeira etapa:**

- Desenvolvimento do modelo Orientado a Objetos para a aplicação em linguagem UML;  

- Desenvolvimento em Java das classes necessárias para resolver o problema proposto (estrutura básica das classes – nome, atributos, construtor, gets e sets).  



**Segunda etapa:**

- Finalizar a construção das classes de acordo com os novos conceitos estudados, incluindo os métodos específicos;  

- Construir o banco de dados e a camada em Java de acesso ao BD  

- Finalizar a aplicação  



**Apresentação:**

- A apresentação deverá ser realizada pela equipe  

- Cada aluno será avaliado individualmente  

- A nota é individual para cada aluno a depender da sua avaliação oral  



#####Considere o seguinte cenário para uma companhia aérea:



A companhia possui um nome, um CNPJ e uma frota composta por diversas aeronaves. Cada aeronave tem um prefixo, uma capacidade na primeira classe, uma capacidade na classe econômica e pode operar em diversos vôos. Um vôo acontece de uma cidade de origem para uma cidade de destino e é identificado por um número e custa um valor em real e um valor em pontos. (ex. o vôo 232 vai da salvador para São Paulo e custa R$250.00 ou 5000 pontos; o vôo 345 vai de Recife para Fortaleza e custa R$ 150.00 ou 3500 pontos). Esses vôos têm uma programação de datas em que eles acontecem, onde é registrada a data e hora de saída e a data e hora prevista de chegada ao destino (ex. o vôo 232 no dia 15/03/2011 sai de Salvador as 10:00 e chega a São Paulo neste mesmo dia as 12:00).   



Para cada programação de data do vôo, são vendidas passagens (dependendo da capacidade da aeronave) para os clientes.    



Os clientes da companhia devem ser cadastrados com CPF, nome, data de nascimento. Clientes especiais possuem um cartão fidelidade com um número para acumular pontos.    



Quando um cliente compra uma passagem é gerado automaticamente um código para a passagem (formado por um número aleatório gerado pelo sistema entre 1 e 1000). Esse código será utilizado no check in. Além do código o cliente indica se tem cartão fidelidade.    



Passagens podem ser de primeira classe ou econômicas. Passagens da primeira classe tem um adicional de 40% em relação ao preço/pontos da passagem econômica. Quando o cliente compra uma passagem de primeira classe ele informa a alimentação desejada pelo cliente e se ele consome bebida alcoólica ou não.    



Para o cenário acima, construir uma aplicação em Java que permita :

- Efetuar todos os cadastros necessários;

- Consultar vôos por data de saída, origem e destino

- Vender passagens 

- Calcular o valor da passagem em real e em pontos

- Calcular a quantidade de pontos ganhos na compra de uma passagem e atualizar estes pontos na efetivação da compra. Para cara R$1.00 cliente ganha 1 ponto.

- Cancelar passagem

- Emitir a passagem vendida, com todos os dados informados (na tela)

- Consultar saldo de pontos do cliente