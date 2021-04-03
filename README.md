# Auth

Esse serviço cuida da parte de authenticação do sistema.

Para já iniciarmos com algumas informações em nossa base, devemos inserir antes de utilizar o sistema.
```sql
USE authdb;
 
INSERT INTO usuario VALUES(1, 'vitor@sgm.mg.gov.br', 'Vitor', '$2$10$/t0pnzsn.8GFVbM6bACbZOoFMIJ8XaUWHlfCbUsaE9v4yhIa0cePK');

INSERT INTO perfil VALUES (1, 'Admin');

INSERT INTO usuario_perfis VALUES(1, 1);
```

## Dependências

Para o desenvolvimento desse projeto foi utilizado uma dependencia chamada Lombok que nos ajuda na redução de código boilerplate.

https://projectlombok.org/
>Project Lombok is a java library that automatically plugs into your editor and build tools, spicing up your java.
>Never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables, and much more.