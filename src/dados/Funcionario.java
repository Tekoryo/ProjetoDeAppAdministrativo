package dados;

import dados.enums.TipoDeContrato;

public class Funcionario extends Dados {
    private Long telefone;
    private double salario;
    private TipoDeContrato TipoContrato;
    private String FuncaoNaEmpresa;
    //private Date DataAdimicao;

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
    }
    public Long getTelefone() {
        return telefone;
    }
    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public TipoDeContrato getTipoContrato() {
        return TipoContrato;
    }
    public void setTipoContrato(TipoDeContrato tipoContrato) {
        TipoContrato = tipoContrato;
    }
    public String getFuncaoNaEmpresa() {
        return FuncaoNaEmpresa;
    }
    public void setFuncaoNaEmpresa(String funcaoNaEmpresa) {
        FuncaoNaEmpresa = funcaoNaEmpresa;
    }
    
    
    
}
