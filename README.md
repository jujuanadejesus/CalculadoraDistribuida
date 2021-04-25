##Calculadora Distribuida##

Disciplina de Sistemas Distribuídos - FACAPE

O objetivo deste projeto é desenvolver um pequeno sistema distribuído de servidores utilizando sockets (Calculadora). 
O projeto será composto de algumas etapas, que serão avaliadas em conjunto. 
O sistema/programa a ser implementado pode ser desenvolvido em Java e deve executar no Linux/ Windows. 
Os fontes, executáveis e o texto devem ser disponibilizados no github. 
O sistema será composto de: 
- Um cliente que pode ser em linha de comando ou interface gráfica que encaminhará as operações via sockets para servidores especialistas multithread 
- servidor especialista A que será encarregado de realizar as 4 operações básicas 
- servidor especialista B que realizará as operações de porcentagem, raiz quadrada e potenciação. 
Um arquivo de texto, tipo README deve descrever as decisões de projeto, entre ela as relacionadas a protocolo criado, endereçamento, registro, portas, obtenção destas informações, etc. Valor 9,0. Grupo de 5.


- Deve ter 3 componentes (cliente, servidor 1, servidor 2)
- Deve ser multithread
- Deve executar corretamente as operações em cada servidor conforme requisitado
- Deve executar a conexão do cliente com os dois servidores
- Deve tratar as exceções de: operação inválida, divisão por zero
- Deve tratar apenas um operador e dois operandos

Equipe: Juliana de Jesus e Tarcisio Ramon.

IP: 127.0.0.1
Port Cliente: 12345
Port ServidorOpBasica: 12347
Port Servidor2: 12348
