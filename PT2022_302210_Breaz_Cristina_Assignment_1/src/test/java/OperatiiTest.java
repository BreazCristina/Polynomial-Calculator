import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class OperatiiTest {


    @Test
    void ADD() {
        Polynomial pol1 = new Polynomial("x^3+3x^2+4x^1+2");
        Polynomial pol2 = new Polynomial("x^2+2x^1");
       // Polynomial pol3= new Polynomial("x^2+1");
        ArrayList lista1 = new ArrayList<>();
        ArrayList lista2 = new ArrayList<>();
        ArrayList lista3= new ArrayList();
        lista1 = pol1.createList();
        lista2 = pol2.createList();
        //lista3= pol3.createList();
        pol1.setMonomialArratList(lista1);
        pol2.setMonomialArratList(lista2);
       // pol3.setMonomialArratList(lista3);
        Polynomial result = Operatii.add(pol1, pol2);
        assertEquals("+1x^3+4x^2+6x^1+2", Operatii.getValue(result));
        System.out.println("Testul la adunare s-a efectuat cu succes");
    }

    @Test
    void SUB() {
        Polynomial pol1 = new Polynomial("x^3+3x^2+4x^1+2");
        Polynomial pol2 = new Polynomial("x^2+2x^1");
        // Polynomial pol3= new Polynomial("x^2+1");
        ArrayList lista1 = new ArrayList<>();
        ArrayList lista2 = new ArrayList<>();
        ArrayList lista3= new ArrayList();
        lista1 = pol1.createList();
        lista2 = pol2.createList();
        //lista3= pol3.createList();
        pol1.setMonomialArratList(lista1);
        pol2.setMonomialArratList(lista2);
        // pol3.setMonomialArratList(lista3);
        Polynomial result = Operatii.SUB(pol1, pol2);
        assertEquals("+1x^3+2x^2+2x^1+2", Operatii.getValue(result));
        System.out.println("Testul la scadere s-a efectuat cu succes");
    }

    @Test
    void multiply() {
        Polynomial pol1 = new Polynomial("x^3+3x^2+4x^1+2");
        Polynomial pol2 = new Polynomial("x^2+2x^1");
        // Polynomial pol3= new Polynomial("x^2+1");
        ArrayList lista1 = new ArrayList<>();
        ArrayList lista2 = new ArrayList<>();
        ArrayList lista3= new ArrayList();
        lista1 = pol1.createList();
        lista2 = pol2.createList();
        //lista3= pol3.createList();
        pol1.setMonomialArratList(lista1);
        pol2.setMonomialArratList(lista2);
        // pol3.setMonomialArratList(lista3);
        Polynomial result = Operatii.multiply(pol1, pol2);
        assertEquals("+1x^5+5x^4+10x^3+10x^2+4x^1", Operatii.getValue(result));
        System.out.println("Testul la inmultire s-a efectuat cu succes");
    }

    @Test
    void division() {
        Polynomial pol1 = new Polynomial("x^2");
        Polynomial pol2 = new Polynomial("x^2+2x^1");
        // Polynomial pol3= new Polynomial("x^2+1");
        ArrayList lista1 = new ArrayList<>();
        ArrayList lista2 = new ArrayList<>();
        ArrayList lista3= new ArrayList();
        lista1 = pol1.createList();
        lista2 = pol2.createList();
        //lista3= pol3.createList();
        pol1.setMonomialArratList(lista1);
        pol2.setMonomialArratList(lista2);
        // pol3.setMonomialArratList(lista3);
        ArrayList< Polynomial> result = Operatii.division(pol2, pol1);
        assertEquals("+1", Operatii.getValue(result.get(0)));
        assertEquals("+2x^1", Operatii.getValue(result.get(1)));
        System.out.println("Testul la impartire s-a efectuat cu succes");
    }

    @Test
    void derivative() {
        Polynomial pol1 = new Polynomial("x^2+2x^1");
        ArrayList lista1 = new ArrayList<>();
        lista1 = pol1.createList();
        pol1.setMonomialArratList(lista1);
        Polynomial res=Operatii.derivative(pol1);
        assertEquals("+2x^1+2", Operatii.getValue(res));
        System.out.println("Testul la derivare s-a efectuat cu succes");
    }

    @Test
    void integration() {
        Polynomial pol1 = new Polynomial("3x^2+2x^1");
        ArrayList lista1 = new ArrayList<>();
        lista1 = pol1.createList();
        pol1.setMonomialArratList(lista1);
        Polynomial res=Operatii.integration(pol1);
        assertEquals("+1x^3+1x^2", Operatii.getValue(res));
        System.out.println("Testul la integrare s-a efectuat cu succes");
    }


}