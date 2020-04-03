import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Tuple {
    String name;
    ImageIcon pic;
    Product product;

    public Tuple(String name, ImageIcon pic, Product product){
        this.name=name;
        this.pic=pic;
        this.product=product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageIcon getPic() {
        return pic;
    }

    public void setPic(ImageIcon pic) {
        this.pic = pic;
    }

    public Product getProduct(){
        return product;
    }
}
