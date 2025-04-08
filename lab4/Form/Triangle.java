public class Triangle extends Form {
    private float height;
    private float base;

    public Triangle() {
        super();
        this.base = 0;
        this.height = 0;
    }

    public Triangle(String color, float base, float height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    public double getArea() {
        return 0.5 * base * height;
    }

    public String toString() {
        return "Triunghi: " + super.toString() + " " + getArea();
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Triangle)) return false;
        Triangle t = (Triangle) obj;
        return this.base == t.base && this.height == t.height && this.color.equals(t.color);
    }

    public void printTriangleDimensions() {
        System.out.println(base + " " + height);
    }
}
