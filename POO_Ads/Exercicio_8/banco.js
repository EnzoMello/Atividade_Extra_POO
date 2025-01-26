"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
Object.defineProperty(exports, "__esModule", { value: true });
exports.Banco = exports.Cliente = exports.Poupanca = exports.ContaImposto = exports.Conta = void 0;
var Conta = /** @class */ (function () {
    function Conta(id, numero, saldo) {
        this._id = id;
        this._numero = numero;
        this._saldo = saldo;
    }
    Conta.prototype.sacar = function (valor) {
        if (this._saldo < valor) {
            throw new Error('Saldo insuficiente:' + this._saldo);
        }
        this._saldo = this._saldo - valor;
    };
    Conta.prototype.depositar = function (valor) {
        this._saldo = this._saldo + valor;
    };
    Conta.prototype.transferir = function (contaDestino, valor) {
        // this.saldo = this.saldo - valor;
        // contaDestino.saldo = contaDestino.saldo + valor;
        this.sacar(valor);
        contaDestino.depositar(valor);
    };
    Object.defineProperty(Conta.prototype, "id", {
        get: function () {
            return this._id;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Conta.prototype, "numero", {
        get: function () {
            return this._numero;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Conta.prototype, "saldo", {
        get: function () {
            return this._saldo;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Conta.prototype, "cliente", {
        get: function () {
            return this._cliente;
        },
        set: function (cliente) {
            this._cliente = cliente;
        },
        enumerable: false,
        configurable: true
    });
    return Conta;
}());
exports.Conta = Conta;
var Poupanca = /** @class */ (function (_super) {
    __extends(Poupanca, _super);
    function Poupanca(id, numero, saldo, taxaDeJuros) {
        var _this = _super.call(this, id, numero, saldo) || this;
        _this._taxaDeJuros = taxaDeJuros;
        return _this;
    }
    Poupanca.prototype.renderJuros = function () {
        var juros = this.saldo * this._taxaDeJuros;
        this.depositar(juros);
    };
    Object.defineProperty(Poupanca.prototype, "taxaDeJuros", {
        get: function () {
            return this._taxaDeJuros;
        },
        enumerable: false,
        configurable: true
    });
    return Poupanca;
}(Conta));
exports.Poupanca = Poupanca;
var ContaImposto = /** @class */ (function (_super) {
    __extends(ContaImposto, _super);
    function ContaImposto(id, numero, saldo, taxaDeImposto) {
        var _this = _super.call(this, id, numero, saldo) || this;
        _this._taxaDeImposto = taxaDeImposto;
        return _this;
    }
    ContaImposto.prototype.sacar = function (valor) {
        var imposto = valor * this._taxaDeImposto;
        var totalSaque = valor + imposto;
        _super.prototype.sacar.call(this, totalSaque);
    };
    Object.defineProperty(ContaImposto.prototype, "taxaDeImposto", {
        get: function () {
            return this._taxaDeImposto;
        },
        enumerable: false,
        configurable: true
    });
    return ContaImposto;
}(Conta));
exports.ContaImposto = ContaImposto;
var Cliente = /** @class */ (function () {
    function Cliente(id, nome, cpf, dataNascimento) {
        this._id = id;
        this._nome = nome;
        this._cpf = cpf;
        this._dataNascimento = dataNascimento;
        this._contas = [];
    }
    Object.defineProperty(Cliente.prototype, "id", {
        get: function () {
            return this._id;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Cliente.prototype, "nome", {
        get: function () {
            return this._nome;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Cliente.prototype, "cpf", {
        get: function () {
            return this._cpf;
        },
        enumerable: false,
        configurable: true
    });
    Cliente.prototype.adicionarConta = function (contaProcurada) {
        this._contas.push(contaProcurada);
    };
    Cliente.prototype.listarCopiaContas = function () {
        var copiaContas = [];
        for (var _i = 0, _a = this._contas; _i < _a.length; _i++) {
            var conta = _a[_i];
            var contaCopiada = new Conta(conta.id, conta.numero, conta.saldo);
            contaCopiada.cliente = conta.cliente;
            copiaContas.push(contaCopiada);
        }
        return copiaContas;
    };
    Object.defineProperty(Cliente.prototype, "dataNascimento", {
        get: function () {
            return this._dataNascimento;
        },
        enumerable: false,
        configurable: true
    });
    return Cliente;
}());
exports.Cliente = Cliente;
/*
let c1: Cliente = new Cliente('ely', '825', new Date);
c1.id = 1;
c1.adicionarConta(new Conta('111-1', 100));

let contas1 = c1.listarCopiaContas();
contas1[0].sacar(100);
console.log(contas1[0].saldo);

let contas2 = c1.listarCopiaContas();
console.log(contas2[0].saldo);

*/
var Banco = /** @class */ (function () {
    function Banco() {
        this._contas = [];
        this._clientes = [];
    }
    Object.defineProperty(Banco.prototype, "contas", {
        get: function () {
            return this._contas;
        },
        enumerable: false,
        configurable: true
    });
    Banco.prototype.inserirConta = function (conta) {
        this._contas.push(conta);
    };
    Banco.prototype.consultarConta = function (numero) {
        var contaProcurada;
        for (var _i = 0, _a = this._contas; _i < _a.length; _i++) {
            var conta = _a[_i];
            if (conta.numero == numero) {
                contaProcurada = conta;
                break;
            }
        }
        return contaProcurada;
    };
    Banco.prototype.consultarContaPorIndice = function (numero) {
        var indiceProcurado = -1;
        for (var i = 0; i < this._contas.length; i++) {
            if (this._contas[i].numero == numero) {
                indiceProcurado = i;
                break;
            }
        }
        return indiceProcurado;
    };
    Banco.prototype.excluir = function (numero) {
        var indiceProcurado = this.consultarContaPorIndice(numero);
        if (indiceProcurado != -1) {
            for (var i = indiceProcurado; i < this._contas.length - 1; i++) {
                this._contas[i] = this._contas[i + 1];
            }
            this._contas.pop();
        }
    };
    Banco.prototype.alterar = function (conta) {
        var contaProcurada = this.consultarConta(conta.numero);
        if (contaProcurada) {
            contaProcurada = conta;
        }
    };
    Banco.prototype.inserirCliente = function (cliente) {
        this._clientes.push(cliente);
    };
    Banco.prototype.consultarCliente = function (cpf) {
        var clienteProcurado;
        for (var _i = 0, _a = this._clientes; _i < _a.length; _i++) {
            var cliente = _a[_i];
            if (cliente.cpf == cpf) {
                clienteProcurado = cliente;
            }
        }
        return clienteProcurado;
    };
    Banco.prototype.sacar = function (numero, valor) {
        var contaProcurada = this.consultarConta(numero);
        if (contaProcurada) {
            contaProcurada.sacar(valor);
        }
    };
    Banco.prototype.depositar = function (numero, valor) {
        var contaProcurada = this.consultarConta(numero);
        if (contaProcurada) {
            contaProcurada.depositar(valor);
        }
    };
    Banco.prototype.transferir = function (numeroOrigem, numeroDestino, valor) {
        var contaOrigem = this.consultarConta(numeroOrigem);
        var contaDestino = this.consultarConta(numeroDestino);
        if (contaOrigem && contaDestino) {
            contaOrigem.transferir(contaDestino, valor);
        }
    };
    Banco.prototype.associarContaCliente = function (numeroConta, cpfCliente) {
        var contaProcurada = this.consultarConta(numeroConta);
        var clienteProcurado = this.consultarCliente(cpfCliente);
        if (contaProcurada && clienteProcurado) {
            contaProcurada.cliente = clienteProcurado;
            clienteProcurado.adicionarConta(contaProcurada);
        }
    };
    Banco.prototype.jaExisteContaParaCliente = function (cliente, conta) {
        var jaExiste = false;
        if (conta.cliente != null) {
            if (conta.cliente.cpf == cliente.cpf) {
                jaExiste = true;
            }
            else {
                for (var _i = 0, _a = cliente.listarCopiaContas(); _i < _a.length; _i++) {
                    var contaAssociada = _a[_i];
                    if (contaAssociada.numero == conta.numero) {
                        jaExiste = true;
                    }
                }
            }
        }
        return jaExiste;
    };
    Banco.prototype.listarContasCliente = function (cpf) {
        var clienteProcurado = this.consultarCliente(cpf);
        var contas = [];
        if (clienteProcurado) {
            contas = clienteProcurado.listarCopiaContas();
        }
        return contas;
    };
    Banco.prototype.renderJuros = function (numero) {
        var contaProcurada = this.consultarConta(numero);
        if (contaProcurada instanceof Poupanca) {
            //(contaProcurada as Poupanca).renderJuros(); em java é obrigatório o "cast"
            contaProcurada.renderJuros(); //em typescript já é feito o cast
        }
    };
    Banco.prototype.totalizarSaldoCliente = function (cpf) {
        var clienteProcurado = this.consultarCliente(cpf);
        var total = 0;
        if (clienteProcurado) {
            for (var _i = 0, _a = clienteProcurado.listarCopiaContas(); _i < _a.length; _i++) {
                var conta = _a[_i];
                total += conta.saldo;
            }
        }
        return total;
    };
    Banco.prototype.obterQuantidadeDeContas = function () {
        return this._contas.length;
    };
    Banco.prototype.obterTotalDinheiroDepositado = function () {
        var total = 0;
        for (var _i = 0, _a = this._contas; _i < _a.length; _i++) {
            var conta = _a[_i];
            total = total + conta.saldo;
        }
        return total;
    };
    Banco.prototype.calcularMediaSaldoContas = function () {
        return this.obterTotalDinheiroDepositado() / this.obterQuantidadeDeContas();
    };
    return Banco;
}());
exports.Banco = Banco;
