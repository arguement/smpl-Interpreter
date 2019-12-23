package fnplot.syntax;

public class Clause {

    private Exp anTqExp;
    private Exp consqExp;

    public Clause(Exp anTqExp, Exp consqExp) {
        this.anTqExp = anTqExp;
        this.consqExp = consqExp;
    }

    public Exp getAnTqExp() {
        return anTqExp;
    }

    public void setAnTqExp(Exp anTqExp) {
        this.anTqExp = anTqExp;
    }

    public Exp getConsqExp() {
        return consqExp;
    }

    public void setConsqExp(Exp consqExp) {
        this.consqExp = consqExp;
    }
    
}