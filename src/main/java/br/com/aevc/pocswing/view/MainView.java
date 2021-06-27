package br.com.aevc.pocswing.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainView extends JFrame {

    private static final String IMG_PATH = "/resources/";

    // PANELS
    private JPanel mainPanel;
    private JPanel statusPanel; // SOUTH
    private JPanel centerPanel; // CENTER

    // borders
    private BorderLayout mainLayout;
    private static Border borderEmpty;
    private static Border borderEtched;
    private static Border borderLowered;

    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

    public MainView() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());// sets basic style based on operational system
        addWindowListener(new MainViewWindowListener()); //sets a basic event listener
        setIconImage(
                Toolkit.getDefaultToolkit().getImage(
                        getClass().getResource("/resources/cube_molecule_view.png")
                )
        );// sets an icon
        setSize(1024, 650);// sets initial size
        setMinimumSize(new Dimension(670, 500));//sets window minimum resible size
        setLocation(150, 50);//sets window position on screen
        setTitle("Registro de Compra");//sets application title
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//ends application on window close

        initComponents();

        setVisible(true);//Defaults to false
    }

    private void initComponents() {
        borderEmpty = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        borderEtched = BorderFactory.createEtchedBorder();
        borderLowered = BorderFactory.createLoweredBevelBorder();

        if (mainLayout == null) {
            mainLayout = new BorderLayout();
        }

        if (mainPanel == null) {
            mainPanel = new JPanel(mainLayout);
            mainPanel.setBorder(borderEmpty);
        }

        buildMenuComponents();

        buildFormComponents();

        if (getContentPane() != mainPanel) {
            setContentPane(mainPanel);
        }
    }

    private void buildFormComponents() {

        this.centerPanel = new JPanel(new BorderLayout());
        // centerPanel.setBorder(borderEmpty);

        // PARAMETROS
        JPanel paramPanel = new JPanel(new FlowLayout());

        JLabel lblPhone = new JLabel("Phone #");
        lblPhone.setBounds(65, 68, 46, 14);
        paramPanel.add(lblPhone);

        textField_1 = new JTextField();
        textField_1.setBounds(128, 65, 86, 20);
        paramPanel.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblEmailId = new JLabel("Email Id");
        lblEmailId.setBounds(65, 115, 46, 14);
        paramPanel.add(lblEmailId);

        textField_2 = new JTextField();
        textField_2.setBounds(128, 112, 247, 17);
        paramPanel.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(65, 162, 46, 14);
        paramPanel.add(lblAddress);

        JTextArea textArea_1 = new JTextArea();
        textArea_1.setBounds(126, 157, 212, 40);
        paramPanel.add(textArea_1);

        JButton btnClear = new JButton("Clear");

        btnClear.setBounds(312, 387, 89, 23);
        paramPanel.add(btnClear);

        JLabel lblSex = new JLabel("Sex");
        lblSex.setBounds(65, 228, 46, 14);
        paramPanel.add(lblSex);

        JLabel lblMale = new JLabel("Male");
        lblMale.setBounds(128, 228, 46, 14);
        paramPanel.add(lblMale);

        JLabel lblFemale = new JLabel("Female");
        lblFemale.setBounds(292, 228, 46, 14);
        paramPanel.add(lblFemale);

        JRadioButton radioButton = new JRadioButton("");
        radioButton.setBounds(337, 224, 109, 23);
        paramPanel.add(radioButton);

        JRadioButton radioButton_1 = new JRadioButton("");
        radioButton_1.setBounds(162, 224, 109, 23);
        paramPanel.add(radioButton_1);

        JLabel lblOccupation = new JLabel("Occupation");
        lblOccupation.setBounds(65, 288, 67, 14);
        paramPanel.add(lblOccupation);

        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Select");
        comboBox.addItem("Business");
        comboBox.addItem("Engineer");
        comboBox.addItem("Doctor");
        comboBox.addItem("Student");
        comboBox.addItem("Others");
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox.setBounds(180, 285, 91, 20);
        paramPanel.add(comboBox);

        JButton btnSubmit = new JButton("submit");

        btnSubmit.setBackground(Color.BLUE);
        btnSubmit.setForeground(Color.MAGENTA);
        btnSubmit.setBounds(65, 387, 89, 23);
        paramPanel.add(btnSubmit);

        this.centerPanel.add(paramPanel, BorderLayout.NORTH);

        this.mainPanel.add(this.centerPanel, BorderLayout.CENTER);
    }

    private void buildMenuComponents() {
        System.out.println("buildMenuComponents");
        mainPanel.add(new MainMenu(), BorderLayout.NORTH);
    }

    private static class MainViewWindowListener extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent event) {

            System.out.println("Fechando a janela!");

        }

    }
}
