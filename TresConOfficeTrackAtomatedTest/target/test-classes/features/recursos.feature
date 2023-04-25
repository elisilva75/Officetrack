# language: pt
Funcionalidade: Recursos

Cenario: Clicar em localizar
Dado Estou logado e no menu Recursos
Quando Informar no campo Busca
E localizar pelo nome do funcionario
E limpar o buscador 
E localizar pelo numero do celular
E limpar o buscador
E Informar um nome de recurso inexistente
Entao Devera aprsentar a mensagem Nao ha registros para exibir
E Clicar duas vezes para Editar um funcionario
E Editar o nome do funcionario
E clicar em salvar e fechar

