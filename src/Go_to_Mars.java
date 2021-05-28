import java.util.LinkedList;
import java.util.Queue;

public class Go_to_Mars implements RouterFinder {

    @Override
    public char[][] findRoute(char[][] map) {
        boolean first_step = true;
        boolean second_step = false;
        int[] first_point = new int[2];
        int[] second_point = new int[2];
        int found = 0;
        int max_y = map.length;
        int max_x = 0;

        char[][] map2 = new char[map.length][];

        for (int i = 0; i < map.length; i++) {
//            if (found >1) break;
            map2[i] = new char[map[i].length];
            for (int j = 0; j <map[i].length; j++) {
                map2[i][j] = map[i][j];
                if (map[i][j] == 'X' || map[i][j] == '@') {
                    max_x = map[i].length;
                    if (found==0) {
                        first_point = new int[] {j, i};
                    }
                    else
                        second_point = new int[] {j, i};
                    found++;
                }
            }
        }
        if (found > 1) {
            map2[first_point[1]][first_point[0]] = '0';
            Queue<int[]> uer = new LinkedList<>();
            uer.add(first_point);

            int[] current_point;

            while (first_step) {
                current_point = uer.poll();

                if(current_point == null) {
                    break;
                }

//                for (int i = 0; i < map2.length - 1; i++ ) {
//                    for (int j = 0; j < map2[i].length - 1; j++) {
//                        System.out.print(map2[i][j]);
//                    }
//                    System.out.println("");
//                }
//                System.out.println("/////////////////////////////////////");
//                System.out.println(current_point[0] + " " + current_point[1]);

                if (current_point[0] == second_point[0] && current_point[1] == second_point[1]) {
                    first_step = false;
                    second_step = true;
                }

                if (!(current_point[1] == max_y - 1 || map2[current_point[1] + 1][current_point[0]] == '#')) {
                    if (second_point[0] == current_point[0] && current_point[1] + 1 == second_point[1]){
                        map2[current_point[1] + 1][current_point[0]] = (char) (map2[current_point[1]][current_point[0]] + 1);
                        uer.add(new int[]{current_point[0], current_point[1] + 1});
                    } else if (map2[current_point[1] + 1][current_point[0]] == '.') {
                        map2[current_point[1] + 1][current_point[0]] = (char) (map2[current_point[1]][current_point[0]] + 1);
                        uer.add(new int[]{current_point[0], current_point[1] + 1});
                    }  else if (map2[current_point[1] + 1][current_point[0]] > map2[current_point[1]][current_point[0]] + 1){
                        map2[current_point[1] + 1][current_point[0]] = (char) (map2[current_point[1]][current_point[0]] + 1);
                        uer.add(new int[]{current_point[0], current_point[1] + 1});
                    }
                }
                if (current_point[0] != 0 && map2[current_point[1]][current_point[0] - 1] != '#') {
                    if (second_point[0] == current_point[0] - 1 && second_point[1] == current_point[1]) {
                        map2[current_point[1]][current_point[0] - 1] = (char) (map2[current_point[1]][current_point[0]] + 1);
                        uer.add(new int[]{current_point[0] - 1, current_point[1]});
                    } else if (map2[current_point[1]][current_point[0] - 1] == '.') {
                        map2[current_point[1]][current_point[0] - 1] = (char) (map2[current_point[1]][current_point[0]] + 1);
                        uer.add(new int[]{current_point[0] - 1, current_point[1]});
                    } else if (map2[current_point[1]][current_point[0] - 1] > map2[current_point[1]][current_point[0]] + 1){
                        map2[current_point[1]][current_point[0] - 1] = (char) (map2[current_point[1]][current_point[0]] + 1);
                        uer.add(new int[]{current_point[0] - 1, current_point[1]});
                    }
                }
                if (current_point[0] != max_x - 1 && map2[current_point[1]][current_point[0] + 1] != '#') {
                    if (second_point[0] == current_point[0] + 1 && second_point[1] == current_point[1]) {
                        map2[current_point[1]][current_point[0] + 1] = (char) (map2[current_point[1]][current_point[0]] + 1);
                        uer.add(new int[]{current_point[0] +1, current_point[1]});
                    } else if (map2[current_point[1]][current_point[0] + 1] == '.') {
                        map2[current_point[1]][current_point[0] + 1] = (char) (map2[current_point[1]][current_point[0]] + 1);
                        uer.add(new int[]{current_point[0] +1, current_point[1]});
                    } else if (map2[current_point[1]][current_point[0] + 1] > map2[current_point[1]][current_point[0]] + 1){
                        map2[current_point[1]][current_point[0] + 1] = (char) (map2[current_point[1]][current_point[0]] + 1);
                        uer.add(new int[]{current_point[0] + 1, current_point[1]});
                    }
                }
                if (current_point[1] != 0 && map2[current_point[1] - 1][current_point[0]] != '#') {
                    if (second_point[0] == current_point[0] && current_point[1] - 1 == second_point[1]) {
                        map2[current_point[1] - 1][current_point[0]] = (char) (map2[current_point[1]][current_point[0]] + 1);
                        uer.add(new int[]{current_point[0], current_point[1] - 1});
                    } else if (map2[current_point[1] - 1][current_point[0]] == '.') {
                        map2[current_point[1] - 1][current_point[0]] = (char) (map2[current_point[1]][current_point[0]] + 1);
                        uer.add(new int[]{current_point[0], current_point[1] - 1});
                    } else if (map2[current_point[1] - 1][current_point[0]] > map2[current_point[1]][current_point[0]] + 1){
                        map2[current_point[1] - 1][current_point[0]] = (char) (map2[current_point[1]][current_point[0]] + 1);
                        uer.add(new int[]{current_point[0], current_point[1] - 1});
                    }
                }
            }


            if (second_step) {
                boolean finish = false;
                current_point = new int[]{second_point[0], second_point[1]};
                while (!finish) {
//                    System.out.println("Текущие координатры: " + current_point[0] + " " + current_point[1]);
                    if (current_point[0] == first_point[0] && current_point[1] == first_point[1]) {
                        map2[current_point[1]][current_point[0]] = '@';
                        finish = true;
                    } else {
                        if (current_point[0] != 0 && map2[current_point[1]][current_point[0] - 1] != '#'
                                && (map2[current_point[1]][current_point[0]] - 1) == map2[current_point[1]][current_point[0] - 1])
                        {
                            current_point[0] = current_point[0] - 1;
                            map[current_point[1]][current_point[0]] = '+';
                            continue;
                        }

                        if (current_point[0] != max_x - 1 && map2[current_point[1]][current_point[0] + 1] != '#'
                                && (map2[current_point[1]][current_point[0]] - 1) == map2[current_point[1]][current_point[0] + 1])
                        {
                            current_point[0] = current_point[0] + 1;
                            map[current_point[1]][current_point[0]] = '+';
                            continue;
                        }

                        if (current_point[1] != 0 && map2[current_point[1] - 1][current_point[0]] != '#'
                                && (map2[current_point[1]][current_point[0]] - 1) == (int) map2[current_point[1] - 1][current_point[0]])
                        {
                            current_point[1] = current_point[1] - 1;
                            map[current_point[1]][current_point[0]] = '+';
                            continue;
                        }
                        if (current_point[1] != max_y -1 && map2[current_point[1] + 1][current_point[0]] != '#'
                                && (map2[current_point[1]][current_point[0]] - 1) == map2[current_point[1] + 1][current_point[0]])
                        {
                            current_point[1] = current_point[1] + 1;
                            map[current_point[1]][current_point[0]] = '+';

                        }
                    }
                }
            }

            if (second_step) {
                return map;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public static void main(String[] args) {

        char[][] map = {
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '@', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', '#', '.', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '.', '#', '#', '#', '#', '.', '.', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', '#', '.', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '.', '#', '.', '.', '.', '.', '#', '#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '#', '#'},
                {'#', '#', '.', '.', '#', '#', '#', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '.', '.', '#', '#', '#', '.', '#', '.', '.', '#', '#', '#', '.', '#', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '#', '#'},
                {'#', '#', '#', '.', '#', '#', '#', '.', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '.', '.', '#', '#', '#', '.', '#', '#', '.', '#', '#', '#', '.', '#', '.', '.', '.', '#', '.', '.', '.', '.', '#', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '#', '#'},
                {'#', '#', '#', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '#', '#', '.', '#', '#', '#', '#', '.', '#', '#', '.', '#', '#', '#', '.', '#', '#', '.', '#', '#', '#', '.', '#', '.', '.', '.', '#', '.', '.', '.', '.', '#', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '#', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.', '.', '.', '#', '#', '#', '#', '.', '#', '#', '.', '#', '#', '#', '.', '#', '#', '.', '#', '#', '#', '.', '#', '.', '.', '.', '#', '.', '.', '.', '.', '#', '.', '#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '#', '#'},
                {'#', '#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '.', '#', '.', '.', '.', '.', '.', '.', '#', '#', '#', '#', '#', '#', '.', '#', '.', '.', '.', '#', '.', '.', '#', '#', '#', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '#', '#'},
                {'#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '.', '#', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '#', '#'},
                {'#', '#', '#', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '.', '#', '.', '.', '.', '.', '.', '.', '#', '.', '#', '#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '#', '#'},
                {'#', '#', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '.', '#', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '#', '#'},
                {'#', '#', '.', '#', '#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '.', '#', '.', '.', '.', '#', '.', '.', '#', '.', '.', '.', '#', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '#', '#'},
                {'#', '#', '.', '#', '.', '.', '.', '#', '#', '#', '#', '#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '#', '#', '#', '#', '#', '#', '.', '.', '.', '.', '.', '#', '.', '.', '#', '#', '.', '.', '#', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '#', '#'},
                {'#', '#', '.', '#', '.', '#', '.', '#', '#', '#', '#', '#', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.', '.', '.', '.', '#', '.', '.', '#', '#', '#', '.', '#', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '#', '#'},
                {'#', '#', '.', '#', '.', '#', '.', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '#', '.', '#', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '#', '#'},
                {'#', '#', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '#', '.', '#', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '#', '#'},
                {'#', '#', '#', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '#', '.', '.', '#', '.', '.', '.', '.', '#', '#', '#', '#', '#', '#', '.', '#', '.', '#', '#'},
                {'#', '#', '#', '.', '.', '#', '#', '#', '.', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.', '.', '.', '.', '#', '#', '#', '#', '.', '#', '#', '#', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '#', '#'},
                {'#', '#', '#', '.', '.', '.', '.', '.', '.', '#', '#', '.', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.', '#', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '#', '#'},
                {'#', '#', '#', '.', '.', '.', '.', '.', '.', '#', '#', '.', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.', '#', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '#', '.', '#', '#'},
                {'#', '#', '#', '.', '.', '.', '.', '.', '.', '#', '#', '.', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '#', '.', '#', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.', '#', '#', '#', '#', '#', '#', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '#', '.', '#', '#'},
                {'#', '#', '.', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '#', '.', '#', '#'},
                {'#', '#', '.', '#', '#', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '#', '.', '#', '#'},
                {'#', '#', '.', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '#', '.', '#', '#'},
                {'#', '#', '.', '.', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#', '#', '#', '#', '.', '#', '.', '#', '.', '#', '#'},
                {'#', '#', '#', '.', '#', '#', '#', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '#'},
                {'#', '#', '#', '.', '#', '#', '#', '.', '#', '.', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#'},
                {'#', '#', '#', '.', '#', '#', '#', '.', '#', '.', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#'},
                {'#', '#', '#', '.', '#', '#', '#', '.', '#', '.', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#'},
                {'#', '#', '#', '.', '#', '#', '#', '.', '#', '.', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '.', '#', '.', '.', '.', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#'},
                {'#', '#', '#', '.', '#', '#', '#', '.', '#', '.', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '.', '#', '.', '#', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#'},
                {'#', '#', '#', '.', '#', '#', '#', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '.', '#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#'},
                {'#', '#', '#', '.', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '.', '.', '#', '#', '#', '#', '#', '#', '#', '.', '#', '.', '#', '#', '.', '.', '.', '.', '.', '.', '.', '#', '#', '#', '#', '.', '.', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#'},
                {'.', '.', '.', '.', '#', '#', '#', '#', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#', '.', '#', '#', '.', '.', '.', '#', '#', '#', '#', '#', '.', '#', '.', '#', '#', '#', '#', '.', '#', '#', '.', '.', '#', '#', '#', '#', '.', '.', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#'},
                {'.', '#', '#', '.', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '.', '#', '#', '#', '#', '.', '.', '#', '#', '#', '#', '.', '#', '.', '#', '#', '#', '#', '.', '#', '#', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#'},
                {'.', '#', '#', '.', '#', '#', '#', '#', '#', '#', '.', '.', '.', '.', '.', '.', '#', '#', '.', '#', '#', '.', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#'},
                {'.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '.', '#', '#', '.', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#'},
                {'#', 'X', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#', '.', '.', '.', '.', '#', '#', '#', '#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
        };

        Go_to_Mars map_to = new Go_to_Mars();
        char[][] mapp = map_to.findRoute(map);

        if (mapp != null) {
            for (int i = 0; i < mapp.length; i++ ) {
                for (int j = 0; j < mapp[i].length; j++) {
                    System.out.print(mapp[i][j]);
                    System.out.print(" ");
                }
                System.out.println("");
            }
        }
    }
}
