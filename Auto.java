import javax.xml.bind.*;

@XmlRootElement(name = "auto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Auto {
    @XmlAttribute(name = "id", required = true)
    private String id;
    @XmlElement(name = "marca")
    private String marca;
    @XmlElement(name = "modelo")
    private String modelo;
    @XmlElement(name = "año")
    private int año;
    @XmlElement(name = "color")
    private String color;
    @XmlElement(name = "tipo_motor")
    private String tipoMotor;
    @XmlElement(name = "cilindrada")
    private double cilindrada;
    @XmlElement(name = "potencia")
    private int potencia;
    @XmlElement(name = "transmision")
    private Transmision transmision;

    public Auto() {}

    public Auto(String id, String marca, String modelo, int año, String color, String tipoMotor, double cilindrada, int potencia, Transmision transmision) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.color = color;
        this.tipoMotor = tipoMotor;
        this.cilindrada = cilindrada;
        this.potencia = potencia;
        this.transmision = transmision;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public Transmision getTransmision() {
        return transmision;
    }

    public void setTransmision(Transmision transmision) {
        this.transmision = transmision;
    }
}

@XmlRootElement(name = "transmision")
@XmlAccessorType(XmlAccessType.FIELD)
class Transmision {
    @XmlElement(name = "tipo")
    private String tipo;
    @XmlElement(name = "velocidades")
    private int velocidades;

    public Transmision() {}

    public Transmision(String tipo, int velocidades) {
        this.tipo = tipo;
        this.velocidades = velocidades;
    }

    // Getters y Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getVelocidades() {
        return velocidades;
    }

    public void setVelocidades(int velocidades) {
        this.velocidades = velocidades;
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear un objeto Auto para probar
        Transmision transmision = new Transmision("automática", 10);
        Auto auto1 = new Auto("001", "Ford", "Mustang", 2023, "rojo", "V8", 5.0, 450, transmision);

        // Escribir el objeto Auto en XML
        try {
            JAXBContext context = JAXBContext.newInstance(Auto.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(auto1, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        // Leer un objeto Auto desde XML
        try {
            String xml = "<auto id=\"002\"><marca>Chevrolet</marca><modelo>Camaro</modelo><año>2024</año><color>azul</color><tipo_motor>V6</tipo_motor><cilindrada>3.6</cilindrada><potencia>335</potencia><transmision><tipo>manual</tipo><velocidades>6</velocidades></transmision></auto>";
            JAXBContext context = JAXBContext.newInstance(Auto.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Auto auto2 = (Auto) unmarshaller.unmarshal(new java.io.StringReader(xml));
            System.out.println("\nObjeto Auto leído desde XML:");
            System.out.println("ID: " + auto2.getId());
            System.out.println("Marca: " + auto2.getMarca());
            System.out.println("Modelo: " + auto2.getModelo());
            System.out.println("Año: " + auto2.getAño());
            System.out.println("Color: " + auto2.getColor());
            System.out.println("Tipo de motor: " + auto2.getTipoMotor());
            System.out.println("Cilindrada: " + auto2.getCilindrada());
            System.out.println("Potencia: " + auto2.getPotencia());
            Transmision transmision2 = auto2.getTransmision();
            System.out.println("Transmisión: " + transmision2.getTipo());
            System.out.println("Velocidades: " + transmision2.getVelocidades());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}