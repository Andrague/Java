# BST 
The program begins by generating a binary search tree with user-specified size, where integers are inserted as nodes in a manner that maintains the BST properties: values less than a parent node are placed in the left subtree, and values greater or equal are placed in the right subtree.
Additionally, the program undertakes a performance analysis comparing the sorting capabilities of the BST in-order traversal method against the traditional bubble sort algorithm. For this analysis, datasets of varying sizes (from 1000 to 10000 elements) are used to observe how each sorting method scales with increasing data size. The results, including the time taken for each sort method, are presented, offering insights into the efficiency of tree-based sorting compared to elementary sorting algorithms.

# DFS
Identification and analysis of graph components using Depth-First Search (DFS). 
Core Components:
Graph Class: Central to the project, this class facilitates graph creation and manipulation. It supports adding vertices and edges, checking connectivity, and performing depth-first search to identify connected components. The Graph class also includes methods for finding maximal independent sets, showcasing the versatility of graph algorithms in solving complex problems.
GraphException Class: A custom exception class designed to handle errors specifically related to graph operations, ensuring robust error handling and enhancing the code's reliability.
Tester Class: This class demonstrates the application of the Graph class's capabilities, including the identification of connected components in various graph structures such as linear, custom-structured, and file-based graphs. It provides a clear example of how to utilize the library for practical graph analysis tasks.

# Employees and companies
Employee: Core class representing an employee with attributes like name, surname, bank account, and functionalities to manage working hours and calculate salaries.
Manager: Extends Employee, adding functionalities to manage subordinates and calculate managerial bonuses.
Company: Manages a collection of employees and provides methods to generate reports and handle financial transactions.
Bank: Simulates financial transactions and includes methods to transfer money while handling possible TransferException.
Databases: Mocks database interactions, providing methods to fetch employee details with potential DatabaseException and ServerTooBusyException.
Exceptions: Includes custom exception classes like ServerTooBusyException, DatabaseException, and TransferException for robust error handling.
Test: Main class to demonstrate the system's functionalities through various scenarios.
