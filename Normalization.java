import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import java.util.List;
import java.util.TimerTask;
import java.util.Timer;
import java.util.concurrent.CopyOnWriteArrayList;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

public class Normalization {

         private static XYChart xyChart;
         private static List<Double> yData;

         public static final String SERIES_NAME = "Z score value";

         public static void test(){
             final SwingWrapper<XYChart> swingWrapper = new SwingWrapper<XYChart>(getChart());
             swingWrapper.displayChart();

             TimerTask chartUpdaterTask = new TimerTask() {
                 @Override
                 public void run() {
                     updateData();
                     javax.swing.SwingUtilities.invokeLater(new Runnable() {
                         @Override
                         public void run() {
                             swingWrapper.repaintChart();
                         }
                     });
                 }
             };

             Timer timer = new Timer();
             timer.scheduleAtFixedRate(chartUpdaterTask, 0, 1000);
         }

    public static XYChart getChart() {
        yData = applyZscore();
        xyChart = new XYChartBuilder()
                .width(500)
                .height(400)
                .theme(Styler.ChartTheme.Matlab)
                .title("Normalization Graph")
                .build();
        xyChart.addSeries(SERIES_NAME, null, yData);

        return xyChart;
    }

    private static List<Double> applyZscore() {
             List<Double> zScore = new CopyOnWriteArrayList<Double>();
             try {
                 for (ZscoreValue value : Zscore.callZscore()){
                     zScore.add(value.getzScore());
                 }
             } catch (Exception e) {
                 e.printStackTrace();
             }
             return zScore;
    }

    private static void updateData() {
             List<Double> newData = applyZscore();
             yData.addAll(newData);

             while (yData.size() > 26){
                 yData.remove(0);
             }
             xyChart.updateXYSeries(SERIES_NAME, null, yData, null);
    }

    double[] xData = new double[] { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16 };

        // Create Chart
        //XYChart chart = QuickChart.getChart("Normalization Graph", "X", "Y", "y(x)", xData, yData);

        // Show it


        // Save it
        //BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapEncoder.BitmapFormat.PNG);

        // or save it in high-res
        //BitmapEncoder.saveBitmapWithDPI(chart, "./Sample_Chart_300_DPI", BitmapEncoder.BitmapFormat.PNG, 300);
    }




