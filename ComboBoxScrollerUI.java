import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.*;
import java.awt.*;

public class ComboBoxScrollerUI extends BasicComboBoxUI {
    @Override
    protected ComboPopup createPopup() {
        return new BasicComboPopup(comboBox) {
            @Override
            protected JScrollPane createScroller() {
                JScrollPane scroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                scroller.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                    @Override
                    public Dimension getPreferredSize(JComponent c) {
                        return new Dimension(13, super.getPreferredSize(c).height);
                    }
                });
                scroller.getVerticalScrollBar().setBackground(new Color(0x4d4d4d));
                scroller.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                    @Override
                    protected void configureScrollBarColors() {
                        this.thumbColor = new Color(0xB8CFE5);
                    }
                });
                scroller.getVerticalScrollBar().setBorder(new LineBorder(new Color(0xB8CFE5),1));
                return scroller;
            }

        };
    }
    @Override
    protected JButton createArrowButton() {
        JButton button = new BasicArrowButton(BasicArrowButton.SOUTH);
        button.setBackground(new Color(0x4d4d4d));
        button.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, new Color(0xB8CFE5)));
       // button.set
        return button;
    }
}