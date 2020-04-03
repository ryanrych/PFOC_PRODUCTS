import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class productRenderer extends DefaultListCellRenderer implements ListCellRenderer<Object> {
    public static final String HTML_1 = "<html><body style='width: ";
    public static final String HTML_2 = "px'>";
    public static final String HTML_3 = "</html>";
    private int width;

    public productRenderer(int width) {
        this.width = width;
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list,Object value,int index,boolean isSelected,boolean cellHasFocus) {

        Tuple is=(Tuple) value;

        setText(is.getName()+": ");
        for (int i=0;i<is.getProduct().getSkus().length;i++){
            if (i==0){setText(getText()+is.getProduct().getSkus()[i]);}
            else{setText(getText()+", "+is.getProduct().getSkus()[i]);}
        }
        setIcon(is.getPic());
        boolean selected=false;

        if (isSelected){
            setBackground(new Color(0xB8CFE5));
            setForeground(new Color(0x4d4d4d));
        }else{
            setBackground(new Color(0x4d4d4d));
            setForeground(new Color(0xe6e6e6));
        }

        setText( HTML_1 + String.valueOf(width) + HTML_2 + getText() + HTML_3);

        setEnabled(true);
        return this;
    }

}
