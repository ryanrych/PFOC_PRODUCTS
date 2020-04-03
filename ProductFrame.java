import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ProductFrame extends JFrame {
    Product product;

    public ProductFrame(Product product){
        this.product=product;
    }

    public void makeFrame(){
        Color backgroundColor = new Color(0x4d4d4d);
        Color fontColor = new Color(0xe6e6e6);
        Color accentColor = new Color(0xb8cfe5);
        Font font = new Font("Roboto", Font.BOLD, 13);

        JFrame window = new JFrame(product.getName());
        window.setSize(600, 450);

        JPanel borders = new JPanel(new BorderLayout());
        borders.setBackground(backgroundColor);

        JLabel borderNorth = new JLabel();
        borderNorth.setPreferredSize(new Dimension(0, 10));
        JLabel borderSouth = new JLabel();
        JLabel borderWest = new JLabel();
        borderWest.setPreferredSize(new Dimension(10, 0));
        JLabel borderEast = new JLabel();
        borderEast.setPreferredSize(new Dimension(10, 0));

        JPanel userLayout = new JPanel(new BorderLayout());
        userLayout.setBackground(backgroundColor);

        JPanel topLayout = new JPanel(new BorderLayout());
        topLayout.setBackground(backgroundColor);

        BufferedImage img = new BufferedImage(product.getThumbnail().getIconWidth(), product.getThumbnail().getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.createGraphics();
        product.getThumbnail().paintIcon(null, g, 0, 0);
        g.dispose();

        JPanel imageLayout = new JPanel(new BorderLayout());
        imageLayout.setBackground(backgroundColor);

        JLabel imageSpace = new JLabel();
        imageSpace.setPreferredSize(new Dimension(0, 0));

        JLabel image = new JLabel();
        ResizeImage resize = new ResizeImage(img, 100, 100, 900);
        image.setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10), BorderFactory.createLineBorder(accentColor, 3)));
        ImageIcon accessImage = new ImageIcon(resize.getResized());
        image.setIcon(accessImage);

        imageLayout.add(image, BorderLayout.NORTH);
        imageLayout.add(imageSpace, BorderLayout.SOUTH);

        JTextArea info = new JTextArea();
        info.setPreferredSize(new Dimension(300, 250));
        info.setWrapStyleWord(true);
        info.setLineWrap(true);
        info.setEditable(false);
        info.setBackground(backgroundColor);
        info.setFont(font);
        info.setForeground(fontColor);
        Border padding = new EmptyBorder(5, 5, 10, 10);
        Border lineBorder = BorderFactory.createLineBorder(accentColor, 2);
        info.setBorder(new CompoundBorder(lineBorder, padding));
        BoxLayout infoLayout = new BoxLayout(info, BoxLayout.PAGE_AXIS);
        info.setLayout(infoLayout);

        info.setText(info.getText() + "Name: " + product.getName() + "\n");
        for (int i = 0; i < product.getSkus().length; i++) {
            if (i == 0) {
                info.setText(info.getText() + product.getSkus()[i]);
            } else {
                info.setText(info.getText() + ", " + product.getSkus()[i]);
            }
        }
        info.setText(info.getText() + "\n");
        info.setText(info.getText() + "Category: " + product.getAttributes()[0] + "\n");
        info.setText(info.getText() + "Use: " + product.getAttributes()[1] + "\n");
        info.setText(info.getText() + "Type: " + product.getAttributes()[2] + "\n");
        info.setText(info.getText() + "Class: " + product.getAttributes()[3] + "\n");
        info.setText(info.getText() + "Power Type: " + product.getPower() + "\n");
        info.setText(info.getText() + "Packaging: " + product.getPackaging() + "\n");
        info.setText(info.getText() + "Price: " + product.getPrice() + "\n");
        info.setText(info.getText() + "Description: " + product.getDescription());

        topLayout.add(imageLayout, BorderLayout.WEST);
        topLayout.add(info, BorderLayout.CENTER);

        JPanel bottomLayout = new JPanel(new BorderLayout());
        bottomLayout.setBackground(backgroundColor);
        bottomLayout.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextArea description = new JTextArea();
        description.setPreferredSize(new Dimension(550, 100));
        description.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), BorderFactory.createLineBorder(accentColor, 2)));
        description.setWrapStyleWord(true);
        description.setLineWrap(true);
        description.setEditable(false);
        description.setBackground(backgroundColor);
        description.setForeground(fontColor);
        description.setFont(font);

        description.setText(description.getText() + "Customers: ");
        for (int i = 0; i < product.getCustomers().length; i++) {
            if (i == 0) {
                description.setText(description.getText() + product.getCustomers()[i]);
            } else {
                description.setText(description.getText() + ", " + product.getCustomers()[i]);
            }
        }
        description.setText(description.getText() + "\n\n");

        description.setText(description.getText() + "Related SKUs: ");
        for (int i = 0; i < product.getRelated().length; i++) {
            if (i == 0) {
                description.setText(description.getText() + product.getRelated()[i]);
            } else {
                description.setText(description.getText() + ", " + product.getRelated()[i]);
            }
        }

        bottomLayout.add(description, BorderLayout.WEST);

        userLayout.add(topLayout, BorderLayout.NORTH);
        userLayout.add(bottomLayout, BorderLayout.CENTER);

        borders.add(borderNorth, BorderLayout.NORTH);
        borders.add(borderSouth, BorderLayout.SOUTH);
        borders.add(borderWest, BorderLayout.WEST);
        borders.add(borderEast, BorderLayout.EAST);
        borders.add(userLayout, BorderLayout.CENTER);

        window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.getContentPane().add(borders);
        window.setVisible(true);
        window.setResizable(false);
    }
}
