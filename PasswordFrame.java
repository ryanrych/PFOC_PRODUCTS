import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PasswordFrame extends JFrame{
    JPasswordField passfld;
    PasswordMemory pass=new PasswordMemory();
    int button;
    Product product;
    int index;
    DefaultListModel list;

    final String password="";

    public final int ADD_WINDOW=1;
    public final int EDIT_WINDOW=2;
    public final int DELETE_WINDOW=3;
    public final int COPY_WINDOW=4;

    public PasswordFrame(Product product,int button,int index){
        this.product = product;
        this.button = button;
        this.index = index;
        passfld = new JPasswordField();
        passfld.setPreferredSize(new Dimension(125, 25));
        passfld.setBackground(new Color(0x4d4d4d));
        passfld.setForeground(new Color(0xe6e6e6));
        passfld.setBorder(new LineBorder(new Color(0xB8CFE5)));
        passfld.setFont(new Font("Roboto", Font.BOLD, 13));
        passfld.setCaretColor(new Color(0xe6e6e6));
        Border rounded = new LineBorder(new Color(0xB8CFE5));
        Border empty = new EmptyBorder(0, 3, 0, 0);
        Border border = new CompoundBorder(rounded, empty);
        passfld.setBorder(border);
    }

    public void open(){
        if(pass.getEntered()){
            if (button==ADD_WINDOW) {
                AddFrame addFrame = new AddFrame();
                addFrame.makeFrame();
            }
            else if (button==EDIT_WINDOW){
                EditFrame editFrame=new EditFrame(product);
                editFrame.makeFrame();
            }
            else if (button==DELETE_WINDOW){
                DeleteFrame deleteFrame=new DeleteFrame(list,index,product);
                deleteFrame.check();
            }
            else if (button==COPY_WINDOW){
                CopyFrame copyFrame=new CopyFrame(product);
                copyFrame.makeFrame();
            }
        }else{
            makeFrame(pass);
        }
    }


    public void makeFrame(PasswordMemory passwordMemory){
            JFrame window = new JFrame("Developer Password");
            window.setSize(350, 100);
            window.setResizable(false);
            JPanel mainLayout = new JPanel(new BorderLayout(0, 0));
            mainLayout.setBackground(new Color(0x4d4d4d));
            JLabel northSpace = new JLabel();
            JLabel southSpace = new JLabel();
            JLabel eastSpace = new JLabel();
            JLabel westSpace = new JLabel();
            window.setLocationRelativeTo(null);

            JPanel center = new JPanel(new FlowLayout());
            center.setBackground(new Color(0x4d4d4d));

            JLabel passLbl = new JLabel();
            passLbl.setFont(new Font("Roboto", Font.BOLD, 13));
            passLbl.setForeground(new Color(0xe6e6e6));
            passLbl.setText("Developer Password:");

            JButton passBtn = new JButton("Enter");
            window.getRootPane().setDefaultButton(passBtn);
            passBtn.setPreferredSize(new Dimension(125, 25));
            passBtn.setBackground(new Color(0x4d4d4d));
            passBtn.setForeground(new Color(0xe6e6e6));
            passBtn.setFont(new Font("Roboto", Font.BOLD, 13));
            passBtn.setBorder(new LineBorder(new Color(0xb8cfe5), 1));

            center.add(passLbl);
            center.add(passfld);
            center.add(passBtn);

            passBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (new String(passfld.getPassword()).equals(password)) {
                        passwordMemory.setEntered(true);
                        open();
                        window.dispose();
                    } else {
                        JLabel wrong = new JLabel(" Wrong password");
                        BorderLayout layout = (BorderLayout) mainLayout.getLayout();
                        wrong.setFont(new Font("Roboto", Font.BOLD, 18));
                        wrong.setForeground(new Color(0xe6e6e6));
                        wrong.setHorizontalAlignment(JLabel.CENTER);
                        mainLayout.remove(layout.getLayoutComponent(BorderLayout.CENTER));
                        mainLayout.add(wrong, BorderLayout.CENTER);
                        SwingUtilities.updateComponentTreeUI(window);
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                pause(750);
                                window.dispose();
                            }
                        });
                    }
                }
            });
            mainLayout.add(northSpace, BorderLayout.NORTH);
            mainLayout.add(southSpace, BorderLayout.SOUTH);
            mainLayout.add(westSpace, BorderLayout.WEST);
            mainLayout.add(eastSpace, BorderLayout.EAST);
            mainLayout.add(center, BorderLayout.CENTER);

            window.add(mainLayout);
            window.setLocationRelativeTo(null);
            window.setVisible(true);
            window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void pause(int ms){
        try{
            Thread.sleep(ms);
        }
        catch(Exception e){

        }

    }
}
