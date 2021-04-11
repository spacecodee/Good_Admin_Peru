package controlador.menu.dashboard;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardCtrl implements Initializable {
    @FXML
    private LineChart<?, ?> totalVentas;
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;
    @FXML
    private PieChart pieCPSales;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.iniLineChart();
        this.iniPieChart();

    }

    private void iniLineChart() {
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data<>("Enero", 4));
        series.getData().add(new XYChart.Data<>("Febrero", 14));
        series.getData().add(new XYChart.Data<>("Marzo", 24));
        series.getData().add(new XYChart.Data<>("Abril", 34));
        series.getData().add(new XYChart.Data<>("Mayo", 24));
        series.getData().add(new XYChart.Data<>("Junio", 54));
        series.getData().add(new XYChart.Data<>("Julio", 46));
        series.getData().add(new XYChart.Data<>("Agosto", 34));
        series.getData().add(new XYChart.Data<>("Septiembre", 24));
        series.getData().add(new XYChart.Data<>("Octubre", 74));
        series.getData().add(new XYChart.Data<>("Noviembre", 64));
        series.getData().add(new XYChart.Data<>("Diciembre", 54));

        XYChart.Series series2 = new XYChart.Series();
        series2.getData().add(new XYChart.Data<>("Enero", 14));
        series2.getData().add(new XYChart.Data<>("Febrero", 114));
        series2.getData().add(new XYChart.Data<>("Marzo", 154));
        series2.getData().add(new XYChart.Data<>("Abril", 134));
        series2.getData().add(new XYChart.Data<>("Mayo", 41));
        series2.getData().add(new XYChart.Data<>("Junio", 154));
        series2.getData().add(new XYChart.Data<>("Julio", 114));
        series2.getData().add(new XYChart.Data<>("Agosto", 174));
        series2.getData().add(new XYChart.Data<>("Septiembre", 124));
        series2.getData().add(new XYChart.Data<>("Octubre", 164));
        series2.getData().add(new XYChart.Data<>("Noviembre", 134));
        series2.getData().add(new XYChart.Data<>("Diciembre", 154));
        this.totalVentas.getData().addAll(series, series2);
        this.totalVentas.lookup(".chart-plot-background").setStyle("-fx-background-color: transparent");
        series.getNode().setStyle("-fx-stroke: #0AAF60");
    }

    private void iniPieChart() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Productos mas vendidos", 60),
                new PieChart.Data("Productos menos vendidos", 20),
                new PieChart.Data("Productos con mas stock vendidos", 250),
                new PieChart.Data("Productos con menos stock vendidos", 15)
        );
        this.pieCPSales.setData(pieChartData);
    }
}
