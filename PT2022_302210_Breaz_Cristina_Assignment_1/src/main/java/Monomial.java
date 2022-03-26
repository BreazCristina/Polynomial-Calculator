public class Monomial {

       private double coeficient;
       private int exponent;
       public Monomial(double coeficient, int exponent)
       {
           this.coeficient=coeficient;
           this.exponent=exponent;
       }

    public double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public Monomial devide(Monomial m)
    {
        Monomial res=new Monomial(0,0);

            res.setExponent( (this).getExponent() - m.getExponent());
            res.setCoeficient((this).getCoeficient()/m.getCoeficient());

        return res;
    }

    @Override
    public String toString() {
        return "Monomial{" +
                "coeficient=" + coeficient +
                ", exponent=" + exponent +
                '}';
    }
}
