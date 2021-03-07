# Projeto Java RMI - Election


## Autor
### Wallace Barbosa 


## Sobre o projeto
### Requisitos do Projeto
Considere uma interface Election que fornece dois métodos remotos:

vote(String eleitor, String candidato):
String eleitor: código hash MD5 gerado a partir do nome completo do eleitor.
String candidato: String de 3 caracteres numéricos que identificam um candidato.
result(String candidato): este método possui dois parâmetros com os quais o servidor recebe o número de um candidato e retorna para o cliente o número de votos desse candidato.
Os identificadores de eleitor devem ser gerados a partir de uma função MD5 do nome completo do eleitor.
O sistema deve carregar a lista de candidatos a partir do arquivo senadores.csvPré-visualizar o documento  
Desenvolva um sistema para o serviço Election utilizando o Java RMI, que garanta que seus registros permaneçam consistentes quando ele é acessado simultaneamente por vários clientes.

O serviço Election deve garantir que todos os votos sejam armazenados com segurança, mesmo quando o processo servidor falha.

Considerando que o Java RMI possui semântica at-most-once, implemente um mecanismo de recuperação de falha no cliente que consiga obter uma semântica exactly-once para o caso do serviço ser interrompido por um tempo inferior a 30 segundos.

### Pré-requisitos
Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [Java JDK 1.8](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html).

### 🎲 Rodando o (Servidor)
```console

# Acesse a pasta de arquivos binários do projeto no terminal/cmd
 cd election-java-rmi-wallacebarbosa/bin

# Insira o comando e veja se o arquivo .bat referente ao servidor foi aberto
$  start servidor
```

### 🎲 Rodando o (Cliente)
```console

# Acesse a pasta de arquivos binários do projeto no terminal/cmd
$ cd election-java-rmi-wallacebarbosa/bin

# Insira o comando e veja se o arquivo .bat referente ao client foi aberto
$ start client {Name || result} {CandidateNumber}
```





