/**
 * @name : InterfaceView
 *
 * @author: lenovo
 * @date : 17.11.2014
 *
 * @brief :
 *
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.prefs.Preferences;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.IntervalCategoryDataset;

public abstract class InterfaceView
        extends JFrame
{
    protected Preferences pref;
    protected ChartPanel pnlChartPanel;

    private JFrame frmInputData;
    private JFrame frmProperties;
    private JMenuBar mbMainMenuBar;
    private JToolBar tbMainToolBar;
    private JFileChooser fileChooser;
    private JPanel pnlInpFrmUpper;
    private JPanel pnlInpFrmDown;
    private JPanel pnlPropertiesSouth;
    private JPanel pnlPropertiesWest;
    private JPanel pnlPropertiesCenter;
    private JSplitPane splPnlMainFrmCenter;
    private JScrollPane scrPnlMainFrmLeft;
    private JScrollPane scrPnlMainFrmRight;
    private JButton btnAbbrechen;
    private JButton btnSave;
    private JButton btnSaveAs;
    private JButton btnInsert;
    private JButton btnNew;
    private JButton btnOpen;
    private JButton btnZoomNormal;
    private JButton btnZoomOut;
    private JButton btnZoomIn;
    private JButton btnInsertTask;
    private JButton btnDeleteTask;
    private JButton btnPropAbbrechen;
    private JButton btnPropBestaetigen;
    private JTextField tfTaskName;
    private JTextField tfPropProjektName;
    private JFormattedTextField ftfTaskDauer;
    private JFormattedTextField ftfTaskEnde;
    private JFormattedTextField ftfTaskStart;
    private JLabel lblFile;
    private JLabel lblBezeichnung;
    private JLabel lblStartZeit;
    private JLabel lblEndeZeit;
    private JLabel lblDauer;
    private JLabel lblProjektName;
    private JMenu mnuAnsicht;
    private JMenu mnuBearbeiten;
    private JMenu mnuDatei;
    private JMenu mnuHilfe;
    private JMenuItem mnuZoomNormal;
    private JMenuItem mnuZoomOut;
    private JMenuItem mnuZoomIn;
    private JMenuItem mnuInfo;
    private JMenuItem mnuNew;
    private JMenuItem mnuOpen;
    private JMenuItem mnuSave;
    private JMenuItem mnuSaveAs;
    private JMenuItem mnuExit;
    private JMenuItem mnuInsertTask;
    private JMenuItem mnuDeleteTask;
    private JMenuItem mnuProperties;
    private Box.Filler flTextFieldProjName;
    private Box.Filler flLblProjName;
    private JTable tblData;

    public InterfaceView()
    {
        initComponents();
    }

    private void initComponents()
    {
        frmInputData = new JFrame();
        frmProperties = new JFrame();
        mbMainMenuBar = new JMenuBar();
        tbMainToolBar = new JToolBar();
        fileChooser = new JFileChooser();
        pnlInpFrmUpper = new JPanel();
        pnlInpFrmDown = new JPanel();
        pnlPropertiesSouth = new JPanel();
        pnlPropertiesWest = new JPanel();
        pnlPropertiesCenter = new JPanel();
        tfTaskName = new JTextField();
        tfPropProjektName = new JTextField();
        ftfTaskStart = new JFormattedTextField();
        ftfTaskEnde = new JFormattedTextField();
        ftfTaskDauer = new JFormattedTextField();
        lblBezeichnung = new JLabel();
        lblStartZeit = new JLabel();
        lblEndeZeit = new JLabel();
        lblDauer = new JLabel();
        lblFile = new JLabel();
        lblProjektName = new JLabel();
        btnAbbrechen = new JButton();
        btnInsert = new JButton();
        btnNew = new JButton();
        btnSave = new JButton();
        btnSaveAs = new JButton();
        btnOpen = new JButton();
        btnZoomIn = new JButton();
        btnZoomOut = new JButton();
        btnZoomNormal = new JButton();
        btnInsertTask = new JButton();
        btnDeleteTask = new JButton();
        btnPropAbbrechen = new JButton();
        btnPropBestaetigen = new JButton();
        splPnlMainFrmCenter = new JSplitPane();
        scrPnlMainFrmLeft = new JScrollPane();
        scrPnlMainFrmRight = new JScrollPane();
        mnuDatei = new JMenu();
        mnuHilfe = new JMenu();
        mnuBearbeiten = new JMenu();
        mnuAnsicht = new JMenu();
        mnuNew = new JMenuItem();
        mnuOpen = new JMenuItem();
        mnuSave = new JMenuItem();
        mnuSaveAs = new JMenuItem();
        mnuExit = new JMenuItem();
        mnuZoomNormal = new JMenuItem();
        mnuZoomIn = new JMenuItem();
        mnuZoomOut = new JMenuItem();
        mnuInfo = new JMenuItem();
        mnuInsertTask = new JMenuItem();
        mnuDeleteTask = new JMenuItem();
        mnuProperties = new JMenuItem();
        flTextFieldProjName = new Box.Filler(new Dimension(0, 10), new Dimension(0, 10), new Dimension(32767, 10));
        flLblProjName = new Box.Filler(new Dimension(0, 10), new Dimension(0, 10), new Dimension(32767, 10));
        tblData = new JTable();

        // ***** main window
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(950, 600));
        setLocationRelativeTo(null);

        getContentPane().add(tbMainToolBar, BorderLayout.PAGE_START);
        getContentPane().add(splPnlMainFrmCenter, BorderLayout.CENTER);
        getContentPane().add(lblFile, BorderLayout.SOUTH);

        // menu bar
        setJMenuBar(mbMainMenuBar);
        mbMainMenuBar.add(mnuDatei);
        mbMainMenuBar.add(mnuBearbeiten);
        mbMainMenuBar.add(mnuAnsicht);
        mbMainMenuBar.add(mnuHilfe);

        // menu datei
        mnuDatei.setMnemonic('D');
        mnuDatei.setText("Datei");

        mnuDatei.add(mnuNew);
        mnuDatei.add(mnuOpen);
        mnuDatei.addSeparator();
        mnuDatei.add(mnuSave);
        mnuDatei.add(mnuSaveAs);
        mnuDatei.addSeparator();
        mnuDatei.add(mnuExit);

        mnuNew.setText("Neu");
        mnuOpen.setText("Öffnen");
        mnuSave.setText("Speichern");
        mnuSaveAs.setText("Speichern unter");
        mnuExit.setText("Schließen");

        mnuNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        mnuOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        mnuSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        mnuSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.SHIFT_MASK | InputEvent.CTRL_MASK));
        mnuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));

        mnuNew.setIcon(new ImageIcon(getClass().getResource("/view/icons/general/New24.gif")));
        mnuOpen.setIcon(new ImageIcon(getClass().getResource("/view/icons/general/Open24.gif")));
        mnuSave.setIcon(new ImageIcon(getClass().getResource("/view/icons/general/Save24.gif")));
        mnuSaveAs.setIcon(new ImageIcon(getClass().getResource("/view/icons/general/SaveAs24.gif")));
        mnuExit.setIcon(new ImageIcon(getClass().getResource("/view/icons/general/close.gif")));

        mnuSave.setEnabled(false);
        mnuSaveAs.setEnabled(false);

        // menu bearbeiten
        mnuBearbeiten.setMnemonic('B');
        mnuBearbeiten.setText("Bearbeiten");

        mnuBearbeiten.add(mnuInsertTask);
        mnuBearbeiten.add(mnuDeleteTask);
        mnuBearbeiten.addSeparator();
        mnuBearbeiten.add(mnuProperties);

        mnuInsertTask.setText("hinzufügen");
        mnuDeleteTask.setText("entfernen");
        mnuProperties.setText("Eigenschaften");

        mnuInsertTask.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, InputEvent.CTRL_MASK));
        mnuDeleteTask.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, InputEvent.CTRL_MASK));

        mnuInsertTask.setIcon(new ImageIcon(getClass().getResource("/view/icons/plus1.gif")));
        mnuDeleteTask.setIcon(new ImageIcon(getClass().getResource("/view/icons/minus1.gif")));

        mnuInsertTask.setEnabled(false);
        mnuDeleteTask.setEnabled(false);
        mnuProperties.setEnabled(false);

        // menu ansicht
        mnuAnsicht.setMnemonic('A');
        mnuAnsicht.setText("Ansicht");
        mnuAnsicht.add(mnuZoomNormal);
        mnuAnsicht.add(mnuZoomIn);
        mnuAnsicht.add(mnuZoomOut);

        mnuZoomNormal.setText("Zoom Normal");
        mnuZoomIn.setText("Zoom In");
        mnuZoomOut.setText("Zoom Out");

        mnuZoomNormal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
        mnuZoomIn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, InputEvent.CTRL_MASK));
        mnuZoomOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, InputEvent.CTRL_MASK));

        mnuZoomNormal.setIcon(new ImageIcon(getClass().getResource("/view/icons/general/Zoom24.gif")));
        mnuZoomIn.setIcon(new ImageIcon(getClass().getResource("/view/icons/general/ZoomIn24.gif")));
        mnuZoomOut.setIcon(new ImageIcon(getClass().getResource("/view/icons/general/ZoomOut24.gif")));

        // menu hilfe
        mnuHilfe.setMnemonic('H');
        mnuHilfe.setText("Hilfe");
        mnuHilfe.add(mnuInfo);

        mnuInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
        mnuInfo.setIcon(new ImageIcon(getClass().getResource("/view/icons/general/About24.gif")));
        mnuInfo.setMnemonic('I');
        mnuInfo.setText("Info");

        // label file path
        lblFile.setText("File");

        // toolbar
        tbMainToolBar.setRollover(false);

        tbMainToolBar.add(btnNew);
        tbMainToolBar.add(btnOpen);
        tbMainToolBar.add(btnSave);
        tbMainToolBar.add(btnSaveAs);
        tbMainToolBar.addSeparator();
        tbMainToolBar.add(btnInsertTask);
        tbMainToolBar.add(btnDeleteTask);
        tbMainToolBar.addSeparator();
        tbMainToolBar.add(btnZoomNormal);
        tbMainToolBar.add(btnZoomIn);
        tbMainToolBar.add(btnZoomOut);

        btnNew.setIcon(new ImageIcon(getClass().getResource("/view/icons/general/New24.gif")));
        btnOpen.setIcon(new ImageIcon(getClass().getResource("/view/icons/general/Open24.gif")));
        btnSave.setIcon(new ImageIcon(getClass().getResource("/view/icons/general/Save24.gif")));
        btnSaveAs.setIcon(new ImageIcon(getClass().getResource("/view/icons/general/SaveAs24.gif")));
        btnZoomNormal.setIcon(new ImageIcon(getClass().getResource("/view/icons/general/Zoom24.gif")));
        btnZoomIn.setIcon(new ImageIcon(getClass().getResource("/view/icons/general/ZoomIn24.gif")));
        btnZoomOut.setIcon(new ImageIcon(getClass().getResource("/view/icons/general/ZoomOut24.gif")));
        btnInsertTask.setIcon(new ImageIcon(getClass().getResource("/view/icons/plus.gif")));
        btnDeleteTask.setIcon(new ImageIcon(getClass().getResource("/view/icons/minus.gif")));

        btnNew.setFocusable(false);
        btnOpen.setFocusable(false);
        btnSave.setFocusable(false);
        btnSaveAs.setFocusable(false);
        btnZoomNormal.setFocusable(false);
        btnZoomIn.setFocusable(false);
        btnZoomOut.setFocusable(false);
        btnInsertTask.setFocusable(false);
        btnDeleteTask.setFocusable(false);

        btnSave.setEnabled(false);
        btnSaveAs.setEnabled(false);
        btnInsertTask.setEnabled(false);
        btnDeleteTask.setEnabled(false);

        // split panel
        splPnlMainFrmCenter.setDividerLocation(500);
        splPnlMainFrmCenter.setOneTouchExpandable(true);
        splPnlMainFrmCenter.setLeftComponent(scrPnlMainFrmLeft);
        splPnlMainFrmCenter.setRightComponent(scrPnlMainFrmRight);

        //tblData.setModel(new DefaultTableModel(null, columnNames));
        //tblData.setFillsViewportHeight(true);

        scrPnlMainFrmLeft.setViewportView(tblData);

        // ***** input data window
        frmInputData.setTitle(" ");
        frmInputData.getContentPane().setLayout(new BoxLayout(frmInputData.getContentPane(), BoxLayout.Y_AXIS));
        frmInputData.setSize(400, 180);
        frmInputData.setDefaultCloseOperation(HIDE_ON_CLOSE);
        frmInputData.setLocationRelativeTo(this);

        frmInputData.getContentPane().add(pnlInpFrmUpper);
        frmInputData.getContentPane().add(pnlInpFrmDown);

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
        ftfTaskStart.setText("01.01.2014");
        ftfTaskStart.setToolTipText("Startdatum eingeben");
        ftfTaskStart.setSelectionStart(0);

        ftfTaskEnde.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter()));
        ftfTaskEnde.setText("31.12.2014");
        ftfTaskEnde.setSelectionStart(0);

        ftfTaskDauer.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0 h"))));
        ftfTaskDauer.setText("0 h");
        ftfTaskDauer.setSelectionStart(0);

        btnAbbrechen.setFont(new Font("Ubuntu", 0, 18));
        btnAbbrechen.setText("Abbrechen");

        btnInsert.setFont(new Font("Ubuntu", 0, 18));
        btnInsert.setText("Einfügen");

        // ***** properties window
        frmProperties.setTitle("Eigenschaften");
        frmProperties.getContentPane().setLayout(new BorderLayout());
        frmProperties.setSize(330, 160);
        frmProperties.setDefaultCloseOperation(HIDE_ON_CLOSE);
        frmProperties.setLocationRelativeTo(this);

        frmProperties.getContentPane().add(pnlPropertiesWest, BorderLayout.WEST);
        frmProperties.getContentPane().add(pnlPropertiesSouth, BorderLayout.SOUTH);
        frmProperties.getContentPane().add(pnlPropertiesCenter, BorderLayout.CENTER);

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

    public ChartPanel getChartPanel()
    {
        return pnlChartPanel;
    }

    public JButton getBtnZoomIn()
    {
        return btnZoomIn;
    }

    public JButton getBtnZoomOut()
    {
        return btnZoomOut;
    }

    public JButton getBtnZoomNormal()
    {
        return btnZoomNormal;
    }

    public JMenuItem getMnuZoomNormal()
    {
        return mnuZoomNormal;
    }

    public JMenuItem getMnuZoomOut()
    {
        return mnuZoomOut;
    }

    public JMenuItem getMnuZoomIn()
    {
        return mnuZoomIn;
    }

    public JFileChooser getFileChooser()
    {
        return fileChooser;
    }

    public JButton getBtnAbbrechen()
    {
        return btnAbbrechen;
    }

    public JButton getBtnSave()
    {
        return btnSave;
    }

    public JButton getBtnSaveAs()
    {
        return btnSaveAs;
    }

    public JButton getBtnInsert()
    {
        return btnInsert;
    }

    public JButton getBtnNew()
    {
        return btnNew;
    }

    public JButton getBtnOpen()
    {
        return btnOpen;
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

    public JLabel getLblFile()
    {
        return lblFile;
    }

    public JMenuItem getMnuInfo()
    {
        return mnuInfo;
    }

    public JMenuItem getMnuNew()
    {
        return mnuNew;
    }

    public JMenuItem getMnuOpen()
    {
        return mnuOpen;
    }

    public JMenuItem getMnuSave()
    {
        return mnuSave;
    }

    public JMenuItem getMnuSaveAs()
    {
        return mnuSaveAs;
    }

    public JMenuItem getMnuExit()
    {
        return mnuExit;
    }

    public JTable getTblData()
    {
        return tblData;
    }

    public JButton getBtnInsertTask()
    {
        return btnInsertTask;
    }

    public JButton getBtnDeleteTask()
    {
        return btnDeleteTask;
    }

    public void setLastDirectory(String path)
    {
        pref.put("LAST_DIRECTORY", path);
    }

    public JMenuItem getMnuInsertTask()
    {
        return mnuInsertTask;
    }

    public JMenuItem getMnuDeleteTask()
    {
        return mnuDeleteTask;
    }

    public JFrame getFrmInputData()
    {
        return frmInputData;
    }

    public JMenuItem getMnuProperties()
    {
        return mnuProperties;
    }

    public JFrame getFrmProperties()
    {
        return frmProperties;
    }

    public JButton getBtnPropAbbrechen()
    {
        return btnPropAbbrechen;
    }

    public JButton getBtnPropBestaetigen()
    {
        return btnPropBestaetigen;
    }

    public JTextField getTfPropProjektName()
    {
        return tfPropProjektName;
    }
    
    public JScrollPane getScrPnlMainFrmRight()
    {
        return scrPnlMainFrmRight;
    }

    public abstract void updateChart(IntervalCategoryDataset dataset, String title);
    
    public abstract String getVersion();
}
