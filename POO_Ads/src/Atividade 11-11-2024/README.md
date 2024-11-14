# Atividade Extra - POO

## Questão 1. Assinale verdadeiro ou falso:
- ( F ) Objetos são modelos para classes;
- ( F ) Atributos de uma classe devem ser obrigatoriamente inicializados para que as
classes compilem;
- ( F ) Uma variável declarada dentro de um método deve ser inicializada para que a
classe seja compilável;
- ( V ) Uma variável que seja uma classe declarada em um método é automaticamente
inicializada com undefined;
- ( V ) Construtores são rotinas especiais que servem para inicializar e configurar os
objetos no momento da instanciação;
- ( V ) Construtores não possuem tipo de retorno e podem ou não ter parâmetros;
- ( V ) Uma classe pode ter várias instâncias.

## 2. Suponha uma classe Hotel que sirva apenas para guardar a quantidade de
### Classe Hotel

A classe `Hotel` serve para guardar a quantidade de solicitações de reservas feitas. Abaixo está a implementação inicial:

```typescript
class Hotel {
    quantReservas: number;

    adicionarReserva(): void {
        this.quantReservas++;
    }
}
```
- Na compilação, não haverá erro, pois o typescript não tem problemas com uma variável undefined na compilação. Um possível erro, será no tempo de execução, já que não é possível incrementar uma variável com undefined. Assim, deve-se iniciar a variável em um construtor.
