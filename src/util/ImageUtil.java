package util;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.Random;



public class ImageUtil {
  public static String scode = "";
  
  public static String getScode() {
    return scode;
  }
  
  public static void setScode(String code) {
    ImageUtil.scode = code;
  }
  
  public static BufferedImage createImage(int width, int height, int n) {
    BufferedImage bImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics g = bImage.getGraphics();
    g.setColor(Color.white);
		Font mFont = new Font("宋体", Font.BOLD, 25);
    g.setFont(mFont);
    g.fillRect(0, 0, width, height);
    g.setColor(Color.black);
    
    String code = "";
		char[] codes = "0123456789qwertyuipasdfghjkzxcvbnmQWERTYUPASDFGHJKLZXCVBNM".toCharArray();
    Random random = new Random();
    for (int i = 0; i < n; i++) {
      int index = random.nextInt(codes.length);
      code += codes[index];
    }
    scode = code;
    g.drawString(scode, 10, 20);
    return bImage;
  }
  
  public static BufferedImage createMulImage(int width, int height, int n) {
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();
    Graphics2D g2d = (Graphics2D)g;
    Random r = new Random();
    Font font = new Font("宋体", Font.BOLD, 17);
    g.setColor(getRandColor(200, 250));
    g.fillRect(0, 0, width, height);
    g.setFont(font);
    g.setColor(getRandColor(180, 200));
    for(int i = 0;i < 100; i++) {
      int x = r.nextInt(width - 1);
      int y = r.nextInt(height - 1);
      int x1 = r.nextInt(6) + 1;
      int y1 = r.nextInt(12) + 1;
      BasicStroke bs = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
      Line2D line = new Line2D.Double(x, y, x + x1, y + y1);
      g2d.setStroke(bs);
      g2d.draw(line);
    }
    String sRand = "";
    String cTmp = "";
    int iTmp = 0;
    for (int i = 0; i < n; i++) {
      if ((r.nextInt(2) + 1) == 1) {
        iTmp = r.nextInt(10) + 48;
        cTmp = String.valueOf((char)iTmp);
      } else {
        iTmp = r.nextInt(26) + 65;
        cTmp = String.valueOf((char)iTmp);
      }
      sRand += cTmp;
      Color c = new Color(20 + r.nextInt(110), 20 + r.nextInt(110), 20 + r.nextInt(110));
      g.setColor(c);
      Graphics2D g2d_word = (Graphics2D)g;
      AffineTransform trans = new AffineTransform();
      trans.rotate(r.nextInt(45) * 3.14 / 180, 15 * i + 8, 7);
      float scaleSize = r.nextFloat() + 0.8f;
      if (scaleSize > 1f) {
        scaleSize = 1f;
      }
      trans.scale(scaleSize, scaleSize);
      g2d_word.setTransform(trans);
      g.drawString(cTmp, 15 * i + 18, 14);
    }
    scode = sRand;
    return image;
  }
  
  public static Color getRandColor(int s, int e) {
    Random ran = new Random();
    if (s > 255) s = 255;
    if (e > 255) e = 255;
    int r = s + ran.nextInt(e - s);
    int g = s + ran.nextInt(e - s);
    int b = s + ran.nextInt(e - s);
    return new Color(r, g, b);
  }
}
