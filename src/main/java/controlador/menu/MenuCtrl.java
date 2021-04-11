package controlador.menu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import recursos.AddImgR;
import vista.menu.MenuV;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuCtrl implements Initializable {
    private boolean flag = true;
    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private ImageView btnMinimize, btnMaxiMin, btnClose;
    @FXML
    private BorderPane pnlContent, pnlCenter;
    @FXML
    private ImageView btbDash, btnUsers, btnProveedores, btnCustomers, btnProducts, btnReports, btnShops, btnInventory, imgLogo, btnMenu;
    @FXML
    private StackPane pnlDash, pnlUsers, pnlProveedores, pnlClients, pnlProducts, pnlReports, pnlShops, pnlInventory;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        AddImgR.AddImg("close.png", this.btnClose);
        AddImgR.AddImg("minimize.png", this.btnMinimize);
        AddImgR.AddImg("maximize.png", this.btnMaxiMin);

        AddImgR.AddImg("menu/dashboard.png", this.btbDash);
        AddImgR.AddImg("menu/users.png", this.btnUsers);
        AddImgR.AddImg("menu/proveedores.png", this.btnProveedores);
        AddImgR.AddImg("menu/customers.png", this.btnCustomers);
        AddImgR.AddImg("menu/productos.png", this.btnProducts);
        AddImgR.AddImg("menu/reports.png", this.btnReports);
        AddImgR.AddImg("menu/shops.png", this.btnShops);
        AddImgR.AddImg("menu/inventory.png", this.btnInventory);
        AddImgR.AddImg("menu/menu.png", this.btnMenu);

        AddImgR.AddImg("logo.png", this.imgLogo);

        this.movePanel();
        this.addDashboard();
    }

    private void movePanel() {
        pnlContent.setOnMousePressed(e -> {
            xOffset = e.getSceneX();
            yOffset = e.getSceneY();

        });
        pnlContent.setOnMouseDragged(event -> {
            MenuV.stage1.setX(event.getScreenX() - xOffset);
            MenuV.stage1.setY(event.getScreenY() - yOffset);
            MenuV.stage1.setOpacity(0.7f);
        });
        pnlContent.setOnDragDone((e) -> MenuV.stage1.setOpacity(1.0f));
        pnlContent.setOnMouseReleased((e) -> MenuV.stage1.setOpacity(1.0f));


    }

    @FXML
    public void btnCloseOnClick(MouseEvent event) {
        if (event.getSource() == this.btnClose) {
            Stage stage = (Stage) this.btnClose.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    public void btnMaxiMin(MouseEvent event) {
        if (event.getSource() == this.btnMaxiMin) {
            Stage stage = (Stage) this.btnMaxiMin.getScene().getWindow();
            //Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();

            stage.setFullScreen(!stage.isFullScreen());
            if (stage.isFullScreen()) {
                AddImgR.AddImg("retraer.png", this.btnMaxiMin);

                this.pnlContent.setStyle("-fx-background-radius: 0px");
            } else {
                AddImgR.AddImg("maximize.png", this.btnMaxiMin);
                this.pnlContent.setStyle("-fx-background-radius: 20px");
            }
        }
    }

    @FXML
    public void btnMinimizeOnClick(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    public void btnMenuOcClick(MouseEvent e) throws IOException {
        if (e.getSource() == this.btnMenu) {
            if (flag) {
                Parent sidebar = FXMLLoader.load(getClass().getResource("/vistafxml/menu/lateralmenu.fxml"));
                pnlCenter.setLeft(sidebar);
                flag = false;
            } else {
                pnlCenter.setLeft(null);
                flag = true;
            }
        }

    }

    private void addDashboard() {
        try {
            Parent sidebar = FXMLLoader.load(getClass().getResource("/vistafxml/menu/dashboard/dashboardinit.fxml"));
            pnlCenter.setCenter(sidebar);

        } catch (Exception e) {
            e.printStackTrace(System.out);
            System.out.println("Al parecer no se pudo cargar el dashboard");
        }
    }

    //dashboard
    @FXML
    public void pnlDashOnEntered(MouseEvent e) {
        if (e.getSource() == this.pnlDash) {
            if (this.pnlCenter.getLeft() != null) {
                LateralCtrl.getPnlDash().setStyle("-fx-background-color: #0AAF60");
                LateralCtrl.getLblDash2().setStyle("-fx-text-fill: #EFECEE");
            }
        }
    }

    @FXML
    public void pnlDashOnExited(MouseEvent e) {
        if (e.getSource() == this.pnlDash) {
            if (this.pnlCenter.getLeft() != null) {
                LateralCtrl.getPnlDash().setStyle("-fx-background-color: #EFECEE");
                LateralCtrl.getLblDash2().setStyle("-fx-text-fill: #252525");
            }
        }
    }

    //usuarios
    @FXML
    public void pnlUsersOnEntered(MouseEvent e) {
        if (e.getSource() == this.pnlUsers) {
            if (this.pnlCenter.getLeft() != null) {
                LateralCtrl.getPnlUsers().setStyle("-fx-background-color: #0AAF60");
                LateralCtrl.getLblUsers2().setStyle("-fx-text-fill: #EFECEE");
            }
        }
    }

    @FXML
    public void pnlUsersOnExited(MouseEvent e) {
        if (e.getSource() == this.pnlUsers) {
            if (this.pnlCenter.getLeft() != null) {
                LateralCtrl.getPnlUsers().setStyle("-fx-background-color: #EFECEE");
                LateralCtrl.getLblUsers2().setStyle("-fx-text-fill: #252525");
            }
        }
    }

    //proveedores
    @FXML
    public void pnlProveedoresOnEntered(MouseEvent e) {
        if (e.getSource() == this.pnlProveedores) {
            if (this.pnlCenter.getLeft() != null) {
                LateralCtrl.getPnlProveedores2().setStyle("-fx-background-color: #0AAF60");
                LateralCtrl.getLblProveedores2().setStyle("-fx-text-fill: #EFECEE");
            }
        }
    }

    @FXML
    public void pnlProveedoresOnExited(MouseEvent e) {
        if (e.getSource() == this.pnlProveedores) {
            if (this.pnlCenter.getLeft() != null) {
                LateralCtrl.getPnlProveedores2().setStyle("-fx-background-color: #EFECEE");
                LateralCtrl.getLblProveedores2().setStyle("-fx-text-fill: #252525");
            }
        }
    }

    //clientes
    @FXML
    public void pnlClientsOnEntered(MouseEvent e) {
        if (e.getSource() == this.pnlClients) {
            if (this.pnlCenter.getLeft() != null) {
                LateralCtrl.getPnlClients().setStyle("-fx-background-color: #0AAF60");
                LateralCtrl.getLblCustomers2().setStyle("-fx-text-fill: #EFECEE");
            }
        }
    }

    @FXML
    public void pnlClientsOnExited(MouseEvent e) {
        if (e.getSource() == this.pnlClients) {
            if (this.pnlCenter.getLeft() != null) {
                LateralCtrl.getPnlClients().setStyle("-fx-background-color: #EFECEE");
                LateralCtrl.getLblCustomers2().setStyle("-fx-text-fill: #252525");
            }
        }
    }

    //productos
    @FXML
    public void pnlProductsOnEntered(MouseEvent e) {
        if (e.getSource() == this.pnlProducts) {
            if (this.pnlCenter.getLeft() != null) {
                LateralCtrl.getPnlProducts().setStyle("-fx-background-color: #0AAF60");
                LateralCtrl.getLblProductos2().setStyle("-fx-text-fill: #EFECEE");
            }
        }
    }

    @FXML
    public void pnlProductsOnExited(MouseEvent e) {
        if (e.getSource() == this.pnlProducts) {
            if (this.pnlCenter.getLeft() != null) {
                LateralCtrl.getPnlProducts().setStyle("-fx-background-color: #EFECEE");
                LateralCtrl.getLblProductos2().setStyle("-fx-text-fill: #252525");
            }
        }
    }

    //reportes
    @FXML
    public void pnlReportsOnEntered(MouseEvent e) {
        if (e.getSource() == this.pnlReports) {
            if (this.pnlCenter.getLeft() != null) {
                LateralCtrl.getPnlReports().setStyle("-fx-background-color: #0AAF60");
                LateralCtrl.getLblReports2().setStyle("-fx-text-fill: #EFECEE");
            }
        }
    }

    @FXML
    public void pnlReportsOnExited(MouseEvent e) {
        if (e.getSource() == this.pnlReports) {
            if (this.pnlCenter.getLeft() != null) {
                LateralCtrl.getPnlReports().setStyle("-fx-background-color: #EFECEE");
                LateralCtrl.getLblReports2().setStyle("-fx-text-fill: #252525");
            }
        }
    }

    //ventas
    @FXML
    public void pnlShopsOnEntered(MouseEvent e) {
        if (e.getSource() == this.pnlShops) {
            if (this.pnlCenter.getLeft() != null) {
                LateralCtrl.getPnlShops().setStyle("-fx-background-color: #0AAF60");
                LateralCtrl.getLblVentas2().setStyle("-fx-text-fill: #EFECEE");
            }
        }
    }

    @FXML
    public void pnlShopsOnExited(MouseEvent e) {
        if (e.getSource() == this.pnlShops) {
            if (this.pnlCenter.getLeft() != null) {
                LateralCtrl.getPnlShops().setStyle("-fx-background-color: #EFECEE");
                LateralCtrl.getLblVentas2().setStyle("-fx-text-fill: #252525");
            }
        }
    }

    //inventario
    @FXML
    public void pnlInventoryOnEntered(MouseEvent e) {
        if (e.getSource() == this.pnlInventory) {
            if (this.pnlCenter.getLeft() != null) {
                LateralCtrl.getPnlInventory().setStyle("-fx-background-color: #0AAF60");
                LateralCtrl.getLblInventory2().setStyle("-fx-text-fill: #EFECEE");
            }
        }
    }

    @FXML
    public void pnlInventoryOnExited(MouseEvent e) {
        if (e.getSource() == this.pnlInventory) {
            if (this.pnlCenter.getLeft() != null) {
                LateralCtrl.getPnlInventory().setStyle("-fx-background-color: #EFECEE");
                LateralCtrl.getLblInventory2().setStyle("-fx-text-fill: #252525");
            }
        }
    }
}
