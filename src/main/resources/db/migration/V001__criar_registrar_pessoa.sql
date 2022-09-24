create table pessoa (
id bigint primary key auto_increment,
nome varchar(50),
logradouro varchar(50),
data_cadastro date ,
data_pagamento date,
numero varchar(20),
bairro varchar(50),
preco varchar(50),
descricao varchar(100),
produto varchar(15),
telefone varchar(30),
quantidade int
);

insert into pessoa (nome, logradouro, data_cadastro ,data_pagamento, numero, bairro, preco, descricao, produto, telefone, quantidade) values ('Mario', 'Espanha', '2022-09-23', '2022-10-20', '357', 'Centro', '120', 'Viado', 'Gas', '439545-1145', 1);
insert into pessoa (nome, logradouro, data_cadastro ,data_pagamento, numero, bairro, preco, descricao, produto, telefone, quantidade) values ('Romario', 'Alemanha', '2022-09-22', '2022-10-20', '30', 'Jardim das Flores', '110', 'Avista', 'Gas', '439545-1145', 1);
insert into pessoa (nome, logradouro, data_cadastro ,data_pagamento, numero, bairro, preco, descricao, produto, telefone, quantidade) values ('José', 'São Paulo', '2022-09-20', '2022-10-25', '400', 'Centro', '120', 'Viado', 'Gas', '439545-1145', 1);
insert into pessoa (nome, logradouro, data_cadastro ,data_pagamento, numero, bairro, preco, descricao, produto, telefone, quantidade) values ('Luiz', 'Canada', '2022-09-24', '2022-10-26', '100', 'Jardim ', '120', 'Viado', 'Gas', '439545-1145', 1);
insert into pessoa (nome, logradouro, data_cadastro ,data_pagamento, numero, bairro, preco, descricao, produto, telefone, quantidade) values ('João', 'Espanha', '2022-09-25', '2022-10-30', '200', 'Centro', '120', 'Avista', 'Gas', '439545-1145', 1);