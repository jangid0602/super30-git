public class TaskDetail {
    String getTask_1 = """
                    {-> The Cosmic Courier Challenge <-}
                    Problem Description:
                     You are given a list of route travel times for a delivery project. The overall project deadline is
                     defined as the maximum travel time among all routes. You are allowed to remove at most one
                     route from the list in order to minimize the deadline.
                     
                     Your task is to compute the minimum possible deadline after optionally removing a single
                     route. If removing a route does not improve the deadline, the original maximum should be
                     returned. This problem evaluates your understanding of array manipulation, edge cases, and
                     time complexity considerations.
                    """;

    String getTask_2 = """
                     {-> The Digital Library System <-}
                          Problem Description:
                          Design an object-oriented system to manage a digital library. Each book is represented as an
                          object, and the library maintains a collection of books.
                          The system must support searching for books by title using:
                          ● Exact match search
                          ● Partial match search
                          
                          The same search method should behave differently based on the input parameters,
                          demonstrating polymorphism. The problem emphasizes clean class design, encapsulation of
                          data, and flexible method behavior.

                    """;

    String getTask_3 = """
                       {-> Factory Floor <-}
                        Problem Description:
                   
                        A robot operates on a factory floor and labels items based on their weight using the following
                        rules:
                        ●  Multiples of 15 →   "Hazardous"
                        ●  Multiples of 3 →    "Heavy"
                        ●  Multiples of 5 →    "Fragile"
                    
                           All other values → the weight itself (as a string)
                           Given a list of item weights, return a list of corresponding labels. This problem checks logical
                           ordering, condition prioritization, and iterative processing.
                    """;

    String getTask_4 = """
                  {-> The Spy’s Cipher <-}
                   Problem Description:
            
                    You are given two Words:
                    ●  original
                    ●  scrambled
                    The scrambled string is formed by rearranging the alphabet of original and adding
                    exactly one extra character. Your task is to identify and return that extra alphabet.
                    This problem tests your ability to analyze alphabet frequencies and compare string
                    compositions efficiently.
            """;

    String getTask_5 = """
                    {->  The Corporate Hierarchy System <-}
                     Problem Description:
            
                    A tech startup manages its employees using a hierarchical class structure consisting of:
                    ● Employee
                    ● Manager
                    ● Executive
                    The base Employee class contains properties such as name, ID, and a protected
                    baseSalary. It provides a method to calculate an annual bonus as 10% of base salary.
                    The Manager class inherits from Employee and overrides the bonus calculation to include 25%
                    of base salary plus a fixed team performance bonus of $5,000.
           
                    The Executive class further extends Manager and overrides the bonus calculation to return
                    50% of base salary plus stock options worth $10,000.
                    You must also design a function that accepts a polymorphic list of employees and calculates
                    the total company-wide bonus payout.
            """;

    String getTask_6 = """
                    {-> The Security Log Analyzer <-}
                    Problem Description:
            
                    A network security firm tracks the number of successful logins per day over multiple days.
                    Analysts frequently query the total number of logins that occurred between a start day i and an
                    end day j (inclusive).
            
                    You are required to design a system that allows:
                    ● A one-time preprocessing step
                    ● O(1) time query resolution for any [i, j]
                    This problem focuses on preprocessing techniques and efficient range query handling.
            """;

    String getTask_7 = """
                   {-> The Concert Seat Manager <-}
                   Problem Description:
           \s
                   A concert ticketing platform processes seat requests as (Customer ID, Seat Number)
                   pairs. Each seat can be assigned only once.
                   Your task is to determine the first customer who attempts to book a seat that has already been
                   requested by another customer. If no such duplicate seat request exists, return -1.
           
                   This problem evaluates efficient duplicate detection using hash-based data structures. \s
           \s
           \s""";

    String getTask_8 = """
                    {-> The Weather Station Data Aggregator <-}
                    Problem Description:
            
                    Given an list of daily temperatures (as strings or integers), determine how many days
                    recorded a temperature that was strictly higher than all previous days.
            
                    The first day always counts as a record. This problem tests sequential processing and
                    maintaining running comparisons
            """;
}
