package ui;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;
import twitter4j.Status;
import util.Util;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MapMarkerImage extends MapMarkerCircle{
    public static final int defaultMarkerSize = 50;
    private Color defaultColor;
    private BufferedImage image;
    private Status status;



    public MapMarkerImage(Layer layer, Coordinate coord, Color c, String url, Status s) {
        super(layer, null, coord, defaultMarkerSize, STYLE.FIXED, getDefaultStyle());
        setColor(Color.BLACK);
        setBackColor(c);
        this.defaultColor = c;
        this.status = s;
        image = Util.imageFromURL(url);

    }

    @Override
    public void paint(Graphics g, Point position, int radio) {
        int width = (int) (this.image.getWidth(null)) / 2;
        int height = (int) (this.image.getHeight(null)) / 2;
        int w2 = width / 2;
        int h2 = height / 2;
        g.setColor(getDefaultColor());
        g.fillOval(position.x - 2*w2, position.y - 2*h2, defaultMarkerSize, defaultMarkerSize);
        g.drawImage(this.image, position.x - w2, position.y - h2, width, height, null);
        this.paintText(g, position);
    }

    private Color getDefaultColor(){
        return defaultColor;
    }

    public Status getStatus(){
        return status;
    }


}
