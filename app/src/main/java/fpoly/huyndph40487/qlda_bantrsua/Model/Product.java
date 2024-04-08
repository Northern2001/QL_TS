package fpoly.huyndph40487.qlda_bantrsua.Model;

public class Product {
    private int id;
    private String name;
    private int gia;

    private String img;

    public Product(int id, String name, int gia, String img) {
        this.id = id;
        this.name = name;
        this.gia = gia;
        this.img = img;
    }


    public Product( String name, int gia) {
        this.name = name;
        this.gia = gia;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
