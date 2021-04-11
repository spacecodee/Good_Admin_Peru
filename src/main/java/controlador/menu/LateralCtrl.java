package controlador.menu;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LateralCtrl implements Initializable {
    @FXML
    private StackPane pnlDash2, pnlUsers2, pnlProveedores, pnlClients2, pnlProducts2, pnlReports2, pnlShops2, pnlInventory2;
    @FXML
    private Label lblDash, lblUsers, lblProveedores, lblCustomers, lblProductos, lblReports, lblVentas, lblInventory;

    //estaticos
    private static StackPane pnlDash = null, pnlUsers = null, pnlProveedores2, pnlClients, pnlProducts, pnlReports, pnlShops, pnlInventory;
    private static Label lblDash2, lblUsers2, lblProveedores2, lblCustomers2, lblProductos2, lblReports2, lblVentas2, lblInventory2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LateralCtrl.pnlDash = this.pnlDash2;
        LateralCtrl.lblDash2 = this.lblDash;

        LateralCtrl.pnlUsers = this.pnlUsers2;
        LateralCtrl.lblUsers2 = this.lblUsers;

        LateralCtrl.pnlProveedores2 = this.pnlProveedores;
        LateralCtrl.lblProveedores2 = this.lblProveedores;

        LateralCtrl.pnlClients = this.pnlClients2;
        LateralCtrl.lblCustomers2 = this.lblCustomers;

        LateralCtrl.pnlProducts = this.pnlProducts2;
        LateralCtrl.lblProductos2 = this.lblProductos;

        LateralCtrl.pnlReports = this.pnlReports2;
        LateralCtrl.lblReports2 = this.lblReports;

        LateralCtrl.pnlShops = this.pnlShops2;
        LateralCtrl.lblVentas2 = this.lblVentas;

        LateralCtrl.pnlInventory = this.pnlInventory2;
        LateralCtrl.lblInventory2 = this.lblInventory;
    }

    public static StackPane getPnlDash() {
        return pnlDash;
    }


    public static StackPane getPnlUsers() {
        return pnlUsers;
    }

    public static StackPane getPnlProveedores2() {
        return pnlProveedores2;
    }

    public static StackPane getPnlClients() {
        return pnlClients;
    }

    public static StackPane getPnlProducts() {
        return pnlProducts;
    }

    public static StackPane getPnlReports() {
        return pnlReports;
    }

    public static StackPane getPnlShops() {
        return pnlShops;
    }

    public static StackPane getPnlInventory() {
        return pnlInventory;
    }

    public static Label getLblDash2() {
        return lblDash2;
    }

    public static Label getLblUsers2() {
        return lblUsers2;
    }

    public static Label getLblProveedores2() {
        return lblProveedores2;
    }

    public static Label getLblCustomers2() {
        return lblCustomers2;
    }

    public static Label getLblProductos2() {
        return lblProductos2;
    }

    public static Label getLblReports2() {
        return lblReports2;
    }

    public static Label getLblVentas2() {
        return lblVentas2;
    }

    public static Label getLblInventory2() {
        return lblInventory2;
    }
}
