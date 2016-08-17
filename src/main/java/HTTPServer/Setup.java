package HTTPServer;

/**
 * Created by jphoenix on 8/8/16.
 */
public class Setup {
    public String rootDirectory;
    public int port;

    public Setup(String[] args) {
        assignPort(args);
        assignRoot(args);
    }

    private void assignPort(String[] args) {
        if (flagFound(args, "-p")) {
            System.out.println("Port assigned");
            this.port = Integer.parseInt(argAfterFlag(args, "-p"));
        } else {
            this.port = 5000;
        }
    }

    private void assignRoot(String[] args) {
        if (flagFound(args, "-d")) {
            System.out.println("Root assigned");
            this.rootDirectory = stripEntry(argAfterFlag(args, "-d"));
        } else {
            this.rootDirectory = "public";
        }
    }

    private String argAfterFlag(String[] args, String flag) {
        int i = 0;
        for (String arg : args) {
            if (arg.equals(flag))
                break;
            i++;
        }
        return args[i + 1];
    }

    private boolean flagFound(String[] args, String flag) {
        for (String arg : args) {
            if (arg.equals(flag))
                return true;
        }
        return false;
    }

    private String stripEntry(String arg) {
        if (arg.endsWith("/")) {
            return arg.substring(0, (arg.length() - 1));
        } else {
            return arg;
        }
    }
}
