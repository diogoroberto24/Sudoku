# Sudoku (Java/Swing)

Implementação do jogo Sudoku em Java com interface gráfica (Swing). O objetivo é preencher a grade 9x9 com dígitos de 1 a 9, sem repetições em linhas, colunas e sub-blocos 3x3. Nesta implementação, o jogo valida suas jogadas comparando com uma solução conhecida: quando todos os campos corresponderem à solução e não houver erros, o jogo é considerado concluído.

## Como o Sudoku funciona
- A grade é 9x9, dividida em 9 blocos 3x3.
- Cada linha, coluna e bloco deve conter todos os números de 1 a 9, sem repetição.
- Algumas células começam preenchidas (fixas) e não podem ser alteradas.
- Nas células vazias, você insere números até completar corretamente a grade.

## Interface do jogo
- Grade 9x9 com campos:
  - Células fixas já aparecem preenchidas e ficam desabilitadas.
  - Células editáveis aceitam apenas um dígito de 1 a 9.
- Botões:
  - Verificar Jogo: informa se o jogo está não iniciado, incompleto ou completo, e se há erros.
  - Finalizar Jogo: caso completo e sem erros, finaliza o jogo e desabilita as ações.
  - Reiniciar: limpa todas as células que não são fixas.

## Requisitos
- JDK 17+ (recomendado) instalado e no PATH.
- Qualquer IDE Java (IntelliJ IDEA, Eclipse, VS Code com extensão Java) ou terminal.

Estrutura do código-fonte: `src/br/com/sudoku/...`. A classe principal da interface gráfica é `br.com.sudoku.UiMain`.

## Executando a UI (UiMain)

A classe `UiMain` espera receber, via argumentos de programa, a configuração inicial do tabuleiro com 81 pares “coordenada;valor,fixed”, onde:
- coordenada = "col,row" (coluna,linha), ambos de 0 a 8
- valor = número correto da solução (1–9) para aquela posição
- fixed = true para célula dada (pré-preenchida) e false para célula vazia

Abaixo existe um exemplo pronto de tabuleiro com uma solução padrão e um conjunto de dicas (células fixas). Basta copiar todos os argumentos exatamente como estão.

### Opção A) Rodar com classes já compiladas (pasta out/production/Sudoku)
No Prompt de Comando (CMD) do Windows, a partir da pasta raiz do projeto:

```bat
cd "c:\Users\marti\Desktop\bootcamp test\Projeto POO\Sudoku"
java -cp "out\production\Sudoku" br.com.sudoku.UiMain ^
"0,0;5,true" "1,0;3,true" "2,0;4,false" "3,0;6,false" "4,0;7,true" "5,0;8,false" "6,0;9,false" "7,0;1,false" "8,0;2,false" ^
"0,1;6,true" "1,1;7,false" "2,1;2,false" "3,1;1,true" "4,1;9,true" "5,1;5,true" "6,1;3,false" "7,1;4,false" "8,1;8,false" ^
"0,2;1,false" "1,2;9,true" "2,2;8,true" "3,2;3,false" "4,2;4,false" "5,2;2,false" "6,2;5,false" "7,2;6,true" "8,2;7,false" ^
"0,3;8,true" "1,3;5,false" "2,3;9,false" "3,3;7,false" "4,3;6,true" "5,3;1,false" "6,3;4,false" "7,3;2,false" "8,3;3,true" ^
"0,4;4,true" "1,4;2,false" "2,4;6,false" "3,4;8,true" "4,4;5,false" "5,4;3,true" "6,4;7,false" "7,4;9,false" "8,4;1,true" ^
"0,5;7,true" "1,5;1,false" "2,5;3,false" "3,5;9,false" "4,5;2,true" "5,5;4,false" "6,5;8,false" "7,5;5,false" "8,5;6,true" ^
"0,6;9,false" "1,6;6,true" "2,6;1,false" "3,6;5,false" "4,6;3,false" "5,6;7,false" "6,6;2,true" "7,6;8,true" "8,6;4,false" ^
"0,7;2,false" "1,7;8,false" "2,7;7,false" "3,7;4,true" "4,7;1,true" "5,7;9,true" "6,7;6,false" "7,7;3,false" "8,7;5,true" ^
"0,8;3,false" "1,8;4,false" "2,8;5,false" "3,8;2,false" "4,8;8,true" "5,8;6,false" "6,8;1,false" "7,8;7,true" "8,8;9,true"
```

