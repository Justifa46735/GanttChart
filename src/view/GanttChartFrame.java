package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.prefs.Preferences;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import org.jfree.chart.ChartPanel;

public class GanttChartFrame
        extends JFrame
        implements InterfaceView
{
    protected Preferences pref;
    protected ChartPanel pnlChartPanel;

    private final String version = "1.0.0";
    private final String[] columnNames;

    private InputDataframe frmInputData;
    private PropertiesFrame frmProperties;
    private JMenuBar mbMainMenuBar;
    private JToolBar tbMainToolBar;
    private JFileChooser fileChooser;
    private JSplitPane splPnlMainFrmCenter;
    private JScrollPane scrPnlMainFrmLeft;
    private JScrollPane scrPnlMainFrmRight;
    private JButton btnSave;
    private JButton btnSaveAs;
    private JButton btnNew;
    private JButton btnOpen;
    private JButton btnZoomNormal;
    private JButton btnZoomOut;
    private JButton btnZoomIn;
    private JButton btnInsertTask;
    private JButton btnDeleteTask;
    private JLabel lblFile;
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
    private JTable tblData;

    public GanttChartFrame()
    {
        int h = this.getToolkit().getScreenSize().height;
        int w = this.getToolkit().getScreenSize().width;
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setSize(new Dimension(w - 100, h - 100));

        columnNames = new String[4];
        columnNames[0] = "Task Bezeichnung";
        columnNames[1] = "Start";
        columnNames[2] = "Ende";
        columnNames[3] = "Dauer";

        initComponents();

        pref = Preferences.userRoot();
        fileChooser.setCurrentDirectory(new File(pref.get("LAST_DIRECTORY", "")));
    }

    private void initComponents()
    {
        frmInputData = new InputDataframe();
        frmProperties = new PropertiesFrame();
        mbMainMenuBar = new JMenuBar();
        tbMainToolBar = new JToolBar();
        fileChooser = new JFileChooser();
        lblFile = new JLabel();
        btnNew = new JButton();
        btnSave = new JButton();
        btnSaveAs = new JButton();
        btnOpen = new JButton();
        btnZoomIn = new JButton();
        btnZoomOut = new JButton();
        btnZoomNormal = new JButton();
        btnInsertTask = new JButton();
        btnDeleteTask = new JButton();
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
        tblData = new JTable();
        pnlChartPanel = new ChartPanel(null);

        this.getContentPane().add(tbMainToolBar, BorderLayout.PAGE_START);
        this.getContentPane().add(splPnlMainFrmCenter, BorderLayout.CENTER);
        this.getContentPane().add(lblFile, BorderLayout.SOUTH);

        // menu bar
        this.setJMenuBar(mbMainMenuBar);
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
        scrPnlMainFrmRight.setViewportView(pnlChartPanel);

        // ***** input data window
        frmInputData.setLocationRelativeTo(this);

        // ***** properties window
        frmProperties.setLocationRelativeTo(this);
    }

    @Override
    public void visible(boolean state)
    {
        setVisible(state);
    }

    @Override
    public String getVersion()
    {
        return version;
    }

    @Override
    public ChartPanel getChartPanel()
    {
        return pnlChartPanel;
    }

    @Override
    public JButton getBtnZoomIn()
    {
        return btnZoomIn;
    }

    @Override
    public JButton getBtnZoomOut()
    {
        return btnZoomOut;
    }

    @Override
    public JButton getBtnZoomNormal()
    {
        return btnZoomNormal;
    }

    @Override
    public JButton getBtnSave()
    {
        return btnSave;
    }

    @Override
    public JButton getBtnSaveAs()
    {
        return btnSaveAs;
    }

    @Override
    public JButton getBtnNew()
    {
        return btnNew;
    }

    @Override
    public JButton getBtnOpen()
    {
        return btnOpen;
    }

    @Override
    public JButton getBtnInsertTask()
    {
        return btnInsertTask;
    }

    @Override
    public JButton getBtnDeleteTask()
    {
        return btnDeleteTask;
    }

    @Override
    public JMenuItem getMnuProperties()
    {
        return mnuProperties;
    }

    @Override
    public JMenuItem getMnuZoomNormal()
    {
        return mnuZoomNormal;
    }

    @Override
    public JMenuItem getMnuZoomOut()
    {
        return mnuZoomOut;
    }

    @Override
    public JMenuItem getMnuZoomIn()
    {
        return mnuZoomIn;
    }

    @Override
    public JMenuItem getMnuInfo()
    {
        return mnuInfo;
    }

    @Override
    public JMenuItem getMnuNew()
    {
        return mnuNew;
    }

    @Override
    public JMenuItem getMnuOpen()
    {
        return mnuOpen;
    }

    @Override
    public JMenuItem getMnuSave()
    {
        return mnuSave;
    }

    @Override
    public JMenuItem getMnuSaveAs()
    {
        return mnuSaveAs;
    }

    @Override
    public JMenuItem getMnuExit()
    {
        return mnuExit;
    }

    @Override
    public JMenuItem getMnuInsertTask()
    {
        return mnuInsertTask;
    }

    @Override
    public JMenuItem getMnuDeleteTask()
    {
        return mnuDeleteTask;
    }

    @Override
    public JFileChooser getFileChooser()
    {
        return fileChooser;
    }

    @Override
    public JLabel getLblFile()
    {
        return lblFile;
    }

    @Override
    public JTable getTblData()
    {
        return tblData;
    }

    @Override
    public void setLastDirectory(String path)
    {
        pref.put("LAST_DIRECTORY", path);
    }

    @Override
    public InputDataframe getFrmInputData()
    {
        return frmInputData;
    }

    @Override
    public PropertiesFrame getFrmProperties()
    {
        return frmProperties;
    }

    @Override
    public JScrollPane getScrPnlMainFrmRight()
    {
        return scrPnlMainFrmRight;
    }

    @Override
    public void showErrorMsg(String msg)
    {
        JOptionPane.showMessageDialog(this, msg, "Fehler !", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void showInfoMsg(String msg)
    {
        JOptionPane.showMessageDialog(this, msg, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public int showOptionDialog(String title, String msg)
    {
        return JOptionPane.showConfirmDialog(this, msg, title, JOptionPane.YES_NO_CANCEL_OPTION);
    }

    @Override
    public void addFensterListener(WindowListener listener)
    {
        this.addWindowListener(listener);
    }
}
