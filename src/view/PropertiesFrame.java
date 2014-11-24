/**
 * @name : PropertiesFrame
 *
 * @author: lenovo
 * @date : 24.11.2014
 *
 * @brief :
 *
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

public class PropertiesFrame
        extends JFrame
{
    private JPanel pnlPropertiesSouth;
    private JPanel pnlPropertiesWest;
    private JPanel pnlPropertiesCenter;
    private JLabel lblProjektName;
    private Box.Filler flTextFieldProjName;
    private Box.Filler flLblProjName;
    private JButton btnPropAbbrechen;
    private JButton btnPropBestaetigen;
    private JTextField tfPropProjektName;

    public PropertiesFrame()
    {
        this.setTitle("Eigenschaften");
        this.setSize(330, 160);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);

        initComponents();
    }

    private void initComponents()
    {
        pnlPropertiesSouth = new JPanel();
        pnlPropertiesWest = new JPanel();
        pnlPropertiesCenter = new JPanel();
        lblProjektName = new JLabel();
        btnPropAbbrechen = new JButton();
        btnPropBestaetigen = new JButton();
        flTextFieldProjName = new Box.Filler(new Dimension(0, 10), new Dimension(0, 10), new Dimension(32767, 10));
        flLblProjName = new Box.Filler(new Dimension(0, 10), new Dimension(0, 10), new Dimension(32767, 10));
        tfPropProjektName = new JTextField();

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(pnlPropertiesWest, BorderLayout.WEST);
        this.getContentPane().add(pnlPropertiesSouth, BorderLayout.SOUTH);
        this.getContentPane().add(pnlPropertiesCenter, BorderLayout.CENTER);

        pnlPropertiesWest.setLayout(new BoxLayout(pnlPropertiesWest, BoxLayout.LINE_AXIS));
        pnlPropertiesWest.add(flLblProjName);
        pnlPropertiesWest.add(lblProjektName);
        lblProjektName.setHorizontalAlignment(SwingConstants.CENTER);
        lblProjektName.setText("   Projektname    ");
        lblProjektName.setFont(new Font("Ubuntu", 0, 18));

        pnlPropertiesSouth.setLayout(new FlowLayout());
        pnlPropertiesSouth.add(btnPropAbbrechen);
        pnlPropertiesSouth.add(btnPropBestaetigen);
        btnPropAbbrechen.setText("Abbrechen");
        btnPropBestaetigen.setText("Bestätigen");
        btnPropAbbrechen.setFont(new Font("Ubuntu", 0, 16));
        btnPropBestaetigen.setFont(new Font("Ubuntu", 0, 16));

        pnlPropertiesCenter.setLayout(new BoxLayout(pnlPropertiesCenter, BoxLayout.LINE_AXIS));
        pnlPropertiesCenter.add(flTextFieldProjName);
        pnlPropertiesCenter.add(tfPropProjektName);
        tfPropProjektName.setHorizontalAlignment(JTextField.LEFT);
        tfPropProjektName.setMaximumSize(new Dimension(2147483647, 30));
        tfPropProjektName.setMinimumSize(new Dimension(200, 30));
        tfPropProjektName.setFont(new Font("Ubuntu", 0, 18));
    }
    
    public JButton getBtnPropBestaetigen()
    {
        return btnPropBestaetigen;
    }
    
    public JButton getBtnPropAbbrechen()
    {
        return btnPropAbbrechen;
    }
    
    public JTextField getTfPropProjektName()
    {
        return tfPropProjektName;
    }
}
