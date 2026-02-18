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

### Rodar pela IDE (IntelliJ IDEA/Eclipse/VS Code)
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
