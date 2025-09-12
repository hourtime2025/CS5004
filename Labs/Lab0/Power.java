// Power.java
public class Power {
    public static void main(String[] args) {
        // compute 2^22 and print
        long result = (long) Math.pow(2, 22);
        System.out.println(result);
    }
}

/*
Differences between Java and Python versions:
1. Java requires a class with a main method; Python just runs code top-to-bottom.
2. Java needs explicit type (long) and uses Math.pow, Python handles big integers natively.
3. Java must be compiled first (javac Power.java) before running (java Power), Python is interpreted.
*/