Dicas:
- O caractere `^` permite quebrar a linha no CMD; você pode colar tudo em uma única linha se preferir.
- Cada argumento está entre aspas e separado por espaço.

### Opção B) Compilar e rodar manualmente (sem IDE)
No CMD, a partir da pasta raiz do projeto:

```bat
cd "c:\Users\marti\Desktop\bootcamp test\Projeto POO\Sudoku"
mkdir bin
javac -d bin -sourcepath src src\br\com\sudoku\UiMain.java
java -cp bin br.com.sudoku.UiMain "0,0;5,true" "1,0;3,true" "2,0;4,false" "3,0;6,false" "4,0;7,true" "5,0;8,false" "6,0;9,false" "7,0;1,false" "8,0;2,false" "0,1;6,true" "1,1;7,false" "2,1;2,false" "3,1;1,true" "4,1;9,true" "5,1;5,true" "6,1;3,false" "7,1;4,false" "8,1;8,false" "0,2;1,false" "1,2;9,true" "2,2;8,true" "3,2;3,false" "4,2;4,false" "5,2;2,false" "6,2;5,false" "7,2;6,true" "8,2;7,false" "0,3;8,true" "1,3;5,false" "2,3;9,false" "3,3;7,false" "4,3;6,true" "5,3;1,false" "6,3;4,false" "7,3;2,false" "8,3;3,true" "0,4;4,true" "1,4;2,false" "2,4;6,false" "3,4;8,true" "4,4;5,false" "5,4;3,true" "6,4;7,false" "7,4;9,false" "8,4;1,true" "0,5;7,true" "1,5;1,false" "2,5;3,false" "3,5;9,false" "4,5;2,true" "5,5;4,false" "6,5;8,false" "7,5;5,false" "8,5;6,true" "0,6;9,false" "1,6;6,true" "2,6;1,false" "3,6;5,false" "4,6;3,false" "5,6;7,false" "6,6;2,true" "7,6;8,true" "8,6;4,false" "0,7;2,false" "1,7;8,false" "2,7;7,false" "3,7;4,true" "4,7;1,true" "5,7;9,true" "6,7;6,false" "7,7;3,false" "8,7;5,true" "0,8;3,false" "1,8;4,false" "2,8;5,false" "3,8;2,false" "4,8;8,true" "5,8;6,false" "6,8;1,false" "7,8;7,true" "8,8;9,true"
```

### Opção C) Rodar pela IDE (IntelliJ IDEA/Eclipse/VS Code)
- Abra a pasta do projeto na IDE.
- Selecione a classe de execução: `br.com.sudoku.UiMain`.
- Defina os “Program Arguments” colando exatamente a mesma lista de argumentos do exemplo acima (pode ser em uma única linha).
- Execute a configuração.

## Personalizando o tabuleiro
- Para mudar quais células começam preenchidas, altere o `true/false` de cada par. `true` = fixa (pré-preenchida), `false` = editável.
- O número antes da vírgula é sempre o valor correto daquela posição na solução final; ele não deve ser alterado arbitrariamente, ou o jogo reportará erros.

## Execução em modo console (opcional)
Também há um modo console (`br.com.sudoku.Main`) que usa o mesmo formato de argumentos de programa. Para rodar via CMD com as classes pré-compiladas:

```bat
java -cp "out\production\Sudoku" br.com.sudoku.Main [MESMOS ARGUMENTOS DO EXEMPLO]
```

Use-o se quiser experimentar as operações em texto (inserir/remover número, exibir status, etc.).

## Licença
Uso educacional.
