import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.ArrayList;

public class CalcController {
    //... The Controller needs to interact with both the Model and View.
    private Operatii m_model;
    private CalcView m_view;

    //========================================================== constructor

    /**
     * Constructor
     */
    CalcController(Operatii model, CalcView view) {
        m_model = model;
        m_view = view;

        //... Add listeners to the view.
        view.addListener(new AddListener());
        view.subListener(new SubListener());
        view.multiplyListener(new MultiplyListener());
        view.devideListener(new DevideListener());
        view.derListener(new DerivationListener());
        view.intListener(new IntegrationListener());
        view.resetListener(new ResetListener());
    }


    ////////////////////////////////////////// inner class MultiplyListener

    /**
     * When a mulitplication is requested.
     * 1. Get the user input number from the View.
     * 2. Call the model to mulitply by this number.
     * 3. Get the result from the Model.
     * 4. Tell the View to display the result.
     * If there was an error, tell the View to display it.
     */
    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            String userInput1 = "";
            try {
                userInput = m_view.getUserInput();
                userInput1 = m_view.getUserInput1();
                Polynomial pol1 = new Polynomial(userInput);
                Polynomial pol2 = new Polynomial(userInput1);
                ArrayList lista1 = new ArrayList<>();
                ArrayList lista2 = new ArrayList<>();
                lista1 = pol1.createList();
                lista2 = pol2.createList();
                pol1.setMonomialArratList(lista1);
                pol2.setMonomialArratList(lista2);
                Operatii op = new Operatii();
                Polynomial res1 = new Polynomial(0);
                res1 = op.add(pol1, pol2);
                m_view.setTotal(op.getValue(res1),"");


            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }
    }//end inner class MultiplyListener


    //////////////////////////////////////////// inner class ClearListener

    /**
     * 1. Reset model.
     * 2. Reset View.
     */
    class SubListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            String userInput1 = "";
            try {
                userInput = m_view.getUserInput();
                userInput1 = m_view.getUserInput1();
                Polynomial pol1 = new Polynomial(userInput);
                Polynomial pol2 = new Polynomial(userInput1);
                ArrayList lista1 = new ArrayList<>();
                ArrayList lista2 = new ArrayList<>();
                lista1 = pol1.createList();
                lista2 = pol2.createList();
                pol1.setMonomialArratList(lista1);
                pol2.setMonomialArratList(lista2);
                Operatii op = new Operatii();
                Polynomial res1 = new Polynomial(0);
                res1 = op.SUB(pol1, pol2);
                m_view.setTotal(op.getValue(res1),"");

            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }
    }

    class MultiplyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            String userInput1 = "";
            try {
                userInput = m_view.getUserInput();
                userInput1 = m_view.getUserInput1();
                Polynomial pol1 = new Polynomial(userInput);
                Polynomial pol2 = new Polynomial(userInput1);
                ArrayList lista1 = new ArrayList<>();
                ArrayList lista2 = new ArrayList<>();
                lista1 = pol1.createList();
                lista2 = pol2.createList();
                pol1.setMonomialArratList(lista1);
                pol2.setMonomialArratList(lista2);
                Operatii op = new Operatii();
                Polynomial res1 = new Polynomial(0);
                res1 = op.multiply(pol1, pol2);
                m_view.setTotal(op.getValue(res1),"");

            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }
    }
    class DevideListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            String userInput1 = "";
            try {
                userInput = m_view.getUserInput();
                userInput1 = m_view.getUserInput1();
                Polynomial pol1 = new Polynomial(userInput);
                Polynomial pol2 = new Polynomial(userInput1);
                ArrayList lista1 = new ArrayList<>();
                ArrayList lista2 = new ArrayList<>();
                lista1 = pol1.createList();
                lista2 = pol2.createList();
                pol1.setMonomialArratList(lista1);
                pol2.setMonomialArratList(lista2);
                Operatii op = new Operatii();
                ArrayList<Polynomial> res1 = new ArrayList();
                res1 = op.division(pol1, pol2);
                m_view.setTotal(op.getValue(res1.get(0)),op.getValue(res1.get(1)));



            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }
    }

    class DerivationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            String userInput1 = "";
            try {
                userInput = m_view.getUserInput();
                userInput1 = m_view.getUserInput1();
                Polynomial pol1 = new Polynomial(userInput);
                Polynomial pol2 = new Polynomial(userInput1);
                ArrayList lista1 = new ArrayList<>();
                ArrayList lista2 = new ArrayList<>();
                lista1 = pol1.createList();
                lista2 = pol2.createList();
                pol1.setMonomialArratList(lista1);
                pol2.setMonomialArratList(lista2);
                Operatii op = new Operatii();
                Polynomial res1 = new Polynomial(0);
                res1 = op.derivative(pol1);
                m_view.setTotal(op.getValue(res1),"");

            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }
    }
    class IntegrationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            String userInput1 = "";
            try {
                userInput = m_view.getUserInput();
                userInput1 = m_view.getUserInput1();
                Polynomial pol1 = new Polynomial(userInput);
                Polynomial pol2 = new Polynomial(userInput1);
                ArrayList lista1 = new ArrayList<>();
                ArrayList lista2 = new ArrayList<>();
                lista1 = pol1.createList();
                lista2 = pol2.createList();
                pol1.setMonomialArratList(lista1);
                pol2.setMonomialArratList(lista2);
                Operatii op = new Operatii();
                Polynomial res1 = new Polynomial(0);
                res1 = op.integration(pol1);
                m_view.setTotal(op.getValue(res1),"");

            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }
    }
      class ResetListener implements ActionListener
      {
          public void actionPerformed(ActionEvent e) {
              String userInput = "";
              String userInput1 = "";
              try {

                  m_view.setTotal("","");

              } catch (NumberFormatException nfex) {
                  m_view.showError("Bad input: '" + userInput + "'");
              }
          }
          }
      }



           // m_model.reset();
           // m_view.reset();

    // end inner class ClearListener

