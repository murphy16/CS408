import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Test {
	/* Solarized Theme */
    /* 								     Hex		    Light          Dark      */
    /*								   ========	   ============== ============== */
    public static final int BASE03  =  0x002B36; //nothing 		  background
    public static final int BASE02  =  0x073642; //nothing		  bg highlight
    public static final int BASE01  =  0x586E75; //emphasized     comments
    public static final int BASE00  =  0x657B83; //body text	  nothing
    public static final int BASE0   =  0x839496; //nothing   	  body text
    public static final int BASE1   =  0x93A1A1; //comments		  emphasized
    public static final int BASE2   =  0xEEE8D5; //bg highlight   nothing
    public static final int BASE3   =  0xFDF6E3; //bg			  nothing
    public static final int YELLOW  =  0xB58900;
    public static final int ORANGE  =  0xCB4B16;
    public static final int RED     =  0xDC322F;
    public static final int MAGENTA =  0xD33682;
    public static final int VIOLET  =  0x6C71C4;
    public static final int BLUE    =  0x268BD2;
    public static final int CYAN    =  0x2AA198;
    public static final int GREEN   =  0x859900;
    
    
    

    /**
     * Default constructor for Test.class
     */
    public Test() {
        initComponents();
    }

    public static void main(String[] args) {

        /**
         * Create GUI and components on Event-Dispatch-Thread
         */
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Test test = new Test();
            }
        });
    }

    /**
     * Initialize GUI and components (including ActionListeners etc)
     */
    private void initComponents() {
        JFrame jFrame = new JFrame();
        jFrame.setSize(500, 500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JCheckBoxMenuItem cbMenuItem;

        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the File menu.
        menu = new JMenu("File");
        menuBar.add(menu);

        //a group of JMenuItems
        menuItem = new JMenuItem("New");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Open...");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        menu.add(menuItem);

        cbMenuItem = new JCheckBoxMenuItem("Word Wrap", false);
        menu.add(cbMenuItem);

        jFrame.setJMenuBar(menuBar);
        
        
        
        StyledDocument doc = (StyledDocument) new DefaultStyledDocument();
        JTextPane textPane = new JTextPane(doc);
        JPanel noWrapPanel = new JPanel(new BorderLayout());
        noWrapPanel.add(textPane);
        JScrollPane jScroll = new JScrollPane(noWrapPanel);
//        LinePainter lp = new LinePainter(textPane);
        TextLineNumber tln = new TextLineNumber(textPane);
        jScroll.setRowHeaderView( tln );
        
        textPane.setSize(500, 500);
        textPane.setBackground(new Color(BASE3));
        textPane.setForeground(new Color(BASE00));
        Font font = new Font("Courier", 0, 14);
        textPane.setFont(font);
        textPane.setText("Hello, world! :)");

        //create necessary styles for various characters
        javax.swing.text.Style comment = textPane.addStyle("comment", null);
        StyleConstants.setForeground(comment, new Color(BASE1));
        
        javax.swing.text.Style primary = textPane.addStyle("primary", null);
        StyleConstants.setForeground(primary, new Color(BASE00));
        
        javax.swing.text.Style yellow = textPane.addStyle("yellow", null);
        StyleConstants.setForeground(yellow, new Color(YELLOW));

        javax.swing.text.Style orange = textPane.addStyle("orange", null);
        StyleConstants.setForeground(orange, new Color(ORANGE));

        javax.swing.text.Style red = textPane.addStyle("red", null);
        StyleConstants.setForeground(red, new Color(RED));

        javax.swing.text.Style magenta = textPane.addStyle("magenta", null);
        StyleConstants.setForeground(magenta, new Color(MAGENTA));

        javax.swing.text.Style violet = textPane.addStyle("violet", null);
        StyleConstants.setForeground(violet, new Color(VIOLET));

        javax.swing.text.Style blue = textPane.addStyle("blue", null);
        StyleConstants.setForeground(blue, new Color(BLUE));

        javax.swing.text.Style cyan = textPane.addStyle("cyan", null);
        StyleConstants.setForeground(cyan, new Color(CYAN));

        javax.swing.text.Style green = textPane.addStyle("green", null);
        StyleConstants.setForeground(green, new Color(GREEN));

        //get all text
        String text = textPane.getText();



        doc.setCharacterAttributes(2, 1, textPane.getStyle("green"), true);

        jFrame.add(jScroll);
        jFrame.setVisible(true);

        doc.setCharacterAttributes(5, 1, textPane.getStyle("blue"), true);
    }
}