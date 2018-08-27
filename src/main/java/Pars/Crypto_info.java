package Pars;

class Crypto_info {
    private String name;
    private String price;
    private String timestamp;

    Crypto_info(String name, String price, String timestamp) {
        this.name = name;
        this.price = price;
        this.timestamp = timestamp;
    }

    String getName() { return name; }

    String getPrice() {
        return price;
    }

    String getTimestamp() {
        return timestamp;
    }


}
