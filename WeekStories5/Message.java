public class Message {
        static String firstCase = """
                                ----> Rules <----
                        List ->  a,b,c,b,a
                        where :-
                                    a
                                   / \\
                                  b   c
                                 / \\
                                b   a
                             OutPut :- 7
                        """;
        static String inputRules = """
                                ----> Rules <----
                        List ->  5,3,-3,10,2,-1,11
                        where :-
                                    5
                                   / \\
                                  3   -3
                                 / \\    \\
                               10   2    11
                        """;

        static String camera = """
                                ----> Rules <----
                        List ->  0,0,-1,0,0
                        where :-
                                    0
                                   /
                                  0
                                 / \\
                                0   0

                                Output :- 1
                                """;

        static String eight = """
                                ----> Rules <----
                        List ->  5,3,3,10,2,-1,11
                        where :-
                                    5
                                   / \\
                                  3    3
                                 / \\    \\
                               10   2    11

                        Output :- 3
                        """;

        static String userInstruction = "Enter value (-1 point to null) [for exit press enter]:- ";
        static String error = "Enter a valid data";
        static String target = "Enter your data :- ";
        static String nullValue = "null";
        static String startInput = "Start entering your tree node values (for exit press Enter) :- ";
        static String separator = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
}
