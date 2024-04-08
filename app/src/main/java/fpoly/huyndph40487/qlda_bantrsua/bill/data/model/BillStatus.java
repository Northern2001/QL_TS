package fpoly.huyndph40487.qlda_bantrsua.bill.data.model;


import fpoly.huyndph40487.qlda_bantrsua.R;

public enum BillStatus {
    CANCELLED, ON_GOING, SHIPPER_FINDING, COMPLETED;

    public String title() {
        if (this == BillStatus.CANCELLED) {
            return "Đã huỷ";
        } else if (this == BillStatus.ON_GOING) {
            return "Đang giao";
        } else if (this == BillStatus.SHIPPER_FINDING) {
            return "Đang tìm shipper";
        }
        return "Hoàn thành";
    }

    public int colorRes() {
        switch (this) {
            case CANCELLED:
                return R.color.Red;
            case ON_GOING:
                return R.color.Blue;
            case SHIPPER_FINDING:
                return R.color.Gray;
            default:
                return R.color.Green;
        }
    }

    public static BillStatus fromString(String text) {
        for (BillStatus status : BillStatus.values()) {
            if (status.name().equalsIgnoreCase(text)) {
                return status;
            }
        }
        return COMPLETED;
    }
}
