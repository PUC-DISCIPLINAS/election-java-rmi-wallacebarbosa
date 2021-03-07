# Projeto Java RMI - Election


## Autor
### Wallace Barbosa 
🏁 Tópicos
=================

* [Sobre](#sobre)
    * [Descrição do Projeto](#Descrição)
    * [Pré-requisitos](#Pré-requisitos)
    * [Classes](#Classes)
* [Tecnologias](#Tecnologias)
* [Autor](#Autor)
* [License](#License)


## Sobre o projeto
### Descrição do Projeto
Foi desenvolvido uma aplicação de eleição utilizando o protocolo RMI (JAVA) através da linguagem JAVA.
Além disto técnicas como programação tolerante a falhas foram utilizados, de forma a tornar o client-side exactly-once.

### Pré-requisitos
Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [Java JDK 1.8](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html).

### 🎲 Rodando o Back End (Servidor)
```bash
# Clone este repositório
$ git clone <https://github.com/PUC-DISCIPLINAS/election-java-rmi-germano-carlos.git>

# Acesse a pasta de arquivos binários do projeto no terminal/cmd
$ cd out/production/election-java-rmi-germano-carlos

# Insira o comando e veja se o arquivo .bat referente ao servidor (ServerSideBAT.bat) foi aberto
$  start ServerSideBAT.bat
```

### 🎲 Rodando o Back End (Cliente)
```bash
# Clone este repositório
$ git clone <https://github.com/PUC-DISCIPLINAS/election-java-rmi-germano-carlos.git>

# Acesse a pasta de arquivos binários do projeto no terminal/cmd
$ cd out/production/election-java-rmi-germano-carlos

# Insira o comando e veja se o arquivo .bat referente ao client (Eleitor)(ClientSideBAT.bat) foi aberto
$ start ClientSideBAT.bat
```


## Classes
#### 📚 EleicaoServer: Classe referente ao servidor alocado para receber as requisições. Utilizado o protocolo RMI para a criação deste servidor.

#### 📕 Eleicao: Interface utilizada para declaração de metodos bases e abstratos. Estes serão sobreescritos pelas classes estendidas.

#### 📘 EleicaoServant: Classe que implementa RemoteObject (RMI) e estende a interface Eleicao. Nesta classe possui a lógica e definição de recebimento e retorno de parametros para o cliente.

#### 📗 Candidato: Classe que conterá atributos referentes aos candidatos a eleição

#### 📙 EleitorClient: Classe que será responsável por conter o "client" do eleitor. Através dessa classe ofereceremos as possibilidades de ações, conectaremos ele ao objeto remoto e faremos a lógica de requisições e semantic-call ("exactly-once") 

#### 📚 Voto: Classe responsável por guardar alguns atributos do voto como "Computado" / "Usuário". Estes valores irão para o Cache de forma a serem recuperados mais facilmente posteriormente.

#### 📒 Cache: Classe que guardará os valores e fará a lógica do cache. Os valores ficarão no cache durante 30segundos, após este tempo o item será removido, e limpado.

#### 📓 ItemCache: Classe que conterá o "Item" que irá para o cache, ele é generico de forma a conseguir receber qualquer tipo de informação

#### 📔 Utils: Classe que será responsável por gerenciar as Utilidades do código. Algumas funções de helper foram utilizadas, como a validação do tempo do cache e Encriptação em MD5


## Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:
- [Java]


