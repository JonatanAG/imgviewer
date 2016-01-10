package kata6;
   
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay<T> extends ApplicationFrame{
    
    private final Histogram<T> histogram;

    public HistogramDisplay(Histogram<T> histogram) {
        super("");
        this.histogram = histogram;
        setContentPane(createPanel());
        pack();
    }

    private JPanel createPanel() {
           ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
           chartPanel.setPreferredSize(new Dimension(500,400));
           return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataset){
        JFreeChart chart = ChartFactory.createBarChart(
            "",
            "Dominios", 
            "Nº email", 
            dataset, 
            PlotOrientation.VERTICAL, 
            false, 
            false, 
            false
        );
        return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for (Object key : histogram.keySet()) {
            dataset.addValue(histogram.get(key), "", (Comparable) key);
        }
        
        return dataset;
    }
    
    public void execute (){
        setVisible(true);
    }
}