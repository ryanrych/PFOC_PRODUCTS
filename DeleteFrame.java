import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteFrame extends JFrame{
    DefaultListModel list;
    Product item;
    int delete;
    boolean confirm;

    Color backgroundColor=new Color(0x4d4d4d);
    Color fontColor=new Color(0xe6e6e6);
    Color accentColor=new Color(0xb8cfe5);
    Font fontPlain=new Font("Roboto",Font.PLAIN,13);
    Font fontBold=new Font("Roboto",Font.BOLD,13);
    Border rounded = new LineBorder(accentColor);
    Border empty = new EmptyBorder(0, 2, 0, 0);
    Border border = new CompoundBorder(rounded, empty);

    public DeleteFrame(DefaultListModel data,int delete,Product item){
        list=data;
        this.delete=delete;
        confirm=false;
        this.item=item;
    }

    public void check(){
        if (confirm){
            //delete
            confirm=false;
        }else{
            makeFrame();
        }
    }

    public void makeFrame(){
        JFrame window=new JFrame();
        window.setSize(350,100);
        window.setLocationRelativeTo(null);

        JPanel mainPanel=new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.PAGE_AXIS));
        mainPanel.setBackground(backgroundColor);

        JLabel title=new JLabel("<html><div style='text-align: center;'><p>Are you sure you'd like to delete "+item.getName()+"?</p></div></html>");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(fontBold);
        title.setForeground(fontColor);
        title.setBackground(backgroundColor);

        JPanel buttonPanel=new JPanel(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        buttonPanel.setBackground(backgroundColor);

        JButton yes=new JButton("Yes");
        yes.setPreferredSize(new Dimension(75,25));
        yes.setBackground(new Color(0x4d4d4d));
        yes.setForeground(new Color(0xe6e6e6));
        yes.setFont(new Font("Roboto",Font.BOLD,13));
        yes.setBorder(BorderFactory.createLineBorder(new Color(0xb8cfe5), 1));
        yes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                confirm=true;
                check();
            }
        });

        JButton no=new JButton("No");
        no.setPreferredSize(new Dimension(75,25));
        no.setBackground(new Color(0x4d4d4d));
        no.setForeground(new Color(0xe6e6e6));
        no.setFont(new Font("Roboto",Font.BOLD,13));
        no.setBorder(BorderFactory.createLineBorder(new Color(0xb8cfe5), 1));
        no.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                window.dispose();
            }
        });

        gbc.insets=new Insets(0,5,0,0);
        gbc.anchor=GridBagConstraints.CENTER;
        gbc.gridx=0;gbc.gridy=0;
        buttonPanel.add(yes,gbc);
        gbc.gridx=1;
        buttonPanel.add(no,gbc);

        mainPanel.add(title);
        mainPanel.add(buttonPanel);


        window.getContentPane().add(mainPanel);
        window.setVisible(true);
        window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
