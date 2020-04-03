import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EditFrame extends JFrame {
    Product product;
    String[] att1Options={"Enviroment","Clocks","Cooking"};
    String[] att2Options={"Indoor","Outdoor"};
    String[] att3Options={"Digital","Analog","Integrated"};
    String[] att4Options={"Weather Station","Forecaster","Thermometer","Rain Gauge","Specialty Weather","Home Monitor","Alarm","Non-Alarm Clock","Timer","Accessory","Hub"};
    String[] att5Options={"Amazon","Home Depot","Walmart","Lowes","Acurite","Tractor Supply","All Other","All"};


    public EditFrame(Product product){
        this.product=product;
    }

    public void makeFrame(){
        Color backgroundColor=new Color(0x4d4d4d);
        Color fontColor=new Color(0xe6e6e6);
        Color accentColor=new Color(0xb8cfe5);
        Font fontPlain=new Font("Roboto",Font.PLAIN,13);
        Font fontBold=new Font("Roboto",Font.BOLD,13);
        Border rounded = new LineBorder(accentColor);
        Border empty = new EmptyBorder(0, 2, 0, 0);
        Border border = new CompoundBorder(rounded, empty);
        GridBagConstraints gbc2;

        JFrame window=new JFrame(product.getName()+" Edit Page");
        window.setSize(500,550);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        JPanel mainBorder=new JPanel(new BorderLayout());
        mainBorder.setBackground(backgroundColor);

        JPanel userPanel=new JPanel(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        userPanel.setBackground(backgroundColor);

        JLabel name=new JLabel("Name:");
        name.setFont(fontBold);
        name.setForeground(fontColor);
        JTextField nameArea=new JTextField(product.getName());
        nameArea.setPreferredSize(new Dimension(400,20));
        nameArea.setBackground(backgroundColor);
        nameArea.setForeground(fontColor);
        nameArea.setFont(fontPlain);
        nameArea.setCaretColor(fontColor);
        nameArea.setBorder(border);

        JLabel skus=new JLabel("SKUs (comma separated):");
        skus.setForeground(fontColor);
        skus.setFont(fontBold);
        JTextField skusArea=new JTextField();
        skusArea.setPreferredSize(new Dimension(400,20));
        skusArea.setBackground(backgroundColor);
        skusArea.setForeground(fontColor);
        skusArea.setFont(fontPlain);
        skusArea.setCaretColor(fontColor);
        skusArea.setBorder(border);
        for (int i=0;i<product.getSkus().length;i++){
            if (i==0){skusArea.setText(product.getSkus()[i]);}
            else {skusArea.setText(skusArea.getText()+","+product.getSkus()[i]);}
        }

        JLabel category=new JLabel("Category:");
        category.setForeground(fontColor);
        category.setFont(fontBold);
        JComboBox categoryArea=new JComboBox(att1Options);
        categoryArea.setPreferredSize(new Dimension(125,20));
        categoryArea.setSelectedItem(product.getAttributes()[0]);
        categoryArea.setBackground(backgroundColor);
        categoryArea.setForeground(fontColor);
        categoryArea.setFont(fontPlain);
        categoryArea.setBorder(border);
        categoryArea.setUI(new ComboBoxScrollerUI());

        JLabel use=new JLabel("Use:");
        use.setForeground(fontColor);
        use.setFont(fontBold);
        JComboBox useArea=new JComboBox(att2Options);
        useArea.setPreferredSize(new Dimension(125,20));
        useArea.setSelectedItem(product.getAttributes()[1]);
        useArea.setBackground(backgroundColor);
        useArea.setForeground(fontColor);
        useArea.setFont(fontPlain);
        useArea.setBorder(border);
        useArea.setUI(new ComboBoxScrollerUI());

        JLabel type=new JLabel("Type:");
        type.setForeground(fontColor);
        type.setFont(fontBold);
        JComboBox typeArea=new JComboBox(att3Options);
        typeArea.setPreferredSize(new Dimension(125,20));
        typeArea.setSelectedItem(product.getAttributes()[2]);
        typeArea.setBackground(backgroundColor);
        typeArea.setForeground(fontColor);
        typeArea.setFont(fontPlain);
        typeArea.setBorder(border);
        typeArea.setUI(new ComboBoxScrollerUI());

        JLabel classLabel=new JLabel("Class:");
        classLabel.setForeground(fontColor);
        classLabel.setFont(fontBold);
        JComboBox classArea=new JComboBox(att4Options);
        classArea.setPreferredSize(new Dimension(125,20));
        classArea.setSelectedItem(product.getAttributes()[3]);
        classArea.setBackground(backgroundColor);
        classArea.setForeground(fontColor);
        classArea.setFont(fontPlain);
        classArea.setBorder(border);
        classArea.setUI(new ComboBoxScrollerUI());

        JLabel customer=new JLabel("Customers (comma separated):");
        customer.setForeground(fontColor);
        customer.setFont(fontBold);
        JTextField customerArea=new JTextField();
        customerArea.setPreferredSize(new Dimension(400,20));
        customerArea.setBackground(backgroundColor);
        customerArea.setForeground(fontColor);
        customerArea.setFont(fontPlain);
        customerArea.setCaretColor(fontColor);
        customerArea.setBorder(border);
        for (int i=0;i<product.getCustomers().length;i++){
            if (i==0){customerArea.setText(product.getCustomers()[i]);}
            else {customerArea.setText(customerArea.getText()+","+product.getCustomers()[i]);}
        }

        JLabel power=new JLabel("Power Type:");
        power.setFont(fontBold);
        power.setForeground(fontColor);
        JTextField powerArea=new JTextField(product.getPower());
        powerArea.setPreferredSize(new Dimension(75,20));
        powerArea.setBackground(backgroundColor);
        powerArea.setForeground(fontColor);
        powerArea.setFont(fontPlain);
        powerArea.setCaretColor(fontColor);
        powerArea.setBorder(border);

        JLabel price=new JLabel("Price:");
        price.setFont(fontBold);
        price.setForeground(fontColor);
        JTextField priceArea=new JTextField(Double.toString(product.getPrice()));
        priceArea.setPreferredSize(new Dimension(75,20));
        priceArea.setBackground(backgroundColor);
        priceArea.setForeground(fontColor);
        priceArea.setFont(fontPlain);
        priceArea.setCaretColor(fontColor);
        priceArea.setBorder(border);

        JLabel description=new JLabel("Description:");
        description.setFont(fontBold);
        description.setForeground(fontColor);
        JTextField descriptionArea=new JTextField(product.getDescription());
        descriptionArea.setPreferredSize(new Dimension(400,20));
        descriptionArea.setBackground(backgroundColor);
        descriptionArea.setForeground(fontColor);
        descriptionArea.setFont(fontPlain);
        descriptionArea.setCaretColor(fontColor);
        descriptionArea.setBorder(border);

        JPanel buttonLayout=new JPanel(new FlowLayout(FlowLayout.CENTER,5,10));
        buttonLayout.setBackground(backgroundColor);

        JButton saveButton=new JButton("Save");
        saveButton.setPreferredSize(new Dimension(100,25));
        saveButton.setBackground(backgroundColor);
        saveButton.setForeground(fontColor);
        saveButton.setFont(new Font("Roboto",Font.BOLD,13));
        saveButton.setBorder(BorderFactory.createLineBorder(accentColor, 1));

        JButton resetButton=new JButton("Reset");
        resetButton.setPreferredSize(new Dimension(100,25));
        resetButton.setBackground(backgroundColor);
        resetButton.setForeground(fontColor);
        resetButton.setFont(new Font("Roboto",Font.BOLD,13));
        resetButton.setBorder(BorderFactory.createLineBorder(accentColor, 1));

        buttonLayout.add(saveButton);
        buttonLayout.add(resetButton);

        gbc.anchor=GridBagConstraints.WEST;
        gbc.ipady=3;
        gbc.gridx=0;
        gbc.gridy=0;
        userPanel.add(name,gbc);
        gbc.gridy++;
        userPanel.add(nameArea,gbc);
        gbc.gridy++;
        userPanel.add(skus,gbc);
        gbc.gridy++;
        userPanel.add(skusArea,gbc);
        gbc.gridy++;
        userPanel.add(category,gbc);
        gbc.gridy++;
        userPanel.add(categoryArea,gbc);
        gbc.gridy++;
        userPanel.add(use,gbc);
        gbc.gridy++;
        userPanel.add(useArea,gbc);
        gbc.gridy++;
        userPanel.add(type,gbc);
        gbc.gridy++;
        userPanel.add(typeArea,gbc);
        gbc.gridy++;
        userPanel.add(classLabel,gbc);
        gbc.gridy++;
        userPanel.add(classArea,gbc);
        gbc.gridy++;
        userPanel.add(customer,gbc);
        gbc.gridy++;
        userPanel.add(customerArea,gbc);
        gbc.gridy++;
        userPanel.add(power,gbc);
        gbc.gridy++;
        userPanel.add(powerArea,gbc);
        gbc.gridy++;
        userPanel.add(price,gbc);
        gbc.gridy++;
        userPanel.add(priceArea,gbc);
        gbc.gridy++;
        userPanel.add(description,gbc);
        gbc.gridy++;
        userPanel.add(descriptionArea,gbc);
        gbc.gridy++;
        gbc.insets=new Insets(0,0,10,0);
        userPanel.add(buttonLayout,gbc);

        JLabel mainNorthSpace=new JLabel();
        JLabel mainSouthSpace=new JLabel();
        JLabel mainWestSpace=new JLabel();
        JLabel mainEastSpace=new JLabel();

        mainBorder.add(mainNorthSpace,BorderLayout.NORTH);
        mainBorder.add(mainSouthSpace,BorderLayout.SOUTH);
        mainBorder.add(mainWestSpace,BorderLayout.WEST);
        mainBorder.add(mainEastSpace,BorderLayout.EAST);
        mainBorder.add(userPanel,BorderLayout.CENTER);

        window.setContentPane(mainBorder);
        window.setVisible(true);
        window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}