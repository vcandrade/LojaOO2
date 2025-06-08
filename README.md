## Download do Projeto
1. Clone o projeto para a pasta **"eclipse-workspace"**:

`git clone https://github.com/vcandrade/LojaOO2`

- Alternativa: Faça download e descompacte o projeto na pasta **"eclipse-workspace"**.

## Configure a Base de Dados
1. Crie uma base de dados com o nome de **"loja"** no MySQL.

2. Na raiz do projeto Java, há uma pasta com o nome de **"database"**, nela há um arquivo chamado **"loja.sql"**. Este arquivo deve ser importado para a base de dados **"loja"**, criada no passo 1.

**Obs.:** Esta base contém uma tabela chamada **"produto"**, nela há 3 produtos previamente cadastrados: _"Fone de Ouvido Bluetooth JBL Tune 510BT"_, _"Camiseta Básica Algodão Masculina"_ e _"Café Torrado e Moído 500g – Melitta Tradicional"_.

## Configure o Projeto no Eclipse IDE
1. Importe o projeto para o eclipse: _File_ > _Import_ > _General_ > _Existing Projects into Workspace_

2. Adicione o conector MySQL:
   - Faça download do conector MySQL: https://moodle.utfpr.edu.br/mod/resource/view.php?id=1770834
   - Pressione com o botão direito no projeto e selecione a opção _Properties_;
   - Selecione _Java Build Path_ > _Libraries_ > _Modulepath_
   - Se o conector não estiver sendo reconhecido, exclua-o e depois clique em _"Add External JARs..."_;
   - Encontre o conector baixado e adicione-o.
     
3. Adicione a biblioteca JUnit
   - Botão direito no projeto e selecione a opção _Properties_;
   - Selecione _Java Build Path_ > _Libraries_ > _Classpath_;
   - Se a biblioteca JUnit não estiver sendo reconhecida, clique em _"Add library..."_;
   - Selecione _"JUnit"_ e em seguida, na versão, _"JUnit5"_.
