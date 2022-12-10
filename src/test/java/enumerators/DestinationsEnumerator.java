package enumerators;

import static com.codeborne.selenide.Selenide.$x;

public enum DestinationsEnumerator {

    Bengaluru("BLR"),
    Delhi("DEL"),
    Dubai("DXB");


    private String xpath;

    DestinationsEnumerator(String xpath) {
        this.xpath = xpath;
    }

    public String getXpath() {
        return xpath;
    }

    public static void main(String[] args) {
        for (DestinationsEnumerator value : DestinationsEnumerator.values()) {
            if(value.toString().equalsIgnoreCase("Delhi")) {
                System.out.println("(//a[@value='" + value.getXpath() + "'])[2]");
            }
        }
        String a = "aaaa - bbbb";
        String[] b = a.trim().split("-");
        String aaaa = b[0];
        System.out.println(aaaa);
    }

}


