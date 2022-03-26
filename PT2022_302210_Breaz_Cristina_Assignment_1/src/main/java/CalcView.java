import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalcView extends JFrame {
    //... Components
    private JTextField m_userInputTf = new JTextField(20);
    private JTextField m1_userInputTf = new JTextField(20);

    private JButton m_addBtn = new JButton("Add");
    private JButton m_subBtn = new JButton(("Substract"));
    private JButton m_multiplyBtn = new JButton("Multiply");
    private JButton m_devBtn = new JButton("Divide");
    private JButton m_derBtn = new JButton("Derivate");
    private JButton m_intBtn = new JButton("Integration");
    private JButton m_resetBtn = new JButton("Reset");
    public JPanel content = new JPanel();
    private JLabel rez = new JLabel("                           ");
    // private JButton    m_clearBtn    = new JButton("Clear");
    private JLabel rez1 = new JLabel("                  ");
    private Operatii m_model;

    //======================================================= constructor

    /**
     * Constructor
     */
    CalcView(Operatii model) {
        //... Set up the logic
        m_model = model;
        m_model.setValue(CalcModel.INITIAL_VALUE);

        //... Initialize components
        // m_totalTf.setText(m_model.getValue());
        // m_totalTf.setEditable(false);

        //... Layout the components.

        content.setLayout(new FlowLayout());
        //content.add(new JLabel("Poynomial Calculator"));
        content.add(Box.createRigidArea(new Dimension(0, 40)));

        content.add(new JLabel("First Polynomial =    "));

        content.add(m_userInputTf);
        content.add(new JLabel("Second Polynomial ="));
        content.add(m1_userInputTf);

        // content.setLayout(new GridLayout(2,3));
        content.add(Box.createRigidArea(new Dimension(0, 40)));
        content.add(m_addBtn);
        content.add(Box.createRigidArea(new Dimension(0, 40)));
        content.add(m_subBtn);
        content.add(Box.createRigidArea(new Dimension(0, 40)));
        content.add(m_multiplyBtn);
        content.add(Box.createRigidArea(new Dimension(0, 40)));
        content.add(m_devBtn);
        content.add(Box.createRigidArea(new Dimension(0, 40)));
        content.add(m_derBtn);
        content.add(Box.createRigidArea(new Dimension(0, 40)));
        content.add(m_intBtn);
        content.add(Box.createRigidArea(new Dimension(0, 40)));
        content.add(m_resetBtn);

        // content.add( Box.createRigidArea(new Dimension(130,40)) );
        // content.add( Box.createRigidArea(new Dimension(100,40)) );
        content.add(new JLabel("Rezultatul calculului este:"));
       // content.add(new JLabel("Rimpartirii este:"));
        content.add(rez);
        content.add(new JLabel("                                         "));

        content.add(new JLabel("Restul impartirii este:"));
        content.add(rez1);
        // content.add(m_totalTf);
        // content.add(m_clearBtn);

        //... finalize layout
        this.setContentPane(content);
        this.pack();

        this.setTitle("Simple Calc - MVC");
        this.setSize(400, 500);
        // The window closing event should probably be passed to the
        // Controller in a real program, but this is a short example.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //void reset() {
    //  m_totalTf.setText(CalcModel.INITIAL_VALUE);
    // }

    String getUserInput() {
        return m_userInputTf.getText();
    }

    String getUserInput1() {
        return m1_userInputTf.getText();
    }

    void setTotal(String newTotal, String newTotal1) {


        rez.setText(newTotal);
        rez1.setText(newTotal1);
        //System.out.println(newTotal);
        //m_totalTf.setText(newTotal);
    }

    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    void addListener(ActionListener mal) {
        m_addBtn.addActionListener(mal);
    }

    void subListener(ActionListener cal) {
        m_subBtn.addActionListener(cal);

    }
    void multiplyListener(ActionListener m)
    {
        m_multiplyBtn.addActionListener(m);
    }

    void devideListener(ActionListener d)
    {
        m_devBtn.addActionListener(d);
    }
    void derListener(ActionListener d1)
    {
        m_derBtn.addActionListener(d1);
    }
    void intListener(ActionListener i)
    {
        m_intBtn.addActionListener(i);
    }
    void resetListener(ActionListener r) {m_resetBtn.addActionListener(r);}

}
