import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String args[]){
        BufferedImage img=new BufferedImage(900,900,BufferedImage.TYPE_INT_ARGB);
        File path=new File("C:\\Users\\ryanj\\..PROGRAMS\\Java\\Primex\\Catalog\\src\\Images\\Access.jpg");
        try{img= ImageIO.read(path);} catch (IOException e){}
        ResizeImage resize=new ResizeImage(img,100,100,900);
        ImageIcon accessImage=new ImageIcon(resize.getResized());
        Product access=new Product(new String[]{"Enviroment","Indoor","Integrated","Hub"},new String[]{"Amazon"},new String[]{"SKU#"},00.00,accessImage,"This is just an example product","Example Product","Cardboard","5V power adapter",new String[]{"Other Product","Different Product"});
        Tuple accessTuple=new Tuple(access.getName(),access.getThumbnail(),access);

        DefaultListModel<Tuple> items=new DefaultListModel<Tuple>();
        items.addElement(accessTuple);
        items.addElement(accessTuple);

        MainFrame frame = new MainFrame(items);
        frame.makeFrame();
    }
}
