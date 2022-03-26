import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {

        ArrayList listaa=new ArrayList<>();
        ArrayList lista1=new ArrayList<>();
        Polynomial pol=new Polynomial("");
        listaa=pol.createList();
        //System.out.println(listaa);
        pol.setMonomialArratList(listaa);
        System.out.println(pol.getMonomialArratList());

        Polynomial pol1=new Polynomial("");
        lista1=pol1.createList();
        pol1.setMonomialArratList(lista1);
        System.out.println(pol1.getMonomialArratList());

        Operatii op= new Operatii();
        //Monomial mon= new Monomial(2,3);
        Polynomial res=op.integration(pol);
        System.out.println(res.getMonomialArratList());
    }
}
