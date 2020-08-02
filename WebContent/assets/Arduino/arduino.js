//No arduino utilizar o código ja pronto do FirmataStandard. Arquivo > Exemplos > Firmata > StandartFirmata

var five = require("johnny-five"),
    board, button;

board = new five.Board();

board.on("ready", function () {
    var lcd = new five.LCD({
        controller: "PCF8574T"
    });
    // Create a new `button` hardware instance.
    // This example allows the button module to
    // create a completely default instance
    buttonLogar = new five.Button(2);
    buttonTransacao = new five.Button(7);

    // Inject the `button` hardware into
    // the Repl instance's context;
    // allows direct command line access
    board.repl.inject({
        button: button
    });

    console.log("Arduino Conectado com sucesso.")
    lcd.cursor(0, 3).print("Bem Vindo!");
    lcd.cursor(1, 0).print("ao Banco Cuelhar");

    // Button Event API

    // "down" the button is pressed
    buttonLogar.on("down", function () {
        var mysql = require('mysql');

        var con = mysql.createConnection({
            host: 'localhost',
            user: 'root',
            password: '009720',
            database: 'CuelharBank'
        });
        lcd.clear();
        lcd.cursor(0, 2).print("Seu token e:");
        lcd.cursor(0, 0).print("*");
        lcd.cursor(0, 15).print("*");

        lcd.cursor(0, 2).print("Seu token e:");

        var criarToken = (function getRandomInt(min, max) {
            var token = Math.floor(Math.random() * (max - min + 1)) + min;
            return token;
        })(100001, 999999);
        var token = criarToken;

        lcd.cursor(1, 5).print(token);
        lcd.cursor(1, 0).print("***");
        lcd.cursor(1, 13).print("***")

        function addToken(con) {
            const sql = "UPDATE Conta SET numeroToken= ?";
            const values = [
    [token]
];
            con.query(sql, [values], function (error, results, fields) {
                if (error) return console.log(error);
                console.log("Token: " + token + " Registrado com sucesso.");
                con.end();

            });

        }

        con.connect(function (err) {
            if (err) return console.log(err)
            addToken(con);
        });

    });
    buttonTransacao.on("down", function () {


        var mysql = require('mysql');

        var con = mysql.createConnection({
            host: 'localhost',
            user: 'root',
            password: 'ferla',
            database: 'CuelharBank'
        });

        function carregarTransacao(con) {
            const sql = "SELECT COUNT(dtTransacao) FROM Transacao WHERE date(dtTransacao) = date(now())";
            con.query(sql, function (error, results, fields) {
                if (error) return console.log(error);

                for (cont = 0; cont <= 2; cont++) {
                    if (cont <= 2) {
                        lcd.clear();
                        lcd.cursor(0, 2).print("Seu token e:");
                        lcd.cursor(0, 0).print("*");
                        lcd.cursor(0, 15).print("*");

                        lcd.cursor(0, 2).print("Seu token e:");

                        var criarToken = (function getRandomInt(min, max) {
                            var token = Math.floor(Math.random() * (max - min + 1)) + min;
                            return token;
                        })(100001, 999999);
                        var token = criarToken;

                        lcd.cursor(1, 5).print(token);
                        lcd.cursor(1, 0).print("***");
                        lcd.cursor(1, 13).print("***")
                        var mysql = require('mysql');

                        var con = mysql.createConnection({
                            host: 'localhost',
                            user: 'root',
                            password: 'ferla',
                            database: 'CuelharBank'
                        });

                        function addToken(con) {
                            const sql = "INSERT INTO ControleToken (Conta_numeroConta, numeroTokenTransacao) VALUES ?";
                            const values = [
    [123, token]
];
                            con.query(sql, [values], function (error, results, fields) {
                                if (error) return console.log(error);
                                console.log("Token: " + token + " Registrado com sucesso.");
                            });

                        }

                        con.connect(function (err) {
                            if (err) return console.log(err)
                            addToken(con);
                        });
                    } if(cont >= 2) {
                        lcd.clear();
                        lcd.cursor(0, 3).print("Transacoes");
                        lcd.cursor(1, 0).print("excedidas no dia");
                        console.log("Numero de Transações do dia foi excedida");
                        console.log(JSON.stringify(results));
                    }
                }
            });
        }
        con.connect(function (err) {
            if (err) return console.log(err)
            carregarTransacao(con);
        });
    });
});