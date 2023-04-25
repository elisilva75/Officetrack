package br.trescon.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import br.trescon.utils.Constants;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class RecursoSteps extends BaseSteps {

	public RecursoSteps() {
		super(true);
	}

	@Dado("^Estou logado e no menu Recursos$")
	public void estou_logado_e_no_menu_Recursos() throws Throwable {
		clicaMenu(Constants.MENU_RECURSOS);
	}

	@Quando("^Informar no campo Busca$")
	public void informar_no_campo_Busca() throws Throwable {
		clicaMenu(Constants.MENU_RECURSOS);
		driver.findElement(By.xpath("//*[@id=\"txtQuickSearch\"]")).click();
	}

	@Quando("^localizar pelo nome do funcionario$")
	public void localizar_pelo_nome_do_funcionario() throws Throwable {
		preencherCampo("Carlos", "//*[@id=\"txtQuickSearch\"]");
		driver.findElement(By.xpath("//*[@id=\"txtQuickSearch\"]")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		String textoElement = driver.findElement(By.xpath("//*[@id=\"RadGrid1_ctl00__0\"]/td[3]")).getText();
		Assert.assertEquals("Carlos", textoElement);
	}

	@Quando("^limpar o buscador$")
	public void limpar_o_buscador() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"txtQuickSearch\"]")).clear();
	}

	@Quando("^localizar pelo numero do celular$")
	public void localizar_pelo_numero_do_celular() throws Throwable {
		preencherCampo("984620254", "//*[@id=\"txtQuickSearch\"]");
		driver.findElement(By.xpath("//*[@id=\"txtQuickSearch\"]")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		String textoElement = driver.findElement(By.xpath("//*[@id=\"RadGrid1_ctl00__0\"]/td[7]")).getText();
		Assert.assertEquals("+5511984620254", textoElement);
	}

	@Quando("^Informar um nome de recurso inexistente$")
	public void informar_um_nome_de_recurso_inexistente() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"txtQuickSearch\"]")).clear();
		preencherCampo("Elcio", "//*[@id=\"txtQuickSearch\"]");
		driver.findElement(By.xpath("//*[@id=\"txtQuickSearch\"]")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	@Entao("^Devera aprsentar a mensagem Nao ha registros para exibir$")
	public void devera_aprsentar_a_mensagem_Nao_ha_registros_para_exibir() throws Throwable {
		String textoElement = driver.findElement(By.xpath("//*[@id=\"RadGrid1_ctl00\"]/tbody/tr/td[2]/div")).getText();
		Assert.assertEquals("Não há registros a exibir", textoElement);
		driver.findElement(By.xpath("//*[@id=\"txtQuickSearch\"]")).clear();

	}

	@Entao("^Clicar duas vezes para Editar um funcionario$")
	public void clicar_duas_vezes_para_Editar_um_funcionario() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"RadToolbar1\"]/div/div/div/ul/li[1]/a/span/span/span/span[1]/span")).click();
		mudarContextoPopUp();
		Thread.sleep(1000);
	}

	@Entao("^Editar o nome do funcionario$")
	public void editar_o_nome_do_funcionario() throws Throwable {
		// //*[@id="txtName"]

		/*
		 * driver.findElement(By.xpath("//*[@id=\"txtName\"]")).clear();
		 * 
		 * preencherCampo("Carlos Gabricio ", "//*[@id=\"txtName\"]");
		 */

	}

	@Entao("^clicar em salvar e fechar$")
	public void clicar_em_salvar_e_fechar() throws Throwable {
		// driver.findElement(By.xpath("//*[@id=\"RadToolbar1\"]/div/div/div/ul/li[1]/a/span/span/span/span")).click();

	}

	@Quando("^Clicar no botao Novo Funcionario$")
	public void clicar_no_botao_Novo_Funcionario() throws Throwable {
		// clicaMenu(Constants.MENU_RECURSOS);
		// driver.findElement(By.xpath("//*[@id=\"RadToolbar1\"]/div/div/div/ul/li[1]/a/span/span/span/span[1]/span")).click();

	}

	@Quando("^Abrir a tela de preenchimento dos dados$")
	public void abrir_a_tela_de_preenchimento_dos_dados() throws Throwable {

	}

	@Quando("^Clicar uma vez sobre o funcionario para selecionar$")
	public void clicar_uma_vez_sobre_o_funcionario_para_selecionar() throws Throwable {

	}

	@Quando("^Clicar no botao excluir$")
	public void clicar_no_botao_excluir() throws Throwable {

	}

	@Quando("^Na tela Tem certeza que deseja excluir o funcionrio suporte Confirmar com Nao$")
	public void na_tela_Tem_certeza_que_deseja_excluir_o_funcionrio_suporte_Confirmar_com_Nao() throws Throwable {

	}

	@Quando("^Clicar uma vez sobre o botao Lista de Funcionarios$")
	public void clicar_uma_vez_sobre_o_botao_Lista_de_Funcionarios() throws Throwable {

	}

	@Quando("^Selecionar o item Lista de Sensores caso nao tenha itens preenchidos devera apresentar Nao ha registros a exibir$")
	public void selecionar_o_item_Lista_de_Sensores_caso_nao_tenha_itens_preenchidos_devera_apresentar_Nao_ha_registros_a_exibir()
			throws Throwable {

	}

	@Quando("^Selecionar o item Lista de Veiculos caso nao tenha itens preenchidos devera apresentar Nao ha registros a exibir$")
	public void selecionar_o_item_Lista_de_Veiculos_caso_nao_tenha_itens_preenchidos_devera_apresentar_Nao_ha_registros_a_exibir()
			throws Throwable {

	}

	@Quando("^Selecionar o item Lista de Funcionarios caso nao tenha itens preenchidos devera apresentar Nao ha registros a exibir$")
	public void selecionar_o_item_Lista_de_Funcionarios_caso_nao_tenha_itens_preenchidos_devera_apresentar_Nao_ha_registros_a_exibir()
			throws Throwable {

	}

	@Quando("^Estiver selecionado um funcionario$")
	public void estiver_selecionado_um_funcionario() throws Throwable {

	}

	@Quando("^Clicar no botao Acoes$")
	public void clicar_no_botao_Acoes() throws Throwable {

	}

	@Quando("^Selecionar editar atribuicao de area de distribuicao$")
	public void selecionar_editar_atribuicao_de_area_de_distribuicao() throws Throwable {

	}

	@Quando("^Na tela clicar em checar Pontos de interesse$")
	public void na_tela_clicar_em_checar_Pontos_de_interesse() throws Throwable {

	}

	@Quando("^Clicar no botao Salvar e Fechar$")
	public void clicar_no_botao_Salvar_e_Fechar() throws Throwable {

	}

	@Quando("^Selecionar editar Adicionar servicos no veiculo$")
	public void selecionar_editar_Adicionar_servicos_no_veiculo() throws Throwable {

	}

	@Quando("^Na tela que abrir pode apresentar a Nao ha registros a exibir$")
	public void na_tela_que_abrir_pode_apresentar_a_Nao_ha_registros_a_exibir() throws Throwable {

	}

	@Quando("^Selecionar gerar codigo de conexao$")
	public void selecionar_gerar_codigo_de_conexao() throws Throwable {

	}

	@Quando("^Na tela que abrir selecionar um funcionario$")
	public void na_tela_que_abrir_selecionar_um_funcionario() throws Throwable {

	}

	@Quando("^Clicar no botao Gerar codigo de conexao$")
	public void clicar_no_botao_Gerar_codigo_de_conexao() throws Throwable {

	}

	@Quando("^selecionar Gerar codigo de conexao e validar o codigo gerado$")
	public void selecionar_Gerar_codigo_de_conexao_e_validar_o_codigo_gerado() throws Throwable {

	}

	@Quando("^Exportar no Excel$")
	public void exportar_no_Excel() throws Throwable {

	}

	@Quando("^Exportar no Word$")
	public void exportar_no_Word() throws Throwable {

	}

	@Quando("^Clicar em fechar a janela$")
	public void clicar_em_fechar_a_janela() throws Throwable {

	}

	@Quando("^Selecionar o botao ferramentas$")
	public void selecionar_o_botao_ferramentas() throws Throwable {

	}

	@Quando("^Importar Veiculos$")
	public void importar_Veiculos() throws Throwable {

	}

	@Quando("^Importar Funcionarios$")
	public void importar_Funcionarios() throws Throwable {

	}

	@Quando("^Validar a importacao de veiculos e funcionarios$")
	public void validar_a_importacao_de_veiculos_e_funcionarios() throws Throwable {

	}
}
