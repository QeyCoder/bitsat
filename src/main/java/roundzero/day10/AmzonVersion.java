package day10;

/**
 * Created by Gaurav on 08/10/17.
 */
public class AmzonVersion {

    public int compareVersion(String versionA, String versionB) {
        String[] version1Str = versionA.split("\\.");
        String[] version2Str = versionB.split("\\.");

        int lowIndex = 0;

        int largerVersion = 0;
        if (version1Str.length > version2Str.length) {
            lowIndex = version2Str.length - 1;
            largerVersion = 1;
        } else if (version1Str.length < version2Str.length) {
            lowIndex = version1Str.length - 1;
            largerVersion = 2;
        } else {
            lowIndex = version2Str.length - 1;
        }
        int i;
        for (i = 0; i <= lowIndex; i++) {

            double a = Double.parseDouble(version1Str[i]);
            double b = Double.parseDouble(version2Str[i]);
            if (a == b) {
                continue;
            } else if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            }
        }

        if (largerVersion == 2) {
            for (int j = i; j <= version2Str.length - 1; j++) {
                if (Double.parseDouble(version2Str[j]) != 0) {
                    return -1;
                }
            }
        }
        if (largerVersion == 1) {
            for (int j = i; j <=version1Str.length - 1; j++) {
                if (Double.parseDouble(version1Str[j]) != 0) {
                    return 1;
                }
            }
        } else if (largerVersion == 0) {
            return 0;
        }

        return 0;
    }

    public static void main(String[] args) {
        AmzonVersion amzonVersion = new AmzonVersion();
        System.out.println(amzonVersion.compareVersion("1", "1.0"));
        System.out.println(amzonVersion.compareVersion("13.0", "13.0.8"));
    }
}
