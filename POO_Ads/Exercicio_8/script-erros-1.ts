

try {
    //lancei um erro
    throw new Error('Meu primeiro erro');
    //pensando que o código ainda executa, vou chamar uma operação
    let n: number = 1;
    console.log('Este número não será exibido' + n);
} catch(e) {
    console.log('Ocorreu um erro inesperado. Contate o suporte.');
}