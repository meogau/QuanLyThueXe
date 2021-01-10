package dataAccess.entities;

public class Bike {
    private int id;
    private String bikeCode;
    private int bikeParkingId;
    private String name;
    private int status;
    private String description;
    private float price;
    private String image;

    public Bike(int id, int bikeParkingId, String name, int status, String description, float price) {
        this.id = id;
        this.bikeParkingId = bikeParkingId;
        this.name = name;
        this.status = status;
        this.description = description;
        this.price = price;
    }
    public Bike() {
    }

    public String getBikeCode() {
        return bikeCode;
    }

    public void setBikeCode(String bikeCode) {
        this.bikeCode = bikeCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBikeParkingId() {
        return bikeParkingId;
    }

    public void setBikeParkingId(int bikeParkingId) {
        this.bikeParkingId = bikeParkingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
