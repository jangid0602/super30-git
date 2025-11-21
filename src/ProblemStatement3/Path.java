package ProblemStatement3;

public class Path {

    public String best(String user[], String page[], int n) {

        String from[] = new String[n];
        String to[] = new String[n];
        int cnt[] = new int[n];
        int used = 0;

        for (int i = 0; i < n - 1; i++) {

            if (user[i].equals(user[i + 1])) {

                String a = page[i];
                String b = page[i + 1];

                int pos = -1;
                for (int j = 0; j < used; j++) {
                    if (from[j].equals(a) && to[j].equals(b)) {
                        pos = j;
                        break;
                    }
                }

                if (pos == -1) {
                    from[used] = a;
                    to[used] = b;
                    cnt[used] = 1;
                    used++;
                } else {
                    cnt[pos]++;
                }
            }
        }

        int best = 0;
        int bestCnt = cnt[0];

        for (int i = 1; i < used; i++) {

            if (cnt[i] > bestCnt) {
                best = i;
                bestCnt = cnt[i];
            } else if (cnt[i] == bestCnt) {

                int x = from[i].compareTo(from[best]);
                if (x < 0) {
                    best = i;
                } else if (x == 0) {
                    int y = to[i].compareTo(to[best]);
                    if (y < 0) {
                        best = i;
                    }
                }
            }
        }

        return from[best] + ", " + to[best];
    }
}
