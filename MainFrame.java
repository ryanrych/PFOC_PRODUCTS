import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Flow;

public class MainFrame extends JFrame {
    DefaultListModel<Tuple> data;

    public MainFrame(DefaultListModel<Tuple> data){
        this.data=data;
    }

    public void makeFrame(){
        JFrame mainWindow=new JFrame("Acurite Product Catalog");
        mainWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainWindow.setSize(925,725);
        mainWindow.setLocationRelativeTo(null);

        JLabel spaceTop=new JLabel();
        JLabel spaceBottom=new JLabel();
        JLabel spaceLeft=new JLabel();
        JLabel spaceRight=new JLabel();

        JPanel mainPanel=new JPanel(new BorderLayout(40,50));
        mainPanel.setBackground(new Color(0x4d4d4d));


        JPanel titleLayout=new JPanel(new FlowLayout());
        titleLayout.setBackground(new Color(0x4d4d4d));

        JLabel title=new JLabel();
        title.setText("Welcome to the Acurite Product Catalog");
        title.setForeground(new Color(0xe6e6e6));
        title.setFont(new Font("Roboto",Font.BOLD,24));
        titleLayout.add(title);

        String[] att1Options={"Category","Enviroment","Clocks","Cooking"};
        String[] att2Options={"Use","Indoor","Outdoor"};
        String[] att3Options={"Type","Digital","Analog","Integrated"};
        String[] att4Options={"Class","Weather Station","Forecaster","Thermometer","Rain Gauge","Specialty Weather","Home Monitor","Alarm","Non-Alarm Clock","Timer","Accessory","Hub"};
        String[] att5Options={"Customer","Amazon","Home Depot","Walmart","Lowes","Acurite","Tractor Supply","All Other","All"};

        JPanel resultsLayout=new JPanel(new BorderLayout(125,0));
        resultsLayout.setBackground(new Color(0x4d4d4d));

        JList results=new JList(data);
        results.setCellRenderer(new productRenderer(225));
        results.setBackground(new Color(0x4d4d4d));
        results.setForeground(new Color(0xe6e6e6));
        results.setBorder(new LineBorder(new Color(0xB8CFE5)));
        results.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        results.setLayoutOrientation(JList.VERTICAL);

        JPanel scrollLayout=new JPanel();
        BoxLayout boxLayout=new BoxLayout(scrollLayout,BoxLayout.PAGE_AXIS);
        scrollLayout.setLayout(boxLayout);
        scrollLayout.setBackground(new Color(0x4d4d4d));

        JScrollPane scroll=new JScrollPane(results);
        scroll.setPreferredSize(new Dimension(450,375));
        scroll.setBorder(new LineBorder(new Color(0xB8CFE5)));
        scroll.getVerticalScrollBar().setBackground(new Color(0x4d4d4d));
        scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(0xB8CFE5);
            }
        });

        JPanel attLayout=new JPanel(new FlowLayout(FlowLayout.CENTER,10,25));
        attLayout.setBackground(new Color(0x4d4d4d));

        JButton searchButton=new JButton();
        searchButton.setPreferredSize(new Dimension(125,25));
        searchButton.setText("Search");
        searchButton.setBackground(new Color(0x4d4d4d));
        searchButton.setForeground(new Color(0xe6e6e6));
        searchButton.setFont(new Font("Roboto",Font.BOLD,13));
        searchButton.setBorder(BorderFactory.createLineBorder(new Color(0xb8cfe5), 1));

        JPanel restoreLayout=new JPanel();
        restoreLayout.setBackground(new Color(0x4d4d4d));
        JButton restoreButton=new JButton();
        restoreButton.setPreferredSize(new Dimension(415,25));
        restoreButton.setText("Show All Products");
        restoreButton.setBackground(new Color(0x4d4d4d));
        restoreButton.setForeground(new Color(0xe6e6e6));
        restoreButton.setFont(new Font("Roboto",Font.BOLD,13));
        restoreButton.setBorder(BorderFactory.createLineBorder(new Color(0xb8cfe5), 1));
        restoreLayout.add(restoreButton);

        JTextField skuSearch=new JTextField();
        skuSearch.setUI(new JTextFieldHintUI("SKU Search",new Color(0xa6a6a6)));
        skuSearch.setPreferredSize(new Dimension(125,25));
        skuSearch.setBackground(new Color(0x4d4d4d));
        skuSearch.setForeground(new Color(0xe6e6e6));
        skuSearch.setFont(new Font("Roboto",Font.BOLD,13));
        skuSearch.setCaretColor(new Color(0xe6e6e6));
        Border rounded = new LineBorder(new Color(0xB8CFE5));
        Border empty = new EmptyBorder(0, 3, 0, 0);
        Border border = new CompoundBorder(rounded, empty);
        skuSearch.setBorder(border);
        skuSearch.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                mainWindow.getRootPane().setDefaultButton(searchButton);
            }
            @Override
            public void focusLost(FocusEvent e){}
        });

        JComboBox att1=new JComboBox(att1Options);
        att1.setBorder(new LineBorder(new Color(0xB8CFE5),1));
        att1.setPreferredSize(new Dimension(135,25));
        att1.setBackground(new Color(0x4d4d4d));
        att1.setForeground(new Color(0xe6e6e6));
        att1.setUI(new ComboBoxScrollerUI());
        att1.setFont(new Font("Roboto",Font.BOLD,12));
        att1.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                mainWindow.getRootPane().setDefaultButton(searchButton);
            }
            @Override
            public void focusLost(FocusEvent e){}
        });
        JComboBox att2=new JComboBox(att2Options);
        att2.setBorder(new LineBorder(new Color(0xB8CFE5),1));
        att2.setPreferredSize(new Dimension(125,25));
        att2.setBackground(new Color(0x4d4d4d));
        att2.setForeground(new Color(0xe6e6e6));
        att2.setUI(new ComboBoxScrollerUI());
        att2.setFont(new Font("Roboto",Font.BOLD,12));
        att2.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                mainWindow.getRootPane().setDefaultButton(searchButton);
            }
            @Override
            public void focusLost(FocusEvent e){}
        });
        JComboBox att3=new JComboBox(att3Options);
        att3.setBorder(new LineBorder(new Color(0xB8CFE5),1));
        att3.setPreferredSize(new Dimension(125,25));
        att3.setBackground(new Color(0x4d4d4d));
        att3.setForeground(new Color(0xe6e6e6));
        att3.setUI(new ComboBoxScrollerUI());
        att3.setFont(new Font("Roboto",Font.BOLD,12));
        att3.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                mainWindow.getRootPane().setDefaultButton(searchButton);
            }
            @Override
            public void focusLost(FocusEvent e){}
        });
        JComboBox att4=new JComboBox(att4Options);
        att4.setPreferredSize(new Dimension(125,25));
        att4.setBackground(new Color(0x4d4d4d));
        att4.setForeground(new Color(0xe6e6e6));
        att4.setUI(new ComboBoxScrollerUI());
        att4.setFont(new Font("Roboto",Font.BOLD,12));
        att4.setBorder(new LineBorder(new Color(0xB8CFE5),1));
        att4.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                mainWindow.getRootPane().setDefaultButton(searchButton);
            }
            @Override
            public void focusLost(FocusEvent e){}
        });
        JComboBox att5=new JComboBox(att5Options);
        att5.setBorder(new LineBorder(new Color(0xB8CFE5),1));
        att5.setPreferredSize(new Dimension(125,25));
        att5.setBackground(new Color(0x4d4d4d));
        att5.setForeground(new Color(0xe6e6e6));
        att5.setUI(new ComboBoxScrollerUI());
        att5.setFont(new Font("Roboto",Font.BOLD,12));
        att5.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                mainWindow.getRootPane().setDefaultButton(searchButton);
            }
            @Override
            public void focusLost(FocusEvent e){}
        });

        attLayout.add(att1);
        attLayout.add(att2);
        attLayout.add(att3);
        attLayout.add(att4);
        attLayout.add(att5);
        attLayout.add(skuSearch);
        attLayout.add(searchButton);

        JPanel keyLayout=new JPanel(new FlowLayout());
        keyLayout.setBackground(new Color(0x4d4d4d));

        JButton keyButton=new JButton("Search");
        keyButton.setPreferredSize(new Dimension(75,25));
        keyButton.setBackground(new Color(0x4d4d4d));
        keyButton.setForeground(new Color(0xe6e6e6));
        keyButton.setFont(new Font("Roboto",Font.BOLD,13));
        keyButton.setBorder(BorderFactory.createLineBorder(new Color(0xb8cfe5), 1));

        JTextField keySearch=new JTextField();
        keySearch.setUI(new JTextFieldHintUI("Keyword Search",new Color(0xa6a6a6)));
        keySearch.setPreferredSize(new Dimension(350,25));
        keySearch.setBackground(new Color(0x4d4d4d));
        keySearch.setForeground(new Color(0xe6e6e6));
        keySearch.setFont(new Font("Roboto",Font.BOLD,13));
        keySearch.setCaretColor(new Color(0xe6e6e6));
        keySearch.setBorder(border);
        keySearch.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                mainWindow.getRootPane().setDefaultButton(keyButton);
            }
            @Override
            public void focusLost(FocusEvent e){}
        });

        keyLayout.add(keySearch);
        keyLayout.add(keyButton);

        scrollLayout.add(keyLayout);
        scrollLayout.add(scroll);
        scrollLayout.add(restoreLayout);

        JLabel centerSpaceLeft=new JLabel();
        JLabel centerSpaceRight=new JLabel();

        JPanel resultsLayoutCenter=new JPanel((new BorderLayout()));
        resultsLayoutCenter.setBackground(new Color(0x4d4d4d));
        resultsLayoutCenter.setPreferredSize(new Dimension(400,400));

        JPanel resultsButtons=new JPanel(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        resultsButtons.setBackground(new Color(0x4d4d4d));


        JButton viewButton=new JButton("View");
        viewButton.setPreferredSize(new Dimension(125,25));
        viewButton.setBackground(new Color(0x4d4d4d));
        viewButton.setForeground(new Color(0xe6e6e6));
        viewButton.setFont(new Font("Roboto",Font.BOLD,13));
        viewButton.setBorder(BorderFactory.createLineBorder(new Color(0xb8cfe5), 1));
        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int index=results.getSelectedIndex();
                if(index!=-1) {
                    Tuple tmp = (Tuple) data.get(index);
                    ProductFrame newWindow = new ProductFrame(tmp.getProduct());
                    newWindow.makeFrame();
                }
            }
        });

        JButton editButton=new JButton("Edit");
        editButton.setPreferredSize(new Dimension(125,25));
        editButton.setBackground(new Color(0x4d4d4d));
        editButton.setForeground(new Color(0xe6e6e6));
        editButton.setFont(new Font("Roboto",Font.BOLD,13));
        editButton.setBorder(BorderFactory.createLineBorder(new Color(0xb8cfe5), 1));
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int index=results.getSelectedIndex();
                if(index!=-1) {
                    Tuple tmp = (Tuple) data.get(index);
                    PasswordFrame newWindow = new PasswordFrame(tmp.getProduct(),2,index);
                    newWindow.open();
                }
            }
        });

        JButton addButton=new JButton("Add");
        addButton.setPreferredSize(new Dimension(125,25));
        addButton.setBackground(new Color(0x4d4d4d));
        addButton.setForeground(new Color(0xe6e6e6));
        addButton.setFont(new Font("Roboto",Font.BOLD,13));
        addButton.setBorder(BorderFactory.createLineBorder(new Color(0xb8cfe5), 1));
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                PasswordFrame newWindow = new PasswordFrame(null,1,-1);
                newWindow.open();
            }
        });

        JButton cloneButton=new JButton("Clone");
        cloneButton.setPreferredSize(new Dimension(125,25));
        cloneButton.setBackground(new Color(0x4d4d4d));
        cloneButton.setForeground(new Color(0xe6e6e6));
        cloneButton.setFont(new Font("Roboto",Font.BOLD,13));
        cloneButton.setBorder(BorderFactory.createLineBorder(new Color(0xb8cfe5), 1));
        cloneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int index=results.getSelectedIndex();
                if(index!=-1) {
                    Tuple tmp = (Tuple) data.get(index);
                    PasswordFrame newWindow = new PasswordFrame(tmp.getProduct(),4,index);
                    newWindow.open();
                }
            }
        });

        JButton deleteButton=new JButton("Delete");
        deleteButton.setPreferredSize(new Dimension(125,25));
        deleteButton.setBackground(new Color(0x4d4d4d));
        deleteButton.setForeground(new Color(0xe6e6e6));
        deleteButton.setFont(new Font("Roboto",Font.BOLD,13));
        deleteButton.setBorder(BorderFactory.createLineBorder(new Color(0xb8cfe5), 1));
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int index=results.getSelectedIndex();
                if (index!=-1){
                    Tuple tmp = (Tuple) data.get(index);
                    PasswordFrame newWindow = new PasswordFrame(tmp.getProduct(),3,index);
                    newWindow.open();
                }
            }
        });

        keyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ListModel<Tuple> scanList=results.getModel();
                if (keySearch.getText().length()!=0){
                    DefaultListModel searchList=new DefaultListModel();
                    for (int i=0;i<scanList.getSize();i++){
                        String[] words = scanList.getElementAt(i).getProduct().getName().split("\\s+");
                        for (int q=0;q<words.length;q++) {words[i] = words[i].replaceAll("[^\\w]", "");}
                        boolean flag=false;
                        for (int j=0;j<words.length;j++){
                            if (words[j].toLowerCase().equals(keySearch.getText().toLowerCase())){
                                searchList.addElement(scanList.getElementAt(i));
                                flag=true;
                            }
                            if (flag){
                                break;
                            }
                        }
                    }
                    results.setModel(searchList);
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (skuSearch.getText().length()!=0) {
                    DefaultListModel searchList = new DefaultListModel();
                    for (int i=0;i<data.getSize();i++){
                        boolean flag=false;
                        for (int j=0;j<data.get(i).getProduct().getSkus().length;j++){
                            if (data.get(i).getProduct().getSkus()[j].toLowerCase().equals(skuSearch.getText().toLowerCase())){
                                searchList.addElement(data.get(i));
                                flag=true;
                            }
                            if (flag){
                                break;
                            }
                        }
                    }
                    results.setModel(searchList);
                }else{
                    DefaultListModel searchList=new DefaultListModel();
                    for (int i=0;i<data.getSize();i++){
                        if ((data.get(i).getProduct().getAttributes()[0].equals(att1.getSelectedItem()) || att1.getSelectedItem().equals("Category"))&&(data.get(i).getProduct().getAttributes()[1].equals(att2.getSelectedItem()) || att2.getSelectedItem().equals("Use"))&&(data.get(i).getProduct().getAttributes()[2].equals(att3.getSelectedItem()) || att3.getSelectedItem().equals("Type"))&&(data.get(i).getProduct().getAttributes()[3].equals(att4.getSelectedItem()) || att4.getSelectedItem().equals("Class"))){
                            boolean flag=false;
                            for (int j=0;j<data.get(i).getProduct().getCustomers().length;j++){
                                if ((att5.getSelectedItem().equals(data.get(i).getProduct().getCustomers()[j])||(att5.getSelectedItem().equals("All")) || att5.getSelectedItem().equals(data.get(i).getProduct().getCustomers()[j])||att5.getSelectedItem().equals("Customer"))){
                                    searchList.addElement(data.get(i));
                                    flag=true;
                                }
                                if (flag){
                                    break;
                                }
                            }
                        }
                        results.setModel(searchList);
                    }
                }
            }
        });

        restoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                results.setModel(data);
                att1.setSelectedItem("Category");
                att2.setSelectedItem("Use");
                att3.setSelectedItem("Type");
                att4.setSelectedItem("Class");
                att5.setSelectedItem("Customer");
                skuSearch.setText("");
                keySearch.setText("");
            }
        });

        gbc.gridx=0;gbc.gridy=0;
        gbc.insets=new Insets(5,0,5,0);
        resultsButtons.add(viewButton,gbc);
        gbc.gridx=0;gbc.gridy=1;
        resultsButtons.add(editButton,gbc);
        gbc.gridx=0;gbc.gridy=2;
        resultsButtons.add(addButton,gbc);
        gbc.gridx=0;gbc.gridy=3;
        resultsButtons.add(cloneButton,gbc);
        gbc.gridx=0;gbc.gridy=4;
        resultsButtons.add(deleteButton,gbc);


        resultsLayoutCenter.add(scrollLayout,BorderLayout.WEST);
        resultsLayoutCenter.add(resultsButtons,BorderLayout.EAST);

        resultsLayout.add(resultsLayoutCenter,BorderLayout.CENTER);
        resultsLayout.add(centerSpaceLeft,BorderLayout.WEST);
        resultsLayout.add(centerSpaceRight,BorderLayout.EAST);

        JPanel centerLayout=new JPanel(new BorderLayout(0,0));
        centerLayout.setBackground(new Color(0x4d4d4d));
        centerLayout.add(titleLayout,BorderLayout.NORTH);
        centerLayout.add(attLayout,BorderLayout.CENTER);
        centerLayout.add(resultsLayout,BorderLayout.SOUTH);

        mainPanel.add(spaceTop,BorderLayout.NORTH);
        mainPanel.add(centerLayout,BorderLayout.CENTER);
        mainPanel.add(spaceBottom,BorderLayout.SOUTH);
        mainPanel.add(spaceLeft,BorderLayout.WEST);
        mainPanel.add(spaceRight,BorderLayout.EAST);

        mainWindow.add(mainPanel);
        mainWindow.setVisible(true);
        mainWindow.setResizable(false);
    }
}
