package modelo.entities;


import modelo.entities.enums.TipoDeContrato;

public class Funcionario extends CadastroDeDados {
    private Long telefone;
    private double salario;
    private TipoDeContrato TipoContrato;
    private String FuncaoNaEmpresa;
    private Boolean StatusDoContrato;

    public Funcionario() {
        super();
    }
    public Funcionario(int ID, String Nome, Long telefone,
            double salario, TipoDeContrato tipoContrato, String funcaoNaEmpresa) {
        super(ID, Nome);
        this.telefone = telefone;
        this.salario = salario;
        this.TipoContrato = tipoContrato;
        this.FuncaoNaEmpresa = funcaoNaEmpresa;
        this.StatusDoContrato=true;
    }
    public Long getTelefone() {
        return telefone;
    }
    public double getSalario() {
        return salario;
    }
    public TipoDeContrato getTipoContrato() {
        return TipoContrato;
    }
    public String getFuncaoNaEmpresa() {
        return FuncaoNaEmpresa;
    }
    public void MudancaSalario(double salario){
        this.salario=salario;
    }
    public void status(boolean status){
        this.StatusDoContrato=status;
    }
    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public void setTipoContrato(TipoDeContrato tipoContrato) {
        TipoContrato = tipoContrato;
    }
    public void setFuncaoNaEmpresa(String funcaoNaEmpresa) {
        FuncaoNaEmpresa = funcaoNaEmpresa;
    }
    public Boolean getStatusDoContrato() {
        return StatusDoContrato;
    }
    public void AtualizandoTodosDados(String Nome, Long telefone, TipoDeContrato tipoContrato, String funcaoNaEmpresa){
        this.Nome=Nome;
        this.telefone = telefone;
        this.TipoContrato = tipoContrato;
        this.FuncaoNaEmpresa = funcaoNaEmpresa;
    }
    public String StatusText(boolean status){
        if(status==true){
            return "Contratado";
        }else{
            return "Demitido";
        }
    }
    @Override
    public String toString() {
        return "| ID do Funcionario: "+super.getID()
                +   "\n | Nome do Funcionario: "+super.getNome()
                +   "\n | Funcionario: " + FuncaoNaEmpresa 
                +   "\n | StatusDoContrato=" + StatusText(StatusDoContrato)
                +   "\n | TipoContrato=" + TipoContrato 
                +   "\n | salario=" + salario 
                +   "\n | telefone=" + telefone;
    }
    
}
