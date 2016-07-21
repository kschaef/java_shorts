package shorts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class fern extends ApplicationFrame {

    private static final Random r = new Random();

    private static XYDataset createDataset() {
        XYSeriesCollection result = new XYSeriesCollection();
        XYSeries series = new XYSeries("Random");
        Double a, b, c, d, e, f;
        Double x = 0.;
        Double y = 0.;
        series.add(x, y);

        for (int i = 0; i <= 10000; i++) {
            double rand = r.nextDouble();
            if (rand < 0.01) {
                a = b = c = e = f = 0.;
                d = 0.16;
            } else if (rand < 0.86) {
                a = d = 0.85;
                b = 0.04;
                c = -0.04;
                e = 0.;
                f = 1.6;
            } else if (rand < 0.93) {
                a = 0.2;
                b = -0.26;
                c = 0.23;
                d = 0.22;
                e = 0.;
                f = 1.6;
            } else {
                a = -0.15;
                b = 0.28;
                c = 0.26;
                d = 0.24;
                e = 0.;
                f = 0.44;
            }

            x = a * x + b * y + e;
            y = c * x + d * y + f;
            series.add(x, y);
        }
        result.addSeries(series);
        return result;
    }

    public static JPanel createPanel() {
        XYDataset data = createDataset();
        JFreeChart chart = ChartFactory.createScatterPlot(
                "Fern", // chart title
                "", // x axis label
                "", // y axis label
                data, // data
                PlotOrientation.VERTICAL,
                false, // include legend
                false, // tooltips
                false // urls
        );
        XYPlot xyPlot = (XYPlot) chart.getPlot();
        XYItemRenderer renderer = xyPlot.getRenderer();
        xyPlot.setBackgroundPaint(Color.white);
        renderer.setSeriesPaint(0, Color.green);
        Shape shape = new Ellipse2D.Double(0,0,2,2);
        renderer.setSeriesShape(0, shape);

        ValueAxis domain = xyPlot.getDomainAxis();
        domain.setVisible(false);
        ValueAxis range = xyPlot.getRangeAxis();
        range.setVisible(false);

        return new ChartPanel(chart);
    }

    public fern(String s) {
        super(s);
        JPanel jpanel = createPanel();
        jpanel.setPreferredSize(new Dimension(600, 700));
        add(jpanel);
    }

    public static void main(String[] args) {
        // create a dataset...
        XYDataset fernData = createDataset();

        // create a chart...
        fern plotFern = new fern("This is a Fern");
        plotFern.pack();
        RefineryUtilities.centerFrameOnScreen(plotFern);
        plotFern.setVisible(true);


    }
}