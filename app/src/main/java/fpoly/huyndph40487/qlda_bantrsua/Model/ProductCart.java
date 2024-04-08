package fpoly.huyndph40487.qlda_bantrsua.Model;

public class ProductCart {

    String name, anh;
    int id, soLuong, size, topping, ice, sugar, status;
    double gia;

    public ProductCart() {
    }

    public ProductCart(int id, String name, double gia, String anh, int soLuong, int size, int topping, int ice, int sugar, int status) {
        this.id = id;
        this.name = name;
        this.gia = gia;
        this.anh = anh;
        this.soLuong = soLuong;
        this.size = size;
        this.topping = topping;
        this.ice = ice;
        this.sugar = sugar;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTopping() {
        return topping;
    }

    public void setTopping(int topping) {
        this.topping = topping;
    }

    public int getIce() {
        return ice;
    }

    public void setIce(int ice) {
        this.ice = ice;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
