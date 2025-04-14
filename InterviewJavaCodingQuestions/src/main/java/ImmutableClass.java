public class ImmutableClass {

    // All fields are private and final to ensure immutability
    // and cannot be changed after the object is created
    private final String data1 ;
    private final String data2 ;
    private final String data3 ;
    private final String data4 ;

    //Constructor initializes all fields
    public ImmutableClass(String data1, String data2, String data3, String data4) {
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.data4 = data4;
    }

    //Getters for all fields
    public String getData1() {
        return data1;
    }

    public String getData2() {
        return data2;
    }

    public String getData3() {
        return data3;
    }

    public String getData4() {
        return data4;
    }
}
