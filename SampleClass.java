public class SampleClass {
    public int a;
    
    public boolean b;

    public boolean equals(Object obj) {
        SampleClass o = (SampleClass) obj;
        boolean result = this.a == o.a ? true : false;
        boolean booleanResult = Boolean.compare(this.b, o.b) == 0 ? true : false;

        return result && booleanResult;
    }
    public String toString() {
        return "The value of a is :" + this.a + " and the value of b is: "  + this.b;
    }
}
