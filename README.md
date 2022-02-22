# API_REST
Sistema Político
Duas API’s , contendo os métodos HTTP básicos (GET, POST, PUT, DELETE) para um
sistema Político.
API de Administrador contendo o CRUD e API de Consumo.
Link documentação postman API Principal - https://documenter.getpostman.com/view/18218649/UVRHghqa
Link documentação postman API Consumo - https://documenter.getpostman.com/view/18218649/UVRHghuq
Api principal necessita de Token(tempo limitado a 10 minutos), gera-lo no postman atraves do endpoint Autenticacao(POST)!
Ao Criar ou Alterar qualquer Político inserir:
nome - String,
cpf(cpf válido),
endereco com: (
logradouro - String,
numero - String,
complemento - String,
cep - String )
telefone - String,
id do partido - Long,
projetos de lei - String,
processos - Boolean, e
fotos - String (colar endereço da imagem).
