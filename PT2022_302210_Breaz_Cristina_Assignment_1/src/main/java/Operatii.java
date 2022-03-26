import java.math.BigInteger;
import java.util.ArrayList;

public class Operatii {

    static final String INITIAL_VALUE = "1";

    //... Member variable defining state of calculator.
    private BigInteger m_total;  // The total current value state.

    //============================================================== constructor
    /** Constructor */
    Operatii() {
        reset();
    }
    /** Reset to initial value. */
    public void reset() {
        m_total = new BigInteger(INITIAL_VALUE);
    }
    public void setValue(String value) {
        m_total = new BigInteger(value);
    }

    //================================================================= getValue
    /** Return current calculator total. */
    public static String getValue(Polynomial Q) {
         String s="";
         for( Monomial m:Q.getMonomialArratList())
         {

             if(m.getCoeficient()==0)
             {                                   //coeficient nul, sa nu se mai afiseze monomul
                 s=s+"";
             }

             else if ( m.getExponent()==0)
             {
                 if(m.getCoeficient()<0)
                 {

                     if(m.getCoeficient()%1==0)
                         s = s + (int)m.getCoeficient();
                     else s=s+ m.getCoeficient();                       //exponent nul, coeficient mai mic decat 0 int sau double
                 }
                 else
                 {    if(m.getCoeficient()%1==0)                       //exponent nul , coeficient >0 int sau double
                         s = s + "+" +(int)m.getCoeficient();
                     else  s=s+"+"+(int)m.getCoeficient();

                 }
             }

             else
             {
                 if(m.getCoeficient()<0)
                 {
                     if(m.getCoeficient()%1==0)
                         s = s + (int)m.getCoeficient() + "x^" + m.getExponent();
                     else s=s+ m.getCoeficient() + "x^"+ m.getExponent();
                 }
                 else
                 {
                     if(m.getCoeficient()%1==0)
                     {
                         s=s+"+" + (int)m.getCoeficient() + "x^" + m.getExponent();
                     }
                     else s=s+ "+"+ m.getCoeficient() + "x^" + m.getExponent();
                 }
             }
         }
        // return s.toString();
        return s;

    }


    public static void restrangere(Polynomial pol)
    {
        for(int i=0;i < pol.getMonomialArratList().size();i++)
        {

            int putere=pol.getMonomialArratList().get(i).getExponent();
            for(int j=i+1; j<pol.getMonomialArratList().size();j++)
            {

                int putere1=pol.getMonomialArratList().get(j).getExponent();
                if(putere==putere1)
                {
                    pol.getMonomialArratList().get(i).setCoeficient(pol.getMonomialArratList().get(i).getCoeficient() + pol.getMonomialArratList().get(j).getCoeficient());
                    pol.stergeMonom(pol.getMonomialArratList().get(j));
                }

            }
        }
    }

    static Polynomial add(Polynomial P, Polynomial Q) {
            Polynomial res = new Polynomial(0);
            ArrayList<Monomial> lista_aux= new ArrayList() ;
             for (Monomial m : P.getMonomialArratList())
             {
                     int ok = 0;
                     for (Monomial m1 : Q.getMonomialArratList()) {
                            if (m.getExponent() == m1.getExponent()) {
                                   Monomial mon = new Monomial(0,0);
                                   mon.setExponent(m1.getExponent());
                                   mon.setCoeficient(m1.getCoeficient() + m.getCoeficient());
                                   res.adaugaMonom(mon);
                                   ok = 1;
                                   lista_aux.add(m1);
                                   break;
                            }
                     }
                    if(ok==0) res.adaugaMonom(m);
              }
             for(Monomial m2: Q.getMonomialArratList())
             {
                 int ok1=0;
                 for(Monomial m3: lista_aux)
                 {
                     if( m2.getExponent() ==m3.getExponent())
                     {
                         ok1=1;
                     }
                 }
                 if(ok1==0)
                 {
                     res.adaugaMonom(m2);
                 }
             }
               res.sort();
               return res;
       }

       static Polynomial SUB(Polynomial P, Polynomial Q)
       {

              Q.schimbareSemn(Q.getMonomialArratList());
              Polynomial res1= new Polynomial(0);
              Polynomial resfin=new Polynomial(0);
              res1= add(P,Q);

              for( Monomial m: res1.getMonomialArratList())
              {
                  if(m.getCoeficient()!=0) resfin.adaugaMonom(m);
              }
              resfin.sort();
              return resfin;

       }

       static Polynomial multiply(Polynomial P, Polynomial Q)
       {
              Polynomial res2 = new Polynomial(0);

              for (Monomial m : P.getMonomialArratList())
              {
                     for(Monomial m1: Q.getMonomialArratList())
                     {

                                   Monomial mon = new Monomial(0, 0);
                                   mon.setExponent(m1.getExponent()+m.getExponent());
                                   mon.setCoeficient(m1.getCoeficient() * m.getCoeficient());
                                   res2.adaugaMonom(mon);

                     }
              }
           restrangere(res2);
              return res2;
       }

       static Polynomial multiply1(Polynomial P, Monomial M) {
              Polynomial res3 = new Polynomial(0);
              for (Monomial m : P.getMonomialArratList()) {

                            Monomial mon = new Monomial(0, 0);
                            mon.setExponent(m.getExponent() + M.getExponent());
                            mon.setCoeficient(m.getCoeficient() * M.getCoeficient());
                            res3.adaugaMonom(mon);

              }
              return res3;
       }

       static ArrayList<Polynomial> division(Polynomial d, Polynomial i)
       {
              ArrayList<Polynomial> res= new ArrayList<Polynomial>();
              Polynomial c= new Polynomial(0);
              while(d.getGrad() >=i.getGrad())
              {
                    Monomial md=d.getMonomialArratList().get(0);
                    Monomial mi=i.getMonomialArratList().get(0);
                    Monomial mc=md.devide(mi);

                    c.monomialArratList.add(mc);

                    restrangere(c);

                    c.sort();

                    Polynomial aux= multiply1(i,mc);
                    d=SUB(d,aux);

              }

                res.add(c);

              res.add(d);
            return res;
       }

       static Polynomial derivative(Polynomial Q)
       {
           Polynomial res4=new Polynomial(0);
           for (Monomial m : Q.getMonomialArratList()) {

               Monomial mon=new Monomial(0,0);
               mon.setCoeficient(m.getCoeficient()*m.getExponent());
               mon.setExponent(m.getExponent()-1);
               res4.adaugaMonom(mon);
           }
           return res4;
       }

       static Polynomial integration(Polynomial Q)
       {
           Polynomial res5=new Polynomial(0);
           for (Monomial m : Q.getMonomialArratList()) {

               Monomial mon=new Monomial(0,0);
               mon.setCoeficient(m.getCoeficient()/(m.getExponent()+1));
               mon.setExponent(m.getExponent()+1);
               res5.adaugaMonom(mon);
           }
           return res5;

       }

}
