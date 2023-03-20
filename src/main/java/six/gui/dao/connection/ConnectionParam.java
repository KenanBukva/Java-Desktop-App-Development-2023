package org.akademija.six.gui.dao.connection;

public enum ConnectionParam {
    URL("jdbc:mysql://localhost:3306/sports"),
    USERNAME("root"),
    PASSWORD("miljacka");

    private final String value;

    private ConnectionParam(String value){
        this.value = value;
    }


    public String getValue() {
        return value;
    }
}
