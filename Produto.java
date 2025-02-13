import java.time.LocalDate;

public class Produto {
protected static final double MARGEM_PADRAO = 0,2;

    protected String descricao;
    protected double precoCusto;
    protected double margemLucro;

    public Produto (String descricao, double precoCusto) {
        this(descricao, precoCusto, MARGEM_PADRAO);
    }

        public Produto(String descricao, double precoCusto, double margemLucro) {
            this.descricao= descricao;
            this.precoCusto= precoCusto;
            this.margemLucro= margemLucro;
        }

        public double valorVenda() {
            return precoCusto* (1+ margemLucro);
        }
}


class ProdutoNaoPerecivel extends Produto {
    public ProdutoNaoPerecivel(String descricao, double precoCusto){
        super(descricao, precoCusto);
    }

    public ProdutoNaoPerecivel(String descricao, double precoCusto, double margemLucro){
        super(descricao, precoCusto, margemLucro);
}

}

class ProdutoPerecivel extends Produto {
    private static final double DESCONTO = 0,25;
    private LocalDate validade;

    public ProdutoPerecivel(String descricao, double precoCusto, double margemLucro, LocalDate validade){
        super(descricao, precoCusto, margemLucro);
        this.validade=validade;

    }

    @Override
    public double valorVenda(){
        LocalDate hoje = LocalDate.now();
        if (!validade.isBefore(hoje) && validade.minusDays(7).isBefore(hoje)) {
            return super.valorVenda() * (1- DESCONTO);

        }
        return super.valorVenda();
}

}

