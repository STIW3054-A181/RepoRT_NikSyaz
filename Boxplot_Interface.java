package Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Boxplot_Interface extends JPanel
{
    /** Version id for serialization. */
    private static final long serialVersionUID = 8221256658243821951L;

    /** First corporate color used for normal coloring.*/
    protected static final Color COLOR1 = new Color( 200, 10, 200);

    /**
     * Performs basic initialization of an example,
     * like setting a default size.
     */
    public Boxplot_Interface()
    {
        super(new BorderLayout());
        setPreferredSize(new Dimension(700, 700));
        setBackground(Color.WHITE);
    }

    /**
     * Returns a short title for the example.
     * @return A title text.
     */
    public abstract String getTitle();
    /**
     * Opens a frame and shows the example in it.
     * @return the frame instance used for displaying the example.
     */
    protected JFrame showInFrame()
    {
        JFrame frame = new JFrame(getTitle());
        frame.getContentPane().add(this, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(getPreferredSize());
        frame.setVisible(true);
        return frame;
    }

    @Override
    public String toString()
    {
        return getTitle();
    }
}