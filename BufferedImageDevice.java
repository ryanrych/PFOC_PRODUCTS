import java.awt.GraphicsDevice;
import java.awt.GraphicsConfiguration;

public class BufferedImageDevice extends GraphicsDevice
{
    GraphicsConfiguration gc;

    public BufferedImageDevice(BufferedImageGraphicsConfig gc) {
        this.gc = gc;
    }

    /**
     * Returns the type of this <code>GraphicsDevice.
     * @return the type of this <code>GraphicsDevice, which can
     * either be TYPE_RASTER_SCREEN, TYPE_PRINTER or TYPE_IMAGE_BUFFER.
     * @see #TYPE_RASTER_SCREEN
     * @see #TYPE_PRINTER
     * @see #TYPE_IMAGE_BUFFER
     */
    public int getType() {
        return GraphicsDevice.TYPE_IMAGE_BUFFER;
    }

    /**
     * Returns the identification string associated with this
     * <code>GraphicsDevice.
     * @return a <code>String that is the identification
     * of this <code>GraphicsDevice.
     */
    public String getIDstring() {
        return ("BufferedImage");
    }

    /**
     * Returns all of the <code>GraphicsConfiguration
     * objects associated with this <code>GraphicsDevice.
     * @return an array of <code>GraphicsConfiguration
     * objects that are associated with this
     * <code>GraphicsDevice.
     */
    public GraphicsConfiguration[] getConfigurations() {
        return new GraphicsConfiguration[] { gc };
    }

    /**
     * Returns the default <code>GraphicsConfiguration
     * associated with this <code>GraphicsDevice.
     * @return the default <code>GraphicsConfiguration
     * of this <code>GraphicsDevice.
     */
    public GraphicsConfiguration getDefaultConfiguration() {
        return gc;
    }
}