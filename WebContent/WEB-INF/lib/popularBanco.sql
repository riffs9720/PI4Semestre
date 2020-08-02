INSERT INTO Cliente (nomeCliente, cpfCliente, telefoneCliente, enderecoCliente, dtNascimentoCliente) VALUES ('Ricardo Ferla Silva', 408669118, 119841831, 'Rua Jorge Leal Amado de Faria, 49', 19910808);	
INSERT INTO TipoConta (tipoConta) VALUES ('Conta Corrente');
INSERT INTO TipoConta (tipoConta) VALUES ('Conta Poupança');
INSERT INTO Agencia (enderecoAgencia, telefoneAgencia) VALUES ('Rua Tutoia, 101', 11592103);
INSERT INTO Conta (numeroConta, senhaConta, dtAberturaConta, saldoConta, numeroToken, Cliente_idCliente, TipoConta_idTipoConta, Agencia_idAgencia) VALUES (123, 123, 20180523, 500.00, 123456, 1, 1, 1);
INSERT INTO Transferencia (identificacaoTransferencia, valorTransferencia, dtTransferencia, cpfBeneficiadoTransferencia, Conta_numeroConta) VALUES ('teste', 500, 20180524, 408669118, 1);


SELECT * FROM Cliente;
SELECT * FROM TipoConta;
SELECT * FROM Agencia;
SELECT * FROM Conta;
SELECT * FROM Pagamento WHERE date(dtPagamento) BETWEEN ('2018-05-26') AND ('2018-05-26');
SELECT * FROM Transferencia;
SELECT * FROM Transacao INNER JOIN Transferencia INNER JOIN Pagamento;
SELECT * FROM Pagamento;

UPDATE Conta SET saldoConta=4000.00 WHERE numeroConta=123;

SELECT identificacaoPagamento, dtPagamento, valorPagamento, identificacaoTransferecia, dtTransferencia, identificacaoTransferecia FROM Transferencia INNER JOIN Pagamento ON Transferencia.dtTransferencia = Pagamento.dtPagamento WHERE dtTransferencia = 20180524;

SELECT identificacaoPagamento, dtPagamento, valorPagamento, identificacaoTransferecia, dtTransferencia, identificacaoTransferecia FROM Transferencia JOIN Pagamento ON Transferencia.Conta_numeroConta = Pagamento.Conta_numeroConta WHERE Pagamento.Conta_numeroConta=123;


SELECT Pagamento.Conta_numeroConta, numeroConta, identificacaoPagamento, valorPagamento, dtPagamento FROM Pagamento INNER JOIN Conta ON Conta.numeroConta = Pagamento.Conta_numeroConta WHERE Conta.numeroConta = 123;

SELECT * FROM Pagamento INNER JOIN Conta ON Pagamento.Conta_numeroConta = Conta.numeroConta INNER JOIN Transferencia ON Transferencia.Conta_numeroConta = Conta.numeroConta WHERE Pagamento.Conta_numeroConta=123;

SELECT Transacao.Pagamento_idPagamento FROM Transacao;

SELECT identificacaoPagamento, valorPagamento, dtPagamento, Pagamento.Conta_numeroConta, Pagamento.Conta_Agencia_idAgencia FROM Pagamento INNER JOIN Conta WHERE date(dtPagamento) BETWEEN ('2018-05-26') AND ('2018-05-26') AND Conta_numeroConta=123;

SELECT identificacaoPagamento, valorPagamento, dtPagamento, Pagamento.Conta_numeroConta FROM Pagamento INNER JOIN Conta ON Pagamento.Conta_numeroConta = Conta.numeroConta WHERE date(dtPagamento) BETWEEN ('2018-05-26') AND ('2018-05-26') AND Conta.numeroConta=123;