import java.io.File;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class PRACTICA48 {

    private static final String FILENAME = "autos.xml";

    public static void main(String[] args) {
        // Mostrar todos los coches
        mostrarCoches();

        // Agregar un nuevo coche
        agregarNuevoCoche();

        // Buscar un coche por ID
        buscarCochePorId("002");
    }

    // Función para mostrar todos los coches
    public static void mostrarCoches() {
        try {
            File inputFile = new File(FILENAME);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("auto");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element auto = (Element) nList.item(temp);
                System.out.println("ID: " + auto.getAttribute("id"));
                System.out.println("Marca: " + auto.getElementsByTagName("marca").item(0).getTextContent());
                System.out.println("Modelo: " + auto.getElementsByTagName("modelo").item(0).getTextContent());
                System.out.println("Año: " + auto.getElementsByTagName("año").item(0).getTextContent());
                System.out.println("Color: " + auto.getElementsByTagName("color").item(0).getTextContent());
                System.out.println("Tipo de Motor: " + auto.getElementsByTagName("tipo_motor").item(0).getTextContent());
                System.out.println("Cilindrada: " + auto.getElementsByTagName("cilindrada").item(0).getTextContent());
                System.out.println("Potencia: " + auto.getElementsByTagName("potencia").item(0).getTextContent());
                Element transmision = (Element) auto.getElementsByTagName("transmision").item(0);
                System.out.println("Transmisión: " + transmision.getElementsByTagName("tipo").item(0).getTextContent());
                System.out.println("Velocidades: " + transmision.getElementsByTagName("velocidades").item(0).getTextContent());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Función para agregar un nuevo coche
    public static void agregarNuevoCoche() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese los detalles del nuevo auto:");
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Marca: ");
            String marca = scanner.nextLine();
            System.out.print("Modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Año: ");
            String año = scanner.nextLine();
            System.out.print("Color: ");
            String color = scanner.nextLine();
            System.out.print("Tipo de Motor: ");
            String tipoMotor = scanner.nextLine();
            System.out.print("Cilindrada: ");
            String cilindrada = scanner.nextLine();
            System.out.print("Potencia: ");
            String potencia = scanner.nextLine();
            System.out.print("Tipo de Transmisión: ");
            String tipoTransmision = scanner.nextLine();
            System.out.print("Velocidades: ");
            String velocidades = scanner.nextLine();

            File inputFile = new File(FILENAME);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Element root = doc.getDocumentElement();

            Element nuevoAuto = doc.createElement("auto");
            nuevoAuto.setAttribute("id", id);

            Element marcaElem = doc.createElement("marca");
            marcaElem.appendChild(doc.createTextNode(marca));
            nuevoAuto.appendChild(marcaElem);

            Element modeloElem = doc.createElement("modelo");
            modeloElem.appendChild(doc.createTextNode(modelo));
            nuevoAuto.appendChild(modeloElem);

            Element añoElem = doc.createElement("año");
            añoElem.appendChild(doc.createTextNode(año));
            nuevoAuto.appendChild(añoElem);

            Element colorElem = doc.createElement("color");
            colorElem.appendChild(doc.createTextNode(color));
            nuevoAuto.appendChild(colorElem);

            Element tipoMotorElem = doc.createElement("tipo_motor");
            tipoMotorElem.appendChild(doc.createTextNode(tipoMotor));
            nuevoAuto.appendChild(tipoMotorElem);

            Element cilindradaElem = doc.createElement("cilindrada");
            cilindradaElem.appendChild(doc.createTextNode(cilindrada));
            nuevoAuto.appendChild(cilindradaElem);

            Element potenciaElem = doc.createElement("potencia");
            potenciaElem.appendChild(doc.createTextNode(potencia));
            nuevoAuto.appendChild(potenciaElem);

            Element transmisionElem = doc.createElement("transmision");
            Element tipoTransmisionElem = doc.createElement("tipo");
            tipoTransmisionElem.appendChild(doc.createTextNode(tipoTransmision));
            transmisionElem.appendChild(tipoTransmisionElem);
            Element velocidadesElem = doc.createElement("velocidades");
            velocidadesElem.appendChild(doc.createTextNode(velocidades));
            transmisionElem.appendChild(velocidadesElem);
            nuevoAuto.appendChild(transmisionElem);

            root.appendChild(nuevoAuto);

            // Guardar los cambios en el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(FILENAME));
            transformer.transform(source, result);

            System.out.println("Coche agregado exitosamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Función para buscar un coche por ID
    public static void buscarCochePorId(String id) {
        try {
            File inputFile = new File(FILENAME);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("auto");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element auto = (Element) nList.item(temp);
                if (auto.getAttribute("id").equals(id)) {
                    System.out.println("ID: " + auto.getAttribute("id"));
                    System.out.println("Marca: " + auto.getElementsByTagName("marca").item(0).getTextContent());
                    System.out.println("Modelo: " + auto.getElementsByTagName("modelo").item(0).getTextContent());
                    System.out.println("Año: " + auto.getElementsByTagName("año").item(0).getTextContent());
                    System.out.println("Color: " + auto.getElementsByTagName ("color").item(0).getTextContent());
                    System.out.println("Tipo de Motor: " + auto.getElementsByTagName("tipo_motor").item(0).getTextContent());
                    System.out.println("Cilindrada: " + auto.getElementsByTagName("cilindrada").item(0).getTextContent());
                    System.out.println("Potencia: " + auto.getElementsByTagName("potencia").item(0).getTextContent());
                    Element transmision = (Element) auto.getElementsByTagName("transmision").item(0);
                    System.out.println("Transmisión: " + transmision.getElementsByTagName("tipo").item(0).getTextContent());
                    System.out.println("Velocidades: " + transmision.getElementsByTagName("velocidades").item(0).getTextContent());
                    return;
                }
            }
            System.out.println("Coche con ID " + id + " no encontrado.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}