/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import services.CRUDReclamation;
import utils.MyDB;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;




/**
 *
 * @author lenovo
 */
public class BarChar extends org.jfree.ui.ApplicationFrame {


    public BarChar(final String title) throws IOException, SQLException {
       
        super(title);

        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(400,400));
        setContentPane(chartPanel);

    }


   private CategoryDataset createDataset() throws  IOException, SQLException {

                // 0. Création d'un diagramme.
          DefaultCategoryDataset dataset = new DefaultCategoryDataset();
               MyDB mc = MyDB.getInstance();

          


         Double d;
         String ch;
//        try {
//            try {
//                Connexion.rs = Connexion.st.executeQuery("select * from marchandise");
//            } catch (SQLException ex) {
//
//            }
//            while (Connexion.rs.next()) {
//                d=Connexion.rs.getDouble(2);
//                ch=Connexion.rs.getString(1);
//                System.out.println(""+d);
//                System.out.println(""+ch);
//              dataset.addValue(d, ch, "");
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("    nndxc,;kx");
//        }

        CRUDReclamation Rec = new CRUDReclamation();
   List<Integer> list = Rec.getCountByCategory();
                dataset.addValue(list.get(0), "Chauffeur", " ");
                dataset.addValue(list.get(1), "Admin", " ");
                dataset.addValue(list.get(2), "Voyageur", " ");
                //dataset.addValue(19, "Taux de couverture Incar", " ");"Chauffeur","Admin","Voyageur"
        return dataset;

    }

    private JFreeChart createChart(final CategoryDataset dataset) {

        final JFreeChart chart = ChartFactory.createBarChart(
            " Categories ",      // chart title
            " ",               // domain axis label
            "  Le nombre de reclamations abouties ",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips
            true                     // urls
        );

        final CategoryPlot plot = chart.getCategoryPlot();
        final CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI /2.0)
        );

//        final CategoryItemRenderer renderer = plot.getRenderer();
//        renderer.setItemLabelsVisible(true);
//        final BarRenderer r = (BarRenderer) renderer;
 
    

        return chart;

    }

   
    public static void main(final String[] args) throws IOException, SQLException {

        final BarChar demo = new BarChar("Statistiques sur les categories des reclamations");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }


}
