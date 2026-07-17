# Cadastro de Pessoa Física

Atividade Android em Java com formulário de pessoa física, validação de campos, seletor de data e resumo dos dados preenchidos.

## Requisitos

- Android Studio com suporte ao Android Gradle Plugin usado pelo projeto
- JDK 17
- SDK Android compile/target 35
- Emulador Android ou aparelho com depuração USB

## Configuração Android

- Linguagem principal: Java
- SDK: compile/target 35
- SDK mínimo: API 24
- Java/JVM: 17

## Funcionalidades

- Nome e CPF
- Contatos e endereço
- Gênero e data de nascimento
- Validação obrigatória
- DatePicker
- Resumo formatado

## Estrutura principal

- `CadastroPessoaFisica/app/src/main/java/.../MainActivity.java — lógica`
- `CadastroPessoaFisica/app/src/main/res — layouts/recursos`
- `CadastroPessoaFisica/app/build.gradle.kts — Android`

## Abrir e executar

1. No Android Studio, abra a pasta `CadastroPessoaFisica`.
2. Aguarde a sincronização do Gradle.
3. Selecione um emulador ou aparelho com API 24 ou superior.
4. Execute a configuração `app`.

## Build pelo wrapper no Windows

Na raiz Android indicada acima:

```powershell
.\gradlew.bat assembleDebug
```

O APK de depuração é produzido pela tarefa padrão `assembleDebug` dentro da árvore `app/build/outputs/apk/debug/`.

## Testes

```powershell
.\gradlew.bat test
```

Também valide manualmente criação, leitura, edição, exclusão, rotação de tela e persistência após reiniciar o aplicativo.

## Dados e segurança

- Os dados são locais ao dispositivo; desinstalar o aplicativo pode removê-los.
- Credenciais de demonstração presentes no código não constituem autenticação segura para produção.

## Limitações

- O código inspecionado representa formulário acadêmico e não indica banco de dados.
- Dados digitados não devem ser tratados como cadastro persistente.
- CPF e demais dados pessoais exigem proteção adicional em uso real.

## Repositório

[redobrai-del/thomas-projetos](https://github.com/redobrai-del/thomas-projetos)