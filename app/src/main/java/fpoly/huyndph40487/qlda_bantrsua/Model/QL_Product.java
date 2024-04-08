package fpoly.huyndph40487.qlda_bantrsua.Model;

public class QL_Product {
    private String name;
    private int gia;
    private int soluong;

    public QL_Product() {
    }

    public QL_Product(String name, int gia, int soluong) {
        this.name = name;
        this.gia = gia;
        this.soluong = soluong;
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

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
