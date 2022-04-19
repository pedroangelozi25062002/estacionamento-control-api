# estacionamento-control-api
A api "estacionamento-control-api" foi criada para facilitar o controle de acesso a vagas de um condominio.

# JAVA

JDK-1.8

# Spring-Boot

SpringBoot-2.6.3

# Configurando as Variáveis JAVA_HOME e MAVEN_HOME no Windows.

Existem algumas maneiras de configurá-las mas creio que a mais 

    simples seja esta:
    Abra o prompt de comando (tecla windows + cmd + enter)
    Digite: setx -m JAVA_HOME "C:\Program Files\Java\jdk-xx.x.x"

Maaas, se você é do tipo que não gosta de fazer as coisas por comandos, temos uma opção um pouco mais demorada porém simples também:

    Clique na tecla windows do teclado e digite variáveis
    Selecione a opção Editar as variáveis de ambiente do sistema
    Clique no botão Variáveis ​​de Ambiente
    
Em variáveis ​​do sistema, clique em novo. (você pode definir somente para usuário logado, mas de preferência adicione nas variáveis do sistema, para que qualquer outro usuário possa usá-las)
  
    Digite o nome da variável como JAVA_HOME ou MAVEN_HOME
    Digite no valor da variável o caminho da instalação. Por exemplo:
    
    "C:\Program Files\Java\jdk-13.0.1” para JAVA_HOME"
    "C:\Program Files\Apache\apache-maven-3.6.3” para MAVEN_HOME"
    
# Clique no botão OK

# Depois de configurar as variáveis, você deverá definir o caminho também para executar via prompt de comando.

    Selecione a variável Path e clique no botão Editar…
    
    Clique Novo
    
    Insira a representação da variável com % antes e após o nome + \bin para acessar os binários. Por exemplo: “%JAVA_HOME%\bin”
    
# Clique em Ok e Ok novamente para confirmar as alterações.
    
# Pronto! Agora precisamos confirmar se está tudo certo…

# Abra o prompt de comando e digite echo %nome_da_variável%
    
# Deve aparecer o caminho especificado na variável, caso não apareça, reinicie seu computador para processar as alterações.




# Configurando as Variáveis JAVA_HOME e MAVEN_HOME Unix (Linux/Mac)

# Ao contrário do Windows, nos sistemas operacionais Unix não é comum fazer esta configuração de forma tão interativa, vamos ter que fazê-la via terminal, que é ainda mais rápido. (Lamento por você que não gosta)

# Korn / bash shell:

export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-13.0.1/Contents/Homeexport MAVEN_HOME=/Library/Apache/apache-maven-3.6.3export PATH=$JAVA_HOME/bin:$MAVEN_HOME/bin:$PATH

# Bourne shell:

JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-13.0.1/Contents/Homeexport JAVA_HOMEMAVEN_HOME=/Library/Apache/apache-maven-3.6.3export MAVEN_HOMEPATH=$JAVA_HOME/bin:$MAVEN_HOME/binexport PATH

# C shell:

setenv JAVA_HOME /Library/Java/JavaVirtualMachines/jdk-13.0.1/Contents/Homesetenv MAVEN_HOME /Library/Apache/apache-maven-3.6.3setenv PATH $JAVA_HOME/bin:$MAVEN_HOME/bin:$PATHexport PATH

# Após configurarmos precisamos testar para ver se está tudo ok. Abra o terminal e digite echo ${nome_da_variável}:

# Caso o valor especificado não apareça, reinicie seu computador para processar as alterações.
# Considerações Finais

Enfim concluímos a configuração das nossas variáveis de ambientes!
Este processo se repete para a grande maioria das outras variáveis que necessitamos configurar, como, por exemplo, ANDROID_HOME, MAVEN_OPTS, ANT_HOME, etc.


# === Java 11 (LTS) ===

# >Abra o Terminal

# >Instalar Java: 

  $ sudo apt install openjdk-11-jdk 
  
# >Verificar instalação: 
  $ java -version
  
# >Configurar variável de ambiente JAVA_HOME:

 # 1)Verificar caminho do Java: 
 
  $ sudo update-alternatives --config java
  
 # 2)Copie o caminho do Java exibido no comando acima
 
 # 3) Edite o arquivo .bashrc: 
 
  $ sudo gedit ~/.bashrc
  
 # 4)Copie o código abaixo e cole no final do arquivo .bashrc (lembrando de colar no código o caminho do Java que você copiou no comando anterior). Agora salve e feche o arquivo .bashrc.
  
  JAVA_HOME=(COLE AQUI O CAMINHO DO JAVA)
  
  export JAVA_HOME
  
  export PATH=$PATH:$JAVA_HOME
  
 # 5) Verifique abrindo o terminal digitando: 
  $ echo $JAVA_HOME
  
# === MAVEN ===

# >Abra o Terminal

# >Instalar Maven: 

  $ sudo apt-get install maven
  
# >Verificar instalação:
 
  $ mvn -v




