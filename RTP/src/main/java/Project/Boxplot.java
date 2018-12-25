package Project;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Stroke;

import de.erichseifert.gral.data.DataSource;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.BoxPlot;
import de.erichseifert.gral.plots.BoxPlot.BoxWhiskerRenderer;
import de.erichseifert.gral.plots.XYPlot.XYNavigationDirection;
import de.erichseifert.gral.plots.colors.LinearGradient;
import de.erichseifert.gral.plots.colors.ScaledContinuousColorMapper;
import de.erichseifert.gral.ui.InteractivePanel;
import de.erichseifert.gral.util.DataUtils;
import de.erichseifert.gral.util.GraphicsUtils;
import de.erichseifert.gral.graphics.Insets2D;
import static Project.Zscore.callZscore;

public class Boxplot extends Boxplot_Interface
{
    /** Version id for serialization. */
    private static final long serialVersionUID = 5228891435595348789L;

    @SuppressWarnings("unchecked")
    public Boxplot()
    {
        try {
            setPreferredSize(new Dimension(400, 600));

            // Add all data of z score in DataTable
            DataTable data = new DataTable(Double.class);
            for (Zscore.ZscoreValue value : callZscore())
            {
                double zScore = value.getzScore();
                data.add(zScore);
            }

            // Create new box plot
            DataSource boxData = BoxPlot.createBoxData(data);
            BoxPlot plot = new BoxPlot(boxData);

            // Format plot
            plot.setInsets(new Insets2D.Double(20.0, 50.0, 40.0, 20.0));

            // Format axes
            plot.getAxisRenderer(BoxPlot.AXIS_X).setCustomTicks
                    (
                    DataUtils.map
                            (
                            new Double[]{1.0},
                            new String[]{"Botplot of Z score"}
                    )
            );

            // Format boxes
            Stroke stroke = new BasicStroke(2f);
            ScaledContinuousColorMapper colors =
                    new LinearGradient(GraphicsUtils.deriveBrighter(COLOR1), Color.WHITE);
            colors.setRange(1.0, 3.0);

            BoxWhiskerRenderer pointRenderer =
                    (BoxWhiskerRenderer) plot.getPointRenderers(boxData).get(0);
            pointRenderer.setWhiskerStroke(stroke);
            pointRenderer.setBoxBorderStroke(stroke);
            pointRenderer.setBoxBackground(colors);
            pointRenderer.setBoxBorderColor(COLOR1);
            pointRenderer.setWhiskerColor(COLOR1);
            pointRenderer.setCenterBarColor(COLOR1);

            plot.getNavigator().setDirection(XYNavigationDirection.VERTICAL);

            // Add plot to Swing component
            InteractivePanel panel = new InteractivePanel(plot);
            add(panel);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public String getTitle()
    {
        return "Box Plot";
    }
}