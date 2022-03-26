import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Polynomial {
     public ArrayList<Monomial> monomialArratList;
     private String poli;
     public ArrayList<Monomial> getMonomialArratList() {
        return monomialArratList;
    }

    public void setMonomialArratList(ArrayList<Monomial> monomialArratList) {
        this.monomialArratList = monomialArratList;
    }

    public Polynomial(int x)
    {
         monomialArratList=new ArrayList<>();
    }

    public Polynomial(String s)
    {
        poli=s;
    }

    public void stergeMonom(Monomial mon)
    {
        monomialArratList.remove(mon);
    }

    public int getGrad()
    {
        int max=-1;
        for( Monomial m:monomialArratList)
        {
            if(m.getExponent()>max)max=m.getExponent();
        }
        return max;
    }

    public void adaugaMonom(Monomial mon)
    {
        monomialArratList.add(mon);
    }


    public void schimbareSemn(ArrayList<Monomial> lista)
    {
        for(Monomial m: lista)
        {
             m.setCoeficient((-1)*m.getCoeficient());
        }
    }


    public void sort(){
        Collections.sort(monomialArratList , new Comparator<Monomial>() {
            @Override
            public int compare(Monomial m1, Monomial m2) {
                if( m1.getExponent() > m2.getExponent()) return  -1;
                else if(m1.getExponent() == m2.getExponent()) return 0;
                else return 1;
            }
        });
    }



    public ArrayList createList()
    {

        ArrayList<Monomial> lista= new ArrayList<>();
        String array[]=this.poli.replace(" ","").split("(?=\\+|\\-)");
        for (String s:array)
        {
            String[] splitAround=s.split("x",2);
            int exponent=0;
            if(splitAround.length>1)
            {
                String sExp =splitAround[1].replace("^","");
                exponent=sExp.isEmpty() ? 1 :Integer.parseInt(sExp);
            }
            String sCoeff=splitAround[0];
            double coefficient=sCoeff.isEmpty() ? 1.0 : ("-".equals(sCoeff) ? -1.0 : Double.parseDouble(sCoeff));
            Monomial mon= new Monomial(0,0);
            mon.setExponent(exponent);
            mon.setCoeficient(coefficient);
            lista.add(mon);

           // System.out.println(mon);
        }
        return lista;

    }

}
