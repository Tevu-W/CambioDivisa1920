package dad.javafx.cambioDivisa;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CambioDivisa extends Application {

	private TextField campo1, campo2;
	private ComboBox<String> cajaCombo1, cajaCombo2;
	private Button cambiar;
	Divisa euro = new Divisa("Euro", 1.0);
	Divisa libra = new Divisa("Libra", 0.8873);
	Divisa dolar = new Divisa("Dolar", 1.2007);
	Divisa yen = new Divisa("Yen", 133.59);
	Divisa origen = null, destino = null;
	Double cantidad;
	Alert alert = new Alert(AlertType.ERROR);

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		campo1 = new TextField();
		campo1.setMaxWidth(80);

		campo2 = new TextField();
		campo2.setMaxWidth(80);
		campo2.setEditable(false);

		cajaCombo1 = new ComboBox<String>();
		//cajaCombo1.setPromptText("Elige");
		cajaCombo1.getItems().addAll("Euro", "Libra", "Dolar", "Yen");
		cajaCombo1.setValue("Elige");

		cajaCombo2 = new ComboBox<String>();
		//cajaCombo2.setPromptText("Elige");
		cajaCombo2.getItems().addAll("Euro", "Libra", "Dolar", "Yen");
		cajaCombo2.setValue("Elige");

		cambiar = new Button("Cambiar");
		cambiar.setDefaultButton(true);
		cambiar.setOnAction(e -> conversion(e));

		HBox caja1 = new HBox(5, campo1, cajaCombo1);
		caja1.setAlignment(Pos.CENTER);

		HBox caja2 = new HBox(5, campo2, cajaCombo2);
		caja2.setAlignment(Pos.CENTER);

		VBox root = new VBox(5, caja1, caja2, cambiar);
		root.setAlignment(Pos.CENTER);

		Scene scene = new Scene(root, 320, 200);

		primaryStage.setTitle("CambioDivisa");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void conversion(ActionEvent e) {

		String origenBox = cajaCombo1.getSelectionModel().getSelectedItem();
		String destinoBox = cajaCombo2.getSelectionModel().getSelectedItem();
		Double datocampo2 = null;
		
		try {
			cantidad = Double.parseDouble(campo1.getText());
		}catch(NumberFormatException p) {
			alert.setContentText("Error");
			alert.showAndWait();
		}

		switch (origenBox) {
		case "Euro":
			origen = euro;
			if (destinoBox.equals("Libra")) {
				destino = libra;
				datocampo2 = destino.fromEuro(origen.toEuro(cantidad));
			} else if (destinoBox.equals("Dolar")) {
				destino = dolar;
				datocampo2 = destino.fromEuro(origen.toEuro(cantidad));
			} else if (destinoBox.equals("Yen")) {
				destino = yen;
				datocampo2 = destino.fromEuro(origen.toEuro(cantidad));
			}
			campo2.setPromptText(Double.toString(datocampo2));
			break;

		case "Libra":
			origen = libra;
			if (destinoBox.equals("Euro")) {
				destino = euro;
				datocampo2 = destino.fromEuro(origen.toEuro(cantidad));
			} else if (destinoBox.equals("Dolar")) {
				destino = dolar;
				datocampo2 = destino.fromEuro(origen.toEuro(cantidad));
			} else if (destinoBox.equals("Yen")) {
				destino = yen;
				datocampo2 = destino.fromEuro(origen.toEuro(cantidad));
			}
			campo2.setPromptText(Double.toString(datocampo2));
			break;

		case "Dolar":
			origen = dolar;
			if (destinoBox.equals("Euro")) {
				destino = euro;
				datocampo2 = destino.fromEuro(origen.toEuro(cantidad));
			} else if (destinoBox.equals("Dolar")) {
				destino = dolar;
				datocampo2 = destino.fromEuro(origen.toEuro(cantidad));
			} else if (destinoBox.equals("Yen")) {
				destino = yen;
				datocampo2 = destino.fromEuro(origen.toEuro(cantidad));
			}
			campo2.setPromptText(Double.toString(datocampo2));
			break;

		case "Yen":
			origen = yen;
			if (destinoBox.equals("Euro")) {
				destino = euro;
				datocampo2 = destino.fromEuro(origen.toEuro(cantidad));
			} else if (destinoBox.equals("Dolar")) {
				destino = dolar;
				datocampo2 = destino.fromEuro(origen.toEuro(cantidad));
			} else if (destinoBox.equals("Libra")) {
				destino = libra;
				datocampo2 = destino.fromEuro(origen.toEuro(cantidad));
			}
			campo2.setPromptText(Double.toString(datocampo2));
			break;

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
