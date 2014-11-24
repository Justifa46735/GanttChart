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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

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
    private UtilDateModel modelStartDate;
    private UtilDateModel modelEndDate;
    private JDatePanelImpl pnlDatePanelStartDate;
    private JDatePanelImpl pnlDatePanelEndDate;
    private JDatePickerImpl datePickerStartDate;
    private JDatePickerImpl datePickerEndDate;

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
        ftfTaskDauer = new JFormattedTextField();

        modelStartDate = new UtilDateModel();
        modelEndDate = new UtilDateModel();
        pnlDatePanelStartDate = new JDatePanelImpl(modelStartDate, new Properties());
        pnlDatePanelEndDate = new JDatePanelImpl(modelEndDate, new Properties());
        datePickerStartDate = new JDatePickerImpl(pnlDatePanelStartDate, new MyFormattedTextField());
        datePickerEndDate = new JDatePickerImpl(pnlDatePanelEndDate, new MyFormattedTextField());

        this.getContentPane().add(pnlInpFrmUpper);
        this.getContentPane().add(pnlInpFrmDown);

        datePickerStartDate.setBounds(220, 350, 120, 30);
        datePickerEndDate.setBounds(220, 350, 120, 30);

        pnlInpFrmUpper.setLayout(new GridLayout(0, 2));
        pnlInpFrmUpper.add(lblBezeichnung);
        pnlInpFrmUpper.add(tfTaskName);
        pnlInpFrmUpper.add(lblStartZeit);
        pnlInpFrmUpper.add(datePickerStartDate);
        pnlInpFrmUpper.add(lblEndeZeit);
        pnlInpFrmUpper.add(datePickerEndDate);
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

    public JFormattedTextField getFtfEndDate()
    {
        return datePickerEndDate.getJFormattedTextField();
    }

    public JFormattedTextField getFtfStartDate()
    {
        return datePickerStartDate.getJFormattedTextField();
    }

    public JTextField getTfTaskName()
    {
        return tfTaskName;
    }
}

class MyFormattedTextField
        extends JFormattedTextField.AbstractFormatter
{
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public Object stringToValue(String text) throws ParseException
    {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(dateFormat.parse(text));
        
        return cal;
    }

    @Override
    public String valueToString(Object value) throws ParseException
    {
        if (value != null)
        {
            GregorianCalendar cal = (GregorianCalendar) value;
            Date date = cal.getTime();
            return dateFormat.format(date);
        }
        else
        {
            return null;
        }
    }
}
