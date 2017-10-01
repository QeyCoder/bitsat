public class UnixPath {
    public static  String simplifyPath(String a) {

        String[] split = a.split("/");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {


            if (!split[i].contains(".")) {
                builder.append("/" + split[i]);
            }else{
                builder =  new StringBuilder();
            }

        }

        return builder.toString();
    }

    public static void main(String[] args) {
        simplifyPath("/home//foo/");
    }
}
