package roundone;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution1496 {
    class Solution {

        class Point {
            int x;
            int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Point point = (Point) o;
                return x == point.x &&
                        y == point.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }

        public boolean isPathCrossing(String path) {
            Set<Point> pointSet = new HashSet<>();
            pointSet.add(new Point(0, 0));
            int x = 0;
            int y = 0;
            for (int i = 0; i < path.length(); i++) {

                char ch = path.charAt(i);
                if (ch == 'N') {
                    y++;
                } else if (ch == 'E') {
                    x++;
                } else if (ch == 'S') {
                    y--;
                } else {
                    x--;
                }
                Point point = new Point(x, y);
                if (pointSet.contains(point)) {
                    return true;
                }
                pointSet.add(point);
            }
            return false;

        }

    }
}
