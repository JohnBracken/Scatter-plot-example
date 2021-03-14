/*  The following code shows an example of generating an XY scatter plot
using the JFreeChart package for the Java programming language.*/
package scatterplotexample;

//Libraries needed to make the scatter plot.
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.ShapeUtilities;

//General class to make the XY scatter plot.
public class ScatterPlotExample extends ApplicationFrame
{
   //Constructor method for the scatter plot. 
    public ScatterPlotExample(String title) {
        
        //Put the title in plot application frame.
        super(title);
        
        /*Create the XY dataset using the return arguement from the 
        createDataset() method.*/
        XYDataset dataset = createDataset();
        
        /*Create the scatter schart object using the createChart method
        and the dataset as an input arguement. */
        JFreeChart chart = createChart(dataset);
        
        /*Create a panel on which to display the chart, also using the chart
        object itself as an input arguement. */
        ChartPanel chartPanel = new ChartPanel(chart);
        
        //Set the size of the display panel for the chart.
        chartPanel.setPreferredSize(new java.awt.Dimension(400,400));
        
        //Put the chart panel onto the application frame.
        setContentPane(chartPanel);
    }
    
    //Method to create and return a dataset for the scatter plot.
    private static XYDataset createDataset()
    {
        /*Create the data series for the plot which in this
        case is data to show points on a cubic polynomial.*/
        XYSeries dataseries = new XYSeries("Data Series");
        dataseries.add(-3.0, -27.0);
        dataseries.add(-2.0, -8.0);
        dataseries.add(-1.0, -1.0);
        dataseries.add(0, 0);
        dataseries.add(1.0, 1.0);
        dataseries.add(2.0, 8.0);
        dataseries.add(3.0, 27.0);
        
        //Put the data into a dataset object and return the dataset.
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(dataseries);
        
        return dataset;
    }
    
    
    private static JFreeChart createChart(XYDataset dataset) 
    {
        // create the chart...
        JFreeChart chart = ChartFactory.createXYLineChart(
        "Cubic polynomial line chart", // chart title
        "X", // x axis label
        "Y", // y axis label
        dataset, // data
        PlotOrientation.VERTICAL,
        false, //  no legend
        true, // tooltips
        false // urls        
       );

        //Create a plot reference to customize the plot even more.
        XYPlot plot = (XYPlot) chart.getPlot();
        
        //Set the plot background color to be light gray.
        plot.setBackgroundPaint(Color.lightGray);
        
        /*Create a rendering object for the reference to the plot.  
        This object allows one to change marker and line properties 
        on the plot.*/
        XYLineAndShapeRenderer renderer =
                (XYLineAndShapeRenderer) plot.getRenderer();
        
        /*Set the marker shape for the series to be an up triangle of
        size 8.*/
        renderer.setSeriesShape(0, ShapeUtilities.createUpTriangle(8));
               
        //Set the series such that the markers are visible.
        renderer.setSeriesShapesVisible(0, true);
        
        //Turn off the line, show only the markers.
        renderer.setSeriesLinesVisible(0, false);
               
        //Set the markers so that they are filled.
        renderer.setSeriesShapesFilled(0,true);
        
        //Set the color of the data series.
        renderer.setSeriesPaint(0,Color.MAGENTA);
               
       return chart;  
    }
    
   
    //Call the main function to generate a cubic polynomial line chart object.
    public static void main(String[] args) 
    {
       //Create the scatter plot object.
        ScatterPlotExample cubic = new ScatterPlotExample("Cubic polynomial");
       cubic.pack();
       
       //Center the plot on the screen and make the plot visible.
       RefineryUtilities.centerFrameOnScreen(cubic);
       cubic.setVisible(true);
    }
    
}
