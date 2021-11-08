package db;

public class Compiler {
    private static Compiler compiler;
    private static String compilationMSG = "Compiling...";

    private Compiler() {}

    public static Compiler compile() {
        if (compiler == null) {
            compiler = new Compiler();
        }
        return compiler;
    }

    public void addCompilerMSG(String msg) {
        compilationMSG += msg + "\n";
    }

    public void showMSG() {
        System.out.println(compilationMSG);
    }
}
