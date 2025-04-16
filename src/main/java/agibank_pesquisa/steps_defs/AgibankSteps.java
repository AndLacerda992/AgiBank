package agibank_pesquisa.steps_defs;

import agibank_pesquisa.web.PesquisaPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import static org.junit.Assert.assertTrue;

public class AgibankSteps {

    PesquisaPage paginaPesquisa;

    @After
    public void afterEach(){
        this.paginaPesquisa.fechar();
    }

    @Given("que estou na tela principal do AgiBank")
    public void que_estou_na_tela_principal_do_agi_bank() {
        this.paginaPesquisa = new PesquisaPage();
    }

    @Given("clico na lupa")
    public void clico_na_lupa() {
        this.paginaPesquisa.abriCampoDePesquisa();
    }

    @When("não insiro valor")
    public void nao_insiro_valor() {
       this.paginaPesquisa.escreverNoCampoPesquisa("");
    }

    @When("clico em pesquisar")
    public void clico_em_pesquisar() {
        this.paginaPesquisa.clicarEmPesquisar();
    }

    @Then("recebo um resultado default")
    public void recebo_um_resultado_default() {
        assertTrue(this.paginaPesquisa.resultadoPesquisaDefault());
    }

    @Then("visualizo mensagem de não há resultado para a pesquisa")
    public void visualizo_mensagem_de_nao_ha_resultado_para_a_pesquisa() {
        assertTrue(this.paginaPesquisa.semResultadoParaPesquisa());;
        assertTrue(this.paginaPesquisa.isSemResultadoDePesquisa());;
    }

    @When("insiro no campo {string}")
    public void insiro_no_campo(String pesquisa) {
        this.paginaPesquisa.escreverNoCampoPesquisa(pesquisa);
    }

    @Then("visualizo somente postagens que contém o texto pesquisado")
    public void visualizo_somente_postagens_que_contem_o_texto_pesquisado() {
        assertTrue(this.paginaPesquisa.pesquisaComResultado());
    }
}
