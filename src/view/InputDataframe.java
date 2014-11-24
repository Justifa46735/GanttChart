/**
 * @name : InputDataframe
 *
 * @author: lenovo
 * @date : 24.11.2014
 *
 * @brief :
 *
 */
package view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

public class InputDataframe
        extends JFrame
{
    private JButton btnAbbrechen;
    private JButton btnInsert;
    private JPanel pnlInpFrmUpper;
    private JPanel pnlInpFrmDown;
    private JLabel lblBezeichnung;
    private JLabel lblStartZeit;
    private JLabel lblEndeZeit;
    private JLabel lblDauer;
    private JTextField tfTaskName;
    private JFormattedTextField ftfTaskDauer;
    private JFormattedTextField ftfTaskEnde;
    private JFormattedTextField ftfTaskStart;

    public InputDataframe()
    {
        this.setTitle(" ");
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setSize(400, 180);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setVisible(false);
        
        initComponents();
    }
    
    public void visible(boolean state)
    {
        setVisible(state);
    }

    private void initComponents()
    {
        pnlInpFrmUpper = new JPanel();
        pnlInpFrmDown = new JPanel();
        lblBezeichnung = new JLabel();
        lblStartZeit = new JLabel();
        lblEndeZeit = new JLabel();
        lblDauer = new JLabel();
        btnAbbrechen = new JButton();
        btnInsert = new JButton();
        tfTaskName = new JTextField();
        ftfTaskStart = new JFormattedTextField();
        ftfTaskEnde = new JFormattedTextField();
        ftfTaskDauer = new JFormattedTextField();

        this.getContentPane().add(pnlInpFrmUpper);
        this.getContentPane().add(pnlInpFrmDown);

        pnlInpFrmUpper.setLayout(new GridLayout(0, 2));
        pnlInpFrmUpper.add(lblBezeichnung);
        pnlInpFrmUpper.add(tfTaskName);
        pnlInpFrmUpper.add(lblStartZeit);
        pnlInpFrmUpper.add(ftfTaskStart);
        pnlInpFrmUpper.add(lblEndeZeit);
        pnlInpFrmUpper.add(ftfTaskEnde);
        pnlInpFrmUpper.add(lblDauer);
        pnlInpFrmUpper.add(ftfTaskDauer);

        pnlInpFrmDown.setLayout(new FlowLayout());
        pnlInpFrmDown.add(btnAbbrechen);
        pnlInpFrmDown.add(btnInsert);

        lblBezeichnung.setFont(new Font("Ubuntu", 0, 18));
        lblBezeichnung.setText(" Bezeichnung");
        lblStartZeit.setFont(new Font("Ubuntu", 0, 18));
        lblStartZeit.setText(" Start");
        lblEndeZeit.setFont(new Font("Ubuntu", 0, 18));
        lblEndeZeit.setText(" Ende");
        lblDauer.setFont(new Font("Ubuntu", 0, 18));
        lblDauer.setText(" Dauer");

        tfTaskName.setFont(new Font("Ubuntu", 0, 18));

        ftfTaskStart.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter()));
        ftfTaskStart.setText("");
        ftfTaskStart.setToolTipText("Startdatum eingeben");
        ftfTaskStart.setSelectionStart(0);

        ftfTaskEnde.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter()));
        ftfTaskEnde.setText("");
        ftfTaskEnde.setSelectionStart(0);

        ftfTaskDauer.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0 h"))));
        ftfTaskDauer.setText("0 h");
        ftfTaskDauer.setSelectionStart(0);

        btnAbbrechen.setFont(new Font("Ubuntu", 0, 18));
        btnAbbrechen.setText("Abbrechen");

        btnInsert.setFont(new Font("Ubuntu", 0, 18));
        btnInsert.setText("Einfügen");
    }

    public JButton getBtnInsert()
    {
        return btnInsert;
    }

    public JButton getBtnAbbrechen()
    {
        return btnAbbrechen;
    }

    public JFormattedTextField getFtfTaskDauer()
    {
        return ftfTaskDauer;
    }

    public JFormattedTextField getFtfTaskEnde()
    {
        return ftfTaskEnde;
    }

    public JFormattedTextField getFtfTaskStart()
    {
        return ftfTaskStart;
    }

    public JTextField getTfTaskName()
    {
        return tfTaskName;
    }
}
