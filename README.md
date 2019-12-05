# projeto-jwt

Projeto com a utiilização simples do JWT para geração de tokens de autenticação, utilizando Spring Boot e o banco em memória H2.

http://localhost:8080/user
Enviar requisição POST com um JSON no corpo da requisição com os campos:
 - nome, email e senha
Como retorno virá uma usuários e um token informando o tipo de autenticação.


Para utilização do token acesse:
http://localhost:8080/login
Enviar requisição POST com um JSON no corpo da requisição com os campos:
 - nome e email
 juntamente com o token recebido por meio do header Authentication.
 
 
 OBS: Os tokens gerados tem validade de 3 minutos afim de testar o JWT.
