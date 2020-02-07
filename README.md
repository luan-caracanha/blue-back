# blue-back
### **Projeto corresponde ao back-end para um sistema de votação pública.**

**Instruções para rodar aplicação blue-back local.**

**O projeto está configurado para utilizar o Banco de Dados
PostgreSQL, na versão <version>9.4.1212</version>
é necessário possuir uma Base de Dados com o nome: blue
e a sua senha: 123456
Caso seja necessário alterar o nome da Base de Dados ou a senha,
essa alteração deve ser realizada no arquivo application.properties 
no seguinte caminho \src\main\resources\application.properties 
e no método dataSource() na classe DataConfig.java no seguinte caminho 
\src\main\java\br\com\blue\back\config\DataConfig.java**

**Havendo a necessidade de implementação de casos de testes, o mesmo deve 
ser implementado no seguinte caminho \src\test\java\br\com\blue\back**

**Após as configurações acima terem sido realizadas, realizar o git clone do projeto, abrir 
o prompt de comando e seguir até a raiz do projeto.
executar o comando: mvn clean install -U**

**Ao finalizar, verificar se a porta 8080 está disponível, 
pois iremos utilizá-la com o próximo comando,
executar o comando: mvnw package && java -jar target/back-0.0.1-SNAPSHOT.jar**

**Ao finalizar, a aplicação estará estartada, e para comunicação é necessário
estartar o projeto blue-front**
