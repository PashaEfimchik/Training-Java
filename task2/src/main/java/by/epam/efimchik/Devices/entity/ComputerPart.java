package by.epam.efimchik.Devices.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.Objects;

@XmlRootElement(name="Devices")
public class ComputerPart {

    @XmlAttribute
    private int id;

    @XmlAttribute
    private String name;

    @XmlAttribute
    private String origin;

    @XmlAttribute
    private float price;

    @XmlAttribute
    private Peripheral peripheral;

    @XmlAttribute
    private float powerUsage;

    @XmlAttribute
    private boolean cooler;

    @XmlAttribute
    private Group group;

    @XmlElement(name = "port")
    private Port port;

    @XmlAttribute
    private boolean critical;

    @XmlAttribute
    private LocalDateTime dateTime;

    public ComputerPart(int id, String name, String origin, float price, Peripheral peripheral, float powerUsage, boolean cooler, Group group, Port port, boolean critical, LocalDateTime dateTime) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.price = price;
        this.peripheral = peripheral;
        this.powerUsage = powerUsage;
        this.cooler = cooler;
        this.group = group;
        this.port = port;
        this.critical = critical;
        this.dateTime = dateTime;
    }

    public LocalDateTime getDate() {
        return dateTime;
    }

    public void setDate(LocalDateTime date) {
        this.dateTime = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputerPart that = (ComputerPart) o;
        return id == that.id && Float.compare(that.price, price) == 0 && Float.compare(that.powerUsage, powerUsage) == 0 && cooler == that.cooler && critical == that.critical && Objects.equals(name, that.name) && Objects.equals(origin, that.origin) && peripheral == that.peripheral && group == that.group && port == that.port && Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, origin, price, peripheral, powerUsage, cooler, group, port, critical, dateTime);
    }

    @Override
    public String toString() {
        return "ComputerPart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", price=" + price +
                ", peripheral=" + peripheral +
                ", powerUsage=" + powerUsage +
                ", cooler=" + cooler +
                ", group=" + group +
                ", port=" + port +
                ", critical=" + critical +
                ", date=" + dateTime +
                '}';
    }

    public ComputerPart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Peripheral getPeripheral() {
        return peripheral;
    }

    public void setPeripheral(Peripheral peripheral) {
        this.peripheral = peripheral;
    }

    public float getPowerUsage() {
        return powerUsage;
    }

    public void setPowerUsage(float powerUsage) {
        this.powerUsage = powerUsage;
    }

    public boolean isCooler() {
        return cooler;
    }

    public void setCooler(boolean cooler) {
        this.cooler = cooler;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    public boolean isCritical() {
        return critical;
    }

    public void setCritical(boolean critical) {
        this.critical = critical;
    }

}
